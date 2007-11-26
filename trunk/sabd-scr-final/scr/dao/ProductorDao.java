package scr.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;

import scr.entidades.Productor;

public class ProductorDao extends JdbcManager {
	public Vector<Productor> getProductores(){
		Connection conn = null;
		ResultSet rs = null;
		try {
		conn = this.getIDSConnectionFromProperties();
		
		String query = "SELECT pridproductor, priddomicilio, prnombre FROM productor";
        
		Statement statement = conn.createStatement();
		rs = statement.executeQuery(query);		
		
		return this.buildProductoresFromResultSet(rs);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
		return null;
	}
	private Vector<Productor> buildProductoresFromResultSet(ResultSet rs) throws SQLException{
		Vector<Productor> vec = new Vector<Productor>();
		while(rs.next()) {
			vec.add(this.buildProductorFromResultSet(rs));
		}
		return vec;
	}
	private Productor buildProductorFromResultSet(ResultSet rs) throws SQLException {
		Productor productor = new Productor();
		productor.setIdProductor(rs.getInt(1));
		productor.setIdDomicilio(rs.getInt(2));
		productor.setNombre(rs.getString(3));
		return productor;
	}
	
	public Productor getProductorDeUnUsuario(int id) {
		Connection conn = null;
		ResultSet rs = null;
		try {
		conn = this.getDB2ConnectionFromProperties();
		
		String query = "SELECT p.pridproductor, p.priddomicilio, p.prnombre " +
				"FROM productor as p, usuarios as u " +
				"WHERE u.uoidusuario = " + id + " and " +
				" p.pridProductor = p.uoidProductor";
		
		Statement statement = conn.createStatement();
		rs = statement.executeQuery(query);		
		
		return this.buildProductorFromResultSet(rs);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
		return null;
	}
	
	public void altaProductor(Productor productor) {
		Connection conn = null;
		ResultSet rs = null;
		try {
		conn = this.getIDSConnectionFromProperties();
		
		//String query = "INS INTO Productor (prIdDomicilio, prNombre) " + 
		//				"VALUES (?, ?)";	
		// la funcion es al reves nombreproductor y despues id dom
		String query = "{? = call fun_insertar_productor(?,?)}";
		
		CallableStatement cStatement = conn.prepareCall(query);
		cStatement.setString(1, productor.getNombre());
		cStatement.setInt(2, productor.getIdDomicilio());

		rs = cStatement.executeQuery();		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
	}
	
}