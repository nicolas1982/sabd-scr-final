package scr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import scr.entidades.TipoCondicionNumerica;

public class TipoCondicionNumericaDao extends JdbcManager {
	public Vector<TipoCondicionNumerica> getTiposCondicionNumerica(){
		Connection conn = null;
		ResultSet rs = null;
		Vector<TipoCondicionNumerica> vec = null; 
		try {
		conn = this.getIDSConnectionFromProperties();
		
		String query = "SELECT * from tipoCondicionnumer";//TODO ver!
        
		Statement statement = conn.createStatement();
		rs = statement.executeQuery(query);		
		
		vec = this.buildTipoCondNumericaFromResultSet(rs);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
		return vec;
	}

	private Vector<TipoCondicionNumerica> buildTipoCondNumericaFromResultSet(ResultSet rs) {
		Vector<TipoCondicionNumerica> vec =  new Vector<TipoCondicionNumerica>();
		TipoCondicionNumerica tipoCondicionNumerica;
		
		try {
			while(rs.next()) {
				tipoCondicionNumerica = new TipoCondicionNumerica();
				tipoCondicionNumerica.setIdTipoCondicionNumerica(rs.getInt(1));
				tipoCondicionNumerica.setDescripcion(rs.getString(2));
				
				vec.add(tipoCondicionNumerica);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vec;
	}

}
