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
 * @author EDUIN FLORES
 */
public class Detalle_Pedido_VehiculoTest {
    
    public Detalle_Pedido_VehiculoTest() {
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
     * Test of getId_pedido_Vehiculo method, of class Detalle_Pedido_Vehiculo.
     */
    @Test
    public void testGetId_pedido_Vehiculo() {
        System.out.println("getId_pedido_Vehiculo");
        Detalle_Pedido_Vehiculo instance = new Detalle_Pedido_Vehiculo();
        int expResult = 0;
        int result = instance.getId_pedido_Vehiculo();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_pedido_Vehiculo method, of class Detalle_Pedido_Vehiculo.
     */
    @Test
    public void testSetId_pedido_Vehiculo() {
        System.out.println("setId_pedido_Vehiculo");
        int id_pedido_Vehiculo = 0;
        Detalle_Pedido_Vehiculo instance = new Detalle_Pedido_Vehiculo();
        try {
        instance.setId_pedido_Vehiculo(id_pedido_Vehiculo);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getId_pedido method, of class Detalle_Pedido_Vehiculo.
     */
    @Test
    public void testGetId_pedido() {
        System.out.println("getId_pedido");
        Detalle_Pedido_Vehiculo instance = new Detalle_Pedido_Vehiculo();
        int expResult = 0;
        int result = instance.getId_pedido();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_pedido method, of class Detalle_Pedido_Vehiculo.
     */
    @Test
    public void testSetId_pedido() {
        System.out.println("setId_pedido");
        int id_pedido = 0;
        Detalle_Pedido_Vehiculo instance = new Detalle_Pedido_Vehiculo();
        try {
        instance.setId_pedido(id_pedido);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getId_vehiculo method, of class Detalle_Pedido_Vehiculo.
     */
    @Test
    public void testGetId_vehiculo() {
        System.out.println("getId_vehiculo");
        Detalle_Pedido_Vehiculo instance = new Detalle_Pedido_Vehiculo();
        int expResult = 0;
        int result = instance.getId_vehiculo();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_vehiculo method, of class Detalle_Pedido_Vehiculo.
     */
    @Test
    public void testSetId_vehiculo() {
        System.out.println("setId_vehiculo");
        int id_vehiculo = 0;
        Detalle_Pedido_Vehiculo instance = new Detalle_Pedido_Vehiculo();
        try {
        instance.setId_vehiculo(id_vehiculo);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getCantidad method, of class Detalle_Pedido_Vehiculo.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        Detalle_Pedido_Vehiculo instance = new Detalle_Pedido_Vehiculo();
        int expResult = 0;
        int result = instance.getCantidad();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCantidad method, of class Detalle_Pedido_Vehiculo.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int cantidad = 0;
        Detalle_Pedido_Vehiculo instance = new Detalle_Pedido_Vehiculo();
        try {
        instance.setCantidad(cantidad);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getPrecio method, of class Detalle_Pedido_Vehiculo.
     */
    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        Detalle_Pedido_Vehiculo instance = new Detalle_Pedido_Vehiculo();
        double expResult = 0.0;
        instance.setPrecio(expResult);
        double result = instance.getPrecio();
        try {
        if(expResult==result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPrecio method, of class Detalle_Pedido_Vehiculo.
     */
    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double precio = 0.0;
        Detalle_Pedido_Vehiculo instance = new Detalle_Pedido_Vehiculo();
        try {
        instance.setPrecio(precio);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }
    
}
