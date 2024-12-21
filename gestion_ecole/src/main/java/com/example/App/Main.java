package com.example.App;

import java.time.LocalDate;

import com.example.dao.impl.EvenementDAO;
import com.example.dao.impl.SallesDAO;
import com.example.model.Evenements;
import com.example.model.Reservations;

public class Main {
    public static void main(String[] args) {

        // //SHOW USER
        // UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        // List<Utilisateur> users = utilisateurDAO.getAll();
        // for (Utilisateur user : users){
        //     System.out.print(user.getIdUser() + " " + user.getPrenom() +" "+ user.getEmail() + " " + user.getType());
        //     System.err.println("");
        // }        


        // Add user
        // Utilisateur user1 = new Utilisateur(6, "Lahbal", "Oualid", "lahbal.oualid@example.com", "ETUDIANT");
        // utilisateurDAO.add(user1); 
       LocalDate date = LocalDate.of(2024, 12, 22);

        // Salles salle = new Salles(1, "salle 1", 55);
        Evenements event = new Evenements(1, "ceremony", date, "111111111111111", 6);

        SallesDAO sallesDAO = new SallesDAO();
        // sallesDAO.add(salle);
        EvenementDAO evenementDAO = new EvenementDAO();
        evenementDAO.add(event);
        Reservations reservation = new Reservations(0, 0, 0, 0, 0, date);
    }
}
