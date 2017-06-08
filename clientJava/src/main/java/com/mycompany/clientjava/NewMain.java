/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientjava;

/**
 *
 * @author jdcaparros
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try { // Call Web Service Operation
            com.mycompany.prweb.Servei_Service service = new com.mycompany.prweb.Servei_Service();
            com.mycompany.prweb.Servei port = service.getServeiPort();
            // TODO initialize WS operation arguments here
            java.lang.String arg0 = "";
            // TODO process result here
            com.mycompany.prweb.Persona result = port.crear("54464646");
            System.out.println("Result = "+result.getNombre());
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }
    
}
