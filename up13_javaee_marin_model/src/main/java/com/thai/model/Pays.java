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
import javax.persistence.Table;

@Entity
@Table(name = "t_pays")
public class Pays {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "nom", length = 40)
    private String nom;

    @OneToMany(
            mappedBy="pays",
            cascade=CascadeType.PERSIST,
            fetch=FetchType.EAGER)
    private List<Port> portList = new ArrayList<Port>();

    public Pays() {
        this(null);
    }

    public Pays(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Port> getPorts() {
        return portList;
    }

    public void setPort(Port port) {
        this.portList.add(port);
    }

    public void setPorts(List<Port> portList) {
        this.portList.addAll(portList);
    }

}
