/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.junitproves;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jdcaparros
 */
public class NewEmptyJUnitTest {
    private Demo d;

    public NewEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setupclass");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("after class");
    }

    @Before
    public void setUp() {
        d=new Demo();
        System.out.println("en before setup");
    }

    @After
    public void tearDown() {
        System.out.println("en after tear");
    }

   
    @Test(expected = IOException.class)
    public void getNombreTest() {
        System.out.println("nombre test");
        assertNull(d.getNombre());
    }
    
    
    @Test
    public void metodoIntegerTest() {
        System.out.println("integer test");
        assertEquals(new Integer(3), d.metodoInteger());
    }
}
