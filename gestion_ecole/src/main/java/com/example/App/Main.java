package com.example.App;

import com.example.dao.impl.UtilisateurDAO;
import com.example.model.Utilisateur;

public class Main {
    public static void main(String[] args) {
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

        // Testing add method
        System.out.println("Adding new user...");
        Utilisateur user1 = new Utilisateur(6, "Lahbal", "Oualid", "lahbal.oualid@example.com", "ETUDIANT");
        utilisateurDAO.add(user1);  // Add user

        // // Testing get method
        // System.out.println("\nFetching user by ID...");
        // Utilisateur fetchedUser = utilisateurDAO.get(1);  // Assuming the user ID is 1
        // if (fetchedUser != null) {
        //     System.out.println("Fetched User: " + fetchedUser.getNom() + " " + fetchedUser.getPrenom());
        // } else {
        //     System.out.println("User not found!");
        // }

        // // Testing getAll method
        // System.out.println("\nFetching all users...");
        // utilisateurDAO.getAll().forEach(user -> {
        //     System.out.println(user.getNom() + " " + user.getPrenom() + " (" + user.getEmail() + ")");
        // });

        // // Testing update method
        // System.out.println("\nUpdating user...");
        // Utilisateur userToUpdate = new Utilisateur(1, "John", "Doe", "john.doe@newemail.com", "Admin");
        // utilisateurDAO.update(userToUpdate);

        // // Fetch updated user to verify
        // Utilisateur updatedUser = utilisateurDAO.get(1);
        // if (updatedUser != null) {
        //     System.out.println("Updated User: " + updatedUser.getNom() + " " + updatedUser.getPrenom() + " (" + updatedUser.getEmail() + ")");
        // }

        // // Testing delete method
        // System.out.println("\nDeleting user...");
        // utilisateurDAO.delete(1);  // Delete user by ID

        // // Verify if the user was deleted
        // Utilisateur deletedUser = utilisateurDAO.get(1);
        // if (deletedUser == null) {
        //     System.out.println("User has been deleted successfully!");
        // } else {
        //     System.out.println("User still exists: " + deletedUser.getNom());
        // }
    }
}
