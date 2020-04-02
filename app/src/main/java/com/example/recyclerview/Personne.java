package com.example.recyclerview;

abstract public class Personne {
    private String nom, prenom;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Personne(String nom, String prenom){
        setNom(nom);
        setPrenom(prenom);
    }

    public Personne(){

    }
}
