package scr.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import layout.utils.DateUtil;
import scr.entidades.CabeceraFactura;
import scr.entidades.Productor;
import scr.entidades.RenglonFactura;

public class FacturacionDao extends JdbcManager {
	public boolean generarFactura(String fecha, Productor productor) {
		Connection conn = null;
		try {
			java.util.Date d2 = DateUtil.formatDate.parse(fecha);
			conn = this.getIDSConnectionFromProperties();
			String query = "{? = call fun_fac_prod(?,?)}";
			CallableStatement cs = conn.prepareCall(query);
			
			//cs.setString(1, fecha);
			//cs.setString(1, "01-01-2001");
			Date fechaDate = DateUtil.formatDate.parse(fecha);
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(fechaDate);
			String myFecha = gc.get(GregorianCalendar.MONTH)+ 1 + "-" + gc.get(GregorianCalendar.DATE) + "-" + gc.get(GregorianCalendar.YEAR);  
				
			cs.setString(1, myFecha);//TODO ojo si la fecha viene nula
			cs.setInt(2,productor.getIdProductor());
			boolean resultado = cs.execute();
			this.cerrarConexion(conn);
			return resultado;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}finally {
				this.cerrarConexion(conn);
			}
			return false;
	}

	public CabeceraFactura getCabeceraFactura(String fecha, int idProductor) {
		Connection conn = null;
		try {
        	//Select * from CabeceraFactura where cfaFecha = fecha and cfaIdProductor = idProductor;
            //Select * from RenglonFactura where rfaidcabecerafact = idFactura;
			
			conn = this.getIDSConnectionFromProperties();
			String query = "SELECT cfaidcabecerafact, cfamontototal, cfafecha,   cfaidproductor FROM CabeceraFactura";
			
			Statement cs = conn.createStatement();
			ResultSet rs = cs.executeQuery(query);
			CabeceraFactura cabecera = this.buildCabeceraFactura(rs,fecha,idProductor);
			this.cerrarConexion(conn);
			return cabecera;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				this.cerrarConexion(conn);
			}
			return null;
	}

	private CabeceraFactura buildCabeceraFactura(ResultSet rs, String fecha, int idProductor) throws SQLException {
		CabeceraFactura cabecera;
		while( rs.next() ){
			cabecera = new CabeceraFactura();
			cabecera.setIdCabecera(rs.getInt(1));
			cabecera.setMontototal(rs.getDouble(2));
			cabecera.setFecha(rs.getDate(3));
			cabecera.setIdProductor(rs.getInt(4));
			if (cabecera.getFecha().equals(fecha) && cabecera.getIdProductor() == idProductor)
				return cabecera;
		}
		return null;
	}

	public Vector getRenglonesFactura(int idFactura) {
		Connection conn = null;
		try {
            //Select * from RenglonFactura where rfaidcabecerafact = idFactura;
			conn = this.getIDSConnectionFromProperties();
			
			String query = "Select rfaidrenglonfact,rfaidcabecerafact, rfaidcontrato, rfadescripcion, rfamonto "+
			" from RenglonFactura where rfaidcabecerafact = "+idFactura;
			Statement cs = conn.createStatement();
			ResultSet rs = cs.executeQuery(query);
			Vector vec = this.buildRenglonesFactura(rs);
			this.cerrarConexion(conn);
			return vec;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				this.cerrarConexion(conn);
			}
			return null;
	}
	
	public Vector buildRenglonesFactura(ResultSet rs) throws SQLException{
		Vector vec = new Vector();
		while(rs.next()) {
			vec.add(this.buildRenglonFactura(rs));
		}
		return vec;
	}
	
	public RenglonFactura buildRenglonFactura(ResultSet rs) throws SQLException{
		RenglonFactura renglon = new RenglonFactura();
			renglon.setIdRenglonFactura(rs.getInt(1));
			renglon.setIdCabeceraFactura(rs.getInt(2));
			renglon.setIdContrato(rs.getInt(3));
			renglon.setDescripcion(rs.getString(4));
			renglon.setMonto(rs.getDouble(5));
		return renglon;
	}
}
