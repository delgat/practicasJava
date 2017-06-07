/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.Principal;

import dao.FactoriaUsuarioDao;
import static java.lang.System.out;
import modelo.Usuario;
import servicio.AuthServicio;
import servicio.FactoriaAuthServicio;

/**
 *
 * @author usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       FactoriaUsuarioDao.get().nueva(new Usuario("este", "otro"));
       FactoriaUsuarioDao.get().nueva(new Usuario("este2", "otro2"));
        FactoriaUsuarioDao.get().todos().forEach(out::println);
        AuthServicio auth = FactoriaAuthServicio.get();
        System.out.println(auth.existe(new Usuario("este","otro")));
        System.out.println(auth.existe(new Usuario("este","otrdfssdao")));
            
    }

}
