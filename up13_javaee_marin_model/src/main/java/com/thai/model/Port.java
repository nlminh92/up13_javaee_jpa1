package com.thai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_port")
public class Port {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "nom", length = 40)
    private String nom;

    @ManyToOne(
            cascade=CascadeType.PERSIST,
            fetch=FetchType.EAGER)
    private Pays pays;

    @OneToMany(
            cascade=CascadeType.PERSIST,
            fetch=FetchType.EAGER,
            mappedBy="port")
    private List<Bateau> bateauList = new ArrayList<Bateau>();

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

    public List<Bateau> getBateauList() {
        return bateauList;
    }

    public void setBateau(Bateau bateau) {
        this.bateauList.add(bateau);
    }

    public void setBateaux(List<Bateau> bateaux) {
        this.bateauList.addAll(bateaux);
    }

    @Override
    public String toString() {
        return nom;
    }
}