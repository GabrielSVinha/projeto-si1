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
    private String title;

    @NotNull(message = "O preço não pode ser nulo.")
    @DecimalMin(value = "0.1", message = "O preço minimo é 0.1 para um anúncio.")
    private Double price;

    @NotNull(message = "O tipo de anúncio não pode ser nulo.")
    @NotEmpty(message = "Escolha um tipo para o anúncio.")
    private String type;

    @NotNull(message = "O criador do anuncio nao pode ser nulo.")
    @NotEmpty(message = "O criador do anuncio nao pode ser vazio.")
    private Long user_id;

    public AnuncioForm() {
    }

    public AnuncioForm(String title, Double price, String type, Long user_id) {
        this.title = title;
        this.price = price;
        this.type = type;
        this.user_id = user_id;
    }

    public AnuncioForm(Anuncio anuncio){
        this.title = anuncio.getTitle();
        this.price = anuncio.getPrice();
        this.type = anuncio.getType();
        this.user_id = anuncio.getUser().getId();
    }

    public Long getUserId() {
        return user_id;
    }

    public void setUser(Long user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

