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


public class Casa extends Vivienda{
    Propietario propietario;
    Barrio barrio;
    Ciudad ciudad;
    Constructora constructora;

    String numCasa;

    public Casa(String numCasa, double precioMetroCuadrado, double numMetrosCuadrados, int numCuartos,
                String identificadorPropietario, String nombreBarrio, String nombreCiudad, String idConstructora) {
        super(precioMetroCuadrado, numMetrosCuadrados, numCuartos, identificadorPropietario, nombreBarrio, nombreCiudad, idConstructora);

        this.numCasa = numCasa;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "numCasa='" + numCasa + '\'' +
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
