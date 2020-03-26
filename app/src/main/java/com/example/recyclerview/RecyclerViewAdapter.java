package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context myContext;
    private List<Object> myData;        //Ce la liste qui va être affiché par le recycler view


    public RecyclerViewAdapter(Context myContext, List<Object> myData){
        this.myContext = myContext;
        this.myData = myData;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) throws IllegalStateException {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());


        //On doit prendre le ViewHolder adapté au type de l'object
        switch(viewType){
            case 0:
                //Pour la liste des Patients
                View v1 = inflater.inflate(R.layout.patient_rv,parent,false);
                viewHolder = new ViewHolderPatient(v1);
                break;
            case 1:
                //Pour la liste des Bilans
                View v2 = inflater.inflate(R.layout.bilan_rv,parent,false);
                viewHolder = new ViewHolderBilan(v2);
                break;
            case 2:
                //Pour les sous-modules
                View v3 = inflater.inflate(R.layout.sous_module_rv,parent,false);
                viewHolder = new ViewHolderSousModule(v3);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        switch (holder.getItemViewType()){  //getItemViewType renvoie 0 si le View est de type Patient, 1 si c'est un Bilan, 2 pour un Sous Module
            case 0: //RV Patient
                ViewHolderPatient vhp = (ViewHolderPatient) holder;
                final Patient patient = (Patient) myData.get(position);
                if (patient.isVide()){
                    vhp.myNom.setText("Nouveau Patient");
                    vhp.myDate.setText("");
                    ((ViewHolderPatient) holder).cardViewPatient.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            patient.setPrenom("Entrer prenom");
                            patient.setNom("Entre nom");
                            patient.setDate("02/28/2020");
                            myData.add(new Patient());
                            notifyDataSetChanged();

                        }
                    });
                }
                else {
                    vhp.myNom.setText(patient.getNom());
                    vhp.myDate.setText(patient.getDate());

                    ((ViewHolderPatient) holder).cardViewPatient.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(myContext, Patient_Activity.class);
                            intent.putExtra("Nom", patient.getNom());
                            intent.putExtra("Prenom", patient.getPrenom());

                            myContext.startActivity(intent);
                        }

                    });
                }

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
            case 2: //RV SousModules
                ViewHolderSousModule vhsm = (ViewHolderSousModule) holder;
                SousModule sousModule = (SousModule) myData.get(position);
                vhsm.nom.setText(sousModule.getNom());
                vhsm.cardViewSousModule.setCardBackgroundColor(sousModule.getCouleur());
                if (sousModule.isChoisi()){
                    ViewGroup.LayoutParams layoutParams = vhsm.cardViewSousModule.getLayoutParams();
                    layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    layoutParams.height = 150;
                    vhsm.cardViewSousModule.setLayoutParams(layoutParams);
                }
                else {
                    ViewGroup.LayoutParams layoutParams = vhsm.cardViewSousModule.getLayoutParams();
                    layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    layoutParams.height = 120;
                    vhsm.cardViewSousModule.setLayoutParams(layoutParams);
                    vhsm.cardViewSousModule.setBackgroundTintList(myContext.getResources().getColorStateList(R.color.gris));

                    ((ViewHolderSousModule) holder).cardViewSousModule.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(myContext,Module_Activity.class);
                            if (v instanceof CardView){
                                int color = ((CardView) v).getCardBackgroundColor().getDefaultColor();
                                intent.putExtra("color", color);
                                intent.putExtra("sous_module_choisi",position);

                            }
                            myContext.startActivity(intent);
                        }
                    });
                }


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
        else if (myData.get(position) instanceof SousModule) {
            return 2;
        }

        return 3;
    }


}
