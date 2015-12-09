package com.thai.test;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.thai.model.Bateau;
import com.thai.model.Marin;

public class MainBateau {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(1987, 12, 25);
        Marin marin1 = new Marin();
        marin1.setDateDeNaissance(calendar.getTime());
        marin1.setNom("Luffy");
        marin1.setPrenom("Monkey");

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

        Bateau bateau1 = new Bateau();
        bateau1.setNom("Hawk Eyes");
        bateau1.setMarin(marin1);
        bateau1.setMarin(marin2);

        Bateau bateau2 = new Bateau();
        bateau2.setNom("Ocean Evil");
        bateau2.setMarin(marin3);
        bateau2.setMarin(marin4);
        bateau2.setMarin(marin5);

        marin1.setBateau(bateau1);
        marin2.setBateau(bateau1);
        marin3.setBateau(bateau2);
        marin4.setBateau(bateau2);
        marin5.setBateau(bateau2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("marin_test");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(marin1);
        em.persist(marin2);
        em.persist(marin3);
        em.persist(marin4);
        em.persist(marin5);
        em.persist(bateau1);
        em.persist(bateau2);

        em.getTransaction().commit();

        // Retrieve
        Bateau bateau = em.find(Bateau.class, 2L);
        List<Marin> marinList = bateau.getEquipage();
        System.out.println("Chercher les marin dans le bateau 2: " + marinList);

    }
}
