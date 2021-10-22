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
public class transmisionTest {
    
    public transmisionTest() {
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
     * Test of getId_transmision method, of class transmision.
     */
    @org.junit.Test
    public void testGetId_transmision() {
        System.out.println("getId_transmision");
        transmision instance = new transmision();
        int expResult = 0;
        int result = instance.getId_transmision();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_transmision method, of class transmision.
     */
    @org.junit.Test
    public void testSetId_transmision() {
        System.out.println("setId_transmision");
        int id_transmision = 0;
        transmision instance = new transmision();
        try{
        instance.setId_transmision(id_transmision);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTransmision method, of class transmision.
     */
    @org.junit.Test
    public void testGetTransmision() {
        System.out.println("getTransmision");
        transmision instance = new transmision();
        String expResult = "";
        instance.setTransmision(expResult);
        String result = instance.getTransmision();
        
        try{
        assertEquals(expResult, result);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setTransmision method, of class transmision.
     */
    @org.junit.Test
    public void testSetTransmision() {
        System.out.println("setTransmision");
        String transmision = "";
        transmision instance = new transmision();
        try{
        instance.setTransmision(transmision);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isEstado method, of class transmision.
     */
    @org.junit.Test
    public void testIsEstado() {
        System.out.println("isEstado");
        transmision instance = new transmision();
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
     * Test of setEstado method, of class transmision.
     */
    @org.junit.Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        transmision instance = new transmision();
        try{
        instance.setEstado(estado);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }
    
}
