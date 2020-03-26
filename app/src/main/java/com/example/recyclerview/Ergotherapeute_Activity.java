package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ergotherapeute_Activity extends AppCompatActivity implements DialogueNom.NomDialogListener, DialoguePrenom.PrenomDialogListener {

    // Définition des vues de l'activité
    private Button modifierNom = null;
    private Button modifierPrenom = null;
    private TextView nomErgo = null;
    private TextView prenomErgo = null;

    // Définition des boîtes de dialogue
    private DialogFragment fragmentNom = null;
    private DialogFragment fragmentPrenom = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergotherapeute);

        Intent i = getIntent();

        // Récupération de toutes les vues de l'activité
        modifierNom = findViewById(R.id.modifierNom);
        modifierPrenom = findViewById(R.id.modifierPrenom);
        nomErgo = findViewById(R.id.texteNom);
        prenomErgo = findViewById(R.id.textePrenom);

        modifierNom.setOnClickListener(listenerModifierNom);
        modifierPrenom.setOnClickListener(listenerModifierPrenom);

    }

    // Création du listener de modification du nom de l'ergothérapeute
    View.OnClickListener listenerModifierNom = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Création de la boîte de dialogue
            fragmentNom = new DialogueNom();
            // Affichage de la boîte de dialogue
            fragmentNom.show(getSupportFragmentManager(), "modifierNom");
        }
    };

    // Création du listener de modification du prénom de l'ergothérapeute
    View.OnClickListener listenerModifierPrenom = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Création de la boîte de dialogue
            fragmentPrenom = new DialoguePrenom();
            // Affichage de la boîte de dialogue
            fragmentPrenom.show(getSupportFragmentManager(), "modifierPrenom");
        }
    };

    @Override
    public void onDialogNomPositiveClick(DialogFragment dialog, String nom) {
        // Le nom de l'ergothérapeute prend celui donné dans la boîte de dialogue
        nomErgo.setText(nom);
    }

    @Override
    public void onDialogPrenomPositiveClick(DialogFragment dialog, String prenom) {
        // Le prénom de l'ergothérapeute prend celui donné dans la boîte de dialogue
        prenomErgo.setText(prenom);
    }

    public void configuation(View view) {
        openDialog();
    }

    private void openDialog() {
        DialogMotdepasse dialog = new DialogMotdepasse();
        dialog.show(getSupportFragmentManager(),"modifier_mot_de_passe");

    }
}

