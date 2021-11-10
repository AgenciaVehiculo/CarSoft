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
public class TipoVehiculoTest {
    
    public TipoVehiculoTest() {
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
     * Test of getIdTipoVehiculo method, of class TipoVehiculo.
     */
    @org.junit.Test
    public void testGetIdTipoVehiculo() {
        System.out.println("getIdTipoVehiculo");
        TipoVehiculo instance = new TipoVehiculo();
        int expResult = 0;
        int result = instance.getIdTipoVehiculo();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setIdTipoVehiculo method, of class TipoVehiculo.
     */
    @org.junit.Test
    public void testSetIdTipoVehiculo() {
        System.out.println("setIdTipoVehiculo");
        int idTipoVehiculo = 0;
        TipoVehiculo instance = new TipoVehiculo();
        try{
        instance.setIdTipoVehiculo(idTipoVehiculo);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTipoVehiculo method, of class TipoVehiculo.
     */
    @org.junit.Test
    public void testGetTipoVehiculo() {
        System.out.println("getTipoVehiculo");
        TipoVehiculo instance = new TipoVehiculo();
        String expResult = "";
        instance.setTipoVehiculo(expResult);
        String result = instance.getTipoVehiculo();
        try{
        assertEquals(expResult, result);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setTipoVehiculo method, of class TipoVehiculo.
     */
    @org.junit.Test
    public void testSetTipoVehiculo() {
        System.out.println("setTipoVehiculo");
        String tipoVehiculo = "";
        TipoVehiculo instance = new TipoVehiculo();
        try{
        instance.setTipoVehiculo(tipoVehiculo);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isEstado method, of class TipoVehiculo.
     */
    @org.junit.Test
    public void testIsEstado() {
        System.out.println("isEstado");
        TipoVehiculo instance = new TipoVehiculo();
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
     * Test of setEstado method, of class TipoVehiculo.
     */
    @org.junit.Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        TipoVehiculo instance = new TipoVehiculo();
        try{
        instance.setEstado(estado);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }
    
}
