package scr.entidades;

public class Contrato {
	
	private int id;
	private String nombre;
	private int idTarifa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdTarifa() {
		return idTarifa;
	}
	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}
	@Override
	public String toString() {
		return this.nombre;
	}
	
	

}
