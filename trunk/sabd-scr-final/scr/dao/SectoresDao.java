package scr.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import scr.entidades.Sector;

public class SectoresDao extends JdbcManager {
	
	public Vector<Sector> getSectores(){
		Connection conn = null;
		ResultSet rs = null;
		Vector<Sector> vec = null; 
		try {
		conn = this.getIDSConnectionFromProperties();
		
		String query = "SELECT sridsector, sridtipocultivo, sridcontrato, sridcampo, srdescripcion, srfechahorainicio, srfechahorafin, srhectareas FROM sector";
        
		Statement statement = conn.createStatement();
		rs = statement.executeQuery(query);		
		
		vec = this.buildSectoresFromResultSet(rs);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
		return vec;
	}
	
	public Vector<Sector> getSectoresByProductor(Integer idProductor){
		Connection conn = null;
		ResultSet rs = null;
		Vector<Sector> vec = null; 
		try {
		conn = this.getIDSConnectionFromProperties();
		
		String query = "SELECT sridsector, sridtipocultivo, sridcontrato, sridcampo, srdescripcion, srfechahorainicio, srfechahorafin, srhectareas FROM sector, campo where sridcampo = coidcampo and coidproductor = "+idProductor;
        
		Statement statement = conn.createStatement();
		rs = statement.executeQuery(query);		
		
		vec = this.buildSectoresFromResultSet(rs);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
		return vec;
	}
	
	private Vector<Sector> buildSectoresFromResultSet(ResultSet rs) throws SQLException{
		Vector<Sector> vec =  new Vector<Sector>();
		Sector sector;
		
		while(rs.next()) {
			sector = new Sector();
			sector.setIdsector(rs.getInt(1));
			sector.setIdTipoCultivo(rs.getInt(2));
			sector.setIdcontrato(rs.getInt(3));
			sector.setIdcampo(rs.getInt(4));
			sector.setDescripcion(rs.getString(5));
			
			Date fechaHoraInicio = rs.getDate(6);
			if(fechaHoraInicio != null) {
				sector.setFechahorainicio(new Time(fechaHoraInicio.getTime()));
			}
			
			Date fechaHoraFin = rs.getDate(7);
			if(fechaHoraFin != null) {
				sector.setFechahorafin(new Time(fechaHoraFin.getTime()));
			}
			
			sector.setSrhectareas(rs.getInt(8));
			vec.add(sector);
		}
		return vec;
	}
	
//	create function fun_get_estado_riego(idSector integer)
//	returning smallint;
//		define p_ret smallint;
//		call sp_get_estado_riego(idSector) returning p_ret;
//		return p_ret;
//	end function;
	public Short getEstadoRiego(Integer idSector) {
		Connection conn = null;
		Short retValue;
		ResultSet rs = null;
		try {
		conn = this.getIDSConnectionFromProperties();
		
		CallableStatement callableStatement = conn.prepareCall("{call fun_get_estado_riego(?)}");
		
	    // Set the value for the IN parameter
		callableStatement.setInt(1, idSector);
        
		//Execute and retrieve the returned value
		rs = callableStatement.executeQuery();
		if(rs.next()) rs.getShort(1);
			retValue = rs.getShort(1);
		
		//retValue = callableStatement.getShort(1);
		
		return retValue;
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.cerrarConexion(conn,rs);
		}
		return null;
	}

	public void insertSector(Sector sector) {
		Connection conn = null;
		ResultSet rs = null;
		try {
		conn = this.getIDSConnectionFromProperties();
		
		//String query = "INS INTO Sector (srIdTipoCultivo, srIdContrato, srIdCampo, " +
		//		"srDescripcion, srFechaHoraInicio, srFechaHoraFin, srHectareas) " + 
		//				"VALUES (?, ?, ?, ?, ?, ?,?)";
		String query = "{? = call fun_alta_sector(?,?,?,?,?,?,?)}";
		
		
		
		CallableStatement cStatement = conn.prepareCall(query);
		cStatement.setInt(1, sector.getIdTipoCultivo());
		cStatement.setInt(2, sector.getIdcontrato());
		cStatement.setInt(3, sector.getIdcampo());
		cStatement.setString(4, sector.getDescripcion());
		cStatement.setTime(5, sector.getFechahorainicio());
		//cStatement.setString(5, "2001-01-01");
		cStatement.setTime(6, sector.getFechahorafin());
		//cStatement.setString(6, "2010-01-01");
		cStatement.setInt(7, sector.getSrhectareas());
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


