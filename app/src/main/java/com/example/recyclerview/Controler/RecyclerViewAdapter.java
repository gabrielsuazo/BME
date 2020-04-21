package com.example.recyclerview.Controler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.Model.Bilan;
import com.example.recyclerview.Model.SousModule;
import com.example.recyclerview.R;
import com.example.recyclerview.View.Bilan_Activity;
import com.example.recyclerview.View.Informations_Patient_Activity;
import com.example.recyclerview.View.MainActivity;
import com.example.recyclerview.View.Module_Activity;
import com.example.recyclerview.View.Patient_Activity;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context myContext;
    private List<Object> myData;        //C'est la liste qui va être affiché par le recycler view


    public RecyclerViewAdapter(Context myContext, List<Object> myData){
        this.myContext = myContext;
        this.myData = myData;
    }

    /**
     * Cette méthode permet de configurer le ViewHolder
     * @param viewType permet de traiter les cas différents (voir méthode getItemViewType)
     * @return le View Holder initialisé avec la view associée
     * @throws IllegalStateException
     */
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

    /**
     * Cette méthode permet de configurer les objets dans le RV
     * @param holder view holder
     * @param position numéro qui nous donne la position de l'objet dans la liste
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        switch (holder.getItemViewType()){  //getItemViewType renvoie 0 si le View est de type Patient, 1 si c'est un Bilan, 2 pour un Sous Module
            case 0: //RV Patient
                ViewHolderPatient vhp = (ViewHolderPatient) holder;
                final Patient patient = (Patient) myData.get(position);


                //Bouton "Nouveau Patient"
                if (patient.isVide()){
                    vhp.myNom.setText("Nouveau Patient");
                    vhp.myNom.setTextColor(myContext.getResources().getColorStateList(R.color.couleurPatientsEtBilans));
                    vhp.cardViewPatient.setCardBackgroundColor(myContext.getResources().getColorStateList(R.color.blanc));
                    vhp.cardViewPatient.setCardElevation(0);
                    vhp.myDate.setText("Appuyez pour créer");
                    vhp.myDate.setTextColor(myContext.getResources().getColorStateList(R.color.couleurPatientsEtBilans));

                    ((ViewHolderPatient) holder).cardViewPatient.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            //On ajoute un nouveau patient à la liste. Il faut aussi actualiser la base de données
                            //Valeurs à l'initialisation du patient. Ces valeurs seront modifiés dans l'activité des informations du patient.
                            myData.add(position, new Patient("Entrer un nom","Entrer un prenom","28/02/2020"));
                            notifyItemInserted(position);
                            notifyItemChanged(position);


                            Intent intent = new Intent(myContext, Informations_Patient_Activity.class);
                            myContext.startActivity(intent);

                        }
                    });
                }
                //Bouton patient existant
                else {
                    vhp.myNom.setText(patient.getNom());
                    vhp.myDate.setText(patient.getDate());

                    ((ViewHolderPatient) holder).cardViewPatient.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(myContext, Patient_Activity.class);

                            //Code temporaire: Normalement c'est juste l'id du patient qui est transmise.
                            //Le nom et le prénom sont ensuite récupérés avec l'id.
                            intent.putExtra("Nom", patient.getNom());
                            intent.putExtra("Prenom", patient.getPrenom());
                            //

                            myContext.startActivity(intent);
                        }

                    });
                    ((ViewHolderPatient) holder).cardViewPatient.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {

                            new AlertDialog.Builder(myContext)
                                    .setIcon(android.R.drawable.ic_delete)
                                    .setTitle("Êtes vous sûr(e) ?")
                                    .setMessage("Voulez vous supprimer " + patient.getNom() + " ?")
                                    .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            myData.remove(position);
                                            notifyItemRemoved(position);
                                            notifyItemRangeChanged(0, myData.size());
                                        }
                                    })
                                    .setNegativeButton("Non", null)
                                    .show();


                            return true;
                        }
                    });

                }

                break;

            case 1: //RV Bilans
                ViewHolderBilan vhb = (ViewHolderBilan) holder;
                Bilan bilan = (Bilan) myData.get(position);

                //Bouton pour ajouter des bilans
                if (bilan.isVide()){
                    vhb.numeroBilan.setText("Nouveau bilan");
                    vhb.numeroBilan.setTextColor(myContext.getResources().getColorStateList(R.color.couleurPatientsEtBilans));
                    vhb.cardViewBilan.setCardBackgroundColor(myContext.getResources().getColorStateList(R.color.blanc));
                    vhb.cardViewBilan.setCardElevation(0);

                    ((ViewHolderBilan) holder).cardViewBilan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //On ajoute un nouveau bilan à la liste. Il faut aussi actualiser la base de données
                            final int indice = position;
                            Bilan nouveauBilan = new Bilan();
                            nouveauBilan.setNumero(indice+1);
                            myData.add(indice,nouveauBilan);
                            notifyDataSetChanged();

                            Intent intent = new Intent(myContext,Bilan_Activity.class);
                            myContext.startActivity(intent);
                        }
                    });

                }
                //Bouton pour les bilans
                else {
                    vhb.numeroBilan.setText("Bilan " + bilan.getNumero());

                    ((ViewHolderBilan) holder).cardViewBilan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(myContext,Bilan_Activity.class);

                            myContext.startActivity(intent);
                        }
                    });
                }

                break;

            case 2: //RV SousModules
                ViewHolderSousModule vhsm = (ViewHolderSousModule) holder;
                SousModule sousModule = (SousModule) myData.get(position);
                vhsm.nom.setText(sousModule.getNom());
                //Les sous-modules affichés prennent la couleur du module choisi
                vhsm.cardViewSousModule.setCardBackgroundColor(sousModule.getCouleur());

                //Cas du sous-module choisi: sa taille augmente (et il n'a pas de ClickListener puisqu'on est déjà sur lui)
                if (sousModule.isChoisi()){
                    ViewGroup.LayoutParams layoutParams = vhsm.cardViewSousModule.getLayoutParams();
                    layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    layoutParams.height = 150;
                    vhsm.cardViewSousModule.setLayoutParams(layoutParams);
                }

                //Cas des autres sous-modules: couleur grisé et configuration du ClickListener
                else {
                    ViewGroup.LayoutParams layoutParams = vhsm.cardViewSousModule.getLayoutParams();
                    layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    layoutParams.height = 120;
                    vhsm.cardViewSousModule.setLayoutParams(layoutParams);
                    vhsm.cardViewSousModule.setBackgroundTintList(myContext.getResources().getColorStateList(R.color.gris));

                    ((ViewHolderSousModule) holder).cardViewSousModule.setOnClickListener(new View.OnClickListener() {
                        /**
                         * Cette méthode nous permet de relancer l'activité module avec le choix de sous-module
                         * @param v View des sous-modules
                         */
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(myContext,Module_Activity.class);
                            if (v instanceof CardView){
                                int color = ((CardView) v).getCardBackgroundColor().getDefaultColor();
                                intent.putExtra("color", color);
                                intent.putExtra("sous_module_choisi",position);

                            }
                            myContext.startActivity(intent);
                            ((Activity)myContext).finish();
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
