/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ua.jtech.proyint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementación JDBC del patrón singleton para acceder a la base de datos
 *
 * @author melvin
 */
public class FuenteDatosJDBC {

    private static Log logger
            = LogFactory.getLog(FuenteDatosJDBC.class);
    private static FuenteDatosJDBC me = new FuenteDatosJDBC();

    private FuenteDatosJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            logger.fatal("No se encuentra el Driver de MySQL ", cnfe);
        }
    }

    public static FuenteDatosJDBC getInstance() {
        return me;
    }

    /**
     * Crea la conexion a la BD
     *
     * @return Conexion creada
     */
    public Connection createConnection() {
        Connection conn = null;

        try {
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost/biblioteca",
                            "root", "especialista");
        } catch (SQLException sqle) {
            logger.fatal("No se ha podido crear la conexion", sqle);
        }

        return conn;
    }

}
