package br.edu.ufcg.computacao.si1.model.ad;

import br.edu.ufcg.computacao.si1.model.user.User;

import javax.persistence.*;

/**
 * Created by gabriel on 27/03/17.
 */
@Entity
@Table(name = "sold_ads")
public class SoldAd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Long user_id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User owner;

    public SoldAd(String title, Long user_id) {
        this.title = title;
        this.user_id = user_id;
    }

    SoldAd(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
