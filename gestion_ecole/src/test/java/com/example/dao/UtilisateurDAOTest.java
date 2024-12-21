package com.example.dao;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.dao.impl.UtilisateurDAO;
import com.example.model.Utilisateur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UtilisateurDAOTest {

    private UtilisateurDAO utilisateurDAO;

    @BeforeEach
    public void setUp() {
        utilisateurDAO = mock(UtilisateurDAO.class);
    }

    @Test
    public void testAddUtilisateur() {
        Utilisateur utilisateur = new Utilisateur(7, "Lahbal", "Oualid", "lahbal.oualid@example.com", "ETUDIANT");

        doNothing().when(utilisateurDAO).add(utilisateur);

        utilisateurDAO.add(utilisateur);

        verify(utilisateurDAO, times(1)).add(utilisateur);
    }

    @Test
    public void testGetUtilisateur() {
        Utilisateur utilisateur = new Utilisateur(1, "John Doe", null, "john.doe@example.com", null);

        when(utilisateurDAO.get(1)).thenReturn(utilisateur);

        Utilisateur result = utilisateurDAO.get(1);

        assertNotNull(result);
        assertEquals(1, result.getIdUser());
        assertEquals("John Doe", result.getNom());
        assertEquals("john.doe@example.com", result.getEmail());
    }

    @Test
    public void testGetAllUtilisateurs() {
        Utilisateur utilisateur = new Utilisateur(1, "John Doe", null, "john.doe@example.com", null);
        List<Utilisateur> utilisateursList = List.of(utilisateur);

        when(utilisateurDAO.getAll()).thenReturn(utilisateursList);

        List<Utilisateur> result = utilisateurDAO.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        Utilisateur resultUtilisateur = result.get(0);
        assertEquals(1, resultUtilisateur.getIdUser());
        assertEquals("John Doe", resultUtilisateur.getNom());
        assertEquals("john.doe@example.com", resultUtilisateur.getEmail());
    }

    @Test
    public void testUpdateUtilisateur() {
        Utilisateur utilisateur = new Utilisateur(6, "Lahbil", "Oualid", "lahbal.oualid@example.com", "ETUDIANT");

        doNothing().when(utilisateurDAO).update(utilisateur);

        utilisateurDAO.update(utilisateur);

        verify(utilisateurDAO, times(1)).update(utilisateur);
    }

    @Test
    public void testDeleteUtilisateur() {
        doNothing().when(utilisateurDAO).delete(1);

        utilisateurDAO.delete(1);

        verify(utilisateurDAO, times(1)).delete(1);
    }
}