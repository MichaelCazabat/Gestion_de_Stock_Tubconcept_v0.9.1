package com.example.gestiondestocktubconcept.vue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondestocktubconcept.R;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);
        String categorie = mData.get(position);
        String reference = mData.get(position);
        String nom = mData.get(position);
        String prix =mData.get(position);
        String quantite=mData.get(position);
        String description=mData.get(position);

        holder.categorie.setText(animal);
        holder.reference.setText(animal);
        holder.nom.setText(animal);
        holder.prix.setText(animal);
        holder.quantite.setText(animal);
        holder.decription.setText(animal);


    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nom;
        TextView categorie;
        TextView reference;
        TextView prix;
        TextView quantite;
        TextView decription;


        ViewHolder(View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.tv_nom_produit);
            categorie = itemView.findViewById(R.id.tv_categorie_produit);
            reference = itemView.findViewById(R.id.tv_reference_produit);
            prix = itemView.findViewById(R.id.tv_prix_produit);
            quantite = itemView.findViewById(R.id.tv_quantite_produit);
            decription = itemView.findViewById(R.id.tv_description_produit);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}