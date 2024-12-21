
package com.example.model;

public class Utilisateur {

    private int idUser;
    private String nom;
    private String prenom;
    private String email;
    private String type; 

    
    public Utilisateur(int idUser,String nom, String prenom, String email, String type) {
        this.idUser=idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.type = type;
    }

    public Utilisateur() {
    }

    
    public int getIdUser() {
        return idUser;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    void setEmail(String email){
        this.email = email;
    }
    void setNom(String nom){
        this.nom = nom;
    }
    void setPrenom(String prenom){
        this.prenom = prenom;
    }
    void setType(String type){
        this.type = type;
    }
    void setIdUser(int idUser){
        this.idUser = idUser;
    }
    
}
