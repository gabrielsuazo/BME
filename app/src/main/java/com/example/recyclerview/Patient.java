package com.example.recyclerview;

import java.util.ArrayList;

public class Patient {

    private String nom, prenom, date;
    ArrayList<Bilan> bilans;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public ArrayList<Bilan> getBilans() {
        return bilans;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    Patient(String prenom, String nom, String date){
        this.setPrenom(prenom);
        this.setNom(nom);
        this.setDate(date);
        this.bilans = new ArrayList<Bilan>();
    }
}
