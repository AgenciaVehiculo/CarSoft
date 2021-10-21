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
public class ValidacionesTest {
    
    public ValidacionesTest() {
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
     * Test of validacionTresLetras method, of class Validaciones.
     */
    @Test
    public void testValidacionTresLetras() {
        System.out.println("validacionTresLetras");
        String aux = "";
        Validaciones instance = new Validaciones();
        boolean expResult = false;
        boolean result = instance.validacionTresLetras(aux);
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of validacionTarjetas method, of class Validaciones.
     */
    @Test
    public void testValidacionTarjetas() {
        System.out.println("validacionTarjetas");
        String texto = "";
        boolean expResult = false;
        boolean result = Validaciones.validacionTarjetas(texto);
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of validacionDecimales method, of class Validaciones.
     */
    @Test
    public void testValidacionDecimales() {
        System.out.println("validacionDecimales");
        String texto = "";
        boolean expResult = true;
        boolean result = Validaciones.validacionDecimales(texto);
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of ValidacionNombreMayusculaYDemasMinus method, of class Validaciones.
     */
    @Test
    public void testValidacionNombreMayusculaYDemasMinus() {
        System.out.println("ValidacionNombreMayusculaYDemasMinus");
        String num = "";
        boolean expResult = false;
        boolean result = Validaciones.ValidacionNombreMayusculaYDemasMinus(num);
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
