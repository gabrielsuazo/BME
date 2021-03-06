package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Object> lstPatient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPatient = new ArrayList<Object>();                                               //On créé une liste de patients. En réalité, cette liste est un paramètre de l'ergothérapeute
        int k = 5;

        for (int i = 1; i <= k; i++){
            lstPatient.add(new Patient("Patient " + i,"Date: 19/03/12"));
        }



        RecyclerView myRV = (RecyclerView) findViewById(R.id.recyclerViewPatients);         //Création du Recycler View
        RecyclerViewAdapter myAdapter;
        myAdapter = new RecyclerViewAdapter(this,lstPatient);                       //Adaptateur qui prends la liste de patients
        myRV.setLayoutManager((new GridLayoutManager(this,3)));              //RV en forme de grille, avec 3 colonnes
        myRV.setAdapter(myAdapter);                                                           //Le ClickListener est directement dans le RV (un pour chaque patient)
    }
}
