package scr.entidades;

public class Usuario {
	private int id;
	private int idProductor;
	private String nombre;
	private int idRol;
	
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public String toString(){
		return this.nombre;
	}
	public int getIdProductor() {
		return idProductor;
	}
	public void setIdProductor(int idProductor) {
		this.idProductor = idProductor;
	}
}
