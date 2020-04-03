package com.example.recyclerview.Model;

public class Module {
    private String nom;
    private String[] sous_modules;

    Module(String name){

        nom = name;
    }

    String getNom(){
        return this.nom;
    }
}

