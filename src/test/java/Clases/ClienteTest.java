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
public class ClienteTest {
    
    public ClienteTest() {
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
     * Test of getId_cliente method, of class Cliente.
     */
    @Test
    public void testGetId_cliente() {
        System.out.println("getId_cliente");
        Cliente instance = new Cliente();
        int expResult = 0;
        int result = instance.getId_cliente();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
        
    }
    

    /**
     * Test of setId_cliente method, of class Cliente.
     */
    @Test
    public void testSetId_cliente() {
        System.out.println("setId_cliente");
        int id_cliente = 0;
        Cliente instance = new Cliente();
        try {
        instance.setId_cliente(id_cliente);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }
    

    /**
     * Test of getId_Persona method, of class Cliente.
     */
    @Test
    public void testGetId_Persona() {
        System.out.println("getId_Persona");
        Cliente instance = new Cliente();
        int expResult = 0;
        int result = instance.getId_Persona();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_Persona method, of class Cliente.
     */
    @Test
    public void testSetId_Persona() {
        System.out.println("setId_Persona");
        int id_Persona = 0;
        Cliente instance = new Cliente();
        try {
        instance.setId_Persona(id_Persona);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getFecha_ingreso_sistema method, of class Cliente.
     */
    @Test
    public void testGetFecha_ingreso_sistema() {
        System.out.println("getFecha_ingreso_sistema");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getFecha_ingreso_sistema();
        try {
            instance.getFecha_ingreso_sistema();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }
    
    

    /**
     * Test of setFecha_ingreso_sistema method, of class Cliente.
     */
    @Test
    public void testSetFecha_ingreso_sistema() {
        System.out.println("setFecha_ingreso_sistema");
        String fecha_ingreso_sistema = "";
        Cliente instance = new Cliente();
        try {
        instance.setFecha_ingreso_sistema(fecha_ingreso_sistema);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
    }

    /**
     * Test of isEstado method, of class Cliente.
     */
    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Cliente instance = new Cliente();
        boolean expResult = false;
        boolean result = instance.isEstado();
        try {
        assertEquals(expResult, result);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
    }

    /**
     * Test of setEstado method, of class Cliente.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        Cliente instance = new Cliente();
        try {
        instance.setEstado(estado);
         } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
