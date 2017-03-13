package br.edu.ufcg.computacao.si1.model.form;


import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AnuncioForm {

    @NotNull(message = "O titulo não pode ser nulo.")
    @NotEmpty(message = "O titulo não pode esta vazio.")
    @Size(min = 10, max = 100, message = "O titulo deve ter entre 2 e 100 caracters")
    private String titulo;
    @NotNull(message = "O preço não pode ser nulo.")
    @DecimalMin(value = "0.1", message = "O preço minimo é 0.1 para um anúncio.")
    private Double preco;
    @NotNull(message = "O tipo de anúncio não pode ser nulo.")
    @NotEmpty(message = "Escolha um tipo para o anúncio.")
    private String tipo;
    @NotNull(message = "O criador do anuncio nao pode ser nulo.")
    @NotEmpty(message = "O criador do anuncio nao pode ser vazio.")
    private Long user;

    public AnuncioForm(String titulo, Double preco, String tipo, Long user) {
        this.titulo = titulo;
        this.preco = preco;
        this.tipo = tipo;
        this.user = user;
    }

    public AnuncioForm(Anuncio anuncio){
        this.titulo = anuncio.getTitulo();
        this.preco = anuncio.getPreco();
        this.tipo = anuncio.getTipo();
        this.user = anuncio.getUser().getUser_id();
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }
}

