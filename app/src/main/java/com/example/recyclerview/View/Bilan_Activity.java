package com.example.recyclerview.View;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.recyclerview.R;


public class Bilan_Activity extends AppCompatActivity implements View.OnClickListener {

    private CardView handicap,modeDeVie,habitat,conclusion;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilan);

        handicap = findViewById(R.id.moduleHandicap);
        modeDeVie = findViewById(R.id.moduleModeDeVie);
        habitat = findViewById(R.id.moduleHabitat);
        conclusion = findViewById(R.id.conclusion);

        handicap.setOnClickListener(Bilan_Activity.this);
        modeDeVie.setOnClickListener(Bilan_Activity.this);
        habitat.setOnClickListener(Bilan_Activity.this);
        conclusion.setOnClickListener(Bilan_Activity.this);



    }

    /**
     * La méthode onClick permet de configurer les boutons des 4 modules
     * Lorsqu'on click sur un des modules, Bilan_Activity se relance avec le module choisi et le premier sous-module
     * D’où sous_module_choisi = 0
     * La couleur nous permet d'identifier le module choisi et donner cette couleur aux sous-modules
     * @param v
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Module_Activity.class);
        if (v instanceof CardView){
            int color = ((CardView) v).getCardBackgroundColor().getDefaultColor();
            intent.putExtra("color", color);
            int sous_module_choisi = 0;
            intent.putExtra("sous_module_choisi",sous_module_choisi);
        }
        startActivity(intent);
    }
}
