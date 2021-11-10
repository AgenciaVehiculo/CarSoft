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
public class Numero_AsientosTest {
    
    public Numero_AsientosTest() {
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
     * Test of getId_Numero_Asientos method, of class Numero_Asientos.
     */
    @org.junit.Test
    public void testGetId_Numero_Asientos() {
        System.out.println("getId_Numero_Asientos");
        Numero_Asientos instance = new Numero_Asientos();
        int expResult = 0;
        int result = instance.getId_Numero_Asientos();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_Numero_Asientos method, of class Numero_Asientos.
     */
    @org.junit.Test
    public void testSetId_Numero_Asientos() {
        System.out.println("setId_Numero_Asientos");
        int id_Numero_Asientos = 0;
        Numero_Asientos instance = new Numero_Asientos();
        try{
        instance.setId_Numero_Asientos(id_Numero_Asientos);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getNumero_Asientos method, of class Numero_Asientos.
     */
    @org.junit.Test
    public void testGetNumero_Asientos() {
        System.out.println("getNumero_Asientos");
        Numero_Asientos instance = new Numero_Asientos();
        String expResult = "";
        instance.setNumero_Asientos(expResult);
        String result = instance.getNumero_Asientos();
        try{
        assertEquals(expResult, result);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setNumero_Asientos method, of class Numero_Asientos.
     */
    @org.junit.Test
    public void testSetNumero_Asientos() {
        System.out.println("setNumero_Asientos");
        String Numero_Asientos = "";
        Numero_Asientos instance = new Numero_Asientos();
        try{
        instance.setNumero_Asientos(Numero_Asientos);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isEstado method, of class Numero_Asientos.
     */
    @org.junit.Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Numero_Asientos instance = new Numero_Asientos();
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
     * Test of setEstado method, of class Numero_Asientos.
     */
    @org.junit.Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        Numero_Asientos instance = new Numero_Asientos();
        try{
        instance.setEstado(estado);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }
    
}
