package com.example.recyclerview.Model;


import java.util.ArrayList;

/**
 * La classe Bilan permet de lier l'information d'un BME (4 modules) à un patient
 * Chaque bilan est identifié par un numéro
 * Chaque patient aura une liste de bilans qui lui sera associée
 */
public class Bilan {
    int idPatient;
    int numero;
    ArrayList<Module> modules;

    public Bilan(){
        modules = new ArrayList<Module>(4);
        modules.add(new Module("Module HANDICAP"));
        modules.add(new Module("Module MODE DE VIE"));
        modules.add(new Module("Module HABITAT"));
        modules.add(new Module("Conclusion"));
        this.idPatient = 2;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero(){
        return this.numero;
    }

    //Création du bouton qui sert pour créer des nouveaux bilans
    public static Bilan nouveauBilan(){
        Bilan nouveau = new Bilan();
        nouveau.idPatient = 0;
        return nouveau;
    }

    boolean isVide(){
        return (this.idPatient==0);
    }
}