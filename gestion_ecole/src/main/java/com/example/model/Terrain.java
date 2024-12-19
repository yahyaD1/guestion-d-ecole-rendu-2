package com.example.model;


public class Terrain {


    private int id_terrain;
    private String nom_terrain;
    private String type;

    public int getIdTerrain(){
        return id_terrain;
    }
    public String getNomTerrain(){
        return nom_terrain;
    }
    public String getType(){
        return type;
    }
    
    public void setId_salle(int id){
        id_terrain =id;
    }
    public void setNom_salle(String nom_terrain){
        this.nom_terrain=nom_terrain;
    }
    public void setType(String type){
        this.type=type;
    }
    public Terrain(){}
    public Terrain(int id_terrain,String nom_terrain,String type){
        setId_salle(id_terrain);
        setNom_salle(nom_terrain);
        setType(type);
    }
}
