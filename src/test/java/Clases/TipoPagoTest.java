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
public class TipoPagoTest {
    
    public TipoPagoTest() {
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
     * Test of getIdTipoPago method, of class TipoPago.
     */
    @Test
    public void testGetIdTipoPago() {
        System.out.println("getIdTipoPago");
        TipoPago instance = new TipoPago();
        Integer expResult = null;
        Integer result = instance.getIdTipoPago();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setIdTipoPago method, of class TipoPago.
     */
    @Test
    public void testSetIdTipoPago() {
        System.out.println("setIdTipoPago");
        Integer idTipoPago = null;
        TipoPago instance = new TipoPago();
        
        try{
        instance.setIdTipoPago(idTipoPago);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getNombre method, of class TipoPago.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        TipoPago instance = new TipoPago();
        String expResult = "";
        instance.setNombre(expResult);
        String result = instance.getNombre();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setNombre method, of class TipoPago.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        TipoPago instance = new TipoPago();
        try{
        instance.setNombre(nombre);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getEstado method, of class TipoPago.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        TipoPago instance = new TipoPago();
        Boolean expResult = null;
        Boolean result = instance.getEstado();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setEstado method, of class TipoPago.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        Boolean estado = null;
        TipoPago instance = new TipoPago();
        try{
        instance.setEstado(estado);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of hashCode method, of class TipoPago.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TipoPago instance = new TipoPago();
        int expResult = 0;
        int result = instance.hashCode();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of equals method, of class TipoPago.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        TipoPago instance = new TipoPago();
        boolean expResult = false;
        boolean result = instance.equals(object);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of toString method, of class TipoPago.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TipoPago instance = new TipoPago();
        String expResult = "";
        try{
        String result = instance.toString();
     }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    
}
