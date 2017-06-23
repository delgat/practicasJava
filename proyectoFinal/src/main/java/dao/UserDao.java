/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import modelos.Usuario;

/**
 *
 * @author jdcaparros
 */
@Stateless
public class UserDao {

    @PersistenceContext(unitName = "com.mycompany_proyectoFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void crear(Usuario u) {
        em.persist(u);
    }

    public Usuario existe(String nombre, String pass) {
        Usuario p;
        final String orden = "select p from Usuario p where p.nombre=:nombre and p.pass=:clave";
        try {
            TypedQuery<Usuario> q = em.createQuery(orden, Usuario.class);
            q.setParameter("nombre", nombre);
            q.setParameter("clave", pass);
            p = q.getSingleResult();
        } catch (Exception e) {
            p = new Usuario(0L);
        }
        System.out.println(p);
        return p;
    }
}
