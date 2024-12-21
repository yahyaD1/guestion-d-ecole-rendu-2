package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Utilisateur;
import com.example.util.PostgreSQLConnection;

@SuppressWarnings("CallToPrintStackTrace")
public class UtilisateurDAO implements GenericDAO<Utilisateur> {

    @Override
    public void add(Utilisateur user) {
        String query = "INSERT INTO utilisateurs (id_user, nom, prenom, email, type) VALUES (?,?, ?, ?, ?)";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, user.getIdUser());
            stmt.setString(2, user.getNom());
            stmt.setString(3, user.getPrenom());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getType());

            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès");
        } catch (SQLException e) {
            System.err.println("Erreur d'ajout d'utilisateur");
            e.printStackTrace();
        }
    }

    @Override
    public Utilisateur get(int id) {
        String query = "SELECT * FROM utilisateurs WHERE idUser = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String type = resultSet.getString("type");
                return new Utilisateur(id, nom, prenom, email, type);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'utilisateur");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Utilisateur> getAll() {
        List<Utilisateur> utilisateurList = new ArrayList<>();
        String query = "SELECT * FROM utilisateurs";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id_user = resultSet.getInt("id_user");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String type = resultSet.getString("type");
                utilisateurList.add(new Utilisateur(id_user, nom, prenom, email, type));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des utilisateurs");
            e.printStackTrace();
        }
        return utilisateurList;
    }

    @Override
    public void update(Utilisateur user) {
        String query = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ?, type = ? WHERE idUser = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getPrenom());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getType());
            stmt.setInt(5, user.getIdUser());
            stmt.executeUpdate();
            System.out.println("Utilisateur mis à jour avec succès");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'utilisateur");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM utilisateurs WHERE idUser = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Utilisateur supprimé avec succès");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'utilisateur");
            e.printStackTrace();
        }
    }
}
