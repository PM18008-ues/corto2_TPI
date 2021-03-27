package es.ua.jtech.proyint.dao.libro;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import es.ua.jtech.proyint.dao.DAOException;
import es.ua.jtech.proyint.dao.FactoriaDAOs;
import es.ua.jtech.proyint.entity.LibroEntity;

public class ILibroDAOTest {

    @Test
    public void testGetLibro() throws DAOException {
        FactoriaDAOs factoriaDao = FactoriaDAOs.getInstance();
        ILibroDAO libroDao = factoriaDao.getLibroDAO();

        LibroEntity libro = libroDao.getLibro("0321180860");
        assertEquals(465, libro.getNumPaginas());
        assertEquals("Understanding SOA with Web Services",
                libro.getTitulo());
        assertEquals("Eric Newcomer and Greg Lomow", libro.getAutor());
    }

    @Test
    public void testGetLibroNulo() throws DAOException {
        FactoriaDAOs factoriaDao = FactoriaDAOs.getInstance();
        ILibroDAO libroDao = factoriaDao.getLibroDAO();

        LibroEntity libro = libroDao.getLibro("1321180860");
        assertNull(libro);
    }

    @Test
    public void testGetLibros() throws DAOException {
        FactoriaDAOs factoriaDao = FactoriaDAOs.getInstance();
        ILibroDAO libroDao = factoriaDao.getLibroDAO();

        List<LibroEntity> libros = libroDao.getLibros();
        assertEquals(12, libros.size());
    }

}
