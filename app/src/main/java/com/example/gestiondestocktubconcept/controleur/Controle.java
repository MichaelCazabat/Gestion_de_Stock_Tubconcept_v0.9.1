package com.example.gestiondestocktubconcept.controleur;

import android.media.Image;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gestiondestocktubconcept.modele.Profil;


public final class Controle {

    private static Controle instance = null;
    private Profil profil;

    private Controle() {
        super();
    }


    public static final Controle getInstance() { //singleton
        if (instance == null) {
            Controle.instance = new Controle();

        }              //
        return Controle.instance;               //
    } //singleton
}