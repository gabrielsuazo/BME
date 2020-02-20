package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context myContext;
    private List<Object> myData;


    public RecyclerViewAdapter(Context myContext, List<Object> myData){
        this.myContext = myContext;
        this.myData = myData;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) throws IllegalStateException {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch(viewType){
            case 0:
                View v1 = inflater.inflate(R.layout.patient_rv,parent,false);
                viewHolder = new ViewHolderPatient(v1);
                break;
            case 1:
                View v2 = inflater.inflate(R.layout.bilan_rv,parent,false);
                viewHolder = new ViewHolderBilan(v2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        switch (holder.getItemViewType()){  //getItemViewType renvoie 0 si le View est de type Patient et 1 si c'est un Bilan
            case 0: //RV Patient
                ViewHolderPatient vhp = (ViewHolderPatient) holder;
                final Patient patient = (Patient) myData.get(position);
                vhp.myNom.setText(patient.getNom());
                vhp.myDate.setText(patient.getDate());

                ((ViewHolderPatient) holder).cardViewPatient.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(myContext,Patient_Activity.class);
                        intent.putExtra("Nom",patient.getNom());

                        myContext.startActivity(intent);
                    }
                });
                break;
            case 1: //RV Bilans
                ViewHolderBilan vhb = (ViewHolderBilan) holder;
                Bilan bilan = (Bilan) myData.get(position);
                vhb.numeroBilan.setText("Bilan " + bilan.getNumero());

                ((ViewHolderBilan) holder).cardViewBilan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(myContext,Bilan_Activity.class);

                        myContext.startActivity(intent);
                    }
                });
                break;
        }

    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public int getItemViewType(int position){
        if (myData.get(position) instanceof Patient){
            return 0;
        }
        else if (myData.get(position) instanceof Bilan){
            return 1;
        }
        return 2;
    }


}
