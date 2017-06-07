/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.practicatest.Aritmetica;
import java.util.ArrayList;
import java.util.List;
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
public class TestAritmetica {
    
    public TestAritmetica() {
    }
    private Aritmetica d;
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
        d=new Aritmetica();
        System.out.println("en before setup");
    }

    @After
    public void tearDown() {
        System.out.println("en after tear");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
      @Test(expected = IllegalArgumentException.class)
    public void nullmediaTest() {
          //assertNotNull(d.media(new ArrayList<>()));
          d.media(null);
          //throw new IllegalArgumentException();
    }
      @Test(expected = IllegalArgumentException.class)
    public void emptyMediaTest() {
          //assertNotNull(d.media(new ArrayList<>()));
          d.media(new ArrayList<>());
          //throw new IllegalArgumentException();
    }
    @Test(expected = RuntimeException.class)
    public void negatioMediaTest() {
          //assertNotNull(d.media(new ArrayList<>()));
          List<Double> llista=new ArrayList<Double>( );
          llista.add(2.2);
          llista.add(2.2);
          llista.add(-2.2);
          d.media(llista);
          //throw new IllegalArgumentException();
    }
    @Test
    public void bonaMediaTest() {
          //assertNotNull(d.media(new ArrayList<>()));
          List<Double> llista=new ArrayList<Double>( );
          llista.add(2.2);
          llista.add(4.8);
          llista.add(2.2);
          System.out.println(d.media(llista));
          //throw new IllegalArgumentException();
    }
}
