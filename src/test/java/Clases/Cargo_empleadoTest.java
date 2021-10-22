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
public class Cargo_empleadoTest {
    
    public Cargo_empleadoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetId_cargo() {
        System.out.println("getId_cargo");
        Cargo_empleado instance = new Cargo_empleado();
        int expResult = 0;
        int result = instance.getId_cargo();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId_cargo() {
        System.out.println("setId_cargo");
        int id_cargo =0;
        Cargo_empleado instance = new Cargo_empleado();
        try {
        instance.setId_cargo(id_cargo);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetCargo() {
        System.out.println("Cargo");
        Cargo_empleado instance = new Cargo_empleado();
        String expResult = "";
        instance.setCargo(expResult);
        String result = instance.getCargo();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetCargo() {
        System.out.println("setCargo");
        String cargo = "";
        Cargo_empleado instance = new Cargo_empleado();
        try {
        instance.setCargo(cargo);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Cargo_empleado instance = new Cargo_empleado();
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
        Cargo_empleado instance = new Cargo_empleado();
        try {
        instance.setEstado(estado);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
