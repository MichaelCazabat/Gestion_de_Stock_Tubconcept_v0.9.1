package com.example.gestiondestocktubconcept.vue;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gestiondestocktubconcept.R;

public class Accueil extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {            // au lancement de l'application, ce qu'il y a dans les crochets va s'executer.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceuil);
    }
}
