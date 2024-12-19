package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Evenements;
import com.example.util.PostgreSQLConnection;

public class EvenementDAO implements GenericDAO<Evenements> {

    @Override
    public void add(Evenements event) {
        String checkUserSql = "SELECT COUNT(*) FROM utilisateurs WHERE id_user = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkUserSql)) {
            checkStmt.setInt(1, event.getUserId());
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    String sql = "INSERT INTO evenements (nom_event, date_event, description, id_user) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setString(1, event.getNom());
                        stmt.setString(2, event.getDate());
                        stmt.setString(3, event.getDescription());
                        stmt.setInt(4, event.getUserId());
                        stmt.executeUpdate();
                        System.out.println("Evenement ajouté avec succès.");
                    }
                } else {
                    throw new SQLException("Utilisateur inexistant.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Evenements get(int id) {
        String sql = "SELECT * FROM evenements WHERE id_event = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Evenements(
                        rs.getInt("id_event"),
                        rs.getString("nom_event"),
                        rs.getString("date_event"),
                        rs.getString("description"),
                        rs.getInt("id_user")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Evenements> getAll() {
        String sql = "SELECT * FROM evenements";
        List<Evenements> evenements = new ArrayList<>();
        try (Connection conn = PostgreSQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultats = stmt.executeQuery(sql)) {
            while (resultats.next()) {
                Evenements event = new Evenements(
                    resultats.getInt("id_event"),
                    resultats.getString("nom_event"),
                    resultats.getString("date_event"),
                    resultats.getString("description"),
                    resultats.getInt("id_user")
                );
                evenements.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evenements;
    }

    @Override
    public void update(Evenements event) {
        String sql = "UPDATE evenements SET nom_event = ?, date_event = ?, description = ?, id_user = ? WHERE id_event = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, event.getNom());
            stmt.setString(2, event.getDate());
            stmt.setString(3, event.getDescription());
            stmt.setInt(4, event.getUserId());
            stmt.setInt(5, event.getId());
            stmt.executeUpdate();
            System.out.println("Evenement modifié avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM evenements WHERE id_event = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Evenement supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
