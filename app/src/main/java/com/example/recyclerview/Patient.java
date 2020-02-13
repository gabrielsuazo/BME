package com.example.recyclerview;

import java.util.ArrayList;

public class Patient {

    private String nom, date;
    ArrayList<Bilan> bilans;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    Patient(String name, String date){
        this.setNom(name);
        this.setDate(date);
    }
}
