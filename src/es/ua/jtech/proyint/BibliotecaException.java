/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ua.jtech.proyint;

/**
 * Excepcion padre de todas las excepciones de la aplicación
 *
 * @author melvin
 */
public class BibliotecaException extends Exception {

    private static final long serialVersionUID = -5438451334294984028L;

    public BibliotecaException() {
        super();
    }

    public BibliotecaException(String message) {
        super(message);
    }

    public BibliotecaException(String message, Throwable cause) {
        super(message, cause);
    }
}
