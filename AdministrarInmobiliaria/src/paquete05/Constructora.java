/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete05;

/**
 *
 * @author reroes
 */
public class Constructora {
    String nombreConstructora, idConstructora;

    public Constructora(String nombreConstructora, String idConstructora) {
        this.nombreConstructora = nombreConstructora;
        this.idConstructora = idConstructora;
    }

    public String getNombreConstructora() {
        return nombreConstructora;
    }

    public void setNombreConstructora(String nombreConstructora) {
        this.nombreConstructora = nombreConstructora;
    }

    public String getIdConstructora() {
        return idConstructora;
    }

    public void setIdConstructora(String idConstructora) {
        this.idConstructora = idConstructora;
    }
}
