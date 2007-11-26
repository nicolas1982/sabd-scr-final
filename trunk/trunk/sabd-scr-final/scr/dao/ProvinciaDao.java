package scr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import scr.entidades.Provincia;

public class ProvinciaDao extends JdbcManager {
	
	public Vector<Provincia> buscarTodos(){
		Connection conn = null;
		ResultSet rs = null;
		Vector<Provincia>vec = new Vector<Provincia>();
		try {
		conn = this.getIDSConnectionFromProperties();
		
		String query = "SELECT * FROM Provincia ";
		
		Statement statement = conn.createStatement();
		rs = statement.executeQuery(query);		
		
		if(rs.next()){
			vec.add(this.rellenarProvincia(rs));	
		}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
		return vec;
	}
	
	private Provincia rellenarProvincia(ResultSet rs) throws SQLException{
		Provincia provincia = new Provincia();
		provincia.setId(rs.getInt(1));
		provincia.setIdPais(rs.getInt(2));
		provincia.setNombre(rs.getString(3));
		return provincia;
	}
}
