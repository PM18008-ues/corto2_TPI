/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ua.jtech.proyint.dao;

import es.ua.jtech.proyint.BibliotecaException;

/**
 * Manejo de excepciones para los DAO
 *
 * @author melvin
 */
public class DAOException extends BibliotecaException {

    private static final long serialVersionUID
            = 6158132279964132104L;

    /**
     * Constructor de la clase
     */
    public DAOException() {
        super();
    }

    /**
     * Constructor de la clase con mensaje
     *
     * @param message Mensaje con la excepcion
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Constructor de la clase con mensaje y causa
     *
     * @param message Mensaje con la excepcion
     * @param cause Causa de la excepcion
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
