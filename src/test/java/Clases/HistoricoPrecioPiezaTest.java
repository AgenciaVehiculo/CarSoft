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
public class HistoricoPrecioPiezaTest {
    
    public HistoricoPrecioPiezaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetIdPieza() {
        System.out.println("getIdPieza");
        HistoricoPrecioPieza instance = new HistoricoPrecioPieza();
        int expResult = 0;
        int result = instance.getIdPieza();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetIdPieza() {
        System.out.println("setIdPieza");
        int idPieza = 0;
        HistoricoPrecioPieza instance = new HistoricoPrecioPieza();
        try {
        instance.setIdPieza(idPieza);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetIdPrecioHistorico() {
        System.out.println("getIdPrecioHistorico");
        HistoricoPrecioPieza instance = new HistoricoPrecioPieza();
        int expResult = 0;
        int result = instance.getIdPrecioHistorico();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetIdPrecioHistorico() {
        System.out.println("setIdPrecioHistorico");
        int idPrecioHistorico = 0;
        HistoricoPrecioPieza instance = new HistoricoPrecioPieza();
        try {
        instance.setIdPrecioHistorico(idPrecioHistorico);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetFechaInicial() {
        System.out.println("getFechaInicial");
        HistoricoPrecioPieza instance = new HistoricoPrecioPieza();
        String expResult = "";
        instance.setFechaInicial(expResult);
        String result = instance.getFechaInicial();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetFechaInicial() {
        System.out.println("setFechaInicial");
        String fechaInicial = "";
        HistoricoPrecioPieza instance = new HistoricoPrecioPieza();
        try {
        instance.setFechaInicial(fechaInicial);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetFechaFinal() {
        System.out.println("getFechaFinal");
        HistoricoPrecioPieza instance = new HistoricoPrecioPieza();
        String expResult = "";
        instance.setFechaFinal(expResult);
        String result = instance.getFechaFinal();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetFechaFinal() {
        System.out.println("setFechaFinal");
        String fechaFinal = "";
        HistoricoPrecioPieza instance = new HistoricoPrecioPieza();
        try {
        instance.setFechaFinal(fechaFinal);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        HistoricoPrecioPieza instance = new HistoricoPrecioPieza();
        double expResult = 0.0;
        double result = instance.getPrecio();
        try {
        assertEquals(expResult, result, 0.0);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double precio = 0;
        HistoricoPrecioPieza instance = new HistoricoPrecioPieza();
        try {
        instance.setPrecio(precio);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        HistoricoPrecioPieza instance = new HistoricoPrecioPieza();
        boolean expResult = false;
        boolean result = instance.getEstado();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = true;
        HistoricoPrecioPieza instance = new HistoricoPrecioPieza();
        try {
        instance.setEstado(estado);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
