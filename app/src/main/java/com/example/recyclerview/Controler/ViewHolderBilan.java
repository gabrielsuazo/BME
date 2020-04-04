package com.example.recyclerview.Controler;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

public class ViewHolderBilan extends RecyclerView.ViewHolder {

    TextView numeroBilan;
    CardView cardViewBilan;

    public ViewHolderBilan(View itemView){
        super(itemView);
        this.numeroBilan = itemView.findViewById(R.id.numero_bilan);
        this.cardViewBilan = itemView.findViewById(R.id.cardviewbilan_id);
    }
}
