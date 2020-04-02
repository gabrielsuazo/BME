package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        lastName = intent.getParcelableExtra("Nom");
        firstName = intent.getParcelableExtra("Prenom");

        nom.setText(lastName);
        prenom.setText(firstName);


        lstBilans = new ArrayList<Object>();
        int k = 2;

        for (int i = 1; i <= k; i++) {
            Bilan bilan = new Bilan();
            bilan.setNumero(i);
            lstBilans.add(bilan);
        }
        RecyclerView myRV = (RecyclerView) findViewById(R.id.recyclerViewBilans);
        RecyclerViewAdapter myAdapter;
        myAdapter = new RecyclerViewAdapter(this, lstBilans);
        myRV.setLayoutManager((new GridLayoutManager(this, 2)));
        myRV.setAdapter(myAdapter);

        modifier = findViewById(R.id.modifierPatient);
        modifier.setOnClickListener(listenerModifier);
    }

    View.OnClickListener listenerModifier = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent activitePatient = new Intent(Patient_Activity.this, Informations_Patient_Activity.class);
            startActivity(activitePatient);
        }
    };


}

