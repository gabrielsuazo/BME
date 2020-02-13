package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Bilan_Activity extends AppCompatActivity {

    List<Object> lstModules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilan);

        lstModules = new ArrayList<Object>(4);
        lstModules.add(new Module("HANDICAP"));
        lstModules.add(new Module("MODE DE VIE"));
        lstModules.add(new Module("HABITAT"));
        lstModules.add(new Module("Conclusion"));


        RecyclerView myRV = (RecyclerView) findViewById(R.id.recyclerViewModules);
        RecyclerViewAdapter myAdapter;
        myAdapter = new RecyclerViewAdapter(this, lstModules);
        myRV.setLayoutManager((new GridLayoutManager(this, 2)));
        myRV.setAdapter(myAdapter);
    }
}
