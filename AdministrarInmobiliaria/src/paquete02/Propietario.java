/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;

/**
 *
 * @author daniel-alejandro-t
 */
public class Propietario {
    String nombres, apellidos, identificacion;

    public Propietario(String nombres, String apellidos, String identificacion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }

    public void setNombres(String n) {
        nombres = n;
    }

    public void setApellidos(String n) {
        apellidos = n;
    }

    public void setIdentificacion(String n) {
        identificacion = n;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    @Override
    public String toString() {
        return "Propietario: " + getNombres() + " " + getApellidos() + " Cédula: " + getIdentificacion();
    }
}
