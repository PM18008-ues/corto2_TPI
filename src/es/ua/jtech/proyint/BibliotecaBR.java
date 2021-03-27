/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ua.jtech.proyint;

/**
 * Reglas de Negocio de la Biblioteca BR = Business Rules
 *
 * Lo implementamos como un singleton por si algun dia queremos leer las
 * constantes desde un fichero de configuración, lo podemos hacer desde el
 * constructor del singleton
 *
 * @author melvin
 */
public class BibliotecaBR {

    private static BibliotecaBR me = new BibliotecaBR();

    private BibliotecaBR() {
    }

    public static BibliotecaBR getInstance() {
        return me;
    }

    /**
     * Calcula el número de dias de plazo que tienen un usuario para realizar
     * una reserva (Socio = 5 , Profesor = 10)
     *
     * @param tipo tipo del usuario
     * @return número de dias de reserva
     * @throws BibliotecaException el tipo del usuario no es válido
     */
    public int calculaNumDiasReserva(TipoUsuario tipo)
            throws BibliotecaException {
        // TODO Completar
    }

    /**
     * Calcula el número de dias de plazo que tienen un usuario para realizar un
     * prestamo (Socio = 7 , Profesor = 30)
     *
     * @param tipo tipo del usuario
     * @return número de dias del prestamo
     * @throws BibliotecaException el tipo del usuario no es válido
     */
    public int calculaNumDiasPrestamo(TipoUsuario tipo)
            throws BibliotecaException {
        // TODO Completar
    }

    /**
     * Valida que el número de operaciones realizadas por un determinado tipo de
     * usuario se inferior al cupo definido
     *
     * @param tipo tipo del usuario
     * @param numOp número de operación que ya tiene realizadas
     * @throws BibliotecaException el cupo de operacion esta lleno, o el tipo
     * del usuario no es el esperado
     */
    public void compruebaCupoOperaciones(TipoUsuario tipo, int numOp)
            throws BibliotecaException {
        // TODO Completar
    }
}
