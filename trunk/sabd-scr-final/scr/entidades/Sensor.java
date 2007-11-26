package scr.entidades;

/**
 * @author TP28637207
 *
 */
public class Sensor {
	private Integer idSensor;
	private Integer idSector;
	private Short tiposensor;
	
	public Integer getIdSector() {
		return idSector;
	}
	public void setIdSector(Integer idSector) {
		this.idSector = idSector;
	}
	public Integer getIdSensor() {
		return idSensor;
	}
	public void setIdSensor(Integer idSensor) {
		this.idSensor = idSensor;
	}
	public Short getTiposensor() {
		return tiposensor;
	}
	public void setTiposensor(Short tiposensor) {
		this.tiposensor = tiposensor;
	}
	public String toString(){
		return ""+this.tiposensor;
	}
	
	
}

