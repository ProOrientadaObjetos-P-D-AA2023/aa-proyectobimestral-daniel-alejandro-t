/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;

import java.io.File;
import java.util.List;

// Importamos todos los paquetes que contienen las clases
import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;
import paquete06.*;

/**
 *
 * @author daniel-alejandro-t
 */
public class Ejecutor {
    public static void main(String []args){
        // Nos aseguramos que existen los archivos
        // propietarios.dat, barrios.dat, ciudades.dat, constructoras.dat y casas.dat
        // De no existir, creamos el archivo en el directorio
        
        // Creamos una lista para todos los objetos
        // de tipo Propietario, Barrio, Ciudad, Constructora y Casa
        List<Propietario> listaPropietarios;
        List<Barrio> listaBarrios;
        List<Ciudad> listaCiudades;
        List<Constructora> listaConstructoras;
        List<Casa> listaCasas;

        // Cargamos los datos de los archivos en las listas


    }

    

    

    /*
     * Método que vuelva todos los objetos de la lista en el archivo, si estos no existen
     */
    public static void volcarDatos(String rutaArchivo, List lista){
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            try {
                // Creamos un objeto de tipo ArchivoEscritura
                ArchivoEscritura archivoEscritura = new ArchivoEscritura(rutaArchivo);
                // Volcamos los datos de la lista en el archivo
                archivoEscritura.volcarLista(lista);
                // Cerramos el archivo
                archivoEscritura.cerrarArchivo();
            } catch (Exception e) {
                System.err.println("Error al volcar los datos en el archivo.");
            }
        }
}
