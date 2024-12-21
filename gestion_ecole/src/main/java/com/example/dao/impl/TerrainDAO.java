package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Terrain;
import com.example.util.PostgreSQLConnection;

@SuppressWarnings("CallToPrintStackTrace")
public class TerrainDAO implements GenericDAO<Terrain> {

    @Override
    public void add(Terrain terrain) {
        String query = "INSERT INTO terrain (nom_terrain, type) VALUES (?, ?)";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, terrain.getNomTerrain());
            stmt.setString(2, terrain.getType());
            
            stmt.executeUpdate();
            System.out.println("Terrain ajouté avec succès");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du terrain");
            e.printStackTrace();
        }
    }

    @Override
    public Terrain get(int id) {
        String query = "SELECT * FROM terrain WHERE id_terrain = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
    
            if (resultSet.next()) {
                String nom_terrain = resultSet.getString("nom_terrain");
                String type = resultSet.getString("type");
                return new Terrain(id, nom_terrain, type);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du terrain");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Terrain> getAll() {
        List<Terrain> terrainList = new ArrayList<>();
        String query = "SELECT * FROM terrain";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id_terrain = resultSet.getInt("id_terrain");
                String nom_terrain = resultSet.getString("nom_terrain");
                String type = resultSet.getString("type");
                terrainList.add(new Terrain(id_terrain, nom_terrain, type));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des terrains");
            e.printStackTrace();
        }
        return terrainList;
    }

    @Override
    public void update(Terrain terrain) {
        String query = "UPDATE terrain SET nom_terrain = ?, type = ? WHERE id_terrain = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, terrain.getNomTerrain());
            stmt.setString(2, terrain.getType());
            stmt.setInt(3, terrain.getIdTerrain());
            stmt.executeUpdate();
            System.out.println("Terrain mis à jour avec succès");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du terrain");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM terrain WHERE id_terrain = ?";
        try (Connection conn = PostgreSQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Terrain supprimé avec succès");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du terrain");
            e.printStackTrace();
        }
    }
}
