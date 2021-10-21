/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormModales;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ModalVehiculosComboTest {
    
    public ModalVehiculosComboTest() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalVehiculosCombo instance =new ModalVehiculosCombo(parent,true);
        int expResult = 0;
        int result = instance.getId();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetModelo() {
        System.out.println("getModelo");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalVehiculosCombo instance =new ModalVehiculosCombo(parent,true);
        String expResult = "";
        String result = instance.getModelo();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetTotalcilin() {
        System.out.println("getTotalcilin");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalVehiculosCombo instance =new ModalVehiculosCombo(parent,true);
        double expResult = 0.0;
        instance.setTotalcilin(expResult);
        double result = instance.getTotalcilin();
        try {
        assertEquals(expResult, result,0.0);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetMarca() {
        System.out.println("getMarca");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalVehiculosCombo instance =new ModalVehiculosCombo(parent,true);
        String expResult = "";
        String result = instance.getMarca();
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
        ModalVehiculosCombo instance =new ModalVehiculosCombo(parent,true);
        try {
        instance.setId(id);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetModelo() {
        System.out.println("setModelo");
        String modelo = "";
        java.awt.Frame parent = new java.awt.Frame ();
        ModalVehiculosCombo instance =new ModalVehiculosCombo(parent,true);
        try {
        instance.setModelo(modelo);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetMarca() {
        System.out.println("setMarca");
        String marca = "";
        java.awt.Frame parent = new java.awt.Frame ();
        ModalVehiculosCombo instance =new ModalVehiculosCombo(parent,true);
        try {
        instance.setMarca(marca);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetTotalcilin() {
        System.out.println("setTotalcilin");
        double totalcilin = 0.0;
        java.awt.Frame parent = new java.awt.Frame ();
        ModalVehiculosCombo instance =new ModalVehiculosCombo(parent,true);
        try {
        instance.setTotalcilin(totalcilin);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
