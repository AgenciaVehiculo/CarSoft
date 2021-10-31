/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import JPAController.EmpleadoJpaController;
import JPAController.PiezaJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class EmpleadoTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    EmpleadoJpaController EmpleadoDao = new EmpleadoJpaController(emf);
    public EmpleadoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetId_Empleado() {
        System.out.println("getId_Empleado");
        Empleado instance = new Empleado();
        int expResult = 0;
        int result = instance.getId_Empleado();
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId_Empleado() {
        System.out.println("setId_Empleado");
        int id_Empleado = 0;
        Empleado instance = new Empleado();
        try {
        instance.setId_Empleado(id_Empleado);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
    }

    @Test
    public void testGetId_Persona() {
        System.out.println("getId_Persona");
        Empleado instance = new Empleado();
        int expResult = 0;
        int result = instance.getId_Persona();
        try {
        assertEquals(expResult, result);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
    }

    @Test
    public void testSetId_Persona() {
        System.out.println("setId_Persona");
        int id_Persona = 0;
        Empleado instance = new Empleado();
        try {
        instance.setId_Persona(id_Persona);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
    }

    @Test
    public void testGetFecha_ingreso() {
        System.out.println("Fecha_ingreso");
        Empleado instance = new Empleado();
        String expResult = "";
        instance.setFecha_ingreso(expResult);
        String result = instance.getFecha_ingreso();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetFecha_ingreso() {
        System.out.println("setFecha_ingreso");
        String fecha_ingreso = "";
        Empleado instance = new Empleado();
        try {
        instance.setFecha_ingreso(fecha_ingreso);
         } catch (Exception e) {
        fail("The test case is a prototype.");
         }
    }

    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Empleado instance = new Empleado();
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
        Empleado instance = new Empleado();
        try {
        instance.setEstado(estado);
         } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
