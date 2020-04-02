package com.example.recyclerview;

import java.util.ArrayList;

public class Ergotherapeute extends Personne {

    ArrayList<Patient> patients;

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    Ergotherapeute(String nom, String prenom){
        super(nom,prenom);
        patients = new ArrayList<Patient>();
    }
}
