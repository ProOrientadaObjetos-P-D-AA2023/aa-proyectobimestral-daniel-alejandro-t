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
    String nombreBarrio;
    String referencia;

    public Barrio(String nombreDelBarrio, String referencia) {
        this.nombreBarrio = nombreDelBarrio;
        this.referencia = referencia;
    }

    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public void setNombreBarrio(String n) {
        this.nombreBarrio = n;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String r) {
        this.referencia = r;
    }

    
    
    
    @Override
    public String toString (){
        
        return "Nombre de barrio: "+ getNombreBarrio() + " Referencia: "+ getReferencia(); 
    }
            
}

