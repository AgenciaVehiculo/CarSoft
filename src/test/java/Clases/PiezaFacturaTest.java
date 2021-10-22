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
public class PiezaFacturaTest {
    
    public PiezaFacturaTest() {
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
     * Test of getIdFacturaPieza method, of class PiezaFactura.
     */
    @Test
    public void testGetIdFacturaPieza() {
        System.out.println("getIdFacturaPieza");
        PiezaFactura instance = new PiezaFactura();
        int expResult = 0;
        instance.setIdFactura(expResult);
        int result = instance.getIdFacturaPieza();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setIdFacturaPieza method, of class PiezaFactura.
     */
    @Test
    public void testSetIdFacturaPieza() {
        System.out.println("setIdFacturaPieza");
        int idFacturaPieza = 0;
        PiezaFactura instance = new PiezaFactura();
        try{
        instance.setIdFacturaPieza(idFacturaPieza);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getIdPieza method, of class PiezaFactura.
     */
    @Test
    public void testGetIdPieza() {
        System.out.println("getIdPieza");
        PiezaFactura instance = new PiezaFactura();
        int expResult = 0;
        instance.setIdPieza(expResult);
        int result = instance.getIdPieza();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setIdPieza method, of class PiezaFactura.
     */
    @Test
    public void testSetIdPieza() {
        System.out.println("setIdPieza");
        int idPieza = 0;
        PiezaFactura instance = new PiezaFactura();
        try{
        instance.setIdPieza(idPieza);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getIdFactura method, of class PiezaFactura.
     */
    @Test
    public void testGetIdFactura() {
        System.out.println("getIdFactura");
        PiezaFactura instance = new PiezaFactura();
        int expResult = 0;
        instance.setIdFactura(expResult);
        int result = instance.getIdFactura();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setIdFactura method, of class PiezaFactura.
     */
    @Test
    public void testSetIdFactura() {
        System.out.println("setIdFactura");
        int idFactura = 0;
        PiezaFactura instance = new PiezaFactura();
        try{
        instance.setIdFactura(idFactura);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getCantidad method, of class PiezaFactura.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        PiezaFactura instance = new PiezaFactura();
        Integer expResult = null;
        Integer result = instance.getCantidad();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setCantidad method, of class PiezaFactura.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        Integer cantidad = null;
        PiezaFactura instance = new PiezaFactura();
        try{
        instance.setCantidad(cantidad);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of toString method, of class PiezaFactura.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PiezaFactura instance = new PiezaFactura();
        String expResult = "";
        try{
        String result = instance.toString();
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    
}
