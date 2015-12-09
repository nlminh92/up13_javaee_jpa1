package com.thai.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_port")
public class Port {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "nom", length = 40)
    private String nom;

    @JoinColumn(name = "pays")
    @OneToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private Pays pays;

    public Port() {
        this(null);
    }

    public Port(String nom) {
        this(nom, null);
    }

    public Port(String nom, Pays pays) {
        this.nom = nom;
        this.pays = pays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

}