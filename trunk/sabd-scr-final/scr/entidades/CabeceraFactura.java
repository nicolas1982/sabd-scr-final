package scr.entidades;

import java.sql.Date;

public class CabeceraFactura {
	private int idCabecera;
	private double montototal;
	private String fecha;
	private int idProductor;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		String dameputafecha = fecha.toString();
		String anio = dameputafecha.substring(0,4);
		String dia = dameputafecha.substring(5,7);
		String mes = dameputafecha.substring(8,10);
		this.fecha = dia + "/" + mes + "/" + anio;
	}
	public int getIdCabecera() {
		return idCabecera;
	}
	public void setIdCabecera(int idCabecera) {
		this.idCabecera = idCabecera;
	}
	public int getIdProductor() {
		return idProductor;
	}
	public void setIdProductor(int idProductor) {
		this.idProductor = idProductor;
	}
	public double getMontototal() {
		return montototal;
	}
	public void setMontototal(double montototal) {
		this.montototal = montototal;
	}
	
}
