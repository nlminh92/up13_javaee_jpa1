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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="t_bateau")
public class Bateau {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name="nom", length=40)
    private String nom;

    @OneToMany(
            cascade=CascadeType.PERSIST,
            fetch=FetchType.EAGER)
    @OrderBy("nom ASC")
    private List<Marin> equipage = new ArrayList<Marin>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Marin> getEquipage() {
        return equipage;
    }

    public void setMarin(Marin marin) {
        equipage.add(marin);
    }
}
