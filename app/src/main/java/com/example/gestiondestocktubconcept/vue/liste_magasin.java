package com.example.gestiondestocktubconcept.vue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.accessibilityservice.GestureDescription;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gestiondestocktubconcept.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class liste_magasin extends AppCompatActivity implements RecyclerView_Adapter_Magasin.ItemClickListener{


    RecyclerView_Adapter_Magasin adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_magasin);




        ArrayList<String> liste_magasin = new ArrayList<>();
        liste_magasin.add("Super U");
        liste_magasin.add("Super I");
        liste_magasin.add("Super O");
        liste_magasin.add("Super P");


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv_liste_magasin);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerView_Adapter_Magasin(this, liste_magasin);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    };



       public void onItemClick(View view, int position) {
           Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
         //  if(position == 0){
         //      Intent intent = new Intent(liste_magasin.this,Magasin.class);
         //      startActivity(intent);
         //  }
       }


     //  ArrayList.setOnItemClickListener(new AdapterView.OnItemClickListener()
     //  {
     //      @Override
     //      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
     //          if (position == 0){
     //            //  Intent intent = new Intent(liste_magasin.this,Magasin.class);
     //            //  startActivity(intent);
     //              Toast.makeText(this,,Toast.LENGTH_LONG).show();
     //          }

     //      }
     //  });
    }
