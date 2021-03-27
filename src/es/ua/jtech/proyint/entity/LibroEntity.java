/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ua.jtech.proyint.entity;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa un libro. Destacar que la app no permite 2 ejemplares de
 * un mismo libro
 *
 * @author melvin
 */
public class LibroEntity extends EntityObject {

    private static final long serialVersionUID = 3957186972437085430L;

    private String isbn;
    private String titulo;
    private String autor;
    private int numPaginas;
    private Date fechaAlta;

    private List<OperacionHistoricoEntity> operaciones;

    private OperacionActivaEntity activa;

    public LibroEntity() {
    }

    public LibroEntity(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // resto de getters/setters
}
