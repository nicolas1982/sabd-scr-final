/*
 * TipoSensor.java
 *
 * Created on 18 de noviembre de 2007, 21:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package layout.enums;

/**
 *
 * @author Administrador
 * TODO quitar el seleccione de aca
 */
public enum TipoSensor {
    SELECCIONE   (-1, "Seleccione un item..."),
    
    TEMPERATURA (0, "Sensor de Temperatura"),
    HUMEDAD   (1, "Sensor de Humedad");
    
    private final int idTipoSensor;
    private final String descTipoSensor;
    
    public int getIdTipoSensor() {
        return this.idTipoSensor;
    }
    
    public String getDescTipoSensor() {
        return this.descTipoSensor;
    }
    
    TipoSensor(int idTipoSensor, String descripcionTipoSensor) {
        this.idTipoSensor = idTipoSensor;
        this.descTipoSensor = descripcionTipoSensor;
    }
}


