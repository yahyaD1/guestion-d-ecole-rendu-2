package com.example.model;

import java.time.LocalDate;

public class Evenements {
    private int id_event;
    private String nom_event;
    private LocalDate date_event;
    private String description;
    private int id_user;
    
    public Evenements() {}

    public Evenements(int id_event,String nom, LocalDate date, String description, int userId) {
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

    public LocalDate getDate() {
        return date_event;
    }
    
    public void setDate(LocalDate date) {
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
    public void setIdUser(int id_user){
        this.id_user=id_user;
    }

}