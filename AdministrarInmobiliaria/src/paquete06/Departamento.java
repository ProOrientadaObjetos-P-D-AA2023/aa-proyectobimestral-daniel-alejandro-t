/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete06;

import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;

public class Departamento extends Vivienda{
    double valorAlicuotaMensual;

    String nombreEdificio;
    String ubicacionInterna;    // Ubicación dentro del edificio

    public Departamento( double valorAlicuotaMensual, String nombreEdificio, String ubicacionInterna,
                         double precioMetroCuadrado, double numMetrosCuadrados, int numCuartos,
                         Propietario propietario, Barrio barrio, Ciudad ciudad, Constructora constructora) {

        super(precioMetroCuadrado, numMetrosCuadrados, numCuartos, propietario, barrio, ciudad, constructora);

        this.valorAlicuotaMensual = valorAlicuotaMensual;
        this.nombreEdificio = nombreEdificio;
        this.ubicacionInterna = ubicacionInterna;
    }

    public double getValorAlicuotaMensual() {
        return valorAlicuotaMensual;
    }

    public void setValorAlicuotaMensual(double valorAlicuotaMensual) {
        this.valorAlicuotaMensual = valorAlicuotaMensual;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public String getUbicacionInterna() {
        return ubicacionInterna;
    }

    public void setUbicacionInterna(String ubicacionInterna) {
        this.ubicacionInterna = ubicacionInterna;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "valorAlicuotaMensual=" + valorAlicuotaMensual +
                ", nombreEdificio='" + nombreEdificio + '\'' +
                ", ubicacionInterna='" + ubicacionInterna + '\'' +
                ", precioMetroCuadrado=" + precioMetroCuadrado +
                ", numMetrosCuadrados=" + numMetrosCuadrados +
                ", costoFinal=" + costoFinal +
                ", numCuartos=" + numCuartos +
                ", propietario=" + propietario +
                ", barrio=" + barrio +
                ", ciudad=" + ciudad +
                ", constructora=" + constructora +
                '}';
    }
    
}
