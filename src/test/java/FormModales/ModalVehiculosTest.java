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
 * @author neos9
 */
public class ModalVehiculosTest {
    
    public ModalVehiculosTest() {
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
    public void testBuscarVehiculoTest() {
        System.out.println("BuscarVehiculoTest");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalVehiculos instance =new ModalVehiculos(parent,true);
        boolean expResult = true;
        instance.chkMarca.setEnabled(true);
        instance.cmbMarcaBusqueda.setSelectedIndex(1);
        boolean result = instance.BuscarVehiculoTest();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    /**
     * Test of getId method, of class ModalVehiculos.
     */
    @org.junit.Test
    public void testGetId() {
        System.out.println("getId");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalVehiculos instance =new ModalVehiculos(parent,true);
        int expResult = 0;
        int result = instance.getId();
        try{
        assertEquals(expResult, result);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        java.awt.Frame parent = new java.awt.Frame ();
        ModalVehiculos instance =new ModalVehiculos(parent,true);
        try{
        instance.setId(id);
        } catch (Exception e){
        
        fail("The test case is a prototype.");
        }
    }
    
}
