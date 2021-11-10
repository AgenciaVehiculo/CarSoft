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
public class HistoricoPrecioVehiculosTest {
    
    public HistoricoPrecioVehiculosTest() {
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
     * Test of getId_vehiculo method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testGetId_vehiculo() {
        System.out.println("getId_vehiculo");
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        Integer expResult = null;
        Integer result = instance.getId_vehiculo();
         try {
        assertEquals(expResult, result);
         }
        catch (Exception e) {
        fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of setId_vehiculo method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testSetId_vehiculo() {
        System.out.println("setId_vehiculo");
        Integer id_vehiculo = null;
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        try {
        instance.setId_vehiculo(id_vehiculo);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getIdPrecioHistorico method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testGetIdPrecioHistorico() {
        System.out.println("getIdPrecioHistorico");
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        Integer expResult = null;
        Integer result = instance.getIdPrecioHistorico();
        try{
        assertEquals(expResult, result);
        } catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setIdPrecioHistorico method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testSetIdPrecioHistorico() {
        System.out.println("setIdPrecioHistorico");
        Integer idPrecioHistorico = null;
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        try{
        instance.setIdPrecioHistorico(idPrecioHistorico);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getFechaInicial method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testGetFechaInicial() {
        System.out.println("getFechaInicial");
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        String expResult = "";
        instance.setFechaInicial(expResult);
        String result = instance.getFechaInicial();
        try{
        assertEquals(expResult, result);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setFechaInicial method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testSetFechaInicial() {
        System.out.println("setFechaInicial");
        String fechaInicial = "";
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        try{ 
        instance.setFechaInicial(fechaInicial);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getFechaFinal method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testGetFechaFinal() {
        System.out.println("getFechaFinal");
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        String expResult = "";
        instance.setFechaFinal(expResult);
        String result = instance.getFechaFinal();
        try{
        assertEquals(expResult, result);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setFechaFinal method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testSetFechaFinal() {
        System.out.println("setFechaFinal");
        String fechaFinal = "";
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        try {
        instance.setFechaFinal(fechaFinal);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getPrecio method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        Double expResult = null;
        Double result = instance.getPrecio();
        try{
        assertEquals(expResult, result);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPrecio method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        Double precio = null;
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        try{
        instance.setPrecio(precio);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getEstado method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testGetEstado() {
        System.out.println("getEstado");
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        Boolean expResult = null;
        Boolean result = instance.getEstado();
        try{
        assertEquals(expResult, result);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setEstado method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testSetEstado() {
        System.out.println("setEstado");
        Boolean estado = null;
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        try {
        instance.setEstado(estado);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of hashCode method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testHashCode() {
        System.out.println("hashCode");
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        int expResult = 0;
        int result = instance.hashCode();
        try{
        assertEquals(expResult, result);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of equals method, of class HistoricoPrecioVehiculos.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        HistoricoPrecioVehiculos instance = new HistoricoPrecioVehiculos();
        boolean expResult = false;
        boolean result = instance.equals(object);
        try{
        assertEquals(expResult, result);
        } catch (Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of toString method, of class HistoricoPrecioVehiculos.
     */

    
}
