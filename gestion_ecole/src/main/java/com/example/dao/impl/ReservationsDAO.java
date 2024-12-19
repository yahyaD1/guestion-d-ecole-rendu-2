package com.example.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.impl.GenericDAO;
import com.example.model.Reservations;
import com.example.util.PostgreSQLConnection;

public class ReservationsDAO implements GenericDAO<Reservations> {

    public boolean verifierDisponibilite(int id_salle, int id_terrain, Date date_reservation) {
        String query = "SELECT id_reservation FROM reservations WHERE date_reservation = ? AND id_salle = ? AND id_terrain = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDate(1, date_reservation);
            stmt.setInt(2, id_salle);
            stmt.setInt(3, id_terrain);

            try (ResultSet resultSet = stmt.executeQuery()) {
                return !resultSet.next(); // Return true if no reservation found
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la vérification de disponibilité : " + e.getMessage());
            return false;
        }
    }

    @Override
    public void add(Reservations reservation) {
        String query = "INSERT INTO reservations (id_user, id_event, id_salle, id_terrain, date_reservation) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, reservation.getId_user());
            stmt.setInt(2, reservation.getId_event());
            stmt.setInt(3, reservation.getId_salle());
            stmt.setInt(4, reservation.getId_terrain());
            stmt.setDate(5, reservation.getDate_reservation());

            stmt.executeUpdate();
            System.out.println("Réservation ajoutée avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la réservation : " + e.getMessage());
        }
    }

    @Override
    public Reservations get(int id_reservation) {
        String query = "SELECT * FROM reservations WHERE id_reservation = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id_reservation);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new Reservations(
                        resultSet.getInt("id_reservation"),
                        resultSet.getInt("id_user"),
                        resultSet.getInt("id_event"),
                        resultSet.getInt("id_salle"),
                        resultSet.getInt("id_terrain"),
                        resultSet.getDate("date_reservation")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de la réservation : " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Reservations> getAll() {
        List<Reservations> reservationsList = new ArrayList<>();
        String query = "SELECT * FROM reservations";
        try (Connection conn = PostgreSQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(query)) {

            while (resultSet.next()) {
                reservationsList.add(new Reservations(
                    resultSet.getInt("id_reservation"),
                    resultSet.getInt("id_user"),
                    resultSet.getInt("id_event"),
                    resultSet.getInt("id_salle"),
                    resultSet.getInt("id_terrain"),
                    resultSet.getDate("date_reservation")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de toutes les réservations : " + e.getMessage());
        }
        return reservationsList;
    }

    @Override
    public void update(Reservations reservation) {
        String sql = "UPDATE reservations SET id_user = ?, id_event = ?, id_salle = ?, id_terrain = ?, date_reservation = ? WHERE id_reservation = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reservation.getId_user());
            stmt.setInt(2, reservation.getId_event());
            stmt.setInt(3, reservation.getId_salle());
            stmt.setInt(4, reservation.getId_terrain());
            stmt.setDate(5, reservation.getDate_reservation());
            stmt.setInt(6, reservation.getId_reservation());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Réservation mise à jour avec succès.");
            } else {
                System.err.println("Réservation introuvable.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de la réservation : " + e.getMessage());
        }
    }

    @Override
    public void delete(int id_reservation) {
        String sql = "DELETE FROM reservations WHERE id_reservation = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_reservation);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Réservation supprimée avec succès.");
            } else {
                System.err.println("Aucune réservation trouvée avec cet ID.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la réservation : " + e.getMessage());
        }
    }
}
