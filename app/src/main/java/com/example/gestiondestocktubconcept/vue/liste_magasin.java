package com.example.gestiondestocktubconcept.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gestiondestocktubconcept.R;

public class liste_magasin extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_magasin);

        listView = (ListView) findViewById(R.id.liste_view_magasin);


        String[] liste_magasin = new String[]{
                "super U",
                "Lidl",
                "Auchan",
                "Etc ..."
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liste_magasin);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(liste_magasin.this,Magasin.class);
                    startActivity(intent);
                }

            }
        });
    }
}
