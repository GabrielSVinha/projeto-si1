package br.edu.ufcg.computacao.si1.config;

import br.edu.ufcg.computacao.si1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                    .antMatchers("/", "/api/**", "/vendor/**", "/views/**").permitAll()
                    .anyRequest().permitAll();
    }

    /**
     * TODO colocar para o login ser feito por dados consultados no banco de dados
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("company").password("password").roles("COMPANY");


        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery(
                "select email as username, password, true as enabled from user where email=?")
            .authoritiesByUsernameQuery(
                "select email as username, type from user where email=?");
    }

//    @Autowired
//    public final void configAuthentication(final AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .userDetailsService(userDetailsService())
//            .passwordEncoder(new BasicEncoder());
//    }
//
    @Bean
    protected UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Autowired
            UserService usuarioService;

            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                br.edu.ufcg.computacao.si1.model.user.User usuario = usuarioService.getByEmail(email).get();
                if (usuario != null) {
                    return new User(usuario.getEmail(), usuario.getPassword(), true, true, true, true,
                            AuthorityUtils.createAuthorityList());
                } else {
                    throw new UsernameNotFoundException("Não foi possível localizar o usuário" + usuario);
                }
            }
        };
    }
}
