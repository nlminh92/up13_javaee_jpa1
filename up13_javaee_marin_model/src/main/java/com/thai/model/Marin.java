package com.thai.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "t_marin", uniqueConstraints = {
        @UniqueConstraint(name = "nom_prenom", columnNames = { "nom", "prenom" }) })
public class Marin {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "nom", length = 40)
    private String nom;

    @Column(name = "prenom", length = 40)
    private String prenom;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_de_naissance", length = 16)
    private Date dateDeNaissance;

    @JoinColumn(name = "bateau")
    @ManyToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private Bateau bateau;

    public long getId() {
        return id;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
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


    public Bateau getBateau() {
        return bateau;
    }

    public void setBateau(Bateau bateau) {
        this.bateau = bateau;
    }

    @Override
    public String toString() {
        return "Nom: " + getNom() + " " + getPrenom() + ", date_de_naissance = " + dateDeNaissance.toString() + ", bateau: ";
    }
}
