package com.example.gestiondestocktubconcept.modele;


import android.widget.ImageView;


public class Profil {


    /*propriétés*/

    private String categorie;
    private String reference;
    private String nom;
    private Float prix;
    private Integer quantite;
    private String description;


    /* Constructeur: */
    /**
     * @param categorie
     * @param reference
     * @param nom
     * @param prix
     * @param quantite
     * @param description
     */
    public Profil(String categorie, String reference, String nom, Float prix, Integer quantite, String description) {
        this.categorie = categorie;
        this.reference = reference;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.description = description;
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
        return prix;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public String getDescription() {
        return description;
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
        this.prix = prixUnite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
