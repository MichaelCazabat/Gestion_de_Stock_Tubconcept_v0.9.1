package com.example.gestiondestocktubconcept.controleur;

import android.media.Image;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gestiondestocktubconcept.modele.AccesDistant;
import com.example.gestiondestocktubconcept.modele.Profil;

import org.json.JSONArray;


public final class Controle {

    private static Controle instance = null;
    private Profil profil;
    private static AccesDistant accesDistant;


    private Controle() {
        super();
    }


    public static final Controle getInstance() { //singleton
        if (instance == null) {
            Controle.instance = new Controle();
            accesDistant = new AccesDistant();
         //   accesDistant.envoi("dernier", new JSONArray());

        }              //
        return Controle.instance;               //
    } //singleton



    public void creerProfil(String categorie, String reference, String nom, Double prix, Integer quantite, String description){
        profil = new Profil(categorie, reference, nom, prix, quantite, description);

      //  accesDistant.envoi("enreg", profil.convertToJSONArray());
    }
}
