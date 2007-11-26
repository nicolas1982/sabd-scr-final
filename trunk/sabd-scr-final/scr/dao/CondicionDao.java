package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import scr.entidades.Condicion;

public class CondicionDao extends JdbcManager {

	@Deprecated
	public void insertCondicion(Condicion condicion) {
		Connection conn = null;
		ResultSet rs = null;
		try {
		conn = this.getDB2ConnectionFromProperties();
		
		//int nextVal = this.nextVal(conn, "mySequence");
		
		String query = "INSERT INTO Condicion(cnIdCondicion, cnIdSector, cnDescripcion, cnComparador, " +
				" cnDiscriminador, cnInicio) VALUES (?, ?, ?, ?, ?, ?)";
				
		PreparedStatement pStatement = conn.prepareStatement(query);
		//pStatement.setInt(1, nextVal);
		pStatement.setInt(2, condicion.getIdSector());
		pStatement.setString(3, condicion.getDescripcion());
		pStatement.setInt(4, condicion.getComparador());
		pStatement.setInt(5, condicion.getDiscriminador());
		pStatement.setInt(6, condicion.getInicio());
		pStatement.executeUpdate();
		
		//String query = "{ ? = call fun_insert_condicion(?,?,?,?,?)}";
//		
//		CallableStatement cStatement = conn.prepareCall(query);
//		cStatement.setInt(1, condicion.getIdSector());
//		cStatement.setString(2, condicion.getDescripcion());
//		cStatement.setInt(3, condicion.getComparador());
//		cStatement.setInt(4, condicion.getDiscriminador());
//		cStatement.setInt(5, condicion.getInicio());
				
		//rs = cStatement.executeQuery();
		
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
	}

	public Vector<Condicion> getCondiciones(int discriminador) {
		Connection conn = null;
		ResultSet rs = null;
		Vector<Condicion> vec = new Vector<Condicion>();
		try {
			conn = this.getIDSConnectionFromProperties();
			
			String query = "SELECT * FROM Condicion c ";
			
			if(discriminador == 0){
				query += " WHERE c.cnDiscriminador = 0 ";
			} else if(discriminador == 1){
				query += " WHERE c.cnDiscriminador = 1 ";
			}
	        
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()){
				vec.add(this.rellenarCondicion(rs));
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

	private Condicion rellenarCondicion(ResultSet rs) throws SQLException {
		Condicion condicion = new Condicion();
		condicion.setId(rs.getInt(1));
		condicion.setIdSector(rs.getInt(2));
		condicion.setDescripcion(rs.getString(3));
		condicion.setComparador(rs.getInt(4));
		condicion.setDiscriminador(rs.getInt(5));
		condicion.setInicio(rs.getInt(6));
		return condicion;
	}

}
