/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author jdcaparros
 */
@Configuration
@ComponentScan(basePackages = "beans")
@PropertySource("propiedades.properties")
@Scope("prototype")
public class Configuracion {

    @Bean(autowire = Autowire.BY_TYPE)
    @Scope("prototype")
    public Persona crear() {
        return new Persona();
    }
    
}
