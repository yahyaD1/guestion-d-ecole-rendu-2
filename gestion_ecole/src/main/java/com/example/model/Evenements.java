package com.example.model;

public class Evenements {
    private int id_event;
    private String nom_event;
    private String date_event;
    private String description;
    private int id_user;
    
    public Evenements() {}

    public Evenements(int id_event,String nom, String date, String description, int userId) {
        this.id_event=id_event;
        this.nom_event = nom;
        this.date_event = date;
        this.description = description;
        this.id_user = userId;
    }


    public int getId() {
        return id_event;
    }

    public void setId(int id_event) {
        this.id_event = id_event;
    }

    public String getNom() {
        return nom_event;
    }

    public void setNom(String nom) {
        this.nom_event = nom;
    }

    public String getDate() {
        return date_event;
    }
    
    public void setDate(String date) {
    	this.date_event=date;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String desc) {
    	this.description=desc;
    }

    public int getUserId() {
        return id_user;
    }

}