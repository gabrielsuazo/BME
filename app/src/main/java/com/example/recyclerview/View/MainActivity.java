package com.example.recyclerview.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerview.Controler.Patient;
import com.example.recyclerview.R;
import com.example.recyclerview.Controler.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe possède un recycler view qui affiche la liste des patients de l'ergothérapeute
 * Elle récupère cette liste de la base de données
 */
public class MainActivity extends AppCompatActivity {

    List<Object> lstPatient;
    RecyclerViewAdapter myAdapter;
    Button modifier = null;
    RecyclerView myRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Code temporaire: création d'une liste de patients. Normalement, on récupère la liste depuis la base de données
        lstPatient = new ArrayList<Object>();
        int k = 5;
        for (int i = 1; i <= k; i++){
            lstPatient.add(new Patient("Dupont", "Pierre " + i,"Date: 19/03/12"));
        }
        lstPatient.add(new Patient());
        //


        //Création du Recycler View
        myRV = findViewById(R.id.recyclerViewPatients);
        //Adaptateur qui prends la liste de patients
        myAdapter = new RecyclerViewAdapter(this,lstPatient);
        //RV en forme de grille, avec 3 colonnes
        myRV.setLayoutManager((new GridLayoutManager(this,3)));
        myRV.setAdapter(myAdapter);

        //Rq: Le ClickListener des patients est directement dans le RV(Classe Recycler view Adapter, méthode OnBindViewHolder, cas 0)

        // On récupère la vue associée au bouton de modification des paramètres de l'ergothérapeuthe
        modifier = findViewById(R.id.modifierErgo);
        modifier.setOnClickListener(listenerModifier);
    }

    View.OnClickListener listenerModifier = new View.OnClickListener() {

        /**
         * ClickListener qui permet d'accéder à l'activité de l'ergothérapeute
         * @param v Bouton modifier
         */
        @Override
        public void onClick(View v) {
            Intent activiteErgo = new Intent(MainActivity.this, Ergotherapeute_Activity.class);
            startActivity(activiteErgo);
        }
    };

}
