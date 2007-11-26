package scr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import scr.entidades.TipoCultivo;

public class TipoCultivoDao extends JdbcManager {

	public Vector<TipoCultivo> getTiposCultivo() {
		Connection conn = null;
		ResultSet rs = null;
		Vector<TipoCultivo> vec = null;
		try {
			conn = this.getIDSConnectionFromProperties();
			
			String query = "SELECT * FROM TipoDeCultivo";
	        
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);		
			
			vec = this.buildTiposCultivoFromResultSet(rs);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
		return vec;
	}

	private Vector<TipoCultivo> buildTiposCultivoFromResultSet(ResultSet rs) throws SQLException {
		Vector<TipoCultivo>vec = new Vector<TipoCultivo>();
		TipoCultivo tipoCultivo = null;
		while(rs.next()){
			tipoCultivo = new TipoCultivo();
			tipoCultivo.setId(rs.getInt(1));
			tipoCultivo.setDescripcion(rs.getString(2));
			tipoCultivo.setFactorAjuste(rs.getFloat(3));
			vec.add(tipoCultivo);
		}
		return vec;
	}


}
