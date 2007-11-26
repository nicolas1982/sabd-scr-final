/*
 * PruebaConexion.java
 *
 * Created on 19 de noviembre de 2007, 23:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package scr.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class PruebaConexion {
    
    /** Creates a new instance of PruebaConexion */
    public PruebaConexion() {
    }
    
    
    public static void main(String args[]) {
        LoginDao dao = new LoginDao();
        try {
            Connection connection = dao.getIDSConnectionFromProperties();
            DatabaseMetaData dbMetaData = connection.getMetaData();
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
