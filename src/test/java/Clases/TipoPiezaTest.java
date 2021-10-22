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
public class TipoPiezaTest {
    
    public TipoPiezaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetIDtipopieza() {
        System.out.println("getIDtipopieza");
        TipoPieza instance = new TipoPieza();
        int expResult = 0;
        int result = instance.getIDtipopieza();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetIDtipopieza() {
        System.out.println("setIDtipopieza");
        int iDtipopieza = 1;
        TipoPieza instance = new TipoPieza();
        try {
        instance.setiDtipopieza(iDtipopieza);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetTipopieza() {
        System.out.println("getTipopieza");
        TipoPieza instance = new TipoPieza();
        String expResult = "";
        instance.setTipopieza(expResult);
        String result = instance.getTipopieza();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetTipopieza() {
        System.out.println("setTipopieza");
        String tipopieza = "Repuesto";
        TipoPieza instance = new TipoPieza();
        try {
        instance.setTipopieza(tipopieza);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        TipoPieza instance = new TipoPieza();
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
        TipoPieza instance = new TipoPieza();
        try {
        instance.setEstado(estado);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

}
