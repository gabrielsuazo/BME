package com.example.recyclerview;

public class SousModule {
    private String nom;
    private int couleur;
    private boolean choisi;

    SousModule(String name, int color){
        this.nom = name;
        this.couleur = color;
        this.choisi = false;
    }

    public String getNom(){
        return this.nom;
    }
    void setCouleur(int color){
        couleur = color;
    }
    public int getCouleur(){
        return this.couleur;
    }
    public boolean isChoisi(){
        return this.choisi;
    }
    public void setChoisi(){
        this.choisi = true;
    }
}
