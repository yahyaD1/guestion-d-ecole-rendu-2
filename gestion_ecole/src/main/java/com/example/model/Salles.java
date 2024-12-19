package com.example.model;

public class Salles {
    private int id_salle;
    private String nom_salle;
    private int capacite;

    public int getId_salle(){
        return id_salle;
    }
    public String getNom_salle(){
        return nom_salle;
    }
    public int getCapacite(){
        return capacite;
    }
    
    public void setId_salle(int id){
        id_salle =id;
    }
    public void setNom_salle(String nom_salle){
        this.nom_salle=nom_salle;
    }
    public void setCapacite(int capacite){
        this.capacite=capacite;
    }

    public Salles(int id_salle,String nom_salle,int capacite){
        setId_salle(id_salle);
        setNom_salle(nom_salle);
        setCapacite(capacite);
    }
    public Salles(){}
}
