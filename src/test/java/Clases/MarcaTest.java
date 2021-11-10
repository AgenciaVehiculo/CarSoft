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
public class MarcaTest {
    
    public MarcaTest() {
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
     * Test of getIdMarca method, of class Marca.
     */
    @org.junit.Test
    public void testGetIdMarca() {
        System.out.println("getIdMarca");
        Marca instance = new Marca();
        int expResult = 0;
        int result = instance.getIdMarca();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setIdMarca method, of class Marca.
     */
    @org.junit.Test
    public void testSetIdMarca() {
        System.out.println("setIdMarca");
        int idMarca = 0;
        Marca instance = new Marca();
        try {
        instance.setIdMarca(idMarca);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getMarca method, of class Marca.
     */
    @org.junit.Test
    public void testGetMarca() {
        System.out.println("getMarca");
        Marca instance = new Marca();
        String expResult = "";
        instance.setMarca(expResult);
        String result = instance.getMarca();
        try {
        assertEquals(expResult, result);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setMarca method, of class Marca.
     */
    @org.junit.Test
    public void testSetMarca() {
        System.out.println("setMarca");
        String marca = "";
        Marca instance = new Marca();
        try{
        instance.setMarca(marca);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isEstado method, of class Marca.
     */
    @org.junit.Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Marca instance = new Marca();
        boolean expResult = false;
        boolean result = instance.isEstado();
        try{
        assertEquals(expResult, result);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setEstado method, of class Marca.
     */
    @org.junit.Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        Marca instance = new Marca();
        try{
        instance.setEstado(estado);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }
    
}
