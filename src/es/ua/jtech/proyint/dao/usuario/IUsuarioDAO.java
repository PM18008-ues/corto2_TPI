/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ua.jtech.proyint.dao.usuario;

import es.ua.jtech.proyint.dao.DAOException;
import es.ua.jtech.proyint.entity.UsuarioEntity;

/**
 * Interface para el DAO Usuario
 *
 * @author melvin
 */
public interface IUsuarioDAO {

    /**
     * Recupera un usuario a partir de su PK
     *
     * @param login Login del usuario a seleccionar
     * @return El usuario seleccionado o null si no existe
     * @throws DAOException
     */
    UsuarioEntity getUsuario(String login) throws DAOException;

    /**
     * Añade un usuario a la BD
     *
     * @param usuario Usuario a añadir en la BD
     * @throws DAOException
     */
    //void addUsuario(UsuarioEntity usuario) throws DAOException;
    /**
     * Borra el usuario de la BD
     *
     * @param login Usuario a eliminar
     * @return Número de registros afectados en el borrado
     * @throws DAOException
     */
    //int delUsuario(String login) throws DAOException;
    /**
     * Modifica los datos de un usario de la BD
     *
     * @param usuario Usuario a modificar
     * @return Número de registros afectados en la actualizacion
     * @throws DAOException
     */
    //int updateUsuario(UsuarioEntity usuario) throws DAOException;
    /**
     * Devuelve una lista con todos los usuarios en la BD
     *
     * @return Lista con todos los usuarios
     * @throws DAOException
     */
    //List<UsuarioEntity> getUsuarios() throws DAOException;
    /**
     * Añade una multa al usuario relacionado con la multa
     *
     * @param multa
     * @throws DAOException
     */
    //void addMulta(MultaEntity multa) throws DAOException;
    /**
     * Elimina una multa
     *
     * @param idMulta Identificador de la multa a eliminar
     * @return Numero de registros afectados por el borrado
     * @throws DAOException
     */
    //int delMulta(String idMulta) throws DAOException;
    /**
     * Obtiene los datos de una multa
     *
     * @param idMulta Identificador de la multa a consultar
     * @return Datos de la multa
     * @throws DAOException
     */
    //MultaEntity getMulta(String idMulta) throws DAOException;
    /**
     * Modifica una multa
     *
     * @param multa Datos de la multa a modificar
     * @return Numero de registros afectados por la modificacion
     * @throws DAOException
     */
    //int updateMulta(MultaEntity multa) throws DAOException;
    /**
     * Obtiene las multas, activas o históricas, de un determinado usuario
     *
     * @param login Login del usuario
     * @param estado Estado de las multas a obtener (activa o histórica)
     * @return Lista de multas
     * @throws DAOException
     */
    //List<MultaEntity> getMultas(String login, EstadoMulta estado) throws DAOException;
}
