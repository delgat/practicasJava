/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;

/**
 *
 * @author jdcaparros
 */
public class Persona {
    private String nombre;
    private Aficion aficion;
    private List<Aficion> aficiones;

    public List<Aficion> getAficiones() {
        return aficiones;
    }

    public void setAficiones(List<Aficion> aficiones) {
        this.aficiones = aficiones;
    }

    public Aficion getAficion() {
        return aficion;
    }

    public void setAficion(Aficion aficion) {
        this.aficion = aficion;
    }
    
    public Persona(){
        System.out.println("constructor de persona");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; 
   }


    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", aficion=" + aficion + ", aficiones=" + aficiones + '}';
    }

   
    
    
}
