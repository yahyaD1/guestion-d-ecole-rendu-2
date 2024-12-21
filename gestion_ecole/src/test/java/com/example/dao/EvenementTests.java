package com.example.dao;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.dao.impl.EvenementDAO;
import com.example.model.Evenements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class EvenementTests {

    private EvenementDAO evenementDAO;

    @BeforeEach
    public void setUp() {
        evenementDAO = mock(EvenementDAO.class);
    }

    @Test
    public void testAjouterEvenement() {
        Evenements evenement = new Evenements();
        evenement.setId(1);
        evenement.setNom("Concert");
        evenement.setDate(LocalDate.of(2024, 12, 25));
        evenement.setDescription("Concert de musique");
        evenement.setIdUser(7);


        doNothing().when(evenementDAO).add(evenement);

        evenementDAO.add(evenement);

        verify(evenementDAO, times(1)).add(evenement);
    }

    @Test
    public void testAfficherEvenement() {
        Evenements evenement = new Evenements();
        evenement.setId(1);
        evenement.setNom("Concert");
        evenement.setDate(LocalDate.of(2024, 12, 25));
        evenement.setDescription("Concert de musique");
        evenement.setIdUser(7);

        when(evenementDAO.get(1)).thenReturn(evenement);

        Evenements resultat = evenementDAO.get(1);

        assertNotNull(resultat);
        assertEquals(1, resultat.getId());
        assertEquals("Concert", resultat.getNom());
        assertEquals(LocalDate.of(2024, 12, 25), resultat.getDate());
        assertEquals("Concert de musique", resultat.getDescription());
        assertEquals(7, resultat.getUserId());
    }

    @Test
    public void testAfficherEvenementNonTrouve() {
        when(evenementDAO.get(999)).thenReturn(null);

        Evenements resultat = evenementDAO.get(999);

        assertNull(resultat);
    }

    @Test
    public void testModifierEvenement() {
        Evenements evenement = new Evenements();
        evenement.setId(1);
        evenement.setNom("Concert");
        evenement.setDate(LocalDate.of(2024, 12, 25));
        evenement.setDescription("Concert de musique");
        evenement.setIdUser(7);

        doNothing().when(evenementDAO).update(evenement);
        evenementDAO.update(evenement);
        verify(evenementDAO, times(1)).update(evenement);
    }

    @Test
    public void testSupprimerEvenement() {
        doNothing().when(evenementDAO).delete(1);
        evenementDAO.delete(1);
        verify(evenementDAO, times(1)).delete(1);
    }
}