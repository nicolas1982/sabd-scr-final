package scr.entidades;

import java.math.BigDecimal;

public class CondicionNumerica extends Condicion {
	private BigDecimal valorCondicion;
	private int tipoCondicionNum;
	
	public int getTipoCondicionNum() {
		return tipoCondicionNum;
	}
	public void setTipoCondicionNum(int tipoCondicionNum) {
		this.tipoCondicionNum = tipoCondicionNum;
	}
	public BigDecimal getValorCondicion() {
		return valorCondicion;
	}
	public void setValorCondicion(BigDecimal valorCondicion) {
		this.valorCondicion = valorCondicion;
	}
	
}
