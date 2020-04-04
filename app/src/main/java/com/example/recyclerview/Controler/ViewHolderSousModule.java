package com.example.recyclerview.Controler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

public class ViewHolderSousModule extends RecyclerView.ViewHolder {

    TextView nom;
    CardView cardViewSousModule;
    public ViewHolderSousModule(@NonNull View itemView) {
        super(itemView);
        this.nom = itemView.findViewById(R.id.nom_sous_module);
        this.cardViewSousModule = itemView.findViewById(R.id.cardviewsousmodules_id);
    }
}
