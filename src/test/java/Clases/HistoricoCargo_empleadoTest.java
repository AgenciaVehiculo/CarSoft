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
public class HistoricoCargo_empleadoTest {
    
    public HistoricoCargo_empleadoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetId_cargo_historico() {
        System.out.println("getId_cargo_historico");
        HistoricoCargo_empleado instance = new HistoricoCargo_empleado();
        int expResult = 0;
        int result = instance.getId_cargo_historico();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId_cargo_historico() {
        System.out.println("setId_cargo_historico");
        int id_cargo_historico = 0;
        HistoricoCargo_empleado instance = new HistoricoCargo_empleado();
        try {
        instance.setId_cargo_historico(id_cargo_historico);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetId_empleado() {
        System.out.println("getId_empleado");
        HistoricoCargo_empleado instance = new HistoricoCargo_empleado();
        int expResult = 0;
        int result = instance.getId_empleado();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId_empleado() {
        System.out.println("setId_empleado");
        int id_empleado = 0;
        HistoricoCargo_empleado instance = new HistoricoCargo_empleado();
        try {
        instance.setId_empleado(id_empleado);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetFecha_inicial() {
        System.out.println("getFecha_inicial");
        HistoricoCargo_empleado instance = new HistoricoCargo_empleado();
        String expResult = "";
        instance.setFecha_inicial(expResult);
        String result = instance.getFecha_inicial();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetFecha_inicial() {
        System.out.println("setFecha_inicial");
        String fecha_inicial = "";
        HistoricoCargo_empleado instance = new HistoricoCargo_empleado();
        try {
        instance.setFecha_inicial(fecha_inicial);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetFecha_final() {
        System.out.println("getFecha_final");
        HistoricoCargo_empleado instance = new HistoricoCargo_empleado();
        String expResult = "";
        instance.setFecha_final(expResult);
        String result = instance.getFecha_final();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetFecha_final() {
        System.out.println("setFecha_final");
        String fecha_final = "";
        HistoricoCargo_empleado instance = new HistoricoCargo_empleado();
        try {
        instance.setFecha_final(fecha_final);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetId_cargo() {
        System.out.println("getId_cargo");
        HistoricoCargo_empleado instance = new HistoricoCargo_empleado();
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
        int id_cargo = 0;
        HistoricoCargo_empleado instance = new HistoricoCargo_empleado();
        try {
        instance.setId_cargo(id_cargo);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        HistoricoCargo_empleado instance = new HistoricoCargo_empleado();
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
        HistoricoCargo_empleado instance = new HistoricoCargo_empleado();
        try {
        instance.setEstado(estado);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
