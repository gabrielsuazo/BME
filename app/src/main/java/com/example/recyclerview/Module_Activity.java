package com.example.recyclerview;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class Module_Activity extends AppCompatActivity implements View.OnClickListener {

    private CardView handicap,modeDeVie,habitat,conclusion;
    List<Object> lstSousModules;
    int sous_module_choisi;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        lstSousModules = new ArrayList<Object>();

        handicap = findViewById(R.id.moduleHandicap);
        modeDeVie = findViewById(R.id.moduleModeDeVie);
        habitat = findViewById(R.id.moduleHabitat);
        conclusion = findViewById(R.id.conclusion);


        Intent intent = getIntent();
        int color = intent.getExtras().getInt("color");
        int sous_module_choisi = intent.getExtras().getInt("sous_module_choisi");
        configurationModules(handicap,color,sous_module_choisi);
        configurationModules(modeDeVie,color,sous_module_choisi);
        configurationModules(habitat,color,sous_module_choisi);
        configurationModules(conclusion,color,sous_module_choisi);

        RecyclerView myRV = (RecyclerView) findViewById(R.id.recyclerViewSousModules);         //Création du Recycler View
        RecyclerViewAdapter myAdapter;
        myAdapter = new RecyclerViewAdapter(this,lstSousModules);
        myRV.setLayoutManager((new StaggeredGridLayoutManager(lstSousModules.size(),StaggeredGridLayoutManager.VERTICAL)));
        myRV.setAdapter(myAdapter);
    }

public void onClick(View v) {
        Intent intent = new Intent(this,Module_Activity.class);
        if (v instanceof CardView){
        int color = ((CardView) v).getCardBackgroundColor().getDefaultColor();
        intent.putExtra("color", color);
        intent.putExtra("sous_module_choisi",0);
        }
        startActivity(intent);
        }
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public void configurationModules(CardView v, int color,int sous_module_choisi){
        if (v.getCardBackgroundColor().getDefaultColor() == color){
            ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
            layoutParams.width = 250;
            layoutParams.height = 150;
            v.setLayoutParams(layoutParams);
            configurationLstSousModules(v,color,lstSousModules,sous_module_choisi);

        }
        else {
            v.setBackgroundTintList(this.getResources().getColorStateList(R.color.gris));
            v.setOnClickListener(this);

        }
}

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public void configurationLstSousModules(CardView v, int color, List<Object> lstSousModules,int sous_module_choisi){
        switch (v.getId()){
            case R.id.moduleHandicap:
                lstSousModules.add(new SousModule("Identité",color));
                lstSousModules.add(new SousModule("Fonctions cognitives",color));
                lstSousModules.add(new SousModule("Motricité/Sensorialité",color));
                lstSousModules.add(new SousModule("AVQ/AIVQ",color));
                lstSousModules.add(new SousModule("Critères",color));
                lstSousModules.add(new SousModule("Graphiques",color));
                break;
            case R.id.moduleModeDeVie:
                lstSousModules.add(new SousModule("Informations aidant",color));
                lstSousModules.add(new SousModule("Activités du patient",color));
                lstSousModules.add(new SousModule("Habiletés relationnelles/sociales",color));
                lstSousModules.add(new SousModule("Besoins aidant",color));
                lstSousModules.add(new SousModule("Synthèse",color));
                break;
            case R.id.moduleHabitat:
                lstSousModules.add(new SousModule("Evaluation lieux de vie",color));
                lstSousModules.add(new SousModule("Evaluation équipements et services quartier",color));
                break;
            case R.id.conclusion:
                lstSousModules.add(new SousModule("Ergothérapie",color));
                lstSousModules.add(new SousModule("Renseignements",color));
                lstSousModules.add(new SousModule("Evaluation",color));
                lstSousModules.add(new SousModule("Diagnostique",color));
                break;
        }

        ((SousModule) lstSousModules.get(sous_module_choisi)).setChoisi();

        }


}
