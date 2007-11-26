package scr.entidades;

import java.sql.Date;

public class RegistroMedicion {
//	insert into RegistroMedicion values (ret, idSensor, valor, CURRENT);
	private Integer idRegistroMedicion;
	private Integer idSensor;
	
	//Ver tipos de datos
	private Float valorMedicion;
	private Date fechaRegistracion;
	
	public Date getFechaRegistracion() {
		return fechaRegistracion;
	}
	public void setFechaRegistracion(Date fechaRegistracion) {
		this.fechaRegistracion = fechaRegistracion;
	}
	public Integer getIdRegistroMedicion() {
		return idRegistroMedicion;
	}
	public void setIdRegistroMedicion(Integer idRegistroMedicion) {
		this.idRegistroMedicion = idRegistroMedicion;
	}
	public Integer getIdSensor() {
		return idSensor;
	}
	public void setIdSensor(Integer idSensor) {
		this.idSensor = idSensor;
	}
	public Float getValorMedicion() {
		return valorMedicion;
	}
	public void setValorMedicion(Float valorMedicion) {
		this.valorMedicion = valorMedicion;
	}
	
	
}
