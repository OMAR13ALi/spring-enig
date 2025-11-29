package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adherant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ida;
    private String nom;
    private String prenom;

    public Adherant(Integer ida, String nom, String prenom) {
        this.ida = ida;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Adherant() {
    }

    public Integer getIda() {
        return ida;
    }

    public void setIda(Integer ida) {
        this.ida = ida;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
