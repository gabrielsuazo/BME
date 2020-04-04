package com.example.recyclerview;

import android.os.Parcel;

import java.util.ArrayList;

/**
 * Chaque objet Patient représente un patient de l'ergo. Chaque patient est identifié par un numéro id
 * date stocke la date de la dernière modification au patient
 * Chaque patient possède une liste de bilans (que l'on récupère de la base de données avec l'id du patient)
 */

public class Patient extends Personne{
    int id;
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

    //Création du Patient "vide" qui sert comme bouton pour créer des nouveaux patients
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
