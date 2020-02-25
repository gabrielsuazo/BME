package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;


import androidx.fragment.app.DialogFragment;

public class DialoguePrenom extends DialogFragment {

    private EditText prenom = null;

    // Création de l'interface permettant de récupérer les informations saisies dans la boîte de dialogue
    public interface PrenomDialogListener {
        void onDialogPrenomPositiveClick(DialogFragment dialog, String prenom);
    }
    // Listener permettant de transférer les informations de la boîte de dialogue vers l'hôte
    private PrenomDialogListener listener;

    // Méthode de callback pour le transfert d'information vers l'hôte
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NomDialogListener so we can send events to the host
            listener = (PrenomDialogListener) context;
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
        builder.setView(inflater.inflate(R.layout.dialogue_prenom_layout, null));
        // Définition du titre de la boîte de dialogue
        builder.setTitle(R.string.nouveauPrenom);
        // Définition du bouton "Confirmer"
        builder.setPositiveButton(R.string.confirmer, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // On récupère l'EditText
                prenom = ((AlertDialog) dialog).findViewById(R.id.zoneEditionPrenom);
                // On renvoie le contenu de l'EditText vers l'activité
                listener.onDialogPrenomPositiveClick(DialoguePrenom.this, prenom.getText().toString());
            }
        });
        // Définition du bouton "Annuler"
        builder.setNegativeButton(R.string.annuler, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                DialoguePrenom.this.getDialog().cancel();
            }
        });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
