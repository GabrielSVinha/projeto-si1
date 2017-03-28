package br.edu.ufcg.computacao.si1.model.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioForm {
    @NotNull(message = "O nome não pode ser nulo.")
    @NotEmpty(message = "O nome não pode ser vazio.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    private String name;

    @NotEmpty(message = "O email não pode ser vazio.")
    @Email
    private String email;

    @NotNull(message = "A senha não pode ser nula.")
    @NotEmpty
    @Size(min = 4, max = 16, message = "A senha deve ter entre 4 e 16 caracteres.")
    private String password;

    @NotNull
    private Integer role;

    public UsuarioForm() {}

    public UsuarioForm(String name, String email, String password, Integer role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
