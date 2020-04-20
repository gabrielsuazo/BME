package com.example.recyclerview.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Les objets de type module sont d'un des 4 types et sont associés à un bilan (numéro bilan)
 * Chaque module possède une liste avec ses sous-modules
 */
public class Module {
    private int numeroBilan;
    private String nom;
    private List<Object> lstSousModules;
    int color;

    public Module(String name, int color){
        nom = name;
        this.color = color;
        lstSousModules = new ArrayList<Object>();
        switch(name){
            case "Module HANDICAP":
                lstSousModules.add(new SousModule("Identité",color));
                lstSousModules.add(new SousModule("Fonctions cognitives",color));
                lstSousModules.add(new SousModule("Motricité/Sensorialité",color));
                lstSousModules.add(new SousModule("AVQ/AIVQ",color));
                lstSousModules.add(new SousModule("Critères",color));
                lstSousModules.add(new SousModule("Graphiques",color));
                break;

            case "Module MODE DE VIE":
                lstSousModules.add(new SousModule("Informations aidant",color));
                lstSousModules.add(new SousModule("Activités du patient",color));
                lstSousModules.add(new SousModule("Habiletés relationnelles/sociales",color));
                lstSousModules.add(new SousModule("Besoins aidant",color));
                lstSousModules.add(new SousModule("Synthèse",color));
                break;

            case "Module HABITAT":
                lstSousModules.add(new SousModule("Evaluation lieux de vie",color));
                lstSousModules.add(new SousModule("Evaluation équipements et services quartier",color));
                break;

            case "Conclusion":
                lstSousModules.add(new SousModule("Ergothérapie",color));
                lstSousModules.add(new SousModule("Renseignements",color));
                lstSousModules.add(new SousModule("Evaluation",color));
                lstSousModules.add(new SousModule("Diagnostique",color));
                break;
        }


    }

    String getNom(){
        return this.nom;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public List<Object> getLstSousModules() {
        return lstSousModules;
    }
}

