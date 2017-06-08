/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prweb;

import javax.jws.WebService;

/**
 *
 * @author jdcaparros
 */
@WebService(serviceName = "Servei")
public class Servei {

    /**
     * This is a sample web service operation
     */
    public Persona crear(String nombre) {
        return new Persona(nombre);
    }
}
