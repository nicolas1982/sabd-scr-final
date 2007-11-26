package scr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import scr.entidades.Contrato;

public class ContratoDao extends JdbcManager {
	
	public Vector<Contrato> getContratos(){
		Connection conn = null;
		ResultSet rs = null;
		Vector<Contrato> vec = null; 
		try {
		conn = this.getIDSConnectionFromProperties();
                
		
		String query = "SELECT * FROM Contrato ";
        
		Statement statement = conn.createStatement();
		rs = statement.executeQuery(query);		
		
		vec = this.buildContratosFromResultSet(rs);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
		return vec;
	}

	private Vector<Contrato> buildContratosFromResultSet(ResultSet rs) throws SQLException {
		Vector<Contrato> vec = new Vector<Contrato>();
		Contrato contrato = null;
		while(rs.next()){
			contrato = new Contrato();
			contrato.setId(rs.getInt(1));
			contrato.setNombre(rs.getString(2));
			contrato.setIdTarifa(rs.getInt(3));
			vec.add(contrato);
		}
		return vec;
	}
	
	

}
