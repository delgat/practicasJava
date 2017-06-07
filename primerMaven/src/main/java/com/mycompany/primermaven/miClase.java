/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primermaven;

/**
 *
 * @author jdcaparros
 */

public class miClase {
     private static miClase singleton= new miClase();
    
    private miClase(){
        
    }
    
    public static miClase instacia(){
        
       return singleton;
        
    }
    
}
