/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class HistoricoSueldo_empleadoTest {
    
    public HistoricoSueldo_empleadoTest() {
    }

    @Test
    public void testGetId_sueldo() {
        System.out.println("getId_sueldo");
        HistoricoSueldo_empleado instance = new HistoricoSueldo_empleado();
        int expResult = 0;
        int result = instance.getId_sueldo();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId_sueldo() {
        System.out.println("setId_sueldo");
        int id_sueldo = 0;
        HistoricoSueldo_empleado instance = new HistoricoSueldo_empleado();
        try {
        instance.setId_sueldo(id_sueldo);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetId_empleado() {
        System.out.println("getId_empleado");
        HistoricoSueldo_empleado instance = new HistoricoSueldo_empleado();
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
        HistoricoSueldo_empleado instance = new HistoricoSueldo_empleado();
        try {
        instance.setId_empleado(id_empleado);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetFecha_inicial() {
        System.out.println("getFecha_inicial");
        HistoricoSueldo_empleado instance = new HistoricoSueldo_empleado();
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
        HistoricoSueldo_empleado instance = new HistoricoSueldo_empleado();
        try {
        instance.setFecha_inicial(fecha_inicial);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetFecha_final() {
        System.out.println("getFecha_final");
        HistoricoSueldo_empleado instance = new HistoricoSueldo_empleado();
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
        HistoricoSueldo_empleado instance = new HistoricoSueldo_empleado();
        try {
        instance.setFecha_final(fecha_final);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetSueldo() {
        System.out.println("getSueldo");
        HistoricoSueldo_empleado instance = new HistoricoSueldo_empleado();
        double expResult = 0.0;
        double result = instance.getSueldo();
        try {
        assertEquals(expResult, result, 0.0);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetSueldo() {
        System.out.println("setSueldo");
        double sueldo = 0.0;
        HistoricoSueldo_empleado instance = new HistoricoSueldo_empleado();
        try {
        instance.setSueldo(sueldo);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        HistoricoSueldo_empleado instance = new HistoricoSueldo_empleado();
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
        HistoricoSueldo_empleado instance = new HistoricoSueldo_empleado();
        try {
        instance.setEstado(estado);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
