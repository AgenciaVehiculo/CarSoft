/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neos9
 */
public class Tipo_colorTest {
    
    public Tipo_colorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId_tipo_color method, of class Tipo_color.
     */
    @org.junit.Test
    public void testGetId_tipo_color() {
        System.out.println("getId_tipo_color");
        Tipo_color instance = new Tipo_color();
        int expResult = 0;
        int result = instance.getId_tipo_color();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_tipo_color method, of class Tipo_color.
     */
    @org.junit.Test
    public void testSetId_tipo_color() {
        System.out.println("setId_tipo_color");
        int id_tipo_color = 0;
        Tipo_color instance = new Tipo_color();
        try{
        instance.setId_tipo_color(id_tipo_color);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTipo_color method, of class Tipo_color.
     */
    @org.junit.Test
    public void testGetTipo_color() {
        System.out.println("getTipo_color");
        Tipo_color instance = new Tipo_color();
        String expResult = "";
        instance.setTipo_color(expResult);
        String result = instance.getTipo_color();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setTipo_color method, of class Tipo_color.
     */
    @org.junit.Test
    public void testSetTipo_color() {
        System.out.println("setTipo_color");
        String tipo_color = "";
        Tipo_color instance = new Tipo_color();
        try{
        instance.setTipo_color(tipo_color);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isEstado method, of class Tipo_color.
     */
    @org.junit.Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Tipo_color instance = new Tipo_color();
        boolean expResult = false;
        boolean result = instance.isEstado();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setEstado method, of class Tipo_color.
     */
    @org.junit.Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        Tipo_color instance = new Tipo_color();
        try{
        instance.setEstado(estado);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }
    
}
