package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Module_Activity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);

        Intent intent = getIntent();
        int color = intent.getExtras().getInt("color");
        CardView menu = findViewById(R.id.menu_sous_modules);
        menu.setCardBackgroundColor(color);

    }
}
