/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Login;

/**
 *
 * @author jdcaparros
 */
@Stateless
public class LoginDao {

    @PersistenceContext(unitName = "com.mycompany_exericiciServlets_war_1.0-SNAPSHOTPU")
    private EntityManager em;
   
     public void missatge(Login object) {
        em.persist(object);
    }
 public List<Login> todas() {
        return em.createQuery("select p from Login p", Login.class).getResultList();
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
