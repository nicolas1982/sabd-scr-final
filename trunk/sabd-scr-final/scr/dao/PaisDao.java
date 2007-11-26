package scr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import scr.entidades.Pais;

public class PaisDao extends JdbcManager {

	public Vector<Pais> buscarTodos(){
		Connection conn = null;
		ResultSet rs = null;
		Vector<Pais> vec = null; 
		try {
			conn = this.getIDSConnectionFromProperties();
			
			String query = "SELECT * FROM Pais ";
	        
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);		
			
			vec = this.buildPaisesFromResultSet(rs);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
		return vec;
	}
	
	private Vector<Pais> buildPaisesFromResultSet(ResultSet rs) throws SQLException{
		Vector<Pais>vec = new Vector<Pais>();
		Pais pais = new Pais();
		while(rs.next()){
			pais = new Pais();
			pais.setId(rs.getInt(1));
			pais.setNombre(rs.getString(2));
			vec.add(pais);
		}
		return vec;
	}
	
}
