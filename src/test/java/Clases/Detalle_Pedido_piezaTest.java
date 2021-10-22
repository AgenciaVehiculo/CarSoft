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
public class Detalle_Pedido_piezaTest {
    
    public Detalle_Pedido_piezaTest() {
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
     * Test of getId_pedido_pieza method, of class Detalle_Pedido_pieza.
     */
    @Test
    public void testGetId_pedido_pieza() {
        System.out.println("getId_pedido_pieza");
        Detalle_Pedido_pieza instance = new Detalle_Pedido_pieza();
        int expResult = 0;
        int result = instance.getId_pedido_pieza();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_pedido_pieza method, of class Detalle_Pedido_pieza.
     */
    @Test
    public void testSetId_pedido_pieza() {
        System.out.println("setId_pedido_pieza");
        int id_pedido_pieza = 0;
        Detalle_Pedido_pieza instance = new Detalle_Pedido_pieza();
        try {
        instance.setId_pedido_pieza(id_pedido_pieza);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getId_pedido method, of class Detalle_Pedido_pieza.
     */
    @Test
    public void testGetId_pedido() {
        System.out.println("getId_pedido");
        Detalle_Pedido_pieza instance = new Detalle_Pedido_pieza();
        int expResult = 0;
        int result = instance.getId_pedido();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_pedido method, of class Detalle_Pedido_pieza.
     */
    @Test
    public void testSetId_pedido() {
        System.out.println("setId_pedido");
        int id_pedido = 0;
        Detalle_Pedido_pieza instance = new Detalle_Pedido_pieza();
        try {
        instance.setId_pedido(id_pedido);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getId_pieza method, of class Detalle_Pedido_pieza.
     */
    @Test
    public void testGetId_pieza() {
        System.out.println("getId_pieza");
        Detalle_Pedido_pieza instance = new Detalle_Pedido_pieza();
        int expResult = 0;
        int result = instance.getId_pieza();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_pieza method, of class Detalle_Pedido_pieza.
     */
    @Test
    public void testSetId_pieza() {
        System.out.println("setId_pieza");
        int id_pieza = 0;
        Detalle_Pedido_pieza instance = new Detalle_Pedido_pieza();
        try {
        instance.setId_pieza(id_pieza);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getCantidad method, of class Detalle_Pedido_pieza.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        Detalle_Pedido_pieza instance = new Detalle_Pedido_pieza();
        int expResult = 0;
        int result = instance.getCantidad();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCantidad method, of class Detalle_Pedido_pieza.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int cantidad = 0;
        Detalle_Pedido_pieza instance = new Detalle_Pedido_pieza();
        try {
        instance.setCantidad(cantidad);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getPrecio method, of class Detalle_Pedido_pieza.
     */
    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        Detalle_Pedido_pieza instance = new Detalle_Pedido_pieza();
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
     * Test of setPrecio method, of class Detalle_Pedido_pieza.
     */
    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double precio = 0.0;
        Detalle_Pedido_pieza instance = new Detalle_Pedido_pieza();
        try {
        instance.setPrecio(precio);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }
    
}
