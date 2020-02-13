package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Patient_Activity extends AppCompatActivity {

    List<Object> lstBilans;
    private TextView nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_);

        nom = (TextView) findViewById(R.id.nom_patient_choisi);
        Intent intent = getIntent();
        String Nom = intent.getExtras().getString("Nom");
        nom.setText(Nom);

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
    }


}

