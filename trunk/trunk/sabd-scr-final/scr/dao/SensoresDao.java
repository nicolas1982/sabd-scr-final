package scr.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import scr.entidades.Sensor;

public class SensoresDao extends JdbcManager{

	public Vector<Sensor> getSensores(Integer idSector){
		Connection conn = null;
		ResultSet rs = null;
		try {
		conn = this.getIDSConnectionFromProperties();
		
		String query = "SELECT seridsensor, seridsector, sertiposensor FROM sensor WHERE seridsector = "+  idSector;
        
		Statement statement = conn.createStatement();
		rs = statement.executeQuery(query);		
		
		return this.buildSensoresFromResultSet(rs);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
		return null;
	}
	
	private Vector<Sensor> buildSensoresFromResultSet(ResultSet rs) throws SQLException{
		Vector<Sensor> vec =  new Vector<Sensor>();
		Sensor sensor;
		
		while(rs.next()) {
			sensor = new Sensor();
			sensor.setIdSensor(rs.getInt(1));
			sensor.setIdSector(rs.getInt(2));
			sensor.setTiposensor(rs.getShort(3));
			vec.add(sensor);
		}
		return vec;
	}

	public void insertSensor(int tipoSensor, int idSector) {
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = this.getDB2ConnectionFromProperties();
			
			String query = "{? = call fun_insert_sensor(?,?)}";
			
			CallableStatement cStatement = conn.prepareCall(query);
			cStatement.setInt(1, idSector);
			cStatement.setInt(2, tipoSensor);
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
