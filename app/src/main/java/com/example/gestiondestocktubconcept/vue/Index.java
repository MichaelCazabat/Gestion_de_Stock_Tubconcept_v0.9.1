package com.example.gestiondestocktubconcept.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestiondestocktubconcept.Acceuil;
import com.example.gestiondestocktubconcept.Connexion_admin;
import com.example.gestiondestocktubconcept.Connexion_commercant;
import com.example.gestiondestocktubconcept.R;
import com.example.gestiondestocktubconcept.controleur.Controle;

public class Index extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {            // au lancement de l'application, ce qu'il y a dans les crochets va s'executer.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        init();
        this.controle = Controle.getInstance();
    }

    /* ++propriétés++ */

    private Button btn_admin;
    private Button btn_commercant;


    /*  --propriétés-- */

    private Controle controle;




    private void init() {       //initialisation de l'application




        /* ++intitalisation des liens avec les objects graphiques++ */

        Button btn_admin = (Button)findViewById(R.id.btn_admin);
        Button btn_commercant = (Button)findViewById(R.id.btn_commercants);

        /* --intitalisation des liens avec les objects graphiques-- */


        /* ++ click sur les buttons pour changer d'activity ++ */


    btn_admin.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Index.this, Connexion_admin.class);
        startActivity(i);
        }
    });

    btn_commercant.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent j = new Intent(Index.this, Connexion_commercant.class);
        }
    });


    }
}








