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
                         String identificadorPropietario, String nombreBarrio, String nombreCiudad, String idConstructora) {

        super(precioMetroCuadrado, numMetrosCuadrados, numCuartos, identificadorPropietario, nombreBarrio, nombreCiudad, idConstructora);

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

    public String getIdentificadorPropietario() {
        return identificadorPropietario;
    }

    public void setIdentificadorPropietario(String identificadorPropietario) {
        this.identificadorPropietario = identificadorPropietario;
    }

    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getIdConstructora() {
        return idConstructora;
    }

    public void setIdConstructora(String idConstructora) {
        this.idConstructora = idConstructora;
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
                ", propietario=" + identificadorPropietario +
                ", barrio=" + nombreBarrio +
                ", ciudad=" + nombreCiudad +
                ", constructora=" + idConstructora +
                '}';
    }
}
