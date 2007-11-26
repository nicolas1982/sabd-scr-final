package scr.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import scr.entidades.CondicionHoraria;

public class CondicionHorariaDao extends JdbcManager {

	/**
	 * TODO Ver si debe devolver el id de condicion horaria
	 * @param condicionHoraria
	 */
	public void insertCondicionHoraria(CondicionHoraria condicionHoraria) {
		Connection conn = null;
		ResultSet rs = null;
		try {
		conn = this.getIDSConnectionFromProperties();

		String query = "{ ? = call fun_ins_condHoraria(?,?,?,?,?,?,?)}";
		
		CallableStatement cs = conn.prepareCall(query);
		cs.setInt(1, condicionHoraria.getIdSector());
		cs.setString(2, condicionHoraria.getDescripcion());
		cs.setInt(3, condicionHoraria.getComparador());
		cs.setInt(4, condicionHoraria.getInicio());
		cs.setInt(5, new Integer(1));//no se usa
		cs.setTime(6, condicionHoraria.getValorCondicion());
		cs.setInt(7, new Integer(0));//0
	
		rs = cs.executeQuery();
		Integer idCondicionHoraria;
		if(rs.next()) {
			idCondicionHoraria = rs.getInt(1);
		}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
	}
	
}
