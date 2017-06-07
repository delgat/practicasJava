/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicatest;

import java.util.List;

/**trabajo (Lérida)
 *
 * @author jdcaparros
 */
public class Aritmetica {

    public Double media(List<Double> numeros) {
        Double result = 0.0;
        if (numeros == null) {
            throw new IllegalArgumentException();
        } else if (numeros.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            int a = 0;
            a += numeros.stream().filter(p -> p < 0.0).count();
            if (a != 0) {
                throw new RuntimeException();
            } else {
               
                result = numeros.stream().map((next) -> next).reduce(result, (accumulator, _item) -> accumulator + _item);
                
            }
        }

        return result / numeros.size();
    }

}
