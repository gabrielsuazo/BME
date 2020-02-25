package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;


import androidx.fragment.app.DialogFragment;

public class DialogueNom extends DialogFragment {

    private EditText nom = null;

    // Création de l'interface permettant de récupérer les informations saisies dans la boîte de dialogue
    public interface NomDialogListener {
        void onDialogNomPositiveClick(DialogFragment dialog, String nom);
    }
    // Listener permettant de transférer les informations de la boîte de dialogue vers l'hôte
    private NomDialogListener listener;

    // Méthode de callback pour le transfert d'information vers l'hôte
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NomDialogListener so we can send events to the host
            listener = (NomDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException("Erreur");
        }
    }

    // Méthode de création de la boîte de dialogue
    @Override
    public Dialog onCreateDialog(Bundle SavedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Définition de la mise en page de la boîte de dialogue
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialogue_nom_layout, null));
        // Définition du titre de la boîte de dialogue
        builder.setTitle(R.string.nouveauNom);
        // Définition du bouton "Confirmer"
        builder.setPositiveButton(R.string.confirmer, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // On récupère l'EditText
                nom = ((AlertDialog) dialog).findViewById(R.id.zoneEditionNom);
                // On renvoie le contenu de l'EditText vers l'activité
                listener.onDialogNomPositiveClick(DialogueNom.this, nom.getText().toString());
            }
        });
        // Définition du bouton "Annuler"
        builder.setNegativeButton(R.string.annuler, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                DialogueNom.this.getDialog().cancel();
            }
        });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
