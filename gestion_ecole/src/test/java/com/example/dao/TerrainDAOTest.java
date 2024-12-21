package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.dao.impl.TerrainDAO;
import com.example.model.Terrain;

public class TerrainDAOTest {

    private TerrainDAO terrainDAO;
    private Connection connectionMock;
    private PreparedStatement preparedStatementMock;
    private ResultSet resultSetMock;

    @BeforeEach
    public void setUp() {
        terrainDAO = mock(TerrainDAO.class);
        connectionMock = mock(Connection.class);
        preparedStatementMock = mock(PreparedStatement.class);
        resultSetMock = mock(ResultSet.class);
    }

    @Test
    public void testAddTerrain() throws Exception {
        Terrain terrain = new Terrain(8, "Central Park", "Football");

        doNothing().when(terrainDAO).add(terrain);

        terrainDAO.add(terrain);

        verify(terrainDAO, times(1)).add(terrain);
    }

    @Test
    public void testGetTerrain() throws Exception {
        Terrain terrain = new Terrain(8, "Central Park", "Football");

        when(terrainDAO.get(8)).thenReturn(terrain);

        Terrain result = terrainDAO.get(8);

        assertNotNull(result);
        assertEquals(8, result.getIdTerrain());
        assertEquals("Central Park", result.getNomTerrain());
        assertEquals("Football", result.getType());
    }

    @Test
    public void testGetAllTerrains() throws Exception {
        Terrain terrain = new Terrain(8, "Central Park", "Football");
        List<Terrain> terrainsList = List.of(terrain);

        when(terrainDAO.getAll()).thenReturn(terrainsList);

        List<Terrain> result = terrainDAO.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        Terrain resultTerrain = result.get(0);
        assertEquals(8, resultTerrain.getIdTerrain());
        assertEquals("Football", resultTerrain.getType());
        assertEquals("Central Park", resultTerrain.getNomTerrain());
    }

    @Test
    public void testUpdateTerrain() throws Exception {
        Terrain terrain = new Terrain(8, "West Side", "Basketball");

        doNothing().when(terrainDAO).update(terrain);

        terrainDAO.update(terrain);

        verify(terrainDAO, times(1)).update(terrain);
    }

    @Test
    public void testDeleteTerrain() throws Exception {
        doNothing().when(terrainDAO).delete(8);

        terrainDAO.delete(8);

        verify(terrainDAO, times(1)).delete(8);
    }
}
