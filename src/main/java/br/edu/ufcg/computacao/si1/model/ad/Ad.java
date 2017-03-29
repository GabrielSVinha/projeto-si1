package br.edu.ufcg.computacao.si1.model.ad;

import br.edu.ufcg.computacao.si1.model.user.User;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="ads")
public class Ad {

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

    @Column(name = "type", nullable = false)
    private AdType type;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User owner;

    public Ad(String title, Date creationDate, double price, AdType type, User owner) {
        this.title = title;
        this.creationDate = creationDate;
        this.price = price;
        this.type = type;
        this.owner = owner;
        this.userId = owner.getUser_id();
    }

    public Ad() {
        title = "";
        creationDate = new Date();
        price = 0;
        type = AdType.NONE;
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

    public AdType getType() {
        return type;
    }

    public void setType(AdType type) {
        this.type = type;
    }

    @JsonIgnore
    public User getUser() {
        return owner;
    }

    public void setUser(User user) {
        this.owner = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ad)) return false;

        Ad anuncio = (Ad) o;

        if (Double.compare(anuncio.getPrice(), getPrice()) != 0) return false;
        if (!getId().equals(anuncio.getId())) return false;
        if (!getTitle().equals(anuncio.getTitle())) return false;
        if (!getCreationDate().equals(anuncio.getCreationDate())) return false;
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
                "\ttype:'" + type + ", "+ System.lineSeparator() +
                "\tuserId:" +owner.getUser_id()+", "+ System.lineSeparator() +
                '}';
    }
}
