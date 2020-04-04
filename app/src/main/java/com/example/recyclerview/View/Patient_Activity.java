package com.example.recyclerview.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.recyclerview.Model.Bilan;

import com.example.recyclerview.R;
import com.example.recyclerview.Controler.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe nous permets d'accèdes à l'information et aux bilans du patient qui a été choisi
 */

public class Patient_Activity extends AppCompatActivity {

    List<Object> lstBilans;
    private TextView nom,prenom;
    private Button modifier;
    String lastName,firstName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_);

        nom = (TextView) findViewById(R.id.nom_patient_choisi);
        prenom = (TextView) findViewById(R.id.prenom_patient_choisi);
        Intent intent = getIntent();

        //Code temporaire: Normalement, on doit récupérer l'id du patient puis chercher son nom et prénom dans la base de données
        lastName = intent.getStringExtra("Nom");
        firstName = intent.getStringExtra("Prenom");
        //

        nom.setText(lastName);
        prenom.setText(firstName);

        //Code temporaire: Normalement, on doit récupérer les bilans du patient à partir de la base de données
        lstBilans = new ArrayList<Object>();
        int k = 2;
        for (int i = 1; i <= k; i++) {
            Bilan bilan = new Bilan();
            bilan.setNumero(i);
            lstBilans.add(bilan);
        }
        //On ajoute le bouton pour créer des nouveaux bilans
        lstBilans.add(Bilan.nouveauBilan());
        //

        //Création du RV qui affiche les bilans du patient
        RecyclerView myRV = (RecyclerView) findViewById(R.id.recyclerViewBilans);
        RecyclerViewAdapter myAdapter;
        myAdapter = new RecyclerViewAdapter(this, lstBilans);
        //RV en forme de grille, avec 2 colonnes
        myRV.setLayoutManager((new GridLayoutManager(this, 2)));
        myRV.setAdapter(myAdapter);

        //Rq: Le ClickListener des bilans est dans le RV(Classe Recycler view Adapter, méthode OnBindViewHolder, cas 1)

        modifier = findViewById(R.id.modifierPatient);
        modifier.setOnClickListener(listenerModifier);
    }

    View.OnClickListener listenerModifier = new View.OnClickListener() {

        /**
         * ClickListener qui permet d'accéder à l'activité des informations du patient
         * @param v Bouton modifier
         */
        @Override
        public void onClick(View v) {
            Intent activitePatient = new Intent(Patient_Activity.this, Informations_Patient_Activity.class);
            startActivity(activitePatient);
        }
    };


}

