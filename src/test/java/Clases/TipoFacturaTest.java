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
public class TipoFacturaTest {
    
    public TipoFacturaTest() {
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
     * Test of getIDtipofactura method, of class TipoFactura.
     */
    @Test
    public void testGetIDtipofactura() {
        System.out.println("getIDtipofactura");
        TipoFactura instance = new TipoFactura();
        Integer expResult = null;
        Integer result = instance.getIDtipofactura();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setIDtipofactura method, of class TipoFactura.
     */
    @Test
    public void testSetIDtipofactura() {
        System.out.println("setIDtipofactura");
        Integer iDtipofactura = null;
        TipoFactura instance = new TipoFactura();
        try{
        instance.setIDtipofactura(iDtipofactura);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getTipoFactura method, of class TipoFactura.
     */
    @Test
    public void testGetTipoFactura() {
        System.out.println("getTipoFactura");
        TipoFactura instance = new TipoFactura();
        String expResult = "";
        instance.setTipoFactura(expResult);
        String result = instance.getTipoFactura();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setTipoFactura method, of class TipoFactura.
     */
    @Test
    public void testSetTipoFactura() {
        System.out.println("setTipoFactura");
        String tipoFactura = "";
        TipoFactura instance = new TipoFactura();
        try{
        instance.setTipoFactura(tipoFactura);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getEstado method, of class TipoFactura.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        TipoFactura instance = new TipoFactura();
        Boolean expResult = null;
        Boolean result = instance.getEstado();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setEstado method, of class TipoFactura.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        Boolean estado = null;
        TipoFactura instance = new TipoFactura();
        try{
        instance.setEstado(estado);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a Mistake.");
    }}


    /**
     * Test of hashCode method, of class TipoFactura.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TipoFactura instance = new TipoFactura();
        int expResult = 0;
        int result = instance.hashCode();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of equals method, of class TipoFactura.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        TipoFactura instance = new TipoFactura();
        boolean expResult = false;
        boolean result = instance.equals(object);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of toString method, of class TipoFactura.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TipoFactura instance = new TipoFactura();
        String expResult = "";
        try{
        String result = instance.toString();
       }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    
}
