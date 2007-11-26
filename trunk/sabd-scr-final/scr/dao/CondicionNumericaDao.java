package scr.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import scr.entidades.CondicionNumerica;

public class CondicionNumericaDao extends JdbcManager {

	/**
	 * TODO ver si hace falta retornar el id de la condicion numerica
	 * @param condicionNumerica
	 */
	public void insertCondicionNumerica(CondicionNumerica condicionNumerica) {
		Connection conn;
		try {
			conn = this.getIDSConnectionFromProperties();
			String query = "{ ? = call fun_ins_condNumerica(?,?,?,?,?,?,?)}";
			
			CallableStatement cs = conn.prepareCall(query);
			cs.setInt(1, condicionNumerica.getIdSector());
			cs.setString(2, condicionNumerica.getDescripcion());
			cs.setInt(3, condicionNumerica.getComparador());
			cs.setInt(4, condicionNumerica.getInicio());
			cs.setInt(5, condicionNumerica.getTipoCondicionNum());//no se usa
			cs.setBigDecimal(6, condicionNumerica.getValorCondicion());
			cs.setInt(7, new Integer(1));//1
		
			ResultSet rs = cs.executeQuery();
			Integer idCondicionNumerica;
			if(rs.next()) {
				idCondicionNumerica = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
