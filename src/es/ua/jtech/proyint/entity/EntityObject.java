/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ua.jtech.proyint.entity;

import java.io.Serializable;

/**
 *
 * Padre de todos nuestros Entities Si abrimos la jerarquia de tipos (F4),
 * podemos ver todos los entities que tenemos. Todos nuestros EntityObject
 * realizan el patrón TransferObject
 *
 * @author melvin
 */

public abstract class EntityObject implements Serializable {

    private static final long serialVersionUID = 1L;

    // Aqui añadiriamos los métodos que quisieramos compartir entre todas las entidades
}