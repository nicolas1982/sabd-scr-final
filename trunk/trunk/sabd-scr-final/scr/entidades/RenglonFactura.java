package scr.entidades;


public class RenglonFactura {
	private int idRenglonFactura;
	private int idCabeceraFactura;
	private int idContrato;
	private String descripcion;
	private double monto; 
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}
	public int getIdRenglonFactura() {
		return idRenglonFactura;
	}
	public void setIdRenglonFactura(int idRenglonFactura) {
		this.idRenglonFactura = idRenglonFactura;
	}
	public int getIdCabeceraFactura() {
		return idCabeceraFactura;
	}
	public void setIdCabeceraFactura(int idCabeceraFactura) {
		this.idCabeceraFactura = idCabeceraFactura;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}

	
}
