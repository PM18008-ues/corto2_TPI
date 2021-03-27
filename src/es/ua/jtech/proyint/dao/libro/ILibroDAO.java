/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ua.jtech.proyint.dao.libro;

import java.util.List;

import es.ua.jtech.proyint.dao.DAOException;
import es.ua.jtech.proyint.entity.LibroEntity;

/**
 * Interface para el DAO Libro
 *
 * @author melvin
 */
public interface ILibroDAO {

    /**
     * Selecciona un libro de la BD
     *
     * @param isbn Isbn del libro a seleccionar
     * @return Libro seleccionado
     * @throws DAOException
     */
    LibroEntity getLibro(String isbn) throws DAOException;

    /**
     * Añade un libro en la BD
     *
     * @param libro Libro a añadir.
     * @throws DAOException
     */
    void addLibro(LibroEntity libro) throws DAOException;

    /**
     * El libro pasado por parámetro es borrado de la BD
     *
     * @param isbn Libro a eliminar
     * @return Número de registros afectados por el borrado
     * @throws DAOException
     */
    int delLibro(String isbn) throws DAOException;

    /**
     * Devuelve una lista con todos los libros en la BD
     *
     * @return Lista con todos los libros
     * @throws DAOException
     */
    List<LibroEntity> getLibros() throws DAOException;

    /**
     * Actualiza el valor de un libro
     *
     * @param libro Libro a modificar.
     * @return Numero de libros actualizados
     * @throws DAOException
     */
    int updateLibro(LibroEntity libro) throws DAOException;
}
