/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete04;

/**
 *
 * @author daniel-alejandro-t
 */
public class Ciudad {
    String nombreCiudad, nombreProvincia;

    public Ciudad(String nombreCiudad, String nombreProvincia) {
        this.nombreCiudad = nombreCiudad;
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    
    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreCiudad = nombreProvincia;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", getNombreCiudad(), getNombreProvincia());
    }
}
