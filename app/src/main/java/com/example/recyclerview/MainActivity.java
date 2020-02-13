package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Object> lstPatient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPatient = new ArrayList<Object>();
        int k = 5;

        for (int i = 1; i <= k; i++){
            lstPatient.add(new Patient("Patient " + i,"Date: 19/03/12",R.drawable.jb));
        }



        RecyclerView myRV = (RecyclerView) findViewById(R.id.recyclerViewPatients);
        RecyclerViewAdapter myAdapter;
        myAdapter = new RecyclerViewAdapter(this,lstPatient);
        myRV.setLayoutManager((new GridLayoutManager(this,3)));
        myRV.setAdapter(myAdapter);
    }
}
