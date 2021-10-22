/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class Detalle_Banco_ClienteTest {
    
    public Detalle_Banco_ClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isEstado method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        boolean expResult = false;
        instance.setEstado(expResult);
        boolean result = instance.isEstado();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setEstado method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean estado = false;
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        try{
        instance.setEstado(estado);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getNumero_prestamo method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testGetNumero_prestamo() {
        System.out.println("getNumero_prestamo");
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        int expResult = 0;
        instance.setNumero_prestamo(0);
        int result = instance.getNumero_prestamo();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setNumero_prestamo method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testSetNumero_prestamo() {
        System.out.println("setNumero_prestamo");
        int numero_prestamo = 0;
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        try{
        instance.setNumero_prestamo(numero_prestamo);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getId_banco method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testGetId_banco() {
        System.out.println("getId_banco");
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        int expResult = 0;
        instance.setId_banco(expResult);
        int result = instance.getId_banco();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setId_banco method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testSetId_banco() {
        System.out.println("setId_banco");
        int id_banco = 0;
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        try{
        instance.setId_banco(id_banco);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getId_cliente method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testGetId_cliente() {
        System.out.println("getId_cliente");
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        int expResult = 0;
        instance.setId_cliente(expResult);
        int result = instance.getId_cliente();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setId_cliente method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testSetId_cliente() {
        System.out.println("setId_cliente");
        int Id_cliente = 0;
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        try{
        instance.setId_cliente(Id_cliente);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getMonto_prestamo method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testGetMonto_prestamo() {
        System.out.println("getMonto_prestamo");
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        double expResult = 0.0;
        instance.setMonto_prestamo(expResult);
        double result = instance.getMonto_prestamo();
        
        try{
        assertEquals(expResult, result, 0.0);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setMonto_prestamo method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testSetMonto_prestamo() {
        System.out.println("setMonto_prestamo");
        double monto_prestamo = 0.0;
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        try{
        instance.setMonto_prestamo(monto_prestamo);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getCuota method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testGetCuota() {
        System.out.println("getCuota");
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        int expResult = 0;
        instance.setCuota(0);
        int result = instance.getCuota();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setCuota method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testSetCuota() {
        System.out.println("setCuota");
        int cuota = 0;
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        try{
        instance.setCuota(cuota);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getValor_interes method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testGetValor_interes() {
        System.out.println("getValor_interes");
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        double expResult = 0.0;
        instance.setValor_interes(expResult);
        double result = instance.getValor_interes();
        try{
        assertEquals(expResult, result, 0.0);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setValor_interes method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testSetValor_interes() {
        System.out.println("setValor_interes");
        double valor_interes = 0.0;
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        try{
        instance.setValor_interes(valor_interes);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getTasa_interes method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testGetTasa_interes() {
        System.out.println("getTasa_interes");
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        double expResult = 0.0;
        instance.setTasa_interes(expResult);
        double result = instance.getTasa_interes();
        try{
        assertEquals(expResult, result, 0.0);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setTasa_interes method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testSetTasa_interes() {
        System.out.println("setTasa_interes");
        double tasa_interes = 0.0;
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        try{
        instance.setTasa_interes(tasa_interes);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getValor_capital method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testGetValor_capital() {
        System.out.println("getValor_capital");
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        double expResult = 0.0;
        instance.setValor_capital(expResult);
        double result = instance.getValor_capital();
        try{
        assertEquals(expResult, result, 0.0);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setValor_capital method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testSetValor_capital() {
        System.out.println("setValor_capital");
        double valor_capital = 0.0;
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        try{
        instance.setValor_capital(valor_capital);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getFecha_inicio method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testGetFecha_inicio() {
        System.out.println("getFecha_inicio");
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        String expResult = "";
        instance.setFecha_inicio(expResult);
        String result = instance.getFecha_inicio();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setFecha_inicio method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testSetFecha_inicio() {
        System.out.println("setFecha_inicio");
        String fecha_inicio = "";
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        try{
        instance.setFecha_inicio(fecha_inicio);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getFecha_final method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testGetFecha_final() {
        System.out.println("getFecha_final");
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        String expResult = "";
        instance.setFecha_final(expResult);
        String result = instance.getFecha_final();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}


    /**
     * Test of setFecha_final method, of class Detalle_Banco_Cliente.
     */
    @Test
    public void testSetFecha_final() {
        System.out.println("setFecha_final");
        String fecha_final = "";
        Detalle_Banco_Cliente instance = new Detalle_Banco_Cliente();
        try{
        instance.setFecha_final(fecha_final);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    
}
