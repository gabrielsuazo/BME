package com.example.recyclerview;

import android.os.Parcel;

import java.util.ArrayList;

public class Patient extends Personne{

    private String date;
    ArrayList<Bilan> bilans;


    public ArrayList<Bilan> getBilans() {
        return bilans;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    Patient(String nom, String prenom, String date){
        super(nom,prenom);
        this.setDate(date);
        this.bilans = new ArrayList<Bilan>();
    }

    Patient(){
        setDate("");
        setNom("");
        setPrenom("");
        this.bilans = new ArrayList<Bilan>();

    }

    boolean isVide(){
        return (this.getDate() == "" && this.getNom() == "" && this.getPrenom() == "");
    }



}
