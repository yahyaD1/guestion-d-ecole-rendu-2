package com.example.dao;

import com.example.dao.impl.SallesDAO;
import com.example.model.Salles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SalleDAOTest {

    private SallesDAO salleDAO;

    @BeforeEach
    public void setUp() {
        salleDAO = mock(SallesDAO.class);
    }

    @Test
    void testAdd() {
        Salles salle = new Salles(0, "Conference Room", 50);

        doNothing().when(salleDAO).add(salle);

        salleDAO.add(salle);

        verify(salleDAO, times(1)).add(salle);
    }

    @Test
    void testGet() {
        Salles salle = new Salles(1, "Conference Room", 50);

        when(salleDAO.get(1)).thenReturn(salle);

        Salles result = salleDAO.get(1);

        assertNotNull(result);
        assertEquals(1, result.getId_salle());
        assertEquals("Conference Room", result.getNom_salle());
        assertEquals(50, result.getCapacite());
    }

    @Test
    void testGetAll() {
        Salles salle = new Salles(1, "Conference Room", 50);
        List<Salles> sallesList = List.of(salle);

        when(salleDAO.getAll()).thenReturn(sallesList);

        List<Salles> result = salleDAO.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        Salles resultSalle = result.get(0);
        assertEquals(1, resultSalle.getId_salle());
        assertEquals("Conference Room", resultSalle.getNom_salle());
        assertEquals(50, resultSalle.getCapacite());
    }

    @Test
    void testUpdate() {
        Salles salle = new Salles(1, "Updated Room", 100);

        doNothing().when(salleDAO).update(salle);

        salleDAO.update(salle);

        verify(salleDAO, times(1)).update(salle);
    }

    @Test
    void testDelete() {
        doNothing().when(salleDAO).delete(1);

        salleDAO.delete(1);

        verify(salleDAO, times(1)).delete(1);
    }
}
