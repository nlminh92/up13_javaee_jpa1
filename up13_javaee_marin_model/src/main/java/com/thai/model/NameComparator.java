package com.thai.model;

import java.util.Comparator;

public class NameComparator implements Comparator<Marin> {

    @Override
    public int compare(Marin arg0, Marin arg1) {
        return arg0.getNom().compareTo(arg1.getNom());
    }

}
