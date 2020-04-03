package com.example.recyclerview.Controler;

import com.example.recyclerview.Model.Personne;
import com.example.recyclerview.Model.Bilan;
import java.util.ArrayList;

public class Patient extends Personne {

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


    public Patient(String nom, String prenom, String date){
        super(nom,prenom);
        this.setDate(date);
        this.bilans = new ArrayList<Bilan>();
    }

    public Patient(){
        setDate("");
        setNom("");
        setPrenom("");
        this.bilans = new ArrayList<Bilan>();

    }

    boolean isVide(){
        return (this.getDate() == "" && this.getNom() == "" && this.getPrenom() == "");
    }



}
