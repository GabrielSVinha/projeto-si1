package br.edu.ufcg.computacao.si1.model.user;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "User")
@Table(name = "users")
public class User extends org.springframework.security.core.userdetails.User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private UserType type;

    @OneToMany(mappedBy = "owner", targetEntity = Ad.class, cascade = CascadeType.ALL)
    @Column
    private Collection<Ad> anuncios;

    public User(String name, String email, String password, UserType type) {
        super(name, password, AuthorityUtils.createAuthorityList(type.toString()));

        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User() {
        super("default", "default", AuthorityUtils.NO_AUTHORITIES);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

}
