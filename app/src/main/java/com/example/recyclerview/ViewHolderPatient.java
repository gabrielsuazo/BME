package com.example.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderPatient extends RecyclerView.ViewHolder{

    TextView myNom, myDate;
    CardView cardViewPatient;

    public ViewHolderPatient(View itemView){
        super(itemView);

        this.myNom = itemView.findViewById(R.id.nom_patient);
        this.myDate = itemView.findViewById(R.id.date_patient);
        this.cardViewPatient = itemView.findViewById(R.id.cardviewpatient_id);
    }
}