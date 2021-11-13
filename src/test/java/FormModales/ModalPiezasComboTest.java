/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormModales;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ModalPiezasComboTest {
    
    public ModalPiezasComboTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    public void testBuscarPiezaTest() {
        System.out.println("BuscarPiezaTest");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalPiezasCombo instance =new ModalPiezasCombo(parent,true);
        boolean expResult = true;
        instance.txtNombreBusqueda.setText("Espejo");
        boolean result = instance.BuscarPiezaTest();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }

    }
    @Test
    public void testGetId() {
        System.out.println("getId");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalPiezasCombo instance =new ModalPiezasCombo(parent,true);
        int expResult = 0;
        int result = instance.getId();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalPiezasCombo instance =new ModalPiezasCombo(parent,true);
        String expResult = "";
        String result = instance.getTipo();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalPiezasCombo instance =new ModalPiezasCombo(parent,true);
        String expResult = "";
        String result = instance.getNombre();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        java.awt.Frame parent = new java.awt.Frame ();
        ModalPiezasCombo instance =new ModalPiezasCombo(parent,true);
        try {
        instance.setId(id);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        java.awt.Frame parent = new java.awt.Frame ();
        ModalPiezasCombo instance =new ModalPiezasCombo(parent,true);
        try {
        instance.setTipo(tipo);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        java.awt.Frame parent = new java.awt.Frame ();
        ModalPiezasCombo instance =new ModalPiezasCombo(parent,true);
        try {
        instance.setNombre(nombre);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
