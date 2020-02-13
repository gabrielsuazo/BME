package com.example.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderModule extends RecyclerView.ViewHolder {


    TextView type_module;
    CardView cardViewModule;

    public ViewHolderModule(View itemView){
        super(itemView);

        this.type_module = itemView.findViewById(R.id.type_module);
        this.cardViewModule = itemView.findViewById(R.id.cardviewmodule_id);

    }
}
