/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dao.UserDao;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelos.Usuario;

/**
 *
 * @author jdcaparros
 */
@WebService(serviceName = "ServicioUsuarios")
public class ServicioUsuarios {

    @EJB
    private UserDao userDao;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
   public Usuario crearUser(String nombre,String pass){
       Usuario p=new Usuario(nombre, pass);
       userDao.crear(p);
       return p;
   }
   public Usuario existeUsuario(String nombre,String pass){
       Usuario p=userDao.existe(nombre, pass);
       return p;       
   }
}
