package com.example.gestiondestocktubconcept.vue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gestiondestocktubconcept.R;
import com.example.gestiondestocktubconcept.modele.Profil;

import java.util.ArrayList;
import java.util.List;

public class Magasin extends AppCompatActivity  {
    MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magasin);

        // data to populate the RecyclerView with
        List<Profil> liste_produits;
        liste_produits = com.example.gestiondestocktubconcept.vue.liste_produits.getListeProduit();



        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv_produits_magasin);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(com.example.gestiondestocktubconcept.vue.liste_produits.getListeProduit());
        recyclerView.setAdapter(adapter);
    }

}

