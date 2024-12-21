package com.example.dao;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.dao.impl.ReservationsDAO;
import com.example.model.Reservations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class ReservationsDAOTest {

    private ReservationsDAO reservationsDAO;

    @BeforeEach
    public void setUp() {
        reservationsDAO = mock(ReservationsDAO.class);
    }

    @Test
    public void testAddReservation() {
        Reservations reservation = new Reservations(1, 2, 3, 4, 5, LocalDate.of(2024, 12, 19));

        doNothing().when(reservationsDAO).add(reservation);

        reservationsDAO.add(reservation);

        verify(reservationsDAO, times(1)).add(reservation);
    }

    @Test
    public void testGetReservation() {
        Reservations reservation = new Reservations(1, 2, 3, 4, 5, LocalDate.of(2024, 12, 19));

        when(reservationsDAO.get(1)).thenReturn(reservation);

        Reservations result = reservationsDAO.get(1);

        assertNotNull(result);
        assertEquals(1, result.getId_reservation());
        assertEquals(2, result.getId_user());
        assertEquals(3, result.getId_event());
        assertEquals(4, result.getId_salle());
        assertEquals(5, result.getId_terrain());
        assertEquals(LocalDate.of(2024, 12, 19), result.getDate_reservation());
    }

    @Test
    public void testGetAllReservations() {
        Reservations reservation = new Reservations(1, 2, 3, 4, 5, LocalDate.of(2024, 12, 19));
        List<Reservations> reservationsList = List.of(reservation);

        when(reservationsDAO.getAll()).thenReturn(reservationsList);

        List<Reservations> result = reservationsDAO.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        Reservations resultReservation = result.get(0);
        assertEquals(1, resultReservation.getId_reservation());
        assertEquals(2, resultReservation.getId_user());
        assertEquals(3, resultReservation.getId_event());
        assertEquals(4, resultReservation.getId_salle());
        assertEquals(5, resultReservation.getId_terrain());
        assertEquals(LocalDate.of(2024, 12, 19), resultReservation.getDate_reservation());
    }

    @Test
    public void testUpdateReservation() {
        Reservations reservation = new Reservations(1, 2, 3, 4, 5, LocalDate.of(2024, 12, 19));

        doNothing().when(reservationsDAO).update(reservation);

        reservationsDAO.update(reservation);

        verify(reservationsDAO, times(1)).update(reservation);
    }

    @Test
    public void testDeleteReservation() {
        doNothing().when(reservationsDAO).delete(1);

        reservationsDAO.delete(1);

        verify(reservationsDAO, times(1)).delete(1);
    }
}
