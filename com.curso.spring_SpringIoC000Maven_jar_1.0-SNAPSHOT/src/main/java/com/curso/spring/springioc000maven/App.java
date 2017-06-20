package com.curso.spring.springioc000maven;

import beans.Persona;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        System.out.println("Contexto cargado");
        System.out.println(ctx.getBean(Persona.class));
        System.out.println(ctx.getBean(Persona.class));
    }
}
