/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

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
public class FrmPedidosTest {
    
    public FrmPedidosTest() {
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
     * Test of btnActivarDesactivarPedido method, of class FrmPedidos.
     */
//    @Test
//    public void testBtnActivarDesactivarPedido() {
//        System.out.println("btnActivarDesactivarPedido");
//        FrmPedidos instance = new FrmPedidos();
//        instance.btnActivarDesactivarPedido();
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of createComboBoxPedido method, of class FrmPedidos.
     */
    

    /**
     * Test of createComboVehiculo method, of class FrmPedidos.
     */
 

    /**
     * Test of createComboPieza method, of class FrmPedidos.
     */
  

    /**
     * Test of createTablePedido method, of class FrmPedidos.
     */
    

    /**
     * Test of filtroPedido method, of class FrmPedidos.
     */
  

    /**
     * Test of btnDesactivarActionPerfomedTest method, of class FrmPedidos.
     */
    @Test
    public void testBtnDesactivarActionPerfomedTest() {
        System.out.println("btnDesactivarActionPerfomedTest");
        int tblPedidoget = 1;
        int tblPedido = 1;
        FrmPedidos instance = new FrmPedidos();
        int expResult = 100;
        int result = instance.btnDesactivarActionPerfomedTest(tblPedidoget, tblPedido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarPedidoTest method, of class FrmPedidos.
     */
    @Test
    public void testAgregarPedidoTest() {
        System.out.println("AgregarPedidoTest");
        int cmbIDPieza = 0;
        int cmbIDVehiculo = 0;
        FrmPedidos instance = new FrmPedidos();
        int expResult =100;
        int result = instance.AgregarPedidoTest(cmbIDPieza, cmbIDVehiculo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of ValidacionNumerosSiTienenDecimal method, of class FrmPedidos.
     */
    @Test
    public void testValidacionNumerosSiTienenDecimal() {
        System.out.println("ValidacionNumerosSiTienenDecimal");
        String num = "12.40";
        FrmPedidos instance = new FrmPedidos();
        boolean expResult = true;
        boolean result = instance.ValidacionNumerosSiTienenDecimal(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ValidacionNumerosDecimales method, of class FrmPedidos.
     */
    @Test
    public void testValidacionNumerosDecimales() {
        System.out.println("ValidacionNumerosDecimales");
        String num = "15.50";
        FrmPedidos instance = new FrmPedidos();
        boolean expResult = true;
        boolean result = instance.ValidacionNumerosDecimales(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of ValidacionNumeros method, of class FrmPedidos.
     */
    @Test
    public void testValidacionNumeros() {
        System.out.println("ValidacionNumeros");
        String num = "5";
        FrmPedidos instance = new FrmPedidos();
        boolean expResult = true;
        boolean result = instance.ValidacionNumeros(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of ValidacionFechaDDMMYYYY method, of class FrmPedidos.
     */
    @Test
    public void testValidacionFechaDDMMYYYY() {
        System.out.println("ValidacionFechaDDMMYYYY");
        String num = "18/10/2021";
        FrmPedidos instance = new FrmPedidos();
        boolean expResult = true;
        boolean result = instance.ValidacionFechaDDMMYYYY(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of ValidacionRangoPrecioPieza method, of class FrmPedidos.
     */
    @Test
    public void testValidacionRangoPrecioPieza() {
        System.out.println("ValidacionRangoPrecioPieza");
        String num = "100.00";
        FrmPedidos instance = new FrmPedidos();
        boolean expResult = true;
        boolean result = instance.ValidacionRangoPrecioPieza(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of ValidacionRangoPrecioVehiculo method, of class FrmPedidos.
     */
    @Test
    public void testValidacionRangoPrecioVehiculo() {
        System.out.println("ValidacionRangoPrecioVehiculo");
        String num = "300,000.00";
        FrmPedidos instance = new FrmPedidos();
        boolean expResult = true;
        boolean result = instance.ValidacionRangoPrecioVehiculo(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of ValidacionCantidadVehiculos method, of class FrmPedidos.
     */
    @Test
    public void testValidacionCantidadVehiculos() {
        System.out.println("ValidacionCantidadVehiculos");
        String num = "2";
        FrmPedidos instance = new FrmPedidos();
        boolean expResult = true;
        boolean result = instance.ValidacionCantidadVehiculos(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of ValidacionCantidadPiezas method, of class FrmPedidos.
     */
    @Test
    public void testValidacionCantidadPiezas() {
        System.out.println("ValidacionCantidadPiezas");
        String num = "10";
        FrmPedidos instance = new FrmPedidos();
        boolean expResult = true;
        boolean result = instance.ValidacionCantidadPiezas(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarVehiculo method, of class FrmPedidos.
     */


    /**
     * Test of BuscarPieza method, of class FrmPedidos.
     */
   

    /**
     * Test of txtPedidoListaBusqueda method, of class FrmPedidos.
     */
  
}
