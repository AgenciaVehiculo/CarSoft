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
public class TipoGasolinaTest {
    
    public TipoGasolinaTest() {
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
     * Test of getIdTipoGasolina method, of class TipoGasolina.
     */
    @org.junit.Test
    public void testGetIdTipoGasolina() {
        System.out.println("getIdTipoGasolina");
        TipoGasolina instance = new TipoGasolina();
        int expResult = 0;
        int result = instance.getIdTipoGasolina();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setIdTipoGasolina method, of class TipoGasolina.
     */
    @org.junit.Test
    public void testSetIdTipoGasolina() {
        System.out.println("setIdTipoGasolina");
        int idTipoGasolina = 0;
        TipoGasolina instance = new TipoGasolina();
        try{
        instance.setIdTipoGasolina(idTipoGasolina);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTipoGasolina method, of class TipoGasolina.
     */
    @org.junit.Test
    public void testGetTipoGasolina() {
        System.out.println("getTipoGasolina");
        TipoGasolina instance = new TipoGasolina();
        String expResult = "";
        instance.setTipoGasolina(expResult);
        String result = instance.getTipoGasolina();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setTipoGasolina method, of class TipoGasolina.
     */
    @org.junit.Test
    public void testSetTipoGasolina() {
        System.out.println("setTipoGasolina");
        String tipoGasolina = "";
        TipoGasolina instance = new TipoGasolina();
        try{
        instance.setTipoGasolina(tipoGasolina);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isEstado method, of class TipoGasolina.
     */
    @org.junit.Test
    public void testIsEstado() {
        System.out.println("isEstado");
        TipoGasolina instance = new TipoGasolina();
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
     * Test of setEstado method, of class TipoGasolina.
     */
    @org.junit.Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        TipoGasolina instance = new TipoGasolina();
        try{
        instance.setEstado(estado);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }
    
}
