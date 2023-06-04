package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import paquete06.Departamento;

public class FicheroDepartamento extends Fichero{
    // Creamos una lista internar de objetos de tipo Departamento
    List<Departamento> listaDepartamentos;
    BufferedReader br;
    // Archivo file que contiene los datos de los departamentos
    File archivoDepartamentos;
    // Constructor de la clase
    public FicheroDepartamento(String rutaArchivo) {
        super(rutaArchivo);

        // Inicializamos listaDepartamentos para evitar NullPointerException
        // listaDepartamentos = new ArrayList<>();
        archivoDepartamentos = new File(rutaArchivo);
    }
    public String getRutaArchivo() {
        return super.rutaArchivo;
    }
    @Override
    public void getCargarDatosAlPrograma() {
        
        try {
            br = new BufferedReader(new FileReader(getRutaArchivo()));
            listaDepartamentos = new ArrayList<>();

            String linea;

            while ((linea = br.readLine()) != null) {
                // Aquí dividimos la línea en campos separados por comas
                String[] campos = linea.split(","); // campos[0] = "Daniel",  campos[1] = "..."
                String nombreEdificio, ubicacionInterna, identificacionPropietario, nombreBarrio, nombreCiudad, idConstructora;
                double valorAlicuotaMensual, precioMetroCuadrado, numMetrosCuadrados;
                int numCuartos;

                // Obtenemos los datos de cada campo
                valorAlicuotaMensual = Double.parseDouble(campos[0]);
                nombreEdificio = campos[1];
                ubicacionInterna = campos[2];
                precioMetroCuadrado = Double.parseDouble(campos[3]);
                numMetrosCuadrados = Double.parseDouble(campos[4]);
                numCuartos = Integer.parseInt(campos[5]);
                identificacionPropietario = campos[6];
                nombreBarrio = campos[7];
                nombreCiudad = campos[8];
                idConstructora = (campos[9].replace(";", "")); // Elimina el punto y coma al final
             
                
                // Agregamos el departamento a la lista
                listaDepartamentos.add(new Departamento(valorAlicuotaMensual, nombreEdificio, ubicacionInterna, precioMetroCuadrado, numMetrosCuadrados,
                                       numCuartos, identificacionPropietario, nombreBarrio, nombreCiudad, idConstructora));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    // El siguiente método escribe todos los datos de la lista en el archivo de texto.
    public void setVolcarDatosAlArchivo(List miListaConDatos) {
        this.listaDepartamentos = miListaConDatos;
        archivoDepartamentos = new File(rutaArchivo);

        // Abre el archivo para escritura
        try {
            FileWriter fw = new FileWriter(archivoDepartamentos);
            BufferedWriter bw = new BufferedWriter(fw);

            // Recorre la lista y escribe cada elemento en el archivo
            for (Departamento departamento : listaDepartamentos) {
                bw.write(departamento.getValorAlicuotaMensual() + "," + departamento.getNombreEdificio() + "," + departamento.getUbicacionInterna() + "," + departamento.getPrecioMetroCuadrado() +
                        "," + departamento.getNumMetrosCuadrados() + "," + departamento.getNumCuartos() + "," + departamento.getIdentificadorPropietario() + 
                        "," + departamento.getNombreBarrio() + "," + departamento.getNombreCiudad() + "," + departamento.getIdConstructora() + ";");
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

    // Método que retorna la lista de departamentos
    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }
}
