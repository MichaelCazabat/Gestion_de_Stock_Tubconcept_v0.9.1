package com.example.gestiondestocktubconcept.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gestiondestocktubconcept.R;

public class Connexion_commercant extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {            // au lancement de l'application, ce qu'il y a dans les crochets va s'executer.
                super.onCreate(savedInstanceState);
                setContentView(R.layout.connexion_commercant);

                 next_button();
        }

        /* ++propriétées++ */

        private EditText txt_id_commercant;
        private EditText mdp_commercant;
        private Button btn_connexion_commercant;
        private Button btn_inscription_commercant;

        /* --propriétées-- */


        public void next_button() {

                Button btn_connexion_commercant = (Button) findViewById(R.id.btn_connexion_commercant);
                Button btn_inscription_commercant = (Button) findViewById((R.id.btn_inscription_commercant));
                btn_connexion_commercant.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                startActivity(new Intent(Connexion_commercant.this, liste_produits.class));
                        }
                });
                btn_inscription_commercant.setOnClickListener((new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                startActivity(new Intent(Connexion_commercant.this, ));
                        }
                }));


        }
}
