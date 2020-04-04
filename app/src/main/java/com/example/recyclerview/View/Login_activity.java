package com.example.recyclerview.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recyclerview.R;

public class Login_activity extends AppCompatActivity {
    public static final String IDENTIFIANTS = "nom_utilisateur_et_mot_de_passe";
    public static  String KEY_NOM ="cle_nom" ;
    public static String KEY_MDP ="cle_mot_du_mot_passe" ;

    private static final String MDP_par_defaut = "12345";
    private static final String Nom_utilisateur_par_defaut = "Ergotherapeute";

    EditText motDePasse = null;
    Button entrer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        entrer = (Button)findViewById(R.id.entrer);
        motDePasse = (EditText)findViewById(R.id.mot_de_passe);
        verifie();
    }

    public void verifie() {
        SharedPreferences sauvegarde = getSharedPreferences(IDENTIFIANTS, MODE_PRIVATE);
        SharedPreferences.Editor editeur;
        if ((sauvegarde.getString(KEY_MDP, "") == "" && sauvegarde.getString(KEY_NOM, "") == "")
                || sauvegarde.getString(KEY_MDP, "").compareTo(MDP_par_defaut) == 0) {

            Toast.makeText(this, "Votre mot de passe " +
                    "est 12345, veuillez le changer en appuyant sur le bouton 'configurer'", Toast.LENGTH_LONG).show();
            editeur = sauvegarde.edit();
            editeur.putString(KEY_MDP, MDP_par_defaut);
            editeur.putString(KEY_NOM, Nom_utilisateur_par_defaut);
            editeur.apply();
        }
    }

    public void connexion(View view) {
        SharedPreferences sauvegarde = getSharedPreferences(IDENTIFIANTS,MODE_PRIVATE);
        String mdp = sauvegarde.getString(KEY_MDP,"");

        if(motDePasse.getText().toString().compareTo(mdp) == 0){
            Intent intent = new Intent(Login_activity.this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(Login_activity.this,"Mot de passe incorrect'",Toast.LENGTH_LONG).show();
        }
    }


}
