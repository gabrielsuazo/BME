package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class Informations_Patient_Activity extends AppCompatActivity implements DialogueNom.NomDialogListener, DialoguePrenom.PrenomDialogListener {

    private Button modifierNom = null;
    private Button modifierPrenom = null;
    private TextView nomPatient = null;
    private TextView prenomPatient = null;
    Patient patient;

    // Définition des boîtes de dialogue
    private DialogFragment fragmentNom = null;
    private DialogFragment fragmentPrenom = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations_patient);

        Intent i = getIntent();

        modifierNom = findViewById(R.id.modifierNom);
        modifierPrenom = findViewById(R.id.modifierPrenom);
        nomPatient = findViewById(R.id.texteNom);
        prenomPatient = findViewById(R.id.textePrenom);

        modifierNom.setOnClickListener(listenerModifierNom);
        modifierPrenom.setOnClickListener(listenerModifierPrenom);

        Intent intent = getIntent();
        nomPatient.setText("Entrer un nom");
        prenomPatient.setText("Entrer un prénom");
    }

    // Création du listener de modification du nom du patient
    View.OnClickListener listenerModifierNom = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Création de la boîte de dialogue
            fragmentNom = new DialogueNom();
            // Affichage de la boîte de dialogue
            fragmentNom.show(getSupportFragmentManager(), "modifierNom");
        }
    };

    // Création du listener de modification du prénom du patient
    View.OnClickListener listenerModifierPrenom = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Création de la boîte de dialogue
            fragmentPrenom = new DialoguePrenom();
            // Affichage de la boîte de dialogue
            fragmentPrenom.show(getSupportFragmentManager(), "modifierPrenom");
        }
    };

    public void onDialogNomPositiveClick(DialogFragment dialog, String nom) {
        // Le nom du patient prend celui donné dans la boîte de dialogue
        nomPatient.setText(nom);
        patient.setNom(nom);
    }

    public void onDialogPrenomPositiveClick(DialogFragment dialog, String prenom) {
        // Le prénom du patient prend celui donné dans la boîte de dialogue
        prenomPatient.setText(prenom);
        patient.setPrenom(prenom);
    }
}
