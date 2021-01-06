package com.example.gestiondestocktubconcept.modele;


import android.media.Image;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Date;


public class Profil {


    /*propriétés*/

    private String categorie;
    private String reference;
    private String nom;
    private Float prixUnite;
    private Integer quantite;
    private String description;
    private ImageView Photo;


    /* Constructeur: */
    /**
     * @param categorie
     * @param reference
     * @param nom
     * @param prixUnite
     * @param quantite
     * @param description
     * @param photo
     */
    public Profil(String categorie, String reference, String nom, Float prixUnite, Integer quantite, String description, ImageView photo) {
        this.categorie = categorie;
        this.reference = reference;
        this.nom = nom;
        this.prixUnite = prixUnite;
        this.quantite = quantite;
        this.description = description;
        Photo = photo;
    }



    /* getters */

    public String getCategorie() {
        return categorie;
    }

    public String getReference() {
        return reference;
    }

    public String getNom() {
        return nom;
    }

    public Float getPrixUnite() {
        return prixUnite;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public String getDescription() {
        return description;
    }

    public ImageView getPhoto() {
        return Photo;
    }


    /* setters */

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrixUnite(Float prixUnite) {
        this.prixUnite = prixUnite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(ImageView photo) {
        Photo = photo;
    }


}
