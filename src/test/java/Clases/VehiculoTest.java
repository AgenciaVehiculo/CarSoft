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
public class VehiculoTest {
    
    public VehiculoTest() {
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
     * Test of getId_tipo_cabina method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetId_tipo_cabina() {
        System.out.println("getId_tipo_cabina");
        Vehiculo instance = new Vehiculo();
        int expResult = 0;
        int result = instance.getId_tipo_cabina();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_tipo_cabina method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetId_tipo_cabina() {
        System.out.println("setId_tipo_cabina");
        int id_tipo_cabina = 0;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setId_tipo_cabina(id_tipo_cabina);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
      
        fail("The test case is a prototype.");
        }
        }
    

    /**
     * Test of getId_vehiculo method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetId_vehiculo() {
        System.out.println("getId_vehiculo");
        Vehiculo instance = new Vehiculo();
        int expResult = 0;
        int result = instance.getId_vehiculo();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
}
    }

    /**
     * Test of setId_vehiculo method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetId_vehiculo() {
        System.out.println("setId_vehiculo");
        int id_vehiculo = 0;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setId_vehiculo(id_vehiculo);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getVin method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetVin() {
        System.out.println("getVin");
        Vehiculo instance = new Vehiculo();
        String expResult = "";
        instance.setVin(expResult);
        String result = instance.getVin();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setVin method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetVin() {
        System.out.println("setVin");
        String vin = "";
        Vehiculo instance = new Vehiculo();
        try{
        instance.setVin(vin);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getId_marca method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetId_marca() {
        System.out.println("getId_marca");
        Vehiculo instance = new Vehiculo();
        int expResult = 0;
        int result = instance.getId_marca();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_marca method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetId_marca() {
        System.out.println("setId_marca");
        int id_marca = 0;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setId_marca(id_marca);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getId_tipo_color method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetId_tipo_color() {
        System.out.println("getId_tipo_color");
        Vehiculo instance = new Vehiculo();
        int expResult = 0;
        int result = instance.getId_tipo_color();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_tipo_color method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetId_tipo_color() {
        System.out.println("setId_tipo_color");
        int id_tipo_color = 0;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setId_tipo_color(id_tipo_color);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getId_tipo_vehiculo method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetId_tipo_vehiculo() {
        System.out.println("getId_tipo_vehiculo");
        Vehiculo instance = new Vehiculo();
        int expResult = 0;
        int result = instance.getId_tipo_vehiculo();
        try{
        assertEquals(expResult, result);
        } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_tipo_vehiculo method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetId_tipo_vehiculo() {
        System.out.println("setId_tipo_vehiculo");
        int id_tipo_vehiculo = 0;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setId_tipo_vehiculo(id_tipo_vehiculo);
        }   catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getId_tipo_gasolina method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetId_tipo_gasolina() {
        System.out.println("getId_tipo_gasolina");
        Vehiculo instance = new Vehiculo();
        int expResult = 0;
        int result = instance.getId_tipo_gasolina();
        try{
        assertEquals(expResult, result);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_tipo_gasolina method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetId_tipo_gasolina() {
        System.out.println("setId_tipo_gasolina");
        int id_tipo_gasolina = 0;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setId_tipo_gasolina(id_tipo_gasolina);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getId_numero_asientos method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetId_numero_asientos() {
        System.out.println("getId_numero_asientos");
        Vehiculo instance = new Vehiculo();
        int expResult = 0;
        int result = instance.getId_numero_asientos();
        try{
        assertEquals(expResult, result);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_numero_asientos method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetId_numero_asientos() {
        System.out.println("setId_numero_asientos");
        int id_numero_asientos = 0;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setId_numero_asientos(id_numero_asientos);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getId_transmision method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetId_transmision() {
        System.out.println("getId_transmision");
        Vehiculo instance = new Vehiculo();
        int expResult = 0;
        int result = instance.getId_transmision();
        try{
        assertEquals(expResult, result);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId_transmision method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetId_transmision() {
        System.out.println("setId_transmision");
        int id_transmision = 0;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setId_transmision(id_transmision);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTotal_cilindraje method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetTotal_cilindraje() {
        System.out.println("getTotal_cilindraje");
        Vehiculo instance = new Vehiculo();
        double expResult = 0.0;
        double result = instance.getTotal_cilindraje();
        try{
        assertEquals(expResult, result, 0.0);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setTotal_cilindraje method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetTotal_cilindraje() {
        System.out.println("setTotal_cilindraje");
        double total_cilindraje = 0.0;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setTotal_cilindraje(total_cilindraje);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getStock method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetStock() {
        System.out.println("getStock");
        Vehiculo instance = new Vehiculo();
        int expResult = 0;
        int result = instance.getStock();
        try{
        assertEquals(expResult, result);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setStock method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetStock() {
        System.out.println("setStock");
        int Stock = 0;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setStock(Stock);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getStock_minimo method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetStock_minimo() {
        System.out.println("getStock_minimo");
        Vehiculo instance = new Vehiculo();
        int expResult = 0;
        int result = instance.getStock_minimo();
        try{
        assertEquals(expResult, result);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setStock_minimo method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetStock_minimo() {
        System.out.println("setStock_minimo");
        int Stock_minimo = 0;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setStock_minimo(Stock_minimo);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getStock_maximo method, of class Vehiculo.
     */
    @org.junit.Test
    public void testGetStock_maximo() {
        System.out.println("getStock_maximo");
        Vehiculo instance = new Vehiculo();
        int expResult = 0;
        int result = instance.getStock_maximo();
        try{
        assertEquals(expResult, result);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setStock_maximo method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetStock_maximo() {
        System.out.println("setStock_maximo");
        int Stock_maximo = 0;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setStock_maximo(Stock_maximo);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isEstado method, of class Vehiculo.
     */
    @org.junit.Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Vehiculo instance = new Vehiculo();
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
     * Test of setEstado method, of class Vehiculo.
     */
    @org.junit.Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        Vehiculo instance = new Vehiculo();
        try{
        instance.setEstado(estado);
         } catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }
    
}
