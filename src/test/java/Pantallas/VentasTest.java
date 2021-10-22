/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Factura;
import JPAController.FacturaJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class VentasTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    public VentasTest() {
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
     * Test of btnActivarDesactivar method, of class Ventas.
     */
//    @Test
//    public void testBtnActivarDesactivar() {
//        System.out.println("btnActivarDesactivar");
//        Ventas instance = new Ventas();
//        instance.btnActivarDesactivar();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of imprimirFacturaBusquedaTest method, of class Ventas.
     */
    @Test
    public void testImprimirFacturaBusquedaTest() throws Exception {
        System.out.println("imprimirFacturaBusquedaTest");
        Factura f = new FacturaJpaController(emf).findFactura(1);
        Ventas instance;
        instance = new Ventas();
        instance.setVisible(false);
        int expResult = 100;
        int result = instance.imprimirFacturaBusquedaTest(f);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of btnImprimirFacturaActionPerfomedTest method, of class Ventas.
     */
    @Test
    public void testBtnImprimirFacturaActionPerfomedTest() {
        System.out.println("btnImprimirFacturaActionPerfomedTest");
        int cmbIDEmpleado = 1;
        String cmbTipoPago = "Efectivo";
        String txtDocumentoCliente = "9999999999999";
        int cmbTipoFacturaVenta = 1;
        Ventas instance = new Ventas();
        int expResult = 100;
        int result = instance.btnImprimirFacturaActionPerfomedTest(cmbIDEmpleado, cmbTipoPago, txtDocumentoCliente, cmbTipoFacturaVenta);
        try{
            assertEquals(expResult, result);
        }catch(Exception e){
            fail("The test case failed");
    }}

    /**
     * Test of imprimirFacturaVentaTest method, of class Ventas.
     */
    @Test
    public void testImprimirFacturaVentaTest() throws Exception {
        System.out.println("imprimirFacturaVentaTest");
        Object[] algo = new Object[]{"","","","",""};
        Ventas instance = new Ventas();
        int expResult = 100;
        int result = instance.imprimirFacturaVentaTest(algo);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
            e.printStackTrace();
    }}

    /**
     * Test of imprimirFacturaVenta method, of class Ventas.
     */
//    @Test
//    public void testImprimirFacturaVenta() throws Exception {
//        System.out.println("imprimirFacturaVenta");
//        Ventas instance = new Ventas();
//        instance.imprimirFacturaVenta();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of btnDesactivar3ActionPerfomedTest method, of class Ventas.
     */
    @Test
    public void testBtnDesactivar3ActionPerfomedTest() {
        System.out.println("btnDesactivar3ActionPerfomedTest");
        int cmbIDNuevoFactura = 1;
        Ventas instance = new Ventas();
        int expResult = 100;
        int result = instance.btnDesactivar3ActionPerfomedTest(cmbIDNuevoFactura);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
             fail("The test case failed");
    }}

    /**
     * Test of btnModificar2ActionPerfomed method, of class Ventas.
     */
    @Test
    public void testBtnModificar2ActionPerfomed() {
        System.out.println("btnModificar2ActionPerfomed");
        int cmbIDNuevoFactura = 1;
        String txtTipoFactura = "Normal";
        Ventas instance = new Ventas();
        int expResult = 100;
        int result = instance.btnModificar2ActionPerfomed(cmbIDNuevoFactura, txtTipoFactura);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
             fail("The test case failed");
    }}

    /**
     * Test of btnAgregar2ActionPerfomed method, of class Ventas.
     */
    @Test
    public void testBtnAgregar2ActionPerfomed() {
        System.out.println("btnAgregar2ActionPerfomed");
        int cmbIDNuevoFactura = 0;
        String txtTipoFactura = "Normal";
        Ventas instance = new Ventas();
        int expResult = 100;
        int result = instance.btnAgregar2ActionPerfomed(cmbIDNuevoFactura, txtTipoFactura);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
             fail("The test case failed");
    }}

    /**
     * Test of btnModificar3ActionPerfomedTest method, of class Ventas.
     */
    @Test
    public void testBtnModificar3ActionPerfomedTest() {
        System.out.println("btnModificar3ActionPerfomedTest");
        String txtCAI = "447000-8043A0-EDD99E-233579-9E";
        String txtFechaInicio = "01/01/2021";
        String txtFechaFinalizacion = "01/01/2025";
        String txtDe = "107-003-01-00230001";
        String txtHasta = "107-003-01-00280000";
        String ltrampa = "1";
        Ventas instance = new Ventas();
        int expResult = 100;
        int result = instance.btnModificar3ActionPerfomedTest(txtCAI, txtFechaInicio, txtFechaFinalizacion, txtDe, txtHasta, ltrampa);
        try{
        assertEquals(expResult, result);
         }catch(Exception e){
             fail("The test case failed");
    }}

    /**
     * Test of jButton1ActionPerfomedTest method, of class Ventas.
     */
    @Test
    public void testJButton1ActionPerfomedTest() {
        System.out.println("jButton1ActionPerfomedTest");
        String txtCAI = "447000-8043A0-EDD99E-233579-9E";
        String txtFechaInicio = "01/01/2021";
        String txtFechaFinalizacion = "01/01/2025";
        String txtDe = "107-003-01-00230001";
        String txtHasta = "107-003-01-00280000";
        Ventas instance = new Ventas();
        int expResult = 100;
        int result = instance.jButton1ActionPerfomedTest(txtCAI, txtFechaInicio, txtFechaFinalizacion, txtDe, txtHasta);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
             fail("The test case failed");
    }}

    /**
     * Test of btnDesactivar4ActionPerfomedTest method, of class Ventas.
     */
    @Test
    public void testBtnDesactivar4ActionPerfomedTest() {
        System.out.println("btnDesactivar4ActionPerfomedTest");
        String ltrampa = "1";
        Ventas instance = new Ventas();
        int expResult = 100;
        int result = instance.btnDesactivar4ActionPerfomedTest(ltrampa);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
             fail("The test case failed");
    }}

    /**
     * Test of btnAgregarTipoPagoActionPerfomed method, of class Ventas.
     */
    @Test
    public void testBtnAgregarTipoPagoActionPerfomed() {
        System.out.println("btnAgregarTipoPagoActionPerfomed");
        int cmbIDTipoPagoAgregar = 0;
        String txtTipoPago = "Efectivo";
        Ventas instance = new Ventas();
        int expResult = 100;
        int result = instance.btnAgregarTipoPagoActionPerfomed(cmbIDTipoPagoAgregar, txtTipoPago);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
             fail("The test case failed");
    }}

    /**
     * Test of btnModificarTipoPagoActionPerfomedTest method, of class Ventas.
     */
    @Test
    public void testBtnModificarTipoPagoActionPerfomedTest() {
        System.out.println("btnModificarTipoPagoActionPerfomedTest");
        int cmbIDTipoPagoAgregar = 1;
        String txtTipoPago = "Efectivo";
        Ventas instance = new Ventas();
        int expResult = 100;
        int result = instance.btnModificarTipoPagoActionPerfomedTest(cmbIDTipoPagoAgregar, txtTipoPago);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
             fail("The test case failed");
    }}

    /**
     * Test of btnDesactivarTipoPagoActionPerfomedTest method, of class Ventas.
     */
    @Test
    public void testBtnDesactivarTipoPagoActionPerfomedTest() {
        System.out.println("btnDesactivarTipoPagoActionPerfomedTest");
        int cmbIDTipoPagoAgregar = 1;
        Ventas instance = new Ventas();
        int expResult = 100;
        int result = instance.btnDesactivarTipoPagoActionPerfomedTest(cmbIDTipoPagoAgregar);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
             fail("The test case failed");
    }}

        public void testBuscarFacturaTest() {
        System.out.println("BuscarFacturaTest");
        Ventas instance = new Ventas();
        boolean expResult = true;
        instance.chkNumFactura.setEnabled(true);
        instance.txtNumFacturaBusqueda.setText("107-003-01-00230001");
        boolean result = instance.BuscarFacturaTest();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
}
