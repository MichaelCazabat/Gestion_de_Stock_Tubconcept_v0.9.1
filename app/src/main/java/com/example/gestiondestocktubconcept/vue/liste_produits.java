package com.example.gestiondestocktubconcept.vue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.gestiondestocktubconcept.R;
import com.example.gestiondestocktubconcept.modele.Profil;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class liste_produits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits);

    }

    /* ++propriétées++ */
    private ListView listView;
    private EditText txt_input_categorie;
    private EditText txt_input_reference;
    private EditText txt_input_nom;
    private EditText txt_input_prix;
    private EditText txt_input_quantite;
    private EditText txt_input_description;
    private Button btn_ajouter;


    /* --propriétées-- */

    private void init(){



        EditText txt_input_categorie = (EditText) findViewById(R.id.txt_input_categorie);

        EditText txt_input_reference = (EditText) findViewById(R.id.txt_input_reference);

        EditText txt_input_nom = (EditText) findViewById(R.id.txt_input_nom);

        EditText txt_input_prix = (EditText) findViewById(R.id.txt_input_prix);

        EditText txt_input_quantite = (EditText) findViewById(R.id.txt_input_quantite);

        EditText txt_input_description = (EditText) findViewById(R.id.txt_input_description);

        Button btn_ajouter = (Button) findViewById(R.id.constraint_layout);




        List<Profil> liste_produits = new ArrayList<>();
        liste_produits.add(new Profil(value_categorie,value_reference,value_nom,value_prix,value_quantite,value_description));





    }


        String value_categorie = txt_input_categorie.getText().toString();
        String value_reference = txt_input_reference.getText().toString();
        String value_nom = txt_input_nom.getText().toString();
        Float value_prix = Float.parseFloat(txt_input_prix.getText().toString());
        Integer value_quantite =Integer.valueOf(txt_input_quantite.getText().toString());
        String value_description = txt_input_description.getText().toString();










    public void export (View view){


        /*  ++Creation des données++  */

        StringBuilder data = new StringBuilder();

        data.append("Catégorie,Référence,Nom,Prix,Quantités,Description");
        for(int i = 0; i<6; i++){
          data.append("\n" + "test");
        }

        /*  --Creation des données--  */


        try {
            /*  ++Sauvegarde des données dans l'appareil++ */

            FileOutputStream out = openFileOutput("data.csv", Context.MODE_PRIVATE);
            out.write((data.toString()).getBytes());
            out.close();

            /*  --Sauvegarde des données dans l'appareil-- */


            /*  ++Export des données++  */

            Context context = getApplicationContext();
            File filelocation = new File(getFilesDir(), "data.csv");
            Uri path = FileProvider.getUriForFile(context,"com.example.gestiondestocktubconcept.FileProvider",filelocation);
            Intent fileIntent = new Intent(Intent.ACTION_SEND);
            fileIntent.setType("text/csv");
            fileIntent.putExtra(Intent.EXTRA_SUBJECT,"Data");
            fileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            fileIntent.putExtra(Intent.EXTRA_STREAM,path);
            startActivity(Intent.createChooser(fileIntent, "Send mail"));

            /*  --Export des données--  */
        }
        catch (Exception e){
            e.printStackTrace();
        }




    }



}