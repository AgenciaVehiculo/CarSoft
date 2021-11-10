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
public class ModalEmpleadoTest {
    
    
    public void ModalEmpleadoTest() {
        
    }
    @Test
    public void testBuscarEmpleadoTest() {
        System.out.println("BuscarEmpleadoTest");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalEmpleado instance =new ModalEmpleado(parent,true);
        boolean expResult = true;
        instance.txtNombreBusqueda.setText("Ariel Alejandro Benitez Ruiz");
        boolean result = instance.BuscarEmpleadoTest();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }


    @Test
    public void testGetId() {
        java.awt.Frame parent = new java.awt.Frame ();
        ModalEmpleado instance =new ModalEmpleado(parent,true);
        System.out.println("getId");
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
        ModalEmpleado instance =new ModalEmpleado(parent,true);
        String expResult = "";
        instance.setNombre(expResult);
        String result = instance.getNombre();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        } 
    }

    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalEmpleado instance =new ModalEmpleado(parent,true);
        String expResult = "";
        instance.setApellido(expResult);
        String result = instance.getApellido();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        } 
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        java.awt.Frame parent = new java.awt.Frame ();
        ModalEmpleado instance =new ModalEmpleado(parent,true);
        instance.setId(id);
        try {
        instance.setId(id);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        } 
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        java.awt.Frame parent = new java.awt.Frame ();
        ModalEmpleado instance =new ModalEmpleado(parent,true);
        try {
        instance.setNombre(nombre);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "";
        java.awt.Frame parent = new java.awt.Frame ();
        ModalEmpleado instance =new ModalEmpleado(parent,true);
        try {
        instance.setApellido(apellido);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
