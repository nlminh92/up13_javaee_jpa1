package com.thai.model;

import java.util.Collection;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
            fetch=FetchType.EAGER,
            mappedBy="bateau")
    @OrderBy("nom ASC")
    private Collection<Marin> equipage = new TreeSet<Marin>(new NameComparator());

    @Enumerated(EnumType.STRING)
    @Column(name="status", length=32)
    private BateauStatus status;

    @ManyToOne(
            cascade=CascadeType.PERSIST,
            fetch=FetchType.EAGER)
    private Port port;

    public Bateau() {
        status = BateauStatus.MER;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Marin> getEquipage() {
        return equipage;
    }

    public void setMarin(Marin marin) {
        equipage.add(marin);
    }

    public BateauStatus getStatus() {
        return status;
    }

    public void setStatus(BateauStatus status) {
        this.status = status;
    }

    public Port getPort() {
        return BateauStatus.MER.equals(status) ? null : port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

}
