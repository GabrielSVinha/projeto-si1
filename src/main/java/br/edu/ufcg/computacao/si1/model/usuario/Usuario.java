package br.edu.ufcg.computacao.si1.model.usuario;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "Usuario")
@Table(name = "usuarios")
public abstract class Usuario extends org.springframework.security.core.userdetails.User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
    @Column
    private String nome;
    @Column(unique = true)
    private String email;
    @Column
    private String senha;
    @Column
    private String role;

    @OneToMany(mappedBy = "owner", targetEntity = Anuncio.class, cascade = CascadeType.ALL)
    @Column
    private Collection<Anuncio> anuncios;

    public Usuario() {
        super("default", "default", AuthorityUtils.createAuthorityList("USER"));
    }

    public Usuario(String nome, String email, String senha, String role) {

        super(email, senha, AuthorityUtils.createAuthorityList(role));

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getN() {
        return nome;
    }

    public void setN(String n) {
        this.nome = n;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getR() {
        return role;
    }

    public void setR(String r) {
        this.role = r;
    }

}
