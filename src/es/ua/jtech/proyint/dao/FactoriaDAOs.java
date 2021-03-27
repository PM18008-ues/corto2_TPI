/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ua.jtech.proyint.dao;

import es.ua.jtech.proyint.dao.libro.ILibroDAO;
import es.ua.jtech.proyint.dao.libro.LibroJDBCDAO;
import es.ua.jtech.proyint.dao.operacion.IOperacionDAO;
import es.ua.jtech.proyint.dao.operacion.OperacionJDBCDAO;
import es.ua.jtech.proyint.dao.usuario.IUsuarioDAO;
import es.ua.jtech.proyint.dao.usuario.UsuarioJDBCDAO;

/**
 * Factoria que desacopla la implementación de los datos
 *
 * @author melvin
 */
public class FactoriaDAOs {

    private static FactoriaDAOs me = new FactoriaDAOs();

    private FactoriaDAOs() {
    }

    public static FactoriaDAOs getInstance() {
        return me;
    }

    public ILibroDAO getLibroDAO() {
        return new LibroJDBCDAO();
    }

    public IOperacionDAO getOperacionDAO() {
        return new OperacionJDBCDAO();
    }

    public IUsuarioDAO getUsuarioDAO() {
        return new UsuarioJDBCDAO();
    }

}
