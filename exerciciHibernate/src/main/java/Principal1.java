/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.hibernate.SessionFactory;

/**
 *
 * @author Chema
 */
public class Principal1 {

    private SessionFactory sessionFactory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal1 p = new Principal1();
        p.inicializarHibernate();
       
    }

    

    private void inicializarHibernate() {
        Runtime.getRuntime().addShutdownHook(new HibernateHook());
        sessionFactory = HibernateUtil.getSessionFactory();
    }
}
