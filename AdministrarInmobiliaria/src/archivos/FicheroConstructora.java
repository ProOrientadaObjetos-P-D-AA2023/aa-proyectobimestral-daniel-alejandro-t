package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import paquete05.Constructora;

public class FicheroConstructora extends Fichero{
    //  Creamos una lista interna de objetos de tipo Constructora
    List<Constructora> listaConstructoras;
    BufferedReader br;

    //  Archivo file que contiene los datos de las constructoras
    File archivoConstructoras;

    //  Constructor de la clase
    public FicheroConstructora(String rutaArchivo) {
        super(rutaArchivo);

        //  Inicializamos listaConstructoras para evitar NullPointerException
        archivoConstructoras = new File(rutaArchivo);
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
            listaConstructoras = new ArrayList<>();

            String linea = br.readLine();
            while (linea != null) {
                String[] campos = linea.split(",");
                Constructora constructora = new Constructora(campos[0], campos[1]);
                listaConstructoras.add(constructora);
                linea = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void setVolcarDatosAlArchivo(List miListaConDatos) {
        this.listaConstructoras = miListaConDatos;
        archivoConstructoras = new File(rutaArchivo);

        try {
            FileWriter fw = new FileWriter(archivoConstructoras);
            BufferedWriter bw = new BufferedWriter(fw);

            // Recorre la lista y escribe cada elemento en una línea del archivo
            for (Constructora constructora : listaConstructoras) {
                bw.write(constructora.getNombreConstructora() + "," + constructora.getIdConstructora() + "\n");
            }

            // Cierra el archivo
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();;
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método que devuelve la lista de constructoras
    public List<Constructora> getListaConstructoras() {
        return listaConstructoras;
    }
}
