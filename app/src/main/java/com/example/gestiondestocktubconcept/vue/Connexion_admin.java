package com.example.gestiondestocktubconcept.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gestiondestocktubconcept.R;

public class Connexion_admin extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {            // au lancement de l'application, ce qu'il y a dans les crochets va s'executer.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_admin);

       next_button();
    }


    /* ++propriétées++ */

    private EditText txt_id_admin;
    private EditText mdp_admin;
    private Button btn_connexion_admin;

    /* --propriétées-- */


    public void next_button() {

        Button btn_connexion_admin = (Button) findViewById(R.id.btn_connexion_admin);
        btn_connexion_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Connexion_admin.this, liste_produits.class));
            }
        });

    }

}