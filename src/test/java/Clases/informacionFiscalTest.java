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
public class informacionFiscalTest {
    
    public informacionFiscalTest() {
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
     * Test of getInicio method, of class informacionFiscal.
     */
    @Test
    public void testGetInicio() {
        System.out.println("getInicio");
        informacionFiscal instance = new informacionFiscal();
        String expResult = "";
        instance.setInicio(expResult);
        String result = instance.getInicio();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getActual method, of class informacionFiscal.
     */
    @Test
    public void testGetActual() {
        System.out.println("getActual");
        informacionFiscal instance = new informacionFiscal();
        String expResult = "";
        instance.setActual(expResult);
        String result = instance.getActual();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setActual method, of class informacionFiscal.
     */
    @Test
    public void testSetActual() {
        System.out.println("setActual");
        String actual = "";
        informacionFiscal instance = new informacionFiscal();
        try{
        instance.setActual(actual);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of isEstado method, of class informacionFiscal.
     */
    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        informacionFiscal instance = new informacionFiscal();
        boolean expResult = false;
        boolean result = instance.isEstado();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setEstado method, of class informacionFiscal.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        informacionFiscal instance = new informacionFiscal();
        try{
        instance.setEstado(estado);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setInicio method, of class informacionFiscal.
     */
    @Test
    public void testSetInicio() {
        System.out.println("setInicio");
        String inicio = "";
        informacionFiscal instance = new informacionFiscal();
        try{
        instance.setInicio(inicio);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getFin method, of class informacionFiscal.
     */
    @Test
    public void testGetFin() {
        System.out.println("getFin");
        informacionFiscal instance = new informacionFiscal();
        String expResult = "";
        instance.setFin(expResult);
        String result = instance.getFin();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setFin method, of class informacionFiscal.
     */
    @Test
    public void testSetFin() {
        System.out.println("setFin");
        String fin = "";
        informacionFiscal instance = new informacionFiscal();
        try{
        instance.setFin(fin);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getIdInf method, of class informacionFiscal.
     */
    @Test
    public void testGetIdInf() {
        System.out.println("getIdInf");
        informacionFiscal instance = new informacionFiscal();
        int expResult = 0;
        instance.setIdInf(0);
        int result = instance.getIdInf();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setIdInf method, of class informacionFiscal.
     */
    @Test
    public void testSetIdInf() {
        System.out.println("setIdInf");
        int idInf = 0;
        informacionFiscal instance = new informacionFiscal();
        try{
        instance.setIdInf(idInf);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getCai method, of class informacionFiscal.
     */
    @Test
    public void testGetCai() {
        System.out.println("getCai");
        informacionFiscal instance = new informacionFiscal();
        String expResult = "";
        instance.setCai(expResult);
        String result = instance.getCai();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setCai method, of class informacionFiscal.
     */
    @Test
    public void testSetCai() {
        System.out.println("setCai");
        String cai = "";
        informacionFiscal instance = new informacionFiscal();
        try{
        instance.setCai(cai);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getFechaInicio method, of class informacionFiscal.
     */
    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        informacionFiscal instance = new informacionFiscal();
        String expResult = "";
        instance.setFechaInicio(expResult);
        String result = instance.getFechaInicio();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setFechaInicio method, of class informacionFiscal.
     */
    @Test
    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        String fechaInicio = "";
        informacionFiscal instance = new informacionFiscal();
        try{
        instance.setFechaInicio(fechaInicio);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getFechaFinal method, of class informacionFiscal.
     */
    @Test
    public void testGetFechaFinal() {
        System.out.println("getFechaFinal");
        informacionFiscal instance = new informacionFiscal();
        String expResult = "";
        instance.setFechaFinal(expResult);
        String result = instance.getFechaFinal();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setFechaFinal method, of class informacionFiscal.
     */
    @Test
    public void testSetFechaFinal() {
        System.out.println("setFechaFinal");
        String fechaFinal = "";
        informacionFiscal instance = new informacionFiscal();
        try{
        instance.setFechaFinal(fechaFinal);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    
}
