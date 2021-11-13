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
 * @author neos9
 */
public class TipoCabinaTest {
    
    public TipoCabinaTest() {
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
     * Test of getIdTipoCabina method, of class TipoCabina.
     */
    @org.junit.Test
    public void testGetIdTipoCabina() {
        System.out.println("getIdTipoCabina");
        TipoCabina instance = new TipoCabina();
        int expResult = 0;
        int result = instance.getIdTipoCabina();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setIdTipoCabina method, of class TipoCabina.
     */
    @org.junit.Test
    public void testSetIdTipoCabina() {
        System.out.println("setIdTipoCabina");
        int idTipoCabina = 0;
        TipoCabina instance = new TipoCabina();
        try{
        instance.setIdTipoCabina(idTipoCabina);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTipoCabina method, of class TipoCabina.
     */
    @org.junit.Test
    public void testGetTipoCabina() {
        System.out.println("getTipoCabina");
        TipoCabina instance = new TipoCabina();
        String expResult = "";
        instance.setTipoCabina(expResult);
        String result = instance.getTipoCabina();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setTipoCabina method, of class TipoCabina.
     */
    @org.junit.Test
    public void testSetTipoCabina() {
        System.out.println("setTipoCabina");
        String tipoCabina = "";
        TipoCabina instance = new TipoCabina();
        try{
        instance.setTipoCabina(tipoCabina);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isEstado method, of class TipoCabina.
     */
    @org.junit.Test
    public void testIsEstado() {
        System.out.println("isEstado");
        TipoCabina instance = new TipoCabina();
        boolean expResult = false;
        boolean result = instance.isEstado();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setEstado method, of class TipoCabina.
     */
    @org.junit.Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        TipoCabina instance = new TipoCabina();
        try{
        instance.setEstado(estado);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }
    
}
