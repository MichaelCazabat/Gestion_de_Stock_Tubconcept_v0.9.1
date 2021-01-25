package com.example.gestiondestocktubconcept.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gestiondestocktubconcept.R;

public class inscription_commercant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_commercant);


        Button btn_enregistrement_commercant = findViewById(R.id.btn_enregistrement_commercant);



        btn_enregistrement_commercant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(inscription_commercant.this, Magasin.class);
                startActivity(n);
            }
        });
    }


}