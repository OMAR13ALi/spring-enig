package tn.enig.model;

import javax.persistence.*;

@Entity
public class Emprunt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ide;
    @ManyToOne
    @JoinColumn(name = "livre_id")
    private  Livre livre;
    @ManyToOne
    @JoinColumn(name = "adherant_ida")
    private  Adherant adherant;
    private  String Date;

    public Emprunt(Integer ide, Livre livre, Adherant adherant, String date) {
        this.ide = ide;
        this.livre = livre;
        this.adherant = adherant;
        Date = date;
    }

    public Integer getIde() {
        return ide;
    }

    public void setIde(Integer ide) {
        this.ide = ide;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Emprunt() {

    }

    public Adherant getAdherant() {
        return adherant;
    }

    public void setAdherant(Adherant adherant) {
        this.adherant = adherant;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

}
