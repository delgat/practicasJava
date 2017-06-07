/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.FactoriaUsuarioDao;
import dao.UsuarioDao;
import java.util.List;
import java.util.Objects;
import modelo.Usuario;

/**
 *
 * @author jdcaparros
 */
class AuthServicioImpl implements AuthServicio{

    @Override
    public Boolean existe(Usuario u) {
        Objects.requireNonNull(u.getNombre());
        Objects.requireNonNull(u.getPassword());        
        UsuarioDao dao = FactoriaUsuarioDao.get();
        List<Usuario> listaUsuarios = dao.todos();
        boolean existe = false;
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getNombre().equals(u.getNombre
        ()) && usuario.getPassword().equals(u.getPassword())){
                existe=true;
            }
        }
        return existe;
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
