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
    Propietario propietario;
    Barrio barrio;
    Ciudad ciudad;
    Constructora constructora;

    // Constructor
    protected Vivienda(double precioMetroCuadrado, double numMetrosCuadrados, int numCuartos,
                        Propietario propietario, Barrio barrio, Ciudad ciudad,
                        Constructora constructora) {

        this.numCuartos = numCuartos;

        this.propietario = propietario;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.constructora = constructora;

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

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {

        this.propietario = propietario;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {

        this.barrio = barrio;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {

        this.ciudad = ciudad;
    }

    public Constructora getConstructora() {
        return constructora;
    }

    public void setConstructora(Constructora constructora) {

        this.constructora = constructora;
    }

    @Override
    public String toString() {
        return "Vivienda{" +
                "precioMetroCuadrado=" + precioMetroCuadrado +
                ", numMetrosCuadrados=" + numMetrosCuadrados +
                ", costoFinal=" + costoFinal +
                ", numCuartos=" + numCuartos +
                ", propietario=" + propietario +
                ", barrio=" + barrio +
                ", ciudad=" + ciudad +
                ", constructora=" + constructora;
    }
}
