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
public class PersonaTest {
    
    public PersonaTest() {
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
     * Test of getId_persona method, of class Persona.
     */
    @Test
    public void testGetId_persona() {
        System.out.println("getId_persona");
        Persona instance = new Persona();
        int expResult = 0;
        int result = instance.getId_persona();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_persona method, of class Persona.
     */
    @Test
    public void testSetId_persona() {
        System.out.println("setId_persona");
        int id_persona = 0;
        Persona instance = new Persona();
        try {
        instance.setId_persona(id_persona);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getNombre method, of class Persona.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Persona instance = new Persona();
        String expResult = "";
        instance.setNombre(expResult);
        String result = instance.getNombre();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of setNombre method, of class Persona.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String Nombre = "";
        Persona instance = new Persona();
        try {
        instance.setNombre(Nombre);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getApellido method, of class Persona.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        Persona instance = new Persona();
        String expResult = "";
        instance.setApellido(expResult);
        String result = instance.getApellido();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of setApellido method, of class Persona.
     */
    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String Apellido = "";
        Persona instance = new Persona();
        try {
        instance.setApellido(Apellido);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getTelefono method, of class Persona.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        Persona instance = new Persona();
        String expResult = "";
        instance.setTelefono(expResult);
        String result = instance.getTelefono();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of setTelefono method, of class Persona.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "";
        Persona instance = new Persona();
        try {
        instance.setApellido(telefono);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getDireccion method, of class Persona.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Persona instance = new Persona();
        String expResult = "";
        instance.setDireccion(expResult);
        String result = instance.getDireccion();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of setDireccion method, of class Persona.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "";
        Persona instance = new Persona();
        try {
        instance.setApellido(direccion);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getCorreo_electroncio method, of class Persona.
     */
    @Test
    public void testGetCorreo_electroncio() {
        System.out.println("getCorreo_electroncio");
        Persona instance = new Persona();
        String expResult = "";
        instance.setCorreo_electroncio(expResult);
        String result = instance.getCorreo_electroncio();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of setCorreo_electroncio method, of class Persona.
     */
    @Test
    public void testSetCorreo_electroncio() {
        System.out.println("setCorreo_electroncio");
        String correo_electroncio = "";
        Persona instance = new Persona();
        try {
        instance.setCorreo_electroncio(correo_electroncio);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getID_tipo_documento method, of class Persona.
     */
    @Test
    public void testGetID_tipo_documento() {
        System.out.println("getID_tipo_documento");
        Persona instance = new Persona();
        int expResult = 0;
        int result = instance.getID_tipo_documento();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of setID_tipo_documento method, of class Persona.
     */
    @Test
    public void testSetID_tipo_documento() {
        System.out.println("setID_tipo_documento");
        int ID_tipo_documento = 0;
        Persona instance = new Persona();
        try {
        instance.setID_tipo_documento(ID_tipo_documento);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getDocumento_id method, of class Persona.
     */
    @Test
    public void testGetDocumento_id() {
        System.out.println("getDocumento_id");
        Persona instance = new Persona();
        String expResult = "";
        instance.setDocumento_id(expResult);
        String result = instance.getDocumento_id();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of setDocumento_id method, of class Persona.
     */
    @Test
    public void testSetDocumento_id() {
        System.out.println("setDocumento_id");
        String documento_id = "";
        Persona instance = new Persona();
        try {
        instance.setDocumento_id(documento_id);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }
}
