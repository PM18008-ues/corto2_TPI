/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ua.jtech.proyint.dao.operacion;

import java.util.List;

import es.ua.jtech.proyint.dao.DAOException;
import es.ua.jtech.proyint.entity.LibroEntity;
import es.ua.jtech.proyint.entity.OperacionActivaEntity;
import es.ua.jtech.proyint.entity.OperacionEntity;

/**
 * Interface para el DAO Operacion
 *
 * @author melvin
 */
public interface IOperacionDAO {

    /**
     * Comprueba si un libro esta diponible para ser reservado o prestado
     *
     * @param isbn ISBN del libro a consultar
     * @return true si el libro está disponible, false en caso contrario
     * @throws DAOException
     */
    boolean isLibroDisponible(String isbn) throws DAOException;

    /**
     * Obtiene una operación proporcionando su identificador
     *
     * @param idOperacion Identificador de la operación a obtener
     * @return la operación solicitada, o null si no hay ninguna operación con
     * el identificador proporcionado
     * @throws DAOException
     */
    OperacionEntity getOperacion(String idOperacion)
            throws DAOException;

    /**
     * Obtiene el numero de operaciones que tiene activo un determinado usuario
     *
     * @param login Login del usuario
     * @return numero de operaciones activas
     * @throws DAOException
     */
    int countOperacionesActivas(String login) throws DAOException;

    /**
     * Añade una nueva operación a la BD.
     *
     * @param operacion Operacion a insertar
     * @return El identificador de operacion generado. Este número es
     * autogenerado.
     * @throws DAOException
     */
    String addOperacion(OperacionEntity operacion)
            throws DAOException;

    /**
     * Elimina la operación cuyo id es el pasado por parámetro
     *
     * @param idOperacion Id de la operación a eliminar.
     * @return Numero de registros afectados
     * @throws DAOException
     */
    int delOperacion(String idOperacion) throws DAOException;

    /**
     * Modifica la operación pasada por parámetro
     *
     * @param operacion Datos de la operación a modificar.
     * @return Numero de registros afectados
     * @throws DAOException
     */
    int updateOperacion(OperacionEntity operacion)
            throws DAOException;

    /**
     * Devuelve una lista de libros prestados, con los atributos del prestamo
     *
     * @return Lista de libros prestados
     * @throws DAOException
     */
    List<OperacionActivaEntity> getLibrosPrestados()
            throws DAOException;

    /**
     * Devuelve una lista de libros reservados, con los atributos de la reserva
     *
     * @return Lista de libros reservados
     * @throws DAOException
     */
    List<OperacionActivaEntity> getLibrosReservados()
            throws DAOException;

    /**
     * Devuelve una lista de libros disponibles
     *
     * @return Lista de libros disponibles
     * @throws DAOException
     */
    List<LibroEntity> getLibrosDisponibles() throws DAOException;

    /**
     * Devuelve una lista de libros, y en el caso de tener alguna operacion
     * asociada, con los atributos de la operacion
     *
     * @return Lista de todos los libros, junto a sus operaciones activas (si
     * las hay)
     * @throws DAOException
     */
    List<LibroEntity> getLibros() throws DAOException;

}
