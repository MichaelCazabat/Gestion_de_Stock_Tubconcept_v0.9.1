package com.example.gestiondestocktubconcept.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gestiondestocktubconcept.R;

public class choix_magasin_produits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_magasin_produits);

        Button btn_choix_produit_admin = findViewById(R.id.btn_choix_produits_admin);
        Button btn_choix_magasin_admin = findViewById(R.id.btn_choix_magasin_admin);

        btn_choix_produit_admin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(choix_magasin_produits.this, liste_produits_admin.class);
                startActivity(i);
            }
        });
        btn_choix_magasin_admin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(choix_magasin_produits.this, Magasin.class);
                startActivity(i);
            }
        });
    }
}