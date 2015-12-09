package com.thai.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thai.model.Bateau;
import com.thai.model.BateauStatus;
import com.thai.model.Marin;
import com.thai.model.Pays;
import com.thai.model.Port;

/**
 * Exercice 2 - Question 4, 5
 * @author HO Phu Thai
 *
 */
public class MainPortNullable {

    public static void main(String[] args) {

        // Marines et Bateaux
        Calendar calendar = Calendar.getInstance();

        calendar.set(1987, 12, 25);
        Marin marin1 = new Marin();
        marin1.setDateDeNaissance(calendar.getTime());
        marin1.setNom("Wislow");
        marin1.setPrenom("Perry");

        calendar.set(1945, 2, 15);
        Marin marin2 = new Marin();
        marin2.setDateDeNaissance(calendar.getTime());
        marin2.setNom("Hook");
        marin2.setPrenom("James");

        calendar.set(1983, 9, 24);
        Marin marin3 = new Marin();
        marin3.setDateDeNaissance(calendar.getTime());
        marin3.setNom("Puller");
        marin3.setPrenom("Chester");

        calendar.set(1977, 12, 14);
        Marin marin4 = new Marin();
        marin4.setDateDeNaissance(calendar.getTime());
        marin4.setNom("The Sailor");
        marin4.setPrenom("Billy");

        calendar.set(1997, 2, 11);
        Marin marin5 = new Marin();
        marin5.setDateDeNaissance(calendar.getTime());
        marin5.setNom("Pirate");
        marin5.setPrenom("Young");

        calendar.set(1964, 12, 25);
        Marin marin6 = new Marin();
        marin6.setDateDeNaissance(calendar.getTime());
        marin6.setNom("Luffy");
        marin6.setPrenom("Monkey D.");

        Bateau bateau1 = new Bateau();
        bateau1.setNom("Hawk Eyes");
        bateau1.setMarin(marin1);
        bateau1.setMarin(marin2);
        bateau1.setMarin(marin3);

        Bateau bateau2 = new Bateau();
        bateau2.setNom("Ocean Evil");
        bateau2.setMarin(marin4);
        bateau2.setMarin(marin5);
        bateau2.setMarin(marin6);

        marin1.setBateau(bateau1);
        marin2.setBateau(bateau1);
        marin3.setBateau(bateau1);
        marin4.setBateau(bateau2);
        marin5.setBateau(bateau2);
        marin6.setBateau(bateau2);

        // Ports et Pays
        Pays pays1 = new Pays("United States");
        Pays pays2 = new Pays("France");

        Port port11 = new Port("Port of New Orleans", pays1);
        Port port12 = new Port("Port of Amory", pays1);
        Port port13 = new Port("Port of Anchorage", pays1);
        Port port14 = new Port("Ashland Harbor", pays1);

        Port port21 = new Port("Port Fluvial d'Arles", pays2);
        Port port22 = new Port("Le Port du Crouesty", pays2);
        Port port23 = new Port("Port d'Evian", pays2);
        Port port24 = new Port("Port de Le Havre", pays2);

        Port[] port1 = {port11, port12, port13, port14};
        pays1.setPorts(Arrays.asList(port1));

        Port[] port2 = {port21, port22, port23, port24};
        pays2.setPorts(Arrays.asList(port2));

        // Ajouter la relation entre ports et bateaux
        List<Bateau> bateauList = new ArrayList<Bateau>();
        bateauList.add(bateau1);
        bateauList.add(bateau2);
        port11.setBateaux(bateauList);
        port12.setBateaux(bateauList);
        port13.setBateaux(bateauList);
        port14.setBateaux(bateauList);
        port21.setBateaux(bateauList);
        port22.setBateaux(bateauList);
        port23.setBateaux(bateauList);
        port24.setBateaux(bateauList);

        bateau1.setStatus(BateauStatus.PORT);
        bateau2.setStatus(BateauStatus.MER);

        bateau1.setPort(port11);
        bateau2.setPort(port24);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("marin_test");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(marin1);
        em.persist(marin2);
        em.persist(marin3);
        em.persist(marin4);
        em.persist(marin5);
        em.persist(marin6);
        em.persist(bateau1);
        em.persist(bateau2);

        em.persist(pays1);
        em.persist(pays2);

        em.persist(port11);
        em.persist(port12);
        em.persist(port13);
        em.persist(port14);

        em.persist(port21);
        em.persist(port22);
        em.persist(port23);
        em.persist(port24);

        em.getTransaction().commit();

        // Retrieve
        System.out.println("Les ports de chaque bateau:");
        Bateau bateau = em.find(Bateau.class, bateau1.getId());
        System.out.println("Bateau " + bateau.getNom() + " est au port: " + bateau.getPort());
        bateau = em.find(Bateau.class, bateau2.getId());
        System.out.println("Bateau " + bateau.getNom() + " est au port: " + bateau.getPort());

        MainMarin.printEndLn();
    }
}
