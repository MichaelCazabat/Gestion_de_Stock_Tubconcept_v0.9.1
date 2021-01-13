package com.example.gestiondestocktubconcept.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        listView =(ListView) findViewById(R.id.liste_view_magasin);


        String[] liste_magasin = new String[]{
                "super U",
                "Lidl",
                "Auchan",
                "Etc ..."
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liste_magasin);

        listView.setAdapter(arrayAdapter);
    }

    public void onBackPressed(){
        Toast.makeText(liste_magasin.this, "Appuyez sur le boutton home ou quittez l'application",Toast.LENGTH_LONG).show();
        Toast.makeText(liste_magasin.this,"veuilliez quitter lapplication",Toast.LENGTH_LONG).show();
    }
}