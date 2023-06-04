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
import paquete04.Ciudad;

/**
 *
 * @author Usuario iTC
 */
public class FicheroCiudad extends Fichero{
    
    // Creamos una lista internar de objetos de tipo Propietario
    List<Ciudad> listaCiudades;
    BufferedReader br;

    // Archivo file que contiene los datos de los propietarios
    File archivoCiudades;

    public FicheroCiudad(String rutaArchivo) {
        super(rutaArchivo);
        
        archivoCiudades = new File(rutaArchivo);
    }
    public String getRutaArchivo() {
        return super.rutaArchivo;
    }

    @Override
    public void getCargarDatosAlPrograma() {
        try {
            br = new BufferedReader(new FileReader(getRutaArchivo()));
            listaCiudades = new ArrayList<>();

            String linea;

            while ((linea = br.readLine()) != null) {
                // Aquí dividimos la línea en campos separados por comas
                String[] campos = linea.split(","); // campos[0] = "daniel Alvarez",  campos[1] = "..."

                // Obtenemos los datos de cada campo
                String nombreCiudad = campos[0];
                String nombreProvincia = campos[1].replace(";", " "); // Elimina el punto y coma al final
                
                // Agregamos el barrio a la lista
                listaCiudades.add( new Ciudad(nombreCiudad, nombreProvincia));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setVolcarDatosAlArchivo(List miListaConDatos) {
        this.listaCiudades = miListaConDatos;
        archivoCiudades = new File(rutaArchivo);
        
        // Abre el archivo para escritura
        try {
            FileWriter fw = new FileWriter(archivoCiudades);
            BufferedWriter bw = new BufferedWriter(fw);

            // Recorre la lista y escribe cada elemento en el archivo
            for (Ciudad ciudad : listaCiudades) {
               bw.write(ciudad.getNombreProvincia() + "," + ciudad.getNombreProvincia()+";");
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
    public List<Ciudad> getListaBarrios() {
        return listaCiudades;
    }
    
    
}
