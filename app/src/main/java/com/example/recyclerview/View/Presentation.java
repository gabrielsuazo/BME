package com.example.recyclerview.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.recyclerview.R;

public class Presentation extends AppCompatActivity {

    private TextView presentation;
    private Button retour;
    private TextView equipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);
        // bouton retour
        retour = (Button) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Presentation.this, Login_activity.class);
                startActivity(intent);  // retour à la page de connexion
            }
        });
        // equipe projet
        equipe = (TextView)findViewById(R.id.equipe);
        String noms_equipe = "<h2>Equipe projet</h2>\n"+
                "<p><u>Chef de projet</u>: <b>Kévin SANANIKONE</b> </p>\n"+
                "<p><u>Responsable design</u>: <b>Paul ARDANT</b> </p>\n"+
                "<p><u>Responsable Communication</u>: <b>Jean-Baptiste BAITAIRIAN</b></p>\n"+
                "<p><u>Responsable Technique 1</u>: <b>Ahmath GADJI</b></p>\n"+
                "<p><u>Responsable Technique 2</u>: <b>Gabriel SUAZO BARAHONA</b></p>";
        equipe.setText(HtmlCompat.fromHtml(noms_equipe,0));


        presentation = (TextView)findViewById(R.id.presentation);
        String htmlText = "<h2>Remerciements</h2>\n"+
                "<p>Nesma HOUMANI pour son soutien et ses conseils </p>\n"+
                "<p>Mme Gwénaëlle REBOURS, M. Dominique ROSE et M. Hadj KALFAT pour leur bienveillance</p> \n"+
                "<p>Mme Corinne TRUCHE pour nous avoir donné la chance de réaliser un tel projet durant une année </p>";
        presentation.setText(HtmlCompat.fromHtml(htmlText,0));
    }
}
