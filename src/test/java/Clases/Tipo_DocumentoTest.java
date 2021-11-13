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
public class Tipo_DocumentoTest {
    
    public Tipo_DocumentoTest() {
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
     * Test of getId_Tipo_Documento method, of class Tipo_Documento.
     */
    @Test
    public void testGetId_Tipo_Documento() {
        System.out.println("getId_Tipo_Documento");
        Tipo_Documento instance = new Tipo_Documento();
        int expResult = 0;
        int result = instance.getId_Tipo_Documento();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of setId_Tipo_Documento method, of class Tipo_Documento.
     */
    @Test
    public void testSetId_Tipo_Documento() {
        System.out.println("setId_Tipo_Documento");
        int id_Tipo_Documento = 0;
        Tipo_Documento instance = new Tipo_Documento();
        try {
        instance.setId_Tipo_Documento(id_Tipo_Documento);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of getDocumento method, of class Tipo_Documento.
     */
    @Test
    public void testGetDocumento() {
        System.out.println("getDocumento");
        Tipo_Documento instance = new Tipo_Documento();
        String expResult = "";
        instance.setDocumento(expResult);
        String result = instance.getDocumento();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of setDocumento method, of class Tipo_Documento.
     */
    @Test
    public void testSetDocumento() {
        System.out.println("setDocumento");
        String documento = "";
        Tipo_Documento instance = new Tipo_Documento();
        try {
        instance.setDocumento(documento);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
       
    }

    /**
     * Test of isEstado method, of class Tipo_Documento.
     */
    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Tipo_Documento instance = new Tipo_Documento();
        boolean expResult = false;
        boolean result = instance.isEstado();
        try {
        assertEquals(expResult, result);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
    }

    /**
     * Test of setEstado method, of class Tipo_Documento.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        Tipo_Documento instance = new Tipo_Documento();
        try {
        instance.setEstado(estado);
         } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
