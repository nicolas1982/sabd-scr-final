package scr.entidades;

public class Condicion {
	
	private int id;
	private int idSector;
	private String descripcion;
	private int comparador;
	private int discriminador;
	private int inicio;
		
	public int getComparador() {
		return comparador;
	}
	public void setComparador(int comparador) {
		this.comparador = comparador;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDiscriminador() {
		return discriminador;
	}
	public void setDiscriminador(int discriminador) {
		this.discriminador = discriminador;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSector() {
		return idSector;
	}
	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	public String toString(){
		return this.descripcion;
	}
}
