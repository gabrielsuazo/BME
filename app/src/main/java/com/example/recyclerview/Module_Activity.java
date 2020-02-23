package com.example.recyclerview;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Module_Activity extends AppCompatActivity implements View.OnClickListener {

    private CardView handicap,modeDeVie,habitat,conclusion;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);

        handicap = findViewById(R.id.moduleHandicap);
        modeDeVie = findViewById(R.id.moduleModeDeVie);
        habitat = findViewById(R.id.moduleHabitat);
        conclusion = findViewById(R.id.conclusion);


        Intent intent = getIntent();
        int color = intent.getExtras().getInt("color");
        CardView menu = findViewById(R.id.menu_sous_modules);
        menu.setCardBackgroundColor(color);
        configurationModules(handicap,color);
        configurationModules(modeDeVie,color);
        configurationModules(habitat,color);
        configurationModules(conclusion,color);

    }

public void onClick(View v) {
        Intent intent = new Intent(this,Module_Activity.class);
        if (v instanceof CardView){
        int color = ((CardView) v).getCardBackgroundColor().getDefaultColor();
        intent.putExtra("color", color);
        }
        startActivity(intent);
        }
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public void configurationModules(CardView v, int color){
        if (v.getCardBackgroundColor().getDefaultColor() == color){
            ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
            layoutParams.width = 200;
            v.setLayoutParams(layoutParams);

        }
        else {
            v.setBackgroundTintList(this.getResources().getColorStateList(R.color.gris));
            v.setOnClickListener(this);

        }
}


}
