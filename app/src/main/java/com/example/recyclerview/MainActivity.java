package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Object> lstPatient;
    Button modifier = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPatient = new ArrayList<Object>();                                               //On créé une liste de patients. En réalité, cette liste est un paramètre de l'ergothérapeute
        int k = 5;

        for (int i = 1; i <= k; i++){
            lstPatient.add(new Patient("Pierre " + i, "Dupont","Date: 19/03/12"));
        }

        RecyclerView myRV = (RecyclerView) findViewById(R.id.recyclerViewPatients);         //Création du Recycler View
        RecyclerViewAdapter myAdapter;
        myAdapter = new RecyclerViewAdapter(this,lstPatient);                       //Adaptateur qui prends la liste de patients
        myRV.setLayoutManager((new GridLayoutManager(this,3)));              //RV en forme de grille, avec 3 colonnes
        myRV.setAdapter(myAdapter);                                                           //Le ClickListener est directement dans le RV (un pour chaque patient)

        // On récupère la vue associée au bouton de modification des paramètres de l'ergothérapeuthe
        modifier = findViewById(R.id.modifierErgo);
        modifier.setOnClickListener(listenerModifier);
    }

    View.OnClickListener listenerModifier = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent activiteErgo = new Intent(MainActivity.this, Ergotherapeute_Activity.class);
            startActivity(activiteErgo);
        }
    };

}
