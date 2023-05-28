package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import paquete02.Propietario;

public class FicheroPropietario extends Fichero{
    // Creamos una lista internar de objetos de tipo Propietario
    List<Propietario> listaPropietarios;
    BufferedReader br;

    // Archivo file que contiene los datos de los propietarios
    File archivoPropietarios;

    // Constructor de la clase
    public FicheroPropietario(String rutaArchivo) {
        super(rutaArchivo);

        // Inicializamos listaPropietarios para evitar NullPointerException
        // listaPropietarios = new ArrayList<>();
        archivoPropietarios = new File(rutaArchivo);
    }

    public String getRutaArchivo() {
        return super.rutaArchivo;
    }

    /**
     * Este método carga los datos al programa desde el archivo especificado.
     * 
     * <p>
     * El método lee línea por línea el archivo de texto, dividiendo cada línea en campos separados por comas. 
     * Los campos representan diferentes atributos del objeto Propietario, tales como el nombre, apellido e identificación.
     * Luego, cada línea se convierte en una instancia de Propietario y se añade a la lista de propietarios.
     * Si ocurre algún error durante la lectura del archivo o la creación de las instancias de Propietario, se imprime la traza de la excepción.
     * </p>
     * 
     * <p>
     * Importante: El archivo de texto debería seguir el siguiente formato para cada línea:
     * [nombre],[apellido],[identificación];
     * Por ejemplo:
     * Jhanneth,Chicaiza,1109090904;
     * Daniel,Irene,1009094980;
     * </p>
     * 
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     */
    @Override
    public void getCargarDatosAlPrograma() {
        
        try {
            br = new BufferedReader(new FileReader(getRutaArchivo()));
            listaPropietarios = new ArrayList<>();

            String linea;

            while ((linea = br.readLine()) != null) {
                // Aquí dividimos la línea en campos separados por comas
                String[] campos = linea.split(","); // campos[0] = "Daniel",  campos[1] = "..."

                // Obtenemos los datos de cada campo
                String nombre = campos[0];
                String apellido = campos[1];
                String identificacion = campos[2].replace(";", ""); // Elimina el punto y coma al final
                
                // Agregamos el propietario a la lista
                listaPropietarios.add( new Propietario(nombre, apellido, identificacion));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    // El siguiente método escribe todos los datos de la lista en el archivo de texto.
    public void setVolcarDatosAlArchivo(List miListaConDatos) {
        this.listaPropietarios = miListaConDatos;
        archivoPropietarios = new File(rutaArchivo);

        // Abre el archivo para escritura
        try {
            FileWriter fw = new FileWriter(archivoPropietarios);
            BufferedWriter bw = new BufferedWriter(fw);

            // Recorre la lista y escribe cada elemento en el archivo
            for (Propietario propietario : listaPropietarios) {
                bw.write(propietario.getNombres() + "," + propietario.getApellidos() + "," + propietario.getIdentificacion() + ";");
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
    public List<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }
}
