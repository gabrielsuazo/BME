package com.example.recyclerview.View;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.recyclerview.R;

import static android.content.Context.MODE_PRIVATE;

public class DialogMotdepasse extends AppCompatDialogFragment {
    private EditText ancienPassword;
    private EditText nouveauPassword;

    AlertDialog dialog;
    // Méthode de création de la boîte de dialogue
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Builder comme son nom l'indique va nous permettre de construire les boites de dialogues
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Définition de la mise en page de la boîte de dialogue
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_mot_de_passe, null);

        // Récupération de toutes les vues de la boite de dialogue a partir de la vue associee au dialogue
        ancienPassword = view.findViewById(R.id.edittext_ancien_MDP);
        nouveauPassword = view.findViewById(R.id.edittext_nouveau_MDP);

        builder.setView(view)  // Definition de la vue associée à la boite de dialogue
                .setTitle( "Nouveau mot de passe")  // titre de la boite de dialogue
                .setNegativeButton("Annuler", null)
                .setPositiveButton("Confirmer",null);

        dialog = builder.create();
        return  dialog;
    }

    @Override
    public void onResume() {
        super.onResume();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Récupération de l'ancien password stocké pour le comparer
                a "ancienPassword" càd le mdp renseigné avant de confirmer la creation du nouveau password*/
                SharedPreferences prefs = getContext().getSharedPreferences(Login_activity.IDENTIFIANTS,MODE_PRIVATE);
                String ancienMDP_sauvegardé = prefs.getString(Login_activity.KEY_MDP,"");

                // si les champs sont bien remplis
                String ancien_mdp_renseigné = ancienPassword.getText().toString();
                if (!TextUtils.isEmpty(ancienPassword.getText().toString())
                        && !TextUtils.isEmpty(nouveauPassword.getText().toString())) {
                    // Si l'ancien mot de passe renseigné est correct
                    if(ancien_mdp_renseigné.compareTo(ancienMDP_sauvegardé)==0){
                        //On enregistre le nouveau mot de passe
                        SharedPreferences.Editor editeur = prefs.edit();
                        String nouvMDP = nouveauPassword.getText().toString();
                        // On sauvevarde ce mot de passe en l'associant la clé KEY_MDP
                        editeur.putString(Login_activity.KEY_MDP,nouvMDP);
                        editeur.apply();  // on applique le changement
                        Toast.makeText(getContext(),
                                "Nouveau mot de passe enregistré",Toast.LENGTH_LONG).show();

                        dialog.dismiss(); //  permet d'enlever la dialogue de l'ecran en envoyer le Toast précedent
                    }else{
                        Toast.makeText(getContext(),
                                "L'ancien mot de passe renseigné est incorrect",
                                Toast.LENGTH_LONG).show();
                    }
                    // si tous les champs ne sont pas renseignés
                }else{
                    Toast.makeText(getContext(),
                            "Veuillez remplir tous les champs",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    // recuperation du mot de passe avec getSharedPreferences
}
