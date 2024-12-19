package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.impl.GenericDAO;
import com.example.model.Salles;
import com.example.util.PostgreSQLConnection;

public class SallesDAO implements GenericDAO<Salles> {

    @Override
    public void add(Salles salle) {
        String query = "INSERT INTO salles (nom_salle, capacite) VALUES (?, ?)";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, salle.getNom_salle());
            stmt.setInt(2, salle.getCapacite());
            
            stmt.executeUpdate();
            System.out.println("Salle ajoutée avec succès");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la salle");
            e.printStackTrace();
        }
    }

    @Override
    public Salles get(int id) {
        String query = "SELECT * FROM salles WHERE id_salle = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
    
            if (resultSet.next()) {
                String nom_salle = resultSet.getString("nom_salle");
                int capacite = resultSet.getInt("capacite");
                return new Salles(id, nom_salle, capacite);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de la salle");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Salles> getAll() {
        List<Salles> sallesList = new ArrayList<>();
        String query = "SELECT * FROM salles";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id_salle = resultSet.getInt("id_salle");
                String nom_salle = resultSet.getString("nom_salle");
                int capacite = resultSet.getInt("capacite");
                sallesList.add(new Salles(id_salle, nom_salle, capacite));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des salles");
            e.printStackTrace();
        }
        return sallesList;
    }

    @Override
    public void update(Salles salle) {
        String query = "UPDATE salles SET nom_salle = ?, capacite = ? WHERE id_salle = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, salle.getNom_salle());
            stmt.setInt(2, salle.getCapacite());
            stmt.setInt(3, salle.getId_salle());
            stmt.executeUpdate();
            System.out.println("Salle mise à jour avec succès");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de la salle");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM salles WHERE id_salle = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Salle supprimée avec succès");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la salle");
            e.printStackTrace();
        }
    }
}
