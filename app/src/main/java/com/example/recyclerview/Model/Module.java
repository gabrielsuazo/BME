package com.example.recyclerview.Model;

/**
 * Les objets de type module sont d'un des 4 types et sont associés à un bilan (numéro bilan)
 * Chaque module possède une liste avec ses sous-modules
 */
public class Module {
    private int numeroBilan;
    private String nom;
    private String[] sous_modules;

    Module(String name){

        nom = name;
    }

    String getNom(){
        return this.nom;
    }
}

