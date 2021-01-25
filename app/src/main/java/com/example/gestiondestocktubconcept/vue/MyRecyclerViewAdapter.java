package com.example.gestiondestocktubconcept.vue;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondestocktubconcept.R;
import com.example.gestiondestocktubconcept.modele.Profil;

import java.util.List;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter {

    private AdapterView.OnItemClickListener onItemClickListener;

    List<Profil> liste_produit;

//Constructeur de la liste des produits
    public MyRecyclerViewAdapter(List<Profil> liste_produit) {
        this.liste_produit = liste_produit;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row,parent,false);
        return new RowViewHolder(itemView);
    }
// Lie les élements avec la vue
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RowViewHolder rowViewHolder = (RowViewHolder) holder;

        int rowPos = rowViewHolder.getBindingAdapterPosition();

        if (rowPos == 0) {
            //Cellules de l'entête
            // permet de mettre un background a la cellule : rowViewHolder.txt_categorie.setBackgroundResource();
           rowViewHolder.txt_categorie.setText("Catégorie");
           rowViewHolder.txt_reference.setText("Reference");
           rowViewHolder.txt_nom.setText("Nom");
           rowViewHolder.txt_prix.setText("Prix");
           rowViewHolder.txt_quantite.setText("Quantité");
           rowViewHolder.txt_description.setText("Description");
        } else{
            Profil profil = liste_produit.get(rowPos-1);

            //Contenues des cellules
            rowViewHolder.txt_categorie.setText(profil.getCategorie()+"");
            rowViewHolder.txt_reference.setText(profil.getReference()+"");
            rowViewHolder.txt_nom .setText(profil.getNom()+"");
            rowViewHolder.txt_prix.setText(profil.getPrixUnite()+"");
            rowViewHolder.txt_quantite.setText(profil.getQuantite()+"");
            rowViewHolder.txt_description.setText(profil.getDescription()+"");


        }

    }

    @Override
    public int getItemCount() {
        return liste_produit.size()+1;
    }




    public class RowViewHolder extends RecyclerView.ViewHolder {
        protected TextView txt_categorie;
        protected TextView txt_reference;
        protected TextView txt_nom;
        protected TextView txt_prix;
        protected TextView txt_quantite;
        protected TextView txt_description;

        public RowViewHolder(View itemView) {
            super(itemView);

            txt_categorie = itemView.findViewById(R.id.tv_categorie_produit);
            txt_reference = itemView.findViewById(R.id.tv_reference_produit);
            txt_nom = itemView.findViewById(R.id.tv_nom_produit);
            txt_prix = itemView.findViewById(R.id.tv_prix_produit);
            txt_quantite = itemView.findViewById(R.id.tv_quantite_produit);
            txt_description = itemView.findViewById(R.id.tv_description_produit);
        }
    }

    String getItem(int id) {
        return String.valueOf(liste_produit.get(id));
    }



}