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
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gestiondestocktubconcept.R;
import com.example.gestiondestocktubconcept.modele.Profil;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class liste_produits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv_produits);

        List<Profil> listeProduit = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // initialisation de l'adapter
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(getListeProduit());
        recyclerView.setAdapter(adapter);




        //this.getListeProduit().add(new Profil("voiture","RF745963-65","twingo",3000.,1,"c une joli voitssssrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrsssssssssssssssssure"));

    }



    //addItem(listeProduit,"voiture","RF745963-65","twingo",3000.,1,"c une joli voiture");
    List<Profil> listeProduit = new ArrayList<>();

    private List<Profil> getListeProduit() {
        List<Profil> listeProduit = new ArrayList<>();
        //Liste de nos produits
        //  ajout_produits(listeProduit,txt_categorie,txt_reference,txt_nom,Double.parseDouble(txt_prix),Integer.parseInt(txt_quantite),txt_description);
        //listeProduit.add(new Profil("voiture","RF745963-65","twingo",3000.,1,"c une joli voiture"));

        return listeProduit;
    }

    public void ajout_produits(List<Profil> listeProduit, String categorie, String reference, String nom, Double prix, int quantite, String descritpion) {
        listeProduit.add(new Profil(categorie, reference, nom, prix, quantite, descritpion));
        //adapter.notifyItemInserted(adapter.getItemCount()-1);
    }




    /* ++propriétées++ */
    private ListView listView;
    MyRecyclerViewAdapter adapter;
    Integer nbr_click = 0;
    /* --propriétées-- */


    public void onClickData(View view) {

        EditText txt_input_categorie = (EditText) findViewById(R.id.txt_input_categorie);
        EditText txt_input_reference = (EditText) findViewById(R.id.txt_input_reference);
        EditText txt_input_nom = (EditText) findViewById(R.id.txt_input_nom);
        EditText txt_input_prix = (EditText) findViewById(R.id.txt_input_prix);
        EditText txt_input_quantite = (EditText) findViewById(R.id.txt_input_quantite);
        EditText txt_input_description = (EditText) findViewById(R.id.txt_input_description);
        Button btn_ajouter = (Button) findViewById(R.id.btn_ajouter);


        if (txt_input_categorie != null && txt_input_reference != null && txt_input_nom != null && txt_input_prix != null && txt_input_quantite != null && txt_input_description != null) {
            String value_description = txt_input_description.getText().toString();
            Integer value_quantite = (Integer.valueOf(txt_input_quantite.getText().toString()));
            Double value_prix = Double.parseDouble(txt_input_prix.getText().toString());
            String value_nom = txt_input_nom.getText().toString();
            String value_reference = txt_input_reference.getText().toString();
            String value_categorie = txt_input_categorie.getText().toString();

            Toast.makeText(getApplicationContext(), "ALED CA MARCHE PAS", Toast.LENGTH_LONG).show();
            //getListeProduit().add(new Profil(value_categorie,value_reference,value_nom,value_prix,value_quantite,value_description));
            listeProduit.add(new Profil("voiture", "RF745963-65", "twingo", 3000., 1, "c une joli voiture"));
            //listeProduit.add(new Profil(value_categorie, value_reference, value_nom, value_prix, value_quantite, value_description));
           // adapter.notifyItemInserted(1);

        } else {
            Toast.makeText(getApplicationContext(), "Veuillez entrer des données", Toast.LENGTH_LONG).show();
        }
    }


        public void export (View view){


            /*  ++Creation des données++  */

            StringBuilder data = new StringBuilder();

            data.append("Catégorie,Référence,Nom,Prix,Quantités,Description");
            for (int i = 0; i < 6; i++) {
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
                Uri path = FileProvider.getUriForFile(context, "com.example.gestiondestocktubconcept.FileProvider", filelocation);
                Intent fileIntent = new Intent(Intent.ACTION_SEND);
                fileIntent.setType("text/csv");
                fileIntent.putExtra(Intent.EXTRA_SUBJECT, "Data");
                fileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                fileIntent.putExtra(Intent.EXTRA_STREAM, path);
                startActivity(Intent.createChooser(fileIntent, "Send mail"));

                /*  --Export des données--  */
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }
