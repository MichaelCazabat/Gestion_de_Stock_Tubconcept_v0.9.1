package com.example.gestiondestocktubconcept.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gestiondestocktubconcept.R;
import com.example.gestiondestocktubconcept.controleur.Controle;

public class Page_login_commercant extends AppCompatActivity {


        private Controle controle;

        @Override
        protected void onCreate(Bundle savedInstanceState) {            // au lancement de l'application, ce qu'il y a dans les crochets va s'executer.
                super.onCreate(savedInstanceState);
                setContentView(R.layout.connexion_commercant);
                this.controle = controle.getInstance();

        /* ++propriétées++ */
        EditText txt_id_commercant;
        EditText mdp_commercant;
        Button btn_connexion_commercant = (Button) findViewById(R.id.btn_connexion_commercant);
        Button btn_inscription_commercant = (Button) findViewById((R.id.btn_inscription_commercant));
        /* --propriétées-- */

                btn_inscription_commercant.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                                Intent k = new Intent(Page_login_commercant.this, Inscription_magasin_commercant.class);
                        startActivity(k);
                        }
                });

                btn_connexion_commercant.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                                Intent l = new Intent(Page_login_commercant.this,liste_magasin.class);
                                startActivity(l);
                        }
                });
        }

}
