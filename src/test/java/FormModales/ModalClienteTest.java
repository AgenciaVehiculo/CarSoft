/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormModales;

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
public class ModalClienteTest {
    
    public ModalClienteTest() {
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
     * Test of getId method, of class ModalCliente.
     */
    @Test
    public void testBuscarClienteTest() {
        System.out.println("BuscarClienteTest");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalCliente instance =new ModalCliente(parent,true);
        boolean expResult = true;
        instance.txtNombreBusqueda.setText("Consumidor Final");
        boolean result = instance.BuscarClienteTest();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    @Test
    public void testGetId() {
        System.out.println("getId");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalCliente instance =new ModalCliente(parent,true);
        int expResult = 0;
        int result = instance.getId();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getNombre method, of class ModalCliente.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalCliente instance =new ModalCliente(parent,true);
        String expResult = "";
        String result = instance.getNombre();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getApellido method, of class ModalCliente.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalCliente instance =new ModalCliente(parent,true);
        String expResult = "";
        String result = instance.getApellido();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        java.awt.Frame parent = new java.awt.Frame ();
        ModalCliente instance =new ModalCliente(parent,true);
        instance.setId(id);
        try {
        instance.setId(id);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        } 
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        java.awt.Frame parent = new java.awt.Frame ();
        ModalCliente instance =new ModalCliente(parent,true);
        try {
        instance.setNombre(nombre);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "";
        java.awt.Frame parent = new java.awt.Frame ();
        ModalCliente instance =new ModalCliente(parent,true);
        try {
        instance.setApellido(apellido);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
