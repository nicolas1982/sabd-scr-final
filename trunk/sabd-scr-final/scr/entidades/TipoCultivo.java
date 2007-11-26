package scr.entidades;

public class TipoCultivo {

	private int id;
	private float factorAjuste;
	private String descripcion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getFactorAjuste() {
		return factorAjuste;
	}
	public void setFactorAjuste(float factorAjuste) {
		this.factorAjuste = factorAjuste;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return this.descripcion;
	}
	
	
	
	
}
