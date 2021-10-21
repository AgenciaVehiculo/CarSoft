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
public class VehiculoFacturaTest {
    
    public VehiculoFacturaTest() {
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
     * Test of isEstado method, of class VehiculoFactura.
     */
    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        VehiculoFactura instance = new VehiculoFactura();
        boolean expResult = false;
        instance.setEstado(expResult);
        boolean result = instance.isEstado();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setEstado method, of class VehiculoFactura.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        VehiculoFactura instance = new VehiculoFactura();
        try{
        instance.setEstado(estado);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getIdFacturaVehiculo method, of class VehiculoFactura.
     */
    @Test
    public void testGetIdFacturaVehiculo() {
        System.out.println("getIdFacturaVehiculo");
        VehiculoFactura instance = new VehiculoFactura();
        int expResult = 0;
        instance.setIdFacturaVehiculo(0);
        int result = instance.getIdFacturaVehiculo();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setIdFacturaVehiculo method, of class VehiculoFactura.
     */
    @Test
    public void testSetIdFacturaVehiculo() {
        System.out.println("setIdFacturaVehiculo");
        int idFacturaVehiculo = 0;
        VehiculoFactura instance = new VehiculoFactura();
        try{
        instance.setIdFacturaVehiculo(idFacturaVehiculo);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getIdVehiculo method, of class VehiculoFactura.
     */
    @Test
    public void testGetIdVehiculo() {
        System.out.println("getIdVehiculo");
        VehiculoFactura instance = new VehiculoFactura();
        int expResult = 0;
        instance.setIdVehiculo(expResult);
        int result = instance.getIdVehiculo();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setIdVehiculo method, of class VehiculoFactura.
     */
    @Test
    public void testSetIdVehiculo() {
        System.out.println("setIdVehiculo");
        int idVehiculo = 0;
        VehiculoFactura instance = new VehiculoFactura();
        try{
        instance.setIdVehiculo(idVehiculo);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getIdFactura method, of class VehiculoFactura.
     */
    @Test
    public void testGetIdFactura() {
        System.out.println("getIdFactura");
        VehiculoFactura instance = new VehiculoFactura();
        int expResult = 0;
        instance.setIdFactura(0);
        int result = instance.getIdFactura();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setIdFactura method, of class VehiculoFactura.
     */
    @Test
    public void testSetIdFactura() {
        System.out.println("setIdFactura");
        int idFactura = 0;
        VehiculoFactura instance = new VehiculoFactura();
        try{
        instance.setIdFactura(idFactura);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getCantidad method, of class VehiculoFactura.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        VehiculoFactura instance = new VehiculoFactura();
        String expResult = "";
        instance.setCantidad(expResult);
        String result = instance.getCantidad();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setCantidad method, of class VehiculoFactura.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        String cantidad = "";
        VehiculoFactura instance = new VehiculoFactura();
        try{
        instance.setCantidad(cantidad);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of toString method, of class VehiculoFactura.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        VehiculoFactura instance = new VehiculoFactura();
        String expResult = "";
        try{
        String result = instance.toString();
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

}
