/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebapersistencia.ws;

import com.mycompany.pruebapersistencia.modelo.Persona;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jdcaparros
 */
@WebService(serviceName = "PersistenciaWs")
@Stateless
public class PersistenciaWs {

    @PersistenceContext
    private EntityManager em;
//    @Resource
//    private javax.transaction.UserTransaction utx;

    /**
     * This is a sample web service operation
     */
    
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

//    public void persist(Object object) {
//        try {
//            utx.begin();
//            em.persist(object);
//            utx.commit();
//        } catch (Exception e) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
//            throw new RuntimeException(e);
//        }
//    }
    
    public Persona crear(String nombre) {
        Persona persona = new Persona(nombre);
        em.persist(persona);
        return persona;
    }
//    public List<Persona> todos(){
//        return null;
//    }
}
