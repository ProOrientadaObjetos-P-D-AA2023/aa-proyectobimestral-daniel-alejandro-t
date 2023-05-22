package archivos;

import java.io.File;
import java.util.List;

public abstract class Fichero {
    String delimitador;
    String saltoLinea;
    String rutaArchivo;

    File archivo;

    protected Fichero(String rutaArchivo) {
        this.delimitador = ",";
        this.saltoLinea = ";";
        this.rutaArchivo = rutaArchivo;

        // Creamos una instancia interna de file que abra el archivo
        if (verificarArchivo(rutaArchivo)) {
            archivo = new File(rutaArchivo);
            
            // Carga de .dat ==> lista según la especificación de cada clase
            getCargarDatosAlPrograma(); 
        } else {
            crearArchivo(rutaArchivo);
            
        }
    }

    // Métodos getters y setters
    public void setSaltoLinea(String n) {
        saltoLinea = n;
    }

    public String getSaltoLinea() {
        return saltoLinea;
    }

    public String getDelimitador() {
        return delimitador;
    }

    // Método que verifica que exista un archivo específico en un directorio
    private static boolean verificarArchivo(String rutaArchivo){
        boolean existe = false;
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            existe = true;
        }
        return existe;
    }
    
    // Método que crea un archivo en un directorio específico
    public static void crearArchivo(String rutaArchivo){
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (Exception e) {
                System.err.println("Error al crear el archivo.");
            }
        }
    }

    // Método que retorna los datos del archivo ==> formato lista
    public abstract void getCargarDatosAlPrograma();

    // Método que vuelca los datos de la lista ==> archivo
    public abstract void setVolcarDatosAlArchivo(List miListaConDatos);

}
