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
public class BancoTest {
    
    public BancoTest() {
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
     * Test of getId_banco method, of class Banco.
     */
    @Test
    public void testGetId_banco() {
        System.out.println("getId_banco");
        Banco instance = new Banco();
        int expResult = 0;
        instance.setId_banco(expResult);
        int result = instance.getId_banco();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setId_banco method, of class Banco.
     */
    @Test
    public void testSetId_banco() {
        System.out.println("setId_banco");
        int id_banco = 0;
        Banco instance = new Banco();
        try{
        instance.setId_banco(id_banco);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getNombre_banco method, of class Banco.
     */
    @Test
    public void testGetNombre_banco() {
        System.out.println("getNombre_banco");
        Banco instance = new Banco();
        String expResult = "";
        instance.setNombre_banco(expResult);
        String result = instance.getNombre_banco();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    }


    /**
     * Test of setNombre_banco method, of class Banco.
     */
    @Test
    public void testSetNombre_banco() {
        System.out.println("setNombre_banco");
        String nombre_banco = "";
        Banco instance = new Banco();
        try{
        instance.setNombre_banco(nombre_banco);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getNombre_contacto method, of class Banco.
     */
    @Test
    public void testGetNombre_contacto() {
        System.out.println("getNombre_contacto");
        Banco instance = new Banco();
        String expResult = "";
        instance.setNombre_contacto(expResult);
        String result = instance.getNombre_contacto();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setNombre_contacto method, of class Banco.
     */
    @Test
    public void testSetNombre_contacto() {
        System.out.println("setNombre_contacto");
        String nombre_contacto = "";
        Banco instance = new Banco();
        try{
        instance.setNombre_contacto(nombre_contacto);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getTelefono_contacto method, of class Banco.
     */
    @Test
    public void testGetTelefono_contacto() {
        System.out.println("getTelefono_contacto");
        Banco instance = new Banco();
        String expResult = "";
        instance.setTelefono_contacto(expResult);
        String result = instance.getTelefono_contacto();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setTelefono_contacto method, of class Banco.
     */
    @Test
    public void testSetTelefono_contacto() {
        System.out.println("setTelefono_contacto");
        String telefono_contacto = "";
        Banco instance = new Banco();
        try{
        instance.setTelefono_contacto(telefono_contacto);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getCorreo_electronico method, of class Banco.
     */
    @Test
    public void testGetCorreo_electronico() {
        System.out.println("getCorreo_electronico");
        Banco instance = new Banco();
        String expResult = "";
        instance.setCorreo_electronico(expResult);
        String result = instance.getCorreo_electronico();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setCorreo_electronico method, of class Banco.
     */
    @Test
    public void testSetCorreo_electronico() {
        System.out.println("setCorreo_electronico");
        String correo_electronico = "";
        Banco instance = new Banco();
        try{
        instance.setCorreo_electronico(correo_electronico);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of isEstado method, of class Banco.
     */
    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Banco instance = new Banco();
        boolean expResult = false;
        instance.setEstado(expResult);
        boolean result = instance.isEstado();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setEstado method, of class Banco.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        Banco instance = new Banco();
        try{
        instance.setEstado(estado);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    
}
