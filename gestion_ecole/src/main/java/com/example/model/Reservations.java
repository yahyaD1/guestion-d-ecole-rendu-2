package com.example.model;

import java.sql.Date;

public class Reservations {
    private int id_reservation;
    private int id_user;
    private int id_event;
    private int id_salle;
    private int id_terrain;
    private Date date_reservation; 

    public Reservations(int id_reservation ,int id_user, int id_event, int id_salle, int id_terrain, Date date_reservation) {
        this.id_reservation=id_reservation;
        this.id_user = id_user;
        this.id_event = id_event;
        this.id_salle = id_salle;
        this.id_terrain = id_terrain;
        this.date_reservation = date_reservation;
    }

    public Reservations() {
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public int getId_terrain() {
        return id_terrain;
    }

    public void setId_terrain(int id_terrain) {
        this.id_terrain = id_terrain;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

}
