/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;

import java.io.File;
import java.util.List;
import java.util.Scanner;

// Importamos todos los paquetes que contienen las clases
import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;
import paquete06.*;

import archivos.*;

/**
 *
 * @author daniel-alejandro-t
 */
public class Ejecutor {
    public static void main(String []args){
        // Textos de menu de opciones
        String menuPrincipal = "Menú de opciones \n 1. CRUD Propietarios \n 2. CRUD Barrios \n 3. CRUD Ciudades \n 4. CRUD Constructoras \n 5. CRUD Casas \n 6. CRUD Departamentos \n 7. Salir";
        String menuCRUD = "Menú de opciones \n 1. Crear \n 2. Leer \n 3. Actualizar \n 4. Eliminar \n 5. Salir";

        // Creamos una lista para todos los objetos
        // de tipo Propietario, Barrio, Ciudad, Constructora y Casa
        List<Propietario> listaPropietarios;
        List<Barrio> listaBarrios;
        List<Ciudad> listaCiudades;
        List<Constructora> listaConstructoras;
        List<Casa> listaCasas;

        // Instanciamos los objetos de tipo ArchivoLectura
        FicheroPropietario lecturaPropietarios = new FicheroPropietario("AdministrarInmobiliaria/datos/propietarios.dat");

        // Usando el método getListaPropietarios() de la clase FicheroPropietario cargamos los datos
        //  del archivo al programa usando la instancia del objeto lecturaPropietarios
        listaPropietarios = lecturaPropietarios.getListaPropietarios();

        // Creamos un objeto de tipo Scanner para leer la opción ingresada por el usuario
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 7
        do {
            // Imprimimos el consola el menú de opciones
            // Que nos permite hacer un CRUD de propietarios; barrio; ciudades; constructoras; casas; departamentos
            System.out.println(menuPrincipal);

            // Leemos la opción ingresada por el usuario
            opcion = entrada.nextInt();
            
            // Creamos un switch para ejecutar el CRUD correspondiente
            switch (opcion) {
                case 1:     // Propietarios
                    // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 1

    
                    break;
                case 2:     // Barrios
                    // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 2
    
                    break;
                case 3:     // Ciudades
                    // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 3
    
                    break;
                case 4:     // Constructoras
                    // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 4
    
                    break;
                case 5:     // Casas
                    // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 5
    
                    break;
                case 6:     // Departamentos
                    // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 6
    
                    break;

                case 7:     // Salir
                    // TODO Evaluar si en este punto del programa es necesario volcar los datos en el archivo
                    // Pienso que si es necesario ya que el contenido de las listas puede haber cambiado

                    System.out.println("Gracias por usar el programa.");
    
                    break;

                default:
                    break;
            }


        } while (opcion != 7);


    }
    // Métodos CRUD
    // No se crea el método Create ya que sería redundante

    // Read
    public void setLeerLista(List listaObjetos){
        for (Object object : listaObjetos) {
            System.out.println(object.toString());
        }
    }

    // Update
    public void setActualizarObjeto(Object objeto, String identificador, List listaObjetos){
        // El identificador es en propietario:identificación, barrio:nombre, ciudad:nombre, constructora:id

        // Si el objeto es de tipo Propietario
        if (objeto instanceof Propietario) {
            // Remplazamos de la lista de propietarios el objeto que tenga la misma identificación
            // que el identificador ingresado por el usuario
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (((Propietario) listaObjetos.get(i)).getIdentificacion().equalsIgnoreCase(identificador) ) {
                    listaObjetos.set(i, objeto);
                }
            }
        }else if (objeto instanceof Barrio) {
            // Remplazamos de la lista de barrios el objeto que tenga el mismo nombre
            // que el identificador ingresado por el usuario
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (((Barrio) listaObjetos.get(i)).getNombre().equalsIgnoreCase(identificador) ) {
                    listaObjetos.set(i, objeto);
                }
            }
        }else if (objeto instanceof Ciudad) {
            // Remplazamos de la lista de ciudades el objeto que tenga el mismo nombre
            // que el identificador ingresado por el usuario
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (((Ciudad) listaObjetos.get(i)).getNombre().equalsIgnoreCase(identificador) ) {
                    listaObjetos.set(i, objeto);
                }
            }
        }else if (objeto instanceof Constructora) {
            // Remplazamos de la lista de constructoras el objeto que tenga el mismo id
            // que el identificador ingresado por el usuario
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (((Constructora) listaObjetos.get(i)).getId().equalsIgnoreCase(identificador) ) {
                    listaObjetos.set(i, objeto);
                }
            }
        }else if (objeto instanceof Casa) {
            // Remplazamos de la lista de casas el objeto que tenga el mismo id
            // que el identificador ingresado por el usuario
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (((Casa) listaObjetos.get(i)).getId().equalsIgnoreCase(identificador) ) {
                    listaObjetos.set(i, objeto);
                }
            }
        }else{
            System.out.println("El objeto no es de tipo Propietario, Barrio, Ciudad, Constructora o Casa");
        }

    }

    // Delete




}
