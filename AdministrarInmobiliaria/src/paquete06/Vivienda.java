package paquete06;

import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;

public abstract class Vivienda {
    // Atributos comunes a todas las viviendas
    double precioMetroCuadrado;
    double numMetrosCuadrados;
    double costoFinal;

    int numCuartos;

    // Instancias colunes entre Casa y Departamento
    String identificadorPropietario;
    String nombreBarrio;
    String nombreCiudad;
    String idConstructora;


    // Constructor
    protected Vivienda(double precioMetroCuadrado, double numMetrosCuadrados, int numCuartos,
                        String identificadorPropietario, String nombreBarrio, String nombreCiudad,
                        String idConstructora) {

        this.numCuartos = numCuartos;

        this.identificadorPropietario = identificadorPropietario;
        this.nombreBarrio = nombreBarrio;
        this.nombreCiudad = nombreCiudad;
        this.idConstructora = idConstructora;

        setCalculaCostoFinal(precioMetroCuadrado, numMetrosCuadrados);  // El método ya guarda los valores
    }

    // Getters y Setters
    public double getPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public void setPrecioMetroCuadrado(double precioMetroCuadrado) {
        this.precioMetroCuadrado = precioMetroCuadrado;
    }

    public double getNumMetrosCuadrados() {
        return numMetrosCuadrados;
    }

    public void setNumMetrosCuadrados(double numMetrosCuadrados) {
        this.numMetrosCuadrados = numMetrosCuadrados;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void setCalculaCostoFinal(double precioMetroCuadrado, double numMetrosCuadrados) {
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.numMetrosCuadrados = numMetrosCuadrados;

        costoFinal = numMetrosCuadrados * precioMetroCuadrado;
    }

    public int getNumCuartos() {
        return numCuartos;
    }

    public void setNumCuartos(int numCuartos) {
        this.numCuartos = numCuartos;
    }

    @Override
    public String toString() {
        return "Vivienda{" +
                "precioMetroCuadrado=" + precioMetroCuadrado +
                ", numMetrosCuadrados=" + numMetrosCuadrados +
                ", costoFinal=" + costoFinal +
                ", numCuartos=" + numCuartos +
                ", cedula del propietario=" + identificadorPropietario +
                ", barrio=" + nombreBarrio +
                ", ciudad=" + nombreCiudad +
                ", constructora=" + idConstructora;
    }
}