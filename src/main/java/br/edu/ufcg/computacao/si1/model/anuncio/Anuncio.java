package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import com.sun.javafx.runtime.SystemProperties;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LongSummaryStatistics;

/**
 * Created by Marcus Oliveira on 08/12/16.
 */
@Entity
@Table(name="anuncios")
public abstract class Anuncio {

    private final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id", nullable = false, unique = true)
    private Long _id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "data_criacao", nullable = false)
    private Date dataDeCriacao;

    @Column(name = "preco", nullable = false)
    private double preco;

    @Column(name = "nota")
    private String nota;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "user_id")
    private Long user_id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Usuario owner;

    public Anuncio(String titulo, Date dataDeCriacao, double preco, String nota, String tipo, Usuario owner) {
        this.titulo = titulo;
        this.dataDeCriacao = dataDeCriacao;
        this.preco = preco;
        this.nota = nota;
        this.tipo = tipo;
        this.owner = owner;
        this.user_id = owner.getUser_id();
    }

    public Anuncio() {
        titulo = "";
        dataDeCriacao = new Date();
        preco = 0;
        nota = "";
        tipo = "";
    }

    /**
     * Retorna o id do anuncio
     * @return o id do anuncio
     */
    public Long get_id() {
        return _id;
    }

    /**
     * Modifica o id do anuncio
     * @param _id id a ser colocado no anuncio
     */public void set_id(Long _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataDeCriacao() {
        return DATE_FORMAT.format(dataDeCriacao);
    }

    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

        if (Double.compare(anuncio.getPreco(), getPreco()) != 0) return false;
        if (!get_id().equals(anuncio.get_id())) return false;
        if (!getTitulo().equals(anuncio.getTitulo())) return false;
        if (!getDataDeCriacao().equals(anuncio.getDataDeCriacao())) return false;
        if (getNota() != null ? !getNota().equals(anuncio.getNota()) : anuncio.getNota() != null) return false;
        return getTipo().equals(anuncio.getTipo());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = get_id().hashCode();
        result = 31 * result + getTitulo().hashCode();
        result = 31 * result + getDataDeCriacao().hashCode();
        temp = Double.doubleToLongBits(getPreco());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getNota() != null ? getNota().hashCode() : 0);
        result = 31 * result + getTipo().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" + " \n"+
                "\t_id:" + _id +", "+ System.lineSeparator() +
                "\ttitulo:'" + titulo + ", "+ System.lineSeparator() +
                "\tdataDeCriacao:" + getDataDeCriacao() +", "+ System.lineSeparator() +
                "\tpreco:" + preco +", "+ System.lineSeparator() +
                "\tnota:" + nota +", "+ System.lineSeparator() +
                "\ttipo:'" + tipo + ", "+ System.lineSeparator() +
                "\tuser_id:" +owner.getUser_id()+", "+ System.lineSeparator() +
                '}';
    }
}
