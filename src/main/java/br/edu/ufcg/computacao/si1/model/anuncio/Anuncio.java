package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Marcus Oliveira on 08/12/16.
 */
@Entity
@Table(name="anuncios")
public abstract class Anuncio {

    private final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "note")
    private String note;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "user_id")
    private Long user_id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Usuario owner;

    public Anuncio(String title, Date creationDate, double price, String note, String type, Usuario owner) {
        this.title = title;
        this.creationDate = creationDate;
        this.price = price;
        this.note = note;
        this.type = type;
        this.owner = owner;
        this.user_id = owner.getId();
    }

    public Anuncio() {
        title = "";
        creationDate = new Date();
        price = 0;
        note = "";
        type = "";
    }

    /**
     * Retorna o id do anuncio
     * @return o id do anuncio
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o id do anuncio
     * @param id id a ser colocado no anuncio
     */public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreationDate() {
        return DATE_FORMAT.format(creationDate);
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Usuario getUser() {
        return owner;
    }

    public void setUser(Usuario user) {
        this.owner = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anuncio)) return false;

        Anuncio anuncio = (Anuncio) o;

        if (Double.compare(anuncio.getPrice(), getPrice()) != 0) return false;
        if (!getId().equals(anuncio.getId())) return false;
        if (!getTitle().equals(anuncio.getTitle())) return false;
        if (!getCreationDate().equals(anuncio.getCreationDate())) return false;
        if (getNote() != null ? !getNote().equals(anuncio.getNote()) : anuncio.getNote() != null) return false;
        return getType().equals(anuncio.getType());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getCreationDate().hashCode();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
        result = 31 * result + getType().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" + " \n"+
                "\tid:" + id +", "+ System.lineSeparator() +
                "\ttitle:'" + title + ", "+ System.lineSeparator() +
                "\tcreationDate:" + getCreationDate() +", "+ System.lineSeparator() +
                "\tprice:" + price +", "+ System.lineSeparator() +
                "\tnote:" + note +", "+ System.lineSeparator() +
                "\ttype:'" + type + ", "+ System.lineSeparator() +
                "\tuser_id:" +owner.getId()+", "+ System.lineSeparator() +
                '}';
    }
}
