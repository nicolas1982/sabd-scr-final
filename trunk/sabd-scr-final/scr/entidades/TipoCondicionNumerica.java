package scr.entidades;

public class TipoCondicionNumerica {
	private Integer idTipoCondicionNumerica;
	private String descripcion;
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the idTipoCondicionNumerica
	 */
	public Integer getIdTipoCondicionNumerica() {
		return idTipoCondicionNumerica;
	}
	/**
	 * @param idTipoCondicionNumerica the idTipoCondicionNumerica to set
	 */
	public void setIdTipoCondicionNumerica(Integer idTipoCondicionNumerica) {
		this.idTipoCondicionNumerica = idTipoCondicionNumerica;
	}
	
	
	public String toString() {
		return this.descripcion;
	}
}
