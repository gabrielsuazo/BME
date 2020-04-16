package com.example.recyclerview.View;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.recyclerview.Model.SousModule;
import com.example.recyclerview.R;
import com.example.recyclerview.Controler.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe nous permet d'afficher le sous-module qui a été choisi
 */

public class Module_Activity extends AppCompatActivity implements View.OnClickListener {

    private CardView handicap,modeDeVie,habitat,conclusion,home;
    List<Object> lstSousModules;
    int sous_module_choisi;
    private ImageView retour;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        lstSousModules = new ArrayList<Object>();

        handicap = findViewById(R.id.moduleHandicap);
        modeDeVie = findViewById(R.id.moduleModeDeVie);
        habitat = findViewById(R.id.moduleHabitat);
        conclusion = findViewById(R.id.conclusion);

        retour = findViewById(R.id.retour);
        home = findViewById(R.id.home);


        Intent intent = getIntent();
        int color = intent.getExtras().getInt("color");
        int sous_module_choisi = intent.getExtras().getInt("sous_module_choisi");
        configurationModules(handicap,color,sous_module_choisi);
        configurationModules(modeDeVie,color,sous_module_choisi);
        configurationModules(habitat,color,sous_module_choisi);
        configurationModules(conclusion,color,sous_module_choisi);

        retour.setOnClickListener(this);
        home.setOnClickListener(this);


        //Création du Recycler View qui affiche tous les sous-modules du module choisi
        RecyclerView RVMenuSousModules = (RecyclerView) findViewById(R.id.recyclerViewSousModules);
        RecyclerViewAdapter myAdapter;
        myAdapter = new RecyclerViewAdapter(this,lstSousModules);
        RVMenuSousModules.setLayoutManager((new StaggeredGridLayoutManager(lstSousModules.size(),StaggeredGridLayoutManager.VERTICAL)));
        RVMenuSousModules.setAdapter(myAdapter);

        //Création du Recycler View du sous-module choisi

    }

    /**
     * Cette méthode permet de configurer le ClickListener du bouton Home, des boutons des modules et du bouton de retour
     * @param v est la view. Son type et son id nous permettra de traiter les différents cas
     */
    public void onClick(View v) {
        Intent intent = new Intent();
        if (v instanceof CardView){
            switch (v.getId()){

                //Cas bouton Home
                case R.id.home:
                    //On revient à l'activité main (déjà créée) en éliminant les autres activités
                    intent = new Intent(this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    break;

                //Cas des modules
                default:
                    intent = new Intent(this,Module_Activity.class);
                    int color = ((CardView) v).getCardBackgroundColor().getDefaultColor();
                    intent.putExtra("color", color);
                    intent.putExtra("sous_module_choisi",0);
                    finish();

            }
        }
        //cas de l'option retour (code temporaire, ce bouton sera peut-être  supprimé)
        else if (v instanceof ImageView) {
            //On revient à l'acitivité bilan (déjà créée)
            intent = new Intent(this, Bilan_Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        }

        startActivity(intent);
        }

    /**
     * Cette méthode permet de configurer les modules (taille, couleur et ClickListener)
     * @param v view des modules
     * @param color la couleur nous permet d'identifier le module choisi
     * @param sous_module_choisi la méthode pour configurer les sous-modules se lance avec le sous-module choisi dans le module choisi
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public void configurationModules(CardView v, int color,int sous_module_choisi){

        //Si c'est le module choisi, on augmente sa taille et on configure ses sous-modules
        if (v.getCardBackgroundColor().getDefaultColor() == color){
            ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
            layoutParams.width = 250;
            layoutParams.height = 150;
            v.setLayoutParams(layoutParams);
            configurationLstSousModules(v,color,lstSousModules,sous_module_choisi);

        }
        //Sinon, on grise la couleur du module
        else {
            v.setBackgroundTintList(this.getResources().getColorStateList(R.color.gris));       //Les modules non choisis sont grisés
            v.setOnClickListener(this);

        }
}

    /**
     *
     * @param v View du module. Permet de l'identifier et faire le case avec son id
     * @param color La couleur du module choisi est donné aux sous-modules
     * @param lstSousModules liste qui est affiché dans RVMenuSousModules
     * @param sous_module_choisi le sous-module choisi n'est pas grisé et sa taille augmente
     * @see RecyclerViewAdapter méthode OnBindViewHolder, cas 2 pour la configuration des sous-modules
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public void configurationLstSousModules(CardView v, int color, List<Object> lstSousModules,int sous_module_choisi){
        switch (v.getId()){
            case R.id.moduleHandicap:   //Ajout des sous-modules au module Handicap
                lstSousModules.add(new SousModule("Identité",color));
                lstSousModules.add(new SousModule("Fonctions cognitives",color));
                lstSousModules.add(new SousModule("Motricité/Sensorialité",color));
                lstSousModules.add(new SousModule("AVQ/AIVQ",color));
                lstSousModules.add(new SousModule("Critères",color));
                lstSousModules.add(new SousModule("Graphiques",color));
                break;
            case R.id.moduleModeDeVie:  //Ajout des sous-modules au module Mode de Vie
                lstSousModules.add(new SousModule("Informations aidant",color));
                lstSousModules.add(new SousModule("Activités du patient",color));
                lstSousModules.add(new SousModule("Habiletés relationnelles/sociales",color));
                lstSousModules.add(new SousModule("Besoins aidant",color));
                lstSousModules.add(new SousModule("Synthèse",color));
                break;
            case R.id.moduleHabitat:    //Ajout des sous-modules au module Habitat
                lstSousModules.add(new SousModule("Evaluation lieux de vie",color));
                lstSousModules.add(new SousModule("Evaluation équipements et services quartier",color));
                break;
            case R.id.conclusion:       //Ajout des sous-modules au module Conclusion
                lstSousModules.add(new SousModule("Ergothérapie",color));
                lstSousModules.add(new SousModule("Renseignements",color));
                lstSousModules.add(new SousModule("Evaluation",color));
                lstSousModules.add(new SousModule("Diagnostique",color));
                break;
        }

        ((SousModule) lstSousModules.get(sous_module_choisi)).setChoisi();

        }


}
