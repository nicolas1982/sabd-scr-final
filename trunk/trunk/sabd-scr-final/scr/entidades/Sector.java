package scr.entidades;

import java.sql.Time;

public class Sector {
	private Integer idsector;
	private Integer idTipoCultivo;
	private Integer idcontrato;
	private Integer idcampo;
	private String  descripcion;
	
	//ver tipos datos
	private Integer srhectareas;
//	private String fechahorainicio;
//	private String fechahorafin;
	private Time fechahorainicio;
	private Time fechahorafin;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
//	public String getFechahorafin() {
//		return fechahorafin;
//	}
//	public void setFechahorafin(String fecha) {
//		String dameputafecha = fecha.toString();
//		String dia = dameputafecha.substring(0,2);
//		String mes = dameputafecha.substring(3,5);
//		String anio = dameputafecha.substring(6);
//
//		this.fechahorafin  = anio + "-" + mes + "-" + dia;
//		//this.fechahorafin = fecha;
//	}
//	public String getFechahorainicio() {
//		return fechahorainicio;
//	}
//	public void setFechahorainicio(String fecha) {
//		String dameputafecha = fecha.toString();
//		String dia = dameputafecha.substring(0,2);
//		String mes = dameputafecha.substring(3,5);
//		String anio = dameputafecha.substring(6);
//		this.fechahorainicio  = anio + "-" + mes + "-" + dia;
//		//this.fechahorainicio = fecha;
//	}
	
	public Integer getIdcampo() {
		return idcampo;
	}
	public void setIdcampo(Integer idcampo) {
		this.idcampo = idcampo;
	}
	public Integer getIdcontrato() {
		return idcontrato;
	}
	public void setIdcontrato(Integer idcontrato) {
		this.idcontrato = idcontrato;
	}
	public Integer getIdsector() {
		return idsector;
	}
	public void setIdsector(Integer idsector) {
		this.idsector = idsector;
	}
	public Integer getIdTipoCultivo() {
		return idTipoCultivo;
	}
	public void setIdTipoCultivo(Integer idTipoCultivo) {
		this.idTipoCultivo = idTipoCultivo;
	}
	public Integer getSrhectareas() {
		if (this.srhectareas == null)return new Integer(0);
		return srhectareas;
	}
	public void setSrhectareas(Integer srhectareas) {
		this.srhectareas = srhectareas;
	}
	public String toString(){
		return this.descripcion;
	}
	/**
	 * @return the fechahorafin
	 */
	public Time getFechahorafin() {
		return fechahorafin;
	}
	/**
	 * @param fechahorafin the fechahorafin to set
	 */
	public void setFechahorafin(Time fechahorafin) {
		this.fechahorafin = fechahorafin;
	}
	/**
	 * @return the fechahorainicio
	 */
	public Time getFechahorainicio() {
		return fechahorainicio;
	}
	/**
	 * @param fechahorainicio the fechahorainicio to set
	 */
	public void setFechahorainicio(Time fechahorainicio) {
		this.fechahorainicio = fechahorainicio;
	}
	
}
