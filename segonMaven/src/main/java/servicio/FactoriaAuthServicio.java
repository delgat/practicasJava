/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

/**
 *
 * @author usuario
 */
public abstract class FactoriaAuthServicio {
    private static final AuthServicio DAO = new AuthServicioImpl();
    public static AuthServicio get(){
        return DAO;
    }
}
