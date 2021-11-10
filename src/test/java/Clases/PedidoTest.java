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
public class PedidoTest {
    
    public PedidoTest() {
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
     * Test of getId_pedido method, of class Pedido.
     */
    @Test
    public void testGetId_pedido() {
        System.out.println("getId_pedido");
        Pedido instance = new Pedido();
        int expResult = 0;
        int result = instance.getId_pedido();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_pedido method, of class Pedido.
     */
    @Test
    public void testSetId_pedido() {
        System.out.println("setId_pedido");
        int id_pedido = 0;
        Pedido instance = new Pedido();
        try {
        instance.setId_pedido(id_pedido);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getMonto_pedido method, of class Pedido.
     */
    @Test
    public void testGetMonto_pedido() {
        System.out.println("getMonto_pedido");
        Pedido instance = new Pedido();
        double expResult = 0.0;
        instance.setMonto_pedido(expResult);
        double result = instance.getMonto_pedido();
        try {
        if(expResult==result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setMonto_pedido method, of class Pedido.
     */
    @Test
    public void testSetMonto_pedido() {
        System.out.println("setMonto_pedido");
        double monto_pedido = 0.0;
        Pedido instance = new Pedido();
        try {
        instance.setMonto_pedido(monto_pedido);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getFecha_pedido method, of class Pedido.
     */
    @Test
    public void testGetFecha_pedido() {
        System.out.println("getFecha_pedido");
        Pedido instance = new Pedido();
        String expResult = "";
        instance.setFecha_pedido(expResult);
        String result = instance.getFecha_pedido();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setFecha_pedido method, of class Pedido.
     */
    @Test
    public void testSetFecha_pedido() {
        System.out.println("setFecha_pedido");
        String fecha_pedido = "";
        Pedido instance = new Pedido();
        try {
        instance.setFecha_pedido(fecha_pedido);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getFecha_entrega method, of class Pedido.
     */
    @Test
    public void testGetFecha_entrega() {
        System.out.println("getFecha_entrega");
        Pedido instance = new Pedido();
        String expResult = "";
        instance.setFecha_entrega(expResult);
        String result = instance.getFecha_entrega();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setFecha_entrega method, of class Pedido.
     */
    @Test
    public void testSetFecha_entrega() {
        System.out.println("setFecha_entrega");
        String fecha_entrega = "";
        Pedido instance = new Pedido();
        try {
        instance.setFecha_entrega(fecha_entrega);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of isEstado method, of class Pedido.
     */
    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Pedido instance = new Pedido();
        boolean expResult = false;
        boolean result = instance.isEstado();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setEstado method, of class Pedido.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        Pedido instance = new Pedido();
        try {
        instance.setEstado(estado);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }
}
