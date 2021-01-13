package com.example.gestiondestocktubconcept.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.gestiondestocktubconcept.R;
import com.example.gestiondestocktubconcept.controleur.Controle;


public class Inscription_magasin_commercant extends AppCompatActivity{

    private Controle controle;

    @Override
protected void onCreate(Bundle savedInstanceState) {            // au lancement de l'application, ce qu'il y a dans les crochets va s'executer.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_magasin_commercant);

        this.controle = Controle.getInstance();

        Button btn_enregisterment_magasin =(Button) findViewById(R.id.btn_enregistrement_magasin);

        btn_enregisterment_magasin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(Inscription_magasin_commercant.this, liste_magasin.class);
                startActivity(m);
            }
        });

        }


}
