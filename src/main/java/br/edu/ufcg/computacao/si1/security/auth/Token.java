package br.edu.ufcg.computacao.si1.security.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.ufcg.computacao.si1.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

@Entity(name = "Token")
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String tokenKey;

    @OneToOne
    @JsonIgnore
    private User user;

    public Token(User user) {
        this.tokenKey = UUID.randomUUID().toString();
        this.user = user;
    }

    public Token(String key) {
        this.tokenKey = key;
    }

    public Token() { }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenKey() {
        return this.tokenKey;
    }

    public void setTokenKey(String key) {
        this.tokenKey = key;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}