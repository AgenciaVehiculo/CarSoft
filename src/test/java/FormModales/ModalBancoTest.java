/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormModales;

import Pantallas.FrmBanco;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ModalBancoTest {
    
    public ModalBancoTest() {
    }
    @Test
    public void testBuscarBancoTest() {
        System.out.println("BuscarBancoTest");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalBanco instance =new ModalBanco(parent,true);
        boolean expResult = true;
        instance.txtNombreBusqueda.setText("Atlantida");
        boolean result = instance.BuscarBancoTest();
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
        ModalBanco instance =new ModalBanco(parent,true);
        int expResult = 0;
        int result = instance.getId();
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
        ModalBanco instance =new ModalBanco(parent,true);
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
        ModalBanco instance =new ModalBanco(parent,true);
        try {
        instance.setId(id);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        java.awt.Frame parent = new java.awt.Frame ();
        ModalBanco instance =new ModalBanco(parent,true);
        try {
        instance.setNombre(nombre);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

}
