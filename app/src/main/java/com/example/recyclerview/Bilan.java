package com.example.recyclerview;

import java.util.ArrayList;

public class Bilan {
    int numero;
    ArrayList<Module> modules;

    Bilan(){
        modules = new ArrayList<Module>(4);
        modules.add(new Module("Module HANDICAP"));
        modules.add(new Module("Module MODE DE VIE"));
        modules.add(new Module("Module HABITAT"));
        modules.add(new Module("Conclusion"));
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero(){
        return this.numero;
    }
}