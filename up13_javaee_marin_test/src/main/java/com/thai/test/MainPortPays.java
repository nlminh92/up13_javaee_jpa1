package com.thai.test;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thai.model.Pays;
import com.thai.model.Port;

public class MainPortPays {

    public static void main(String[] args) {

        Pays pays1 = new Pays("United States");
        Pays pays2 = new Pays("France");
        Pays pays3 = new Pays("Japan");
        Pays pays4 = new Pays("United Kingdom");

        Port port11 = new Port("Port of New Orleans", pays1);
        Port port12 = new Port("Port of Amory", pays1);
        Port port13 = new Port("Port of Anchorage", pays1);
        Port port14 = new Port("Ashland Harbor", pays1);

        Port port21 = new Port("Port Fluvial d'Arles", pays2);
        Port port22 = new Port("Le Port du Crouesty", pays2);
        Port port23 = new Port("Port d'Evian", pays2);
        Port port24 = new Port("Port de Le Havre", pays2);

        Port port31 = new Port("Port of Mizushima", pays3);
        Port port32 = new Port("Port of Sendai", pays3);

        Port port41 = new Port("Port of Liverpool", pays4);
        Port port42 = new Port("Port of Southampton", pays4);
        Port port43 = new Port("Thamesport", pays4);

        Port[] port1 = {port11, port12, port13, port14};
        pays1.setPorts(Arrays.asList(port1));

        Port[] port2 = {port21, port22, port23, port24};
        pays2.setPorts(Arrays.asList(port2));

        Port[] port3 = {port31, port32};
        pays3.setPorts(Arrays.asList(port3));

        Port[] port4 = {port41, port42, port43};
        pays4.setPorts(Arrays.asList(port4));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("marin_test");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(pays1);
        em.persist(pays2);
        em.persist(pays3);
        em.persist(pays4);

        em.persist(port11);
        em.persist(port12);
        em.persist(port13);
        em.persist(port14);

        em.persist(port21);
        em.persist(port22);
        em.persist(port23);
        em.persist(port24);

        em.persist(port31);
        em.persist(port32);

        em.persist(port41);
        em.persist(port42);
        em.persist(port43);

        em.getTransaction().commit();


    }

}
