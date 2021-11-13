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
 * @author User
 */
public class FacturarechazadaTest {
    
    public FacturarechazadaTest() {
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
     * Test of getId method, of class Facturarechazada.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Facturarechazada instance = new Facturarechazada();
        int expResult = 0;
        instance.setId(expResult);
        int result = instance.getId();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setId method, of class Facturarechazada.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Facturarechazada instance = new Facturarechazada();
        try{
        instance.setId(id);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getFechaRechazo method, of class Facturarechazada.
     */
    @Test
    public void testGetFechaRechazo() {
        System.out.println("getFechaRechazo");
        Facturarechazada instance = new Facturarechazada();
        String expResult = "";
        instance.setFechaRechazo(expResult);
        String result = instance.getFechaRechazo();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setFechaRechazo method, of class Facturarechazada.
     */
    @Test
    public void testSetFechaRechazo() {
        System.out.println("setFechaRechazo");
        String fechaRechazo = "";
        Facturarechazada instance = new Facturarechazada();
        try{
        instance.setFechaRechazo(fechaRechazo);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getIdRechazo method, of class Facturarechazada.
     */
    @Test
    public void testGetIdRechazo() {
        System.out.println("getIdRechazo");
        Facturarechazada instance = new Facturarechazada();
        Integer expResult = 0;
       instance.setIdRechazo(expResult);
        Integer result = instance.getIdRechazo();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setIdRechazo method, of class Facturarechazada.
     */
    @Test
    public void testSetIdRechazo() {
        System.out.println("setIdRechazo");
        Integer idRechazo = null;
        Facturarechazada instance = new Facturarechazada();
        try{
        instance.setIdRechazo(idRechazo);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getDescripcion method, of class Facturarechazada.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Facturarechazada instance = new Facturarechazada();
        String expResult = "";
        instance.setDescripcion(expResult);
        String result = instance.getDescripcion();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setDescripcion method, of class Facturarechazada.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Facturarechazada instance = new Facturarechazada();
        try{
        instance.setDescripcion(descripcion);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of hashCode method, of class Facturarechazada.
     */
    

    /**
     * Test of equals method, of class Facturarechazada.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Facturarechazada instance = new Facturarechazada();
        boolean expResult = false;
        boolean result = instance.equals(object);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of toString method, of class Facturarechazada.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Facturarechazada instance = new Facturarechazada();
        
        try{
        String result = instance.toString();
        
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}
    
}
