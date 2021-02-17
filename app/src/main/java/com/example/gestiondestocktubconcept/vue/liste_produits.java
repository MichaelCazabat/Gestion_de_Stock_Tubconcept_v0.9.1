package com.example.gestiondestocktubconcept.vue;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondestocktubconcept.R;
import com.example.gestiondestocktubconcept.modele.Profil;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class liste_produits extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{

    List<Profil> liste_produits;
    MyRecyclerViewAdapter adapter;



    StringBuilder data = new StringBuilder();


    TextView txt_categorie_produit ;
    TextView txt_reference_produit ;
    TextView txt_nom_produit ;
    TextView txt_prix_produit ;
    TextView txt_quantite_produit ;
    TextView txt_description_produit ;

    EditText value_categorie;
    EditText value_reference;
    EditText value_nom;
    EditText value_prix;
    EditText value_quantite;
    EditText value_description ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits);


        value_categorie =  findViewById(R.id.txt_input_categorie);
        value_reference =  findViewById(R.id.txt_input_reference);
        value_nom = findViewById(R.id.txt_input_nom);
        value_prix =  findViewById(R.id.txt_input_prix);
        value_quantite =  findViewById(R.id.txt_input_quantite);
        value_description = findViewById(R.id.txt_input_description);


        // Données pour remplir le RecyclerView :
        liste_produits = new ArrayList<>();


        // set up le RecyclerView:
        RecyclerView recyclerView = findViewById(R.id.rv_produits);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter = new MyRecyclerViewAdapter(this, liste_produits);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }


    public boolean isEmpty(EditText editText){
        if (editText.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


    public void onButtonClick(View view){

        if(isEmpty(value_categorie) && isEmpty(value_description) && isEmpty(value_nom) && isEmpty(value_prix) && isEmpty(value_quantite) && isEmpty(value_reference)){
            Double value_prix_double = Double.parseDouble(value_prix.getText().toString().replace(",","."));
            Integer value_quantite_int = Integer.parseInt(value_quantite.getText().toString().replace(",","."));
            ajout_un_item(value_categorie.getText().toString(),value_reference.getText().toString(),value_nom.getText().toString(),value_prix_double,value_quantite_int,value_description.getText().toString());
            // : 09/02/2021 quand tu mets une valeur a virgule dans quantité ou prix ca crash , convert la virgule en un point
            //résolu


        }else{
            Toast.makeText(this, "Veuillez entrer de valeurs valides", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

    }



    private void ajout_un_item(String categorie,String reference,String nom,Double prix,Integer quantite,String description ) {
        Profil item = new Profil(categorie, reference, nom, prix, quantite, description);
        int insertIndex = 0;
        liste_produits.add(insertIndex, item);
        adapter.notifyItemInserted(insertIndex);


    }


    public void export (View view){


       // /*  ++Creation des données++  */



        int nbr_produits = adapter.getItemCount();
        for (int s = 0; s < nbr_produits; s++) {
            data.append("\n"+String.valueOf(liste_produits.get(s).convertToJSONArray()));
            Log.i("message", String.valueOf(liste_produits.get(s).convertToJSONArray()));

        }

        String data1 = data.toString();
        String data2 = data1.replaceAll("]",",");
        String data3 = data2.replaceAll("\\[","");
        String data4 = data3.replaceAll("\"","");
        Log.i("message", data4);
        // set la lenght a 0 c'est mieu pour la mémoire que d'en refaire une.
        data.setLength(0);
        data.append("Categorie,Reference,Nom,Prix,Quantites,Description");
        data.append(data4);
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