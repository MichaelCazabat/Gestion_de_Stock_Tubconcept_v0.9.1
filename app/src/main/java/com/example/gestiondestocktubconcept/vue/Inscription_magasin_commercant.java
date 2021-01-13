package com.example.gestiondestocktubconcept.vue;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.gestiondestocktubconcept.R;
import com.example.gestiondestocktubconcept.controleur.Controle;


public class Inscription_magasin_commercant extends AppCompatActivity{

    private Controle controle;

    @Override
protected void onCreate(Bundle savedInstanceState) {            // au lancement de l'application, ce qu'il y a dans les crochets va s'executer.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_magasin_commercant);
        init();
        this.controle = Controle.getInstance();

        init();
        }

    private void init() {
    }
}
