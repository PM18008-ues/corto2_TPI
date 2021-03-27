/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ua.jtech.proyint;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Prueba JUnit sobre las reglas de negocio
 * 
 * @author melvin
 */
public class BibliotecaBRTest {

    @Test
    public void testCalculaNumDiasReservaProfesor() throws BibliotecaException {
        int dias = BibliotecaBR.getInstance().calculaNumDiasReserva(TipoUsuario.profesor);
        assertEquals(dias, 10);
    }

    @Test
    public void testCalculaNumDiasReservaSocio() throws BibliotecaException {
        int dias = BibliotecaBR.getInstance().calculaNumDiasReserva(TipoUsuario.socio);
        assertEquals(dias, 5);
    }

    @Test
    public void testCalculaNumDiasPrestamoProfesor() throws Exception {
        int dias = BibliotecaBR.getInstance().calculaNumDiasPrestamo(TipoUsuario.profesor);
        assertEquals(dias, 30);
    }

    @Test
    public void testCalculaNumDiasPrestamoSocio() throws Exception {
        int dias = BibliotecaBR.getInstance().calculaNumDiasPrestamo(TipoUsuario.socio);
        assertEquals(dias, 7);
    }

    @Test
    public void testCompruebaCupoOperacionesProfesor() {
        try {
            BibliotecaBR.getInstance().compruebaCupoOperaciones(TipoUsuario.profesor, 4);
            BibliotecaBR.getInstance().compruebaCupoOperaciones(TipoUsuario.profesor, 0);
        } catch (BibliotecaException e) {
            fail("No deberia fallar el socio");
        }

        try {
            BibliotecaBR.getInstance().compruebaCupoOperaciones(TipoUsuario.profesor, 11);
            fail("Debería evitar que un profesor pudiera hacer más de 10 operaciones");
        } catch (BibliotecaException e) {
        }
    }

    @Test
    public void testCompruebaCupoOperacionesSocio() {
        try {
            BibliotecaBR.getInstance().compruebaCupoOperaciones(TipoUsuario.socio, 2);
            BibliotecaBR.getInstance().compruebaCupoOperaciones(TipoUsuario.socio, 0);
        } catch (BibliotecaException e) {
            fail("No deberia fallar el socio");
        }

        try {
            BibliotecaBR.getInstance().compruebaCupoOperaciones(TipoUsuario.socio, 4);
            fail("Debería evitar que un socio pudiera hacer más de 3 operaciones");
        } catch (BibliotecaException e) {
        }
    }
}

