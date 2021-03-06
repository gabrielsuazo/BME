package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class Bilan_Activity extends AppCompatActivity implements View.OnClickListener {

    private CardView handicap,modeDeVie,habitat,conclusion;

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

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Module_Activity.class);
        if (v instanceof CardView){
            int color = ((CardView) v).getCardBackgroundColor().getDefaultColor();
            intent.putExtra("color", color);
        }
        startActivity(intent);
    }
}
