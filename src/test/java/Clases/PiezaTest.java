/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class PiezaTest {
    
    public PiezaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetId_Pieza() {
        System.out.println("getId_Pieza");
        Pieza instance = new Pieza();
        int expResult = 0;
        int result = instance.getId_Pieza();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId_Pieza() {
        System.out.println("setId_Pieza");
        int id_Pieza = 0;
        Pieza instance = new Pieza();
        try {
        instance.setId_Pieza(id_Pieza);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetId_Tipo_Pieza() {
        System.out.println("getId_Tipo_Pieza");
        Pieza instance = new Pieza();
        int expResult = 0;
        int result = instance.getId_Tipo_Pieza();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId_Tipo_Pieza() {
        System.out.println("setId_Tipo_Pieza");
        int id_Tipo_Pieza = 0;
        Pieza instance = new Pieza();
        try {
        instance.setId_Tipo_Pieza(id_Tipo_Pieza);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Pieza instance = new Pieza();
        try {
            instance.getNombre();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        Pieza instance = new Pieza();       
        String expResult = "";
        instance.setNombre(expResult);
        String result = instance.getNombre();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetCarateristica_Pieza() {
        System.out.println("getCarateristica_Pieza");
        Pieza instance = new Pieza();
        String expResult = "";
        instance.setCarateristica_Pieza(expResult);
        String result = instance.getCarateristica_Pieza();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetCarateristica_Pieza() {
        System.out.println("setCarateristica_Pieza");
        String carateristica_Pieza = "";
        Pieza instance = new Pieza();
        try {
        instance.setCarateristica_Pieza(carateristica_Pieza);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetStock() {
        System.out.println("getStock");
        Pieza instance = new Pieza();
        int expResult = 0;
        int result = instance.getStock();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetStock() {
        System.out.println("setStock");
        int stock = 0;
        Pieza instance = new Pieza();
        try {
        instance.setStock(stock);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetStock_Minimo() {
        System.out.println("getStock_Minimo");
        Pieza instance = new Pieza();
        int expResult = 0;
        int result = instance.getStock_Minimo();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetStock_Minimo() {
        System.out.println("setStock_Minimo");
        int stock_Minimo = 0;
        Pieza instance = new Pieza();
        try {
        instance.setStock_Minimo(stock_Minimo);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetStock_Maximo() {
        System.out.println("getStock_Maximo");
        Pieza instance = new Pieza();
        int expResult = 0;
        int result = instance.getStock_Maximo();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetStock_Maximo() {
        System.out.println("setStock_Maximo");
        int stock_Maximo = 0;
        Pieza instance = new Pieza();
        try {
        instance.setStock_Maximo(stock_Maximo);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Pieza instance = new Pieza();
        boolean expResult = false;
        boolean result = instance.isEstado();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        Pieza instance = new Pieza();
        try {
        instance.setEstado(estado);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
