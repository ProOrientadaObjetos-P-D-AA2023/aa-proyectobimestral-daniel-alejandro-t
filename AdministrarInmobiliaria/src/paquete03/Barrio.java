/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

/**
 *
 * @author reroes
 */
public class Barrio {
    String nombreDelBarrio;
    String referencia;

    public Barrio(String nombreDelBarrio, String referencia) {
        this.nombreDelBarrio = nombreDelBarrio;
        this.referencia = referencia;
    }

    public String getNombreDelBarrio() {
        return nombreDelBarrio;
    }

    public void setNombreDelBarrio(String nombreDelBarrio) {
        this.nombreDelBarrio = nombreDelBarrio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}

