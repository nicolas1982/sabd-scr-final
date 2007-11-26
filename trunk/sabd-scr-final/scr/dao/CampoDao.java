package scr.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;

import scr.entidades.Campo;

public class CampoDao extends JdbcManager {
	
	public void insertCampo(Campo campo) {
		Connection conn = null;
		ResultSet rs = null;
		try {
		conn = this.getIDSConnectionFromProperties();
		
		String query = "{ ? = call fun_insert_campo(?,?,?)}";
		//fun_ins_campo(idProductor integer, idDomicilio integer, nombre varchar(30))
		CallableStatement cStatement = conn.prepareCall(query);
		
		cStatement.setInt(1, campo.getIdProductor());
		cStatement.setInt(2, campo.getIdDomicilio());
		cStatement.setString(3, campo.getNombre());
		
		rs = cStatement.executeQuery();		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
	}

	public Vector<Campo> getCampos() {
		Connection conn = null;
		ResultSet rs = null;
		Vector<Campo> vec = null;
		try {
			conn = this.getIDSConnectionFromProperties();
			
			String query = "SELECT * FROM Campo";
	        
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);		
			
			vec = this.buildCamposFromResultSet(rs);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
		return vec;
	}

	private Vector<Campo> buildCamposFromResultSet(ResultSet rs) throws SQLException {
		Vector<Campo> vec = new Vector<Campo>();
		Campo campo = null;
		while(rs.next()){
			campo = new Campo();
			campo.setId(rs.getInt(1));
			campo.setIdProductor(rs.getInt(2));
			campo.setIdDomicilio(rs.getInt(3));
			campo.setNombre(rs.getString(4));
			vec.add(campo);
		}
		return vec;
	}
}