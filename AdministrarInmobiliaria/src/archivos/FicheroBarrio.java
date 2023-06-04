/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import paquete03.Barrio;



/**
 *
 * @author aysanchez6
 */
public class FicheroBarrio extends Fichero{
    // Creamos una lista internar de objetos de tipo Barrio
    List<Barrio> listaBarrios;
    BufferedReader br;

    // Archivo file que contiene los datos de los Barrio
    File archivoBarrios;

    // Constructor de la clase
    public FicheroBarrio(String a) {
        super(a);

        // Inicializamos ListaBarrio para evitar NullPointerException
        // listaPropietarios = new ArrayList<>();
        archivoBarrios = new File(a);
    }

    public String getRutaArchivo() {
        return super.rutaArchivo;
    }


    @Override
    public void getCargarDatosAlPrograma() {
        
        try {
            br = new BufferedReader(new FileReader(getRutaArchivo()));
            listaBarrios = new ArrayList<>();

            String linea;

            while ((linea = br.readLine()) != null) {
                // Aquí dividimos la línea en campos separados por comas
                String[] campos = linea.split(","); // campos[0] = "daniel Alvarez",  campos[1] = "..."

                // Obtenemos los datos de cada campo
                String nombre = campos[0];
                String referencia = campos[1].replace(";", " "); // Elimina el punto y coma al final
                
                // Agregamos el barrio a la lista
                listaBarrios.add( new Barrio(nombre, referencia));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    // El siguiente método escribe todos los datos de la lista en el archivo de texto.
    public void setVolcarDatosAlArchivo(List miListaConDatos) {
        this.listaBarrios = miListaConDatos;
        archivoBarrios = new File(rutaArchivo);
        
        // Abre el archivo para escritura
        try {
            FileWriter fw = new FileWriter(archivoBarrios);
            BufferedWriter bw = new BufferedWriter(fw);

            // Recorre la lista y escribe cada elemento en el archivo
            for (Barrio barrio : listaBarrios) {
               bw.write(barrio.getNombreBarrio() + "," + barrio.getReferencia()+";");
                bw.newLine();
            }

            // Cierra el archivo
            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Método que retorna la lista de propietarios
    public List<Barrio> getListaBarrios() {
        return listaBarrios;
    }
    
}
