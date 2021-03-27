/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ua.jtech.proyint.dao.libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.ua.jtech.proyint.dao.DAOException;
import es.ua.jtech.proyint.dao.FuenteDatosJDBC;
import es.ua.jtech.proyint.entity.LibroEntity;

/**
 * Implementación JDBC del DAO Libro
 *
 * @author melvin
 */
public class LibroJDBCDAO implements ILibroDAO {

    private static Log logger = LogFactory.getLog(LibroJDBCDAO.class.getName());

    /**
     * Método para seleccionar el libro cuyo Isbn se pasa por parámetro.
     *
     * @see es.ua.jtech.proyint.dao.libro.ILibroDAO#getLibro(java.lang.String)
     */
    public LibroEntity getLibro(String isbn) throws DAOException {
        LibroEntity libro = null;

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String query = "select * from libro where isbn = ?";

            if (logger.isDebugEnabled()) {
                logger.debug(query + " [isbn=" + isbn + "]");
            }

            conn = FuenteDatosJDBC.getInstance().createConnection();
            st = conn.prepareStatement(query);
            st.setString(1, isbn);
            rs = st.executeQuery();

            if (rs.next()) {
                libro = new LibroEntity();
                libro.setIsbn(rs.getString("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setNumPaginas(rs.getInt("numPaginas"));
                libro.setFechaAlta(rs.getDate("fechaAlta"));
            }
        } catch (SQLException sqle) {
            throw new DAOException("Error en el select de un libro",
                    sqle);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (st != null) {
                    st.close();
                    st = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException sqlError) {
                throw new RuntimeException("Error cerrando las conexiones",
                        sqlError);
            }
        }

        return libro;
    }

    public void addLibro(LibroEntity libro) throws DAOException {
        Connection conn = null;
        PreparedStatement st = null;
        Date fechaAlta = null;

        try {
            String insert = "insert into libro(isbn, titulo, "
                    + "autor, numPaginas, fechaAlta) values (?, ?, ?, ?, ?)";

            conn = FuenteDatosJDBC.getInstance().createConnection();
            st = conn.prepareStatement(insert);
            st.setString(1, libro.getIsbn());
            st.setString(2, libro.getTitulo());
            st.setString(3, libro.getAutor());
            st.setInt(4, libro.getNumPaginas());
            fechaAlta = libro.getFechaAlta();
            if (fechaAlta == null) {
                st.setDate(5, null);
            } else {
                st.setDate(5, new java.sql.Date(fechaAlta.getTime()));
            }
            st.executeUpdate();
        } catch (SQLException sqle) {
            throw new DAOException("Error en el insert de libro", sqle);
        } finally {
            try {
                if (st != null) {
                    st.close();
                    st = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException sqlError) {
                throw new RuntimeException("Error cerrando las conexiones",
                        sqlError);
            }
        }
    }

    public int delLibro(String isbn) throws DAOException {
        Connection conn = null;
        PreparedStatement st = null;
        int numDel = 0;

        try {
            String delete = "delete from libro where isbn=?";

            conn = FuenteDatosJDBC.getInstance().createConnection();
            st = conn.prepareStatement(delete);
            st.setString(1, isbn);
            numDel = st.executeUpdate();
        } catch (SQLException sqle) {
            throw new DAOException("Error en el delete de libro", sqle);
        } finally {
            try {
                if (st != null) {
                    st.close();
                    st = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException sqlError) {
                throw new RuntimeException("Error cerrando las conexiones",
                        sqlError);
            }
        }
        return numDel;
    }

    public List<LibroEntity> getLibros() throws DAOException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        List<LibroEntity> al = null;

        try {
            conn = FuenteDatosJDBC.getInstance().createConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from libro");
            al = new ArrayList<LibroEntity>();
            LibroEntity libro = null;
            while (rs.next()) {
                libro = new LibroEntity();
                libro.setIsbn(rs.getString("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setNumPaginas(rs.getInt("numPaginas"));
                libro.setFechaAlta(rs.getDate("fechaAlta"));
                al.add(libro);
            }
        } catch (SQLException sqle) {
            throw new DAOException("Error en el select de libros", sqle);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (st != null) {
                    st.close();
                    st = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException sqlError) {
                throw new RuntimeException("Error cerrando las conexiones",
                        sqlError);
            }
        }
        return al;
    }

    public int updateLibro(LibroEntity libro) throws DAOException {
        Connection conn = null;
        PreparedStatement st = null;
        int numUpdate = 0;

        try {
            String update = "update libro set isbn=?, titulo=?, "
                    + "autor=?, numPaginas=?, fechaAlta=? where isbn=?";

            conn = FuenteDatosJDBC.getInstance().createConnection();
            st = conn.prepareStatement(update);
            st.setString(1, libro.getIsbn());
            st.setString(2, libro.getTitulo());
            st.setString(3, libro.getAutor());
            st.setInt(4, libro.getNumPaginas());
            st.setDate(5, new java.sql.Date(libro.getFechaAlta().getTime()));
            st.setString(6, libro.getIsbn());
            numUpdate = st.executeUpdate();
        } catch (SQLException sqle) {
            throw new DAOException("Error en el update de libro", sqle);
        } finally {
            try {
                if (st != null) {
                    st.close();
                    st = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException sqlError) {
                throw new RuntimeException("Error cerrando las conexiones",
                        sqlError);
            }
        }
        return numUpdate;
    }

}
