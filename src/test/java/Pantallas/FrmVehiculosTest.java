/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Acceso;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neos9
 */
public class FrmVehiculosTest {
    
    public FrmVehiculosTest() {
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

    @Test
    public void testAgregarMarca() throws Exception {
        System.out.println("AgregarMarca");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDMarca.setSelectedIndex(0);
        instance.txtMarca.setText("Chevrolet");
        boolean result = instance.AgregarMarca();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarMarca() throws Exception {
        System.out.println("ModificarMarca");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDMarca.setSelectedIndex(1);
        instance.txtMarca.setText("Nissan");
        boolean result = instance.ModificarMarca();
        try{
        assertEquals(expResult, !result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    @Test
    public void testDesactivarMarca() throws Exception {
        System.out.println("DesactivarMarca");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDMarca.setSelectedIndex(1);
        boolean result = instance.DesactivarMarca();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testAgregarColor() throws Exception {
        System.out.println("AgregarColor");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDColor.setSelectedIndex(0);
        instance.txtColor.setText("Amarillo");
        boolean result = instance.AgregarColor();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarColor() throws Exception {
        System.out.println("ModificarColor");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDColor.setSelectedIndex(1);
        instance.txtColor.setText("Verde");
        boolean result = instance.ModificarColor();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testDesactivarColor() throws Exception {
        System.out.println("DesactivarColor");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDColor.setSelectedIndex(1);
        boolean result = instance.DesactivarColor();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testAgregarTipoVehiculo() throws Exception {
        System.out.println("AgregarTipoVehiculo");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDTipoVehiculo.setSelectedIndex(0);
        instance.txtTipoVehiculo.setText("Suv");
        boolean result = instance.AgregarTipoVehiculo();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarTipoVehiculo() throws Exception {
        System.out.println("ModificarTipoVehiculo");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);

        boolean expResult = true;
        instance.cmbIDTipoVehiculo.setSelectedIndex(1);
        instance.txtTipoVehiculo.setText("Pickup");
        boolean result = instance.ModificarTipoVehiculo();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }


    @Test
    public void testDesactivarTipoVehiculo() throws Exception {
        System.out.println("DesactivarTipoVehiculo");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDTipoVehiculo.setSelectedIndex(1);
        boolean result = instance.DesactivarTipoVehiculo();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testAgregarTipoCabina() throws Exception {
        System.out.println("AgregarTipoCabina");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        
        boolean expResult = true;
        instance.cmbPiezaClave.setSelectedIndex(0);
        instance.txtTipoCabina.setText("Cabina triple");
        boolean result = instance.AgregarTipoCabina();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarTipoCabina() throws Exception {
        System.out.println("ModificarTipoCabina");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
                boolean expResult = true;
        instance.cmbPiezaClave.setSelectedIndex(1);
        instance.txtTipoCabina.setText("Cabina cuadruple");
        boolean result = instance.ModificarTipoCabina();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }


    @Test
    public void testDesactivarTipoCabina() throws Exception {
        System.out.println("DesactivarTipoCabina");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
                        boolean expResult = true;
        instance.cmbPiezaClave.setSelectedIndex(1);

        boolean result = instance.DesactivarTipoCabina();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testAgregarTipoCombustible() throws Exception {
        System.out.println("AgregarTipoCombustible");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
                        boolean expResult = true;
        instance.cmbIDTipoGasolina.setSelectedIndex(0);
        instance.txtTipoGasolina.setText("Refresh");
        boolean result = instance.AgregarTipoCombustible();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarTipoCombustible() throws Exception {
        System.out.println("ModificarTipoCombustible");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDTipoGasolina.setSelectedIndex(1);
        instance.txtTipoGasolina.setText("Nitron");
        boolean result = instance.ModificarTipoCombustible();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testDesactivarTipoCombustible() throws Exception {
        System.out.println("DesactivarTipoCombustible");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDTipoGasolina.setSelectedIndex(1);
        boolean result = instance.DesactivarTipoCombustible();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
        
        
    }

    @Test
    public void testAgregarTransmision() throws Exception {
        System.out.println("AgregarTransmision");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDTipoTransmision.setSelectedIndex(0);
        instance.txtTipoTransmision.setText("Reversa");
        boolean result = instance.AgregarTransmision();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    

    @Test
    public void testModificarTransmision() throws Exception {
        System.out.println("ModificarTransmision");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
                boolean expResult = true;
        instance.cmbIDTipoTransmision.setSelectedIndex(1);
        instance.txtTipoTransmision.setText("Inversa");
        boolean result = instance.ModificarTransmision();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }


    @Test
    public void testDesactivarTransmision() throws Exception {
        System.out.println("DesactivarTransmision");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);

        boolean expResult = true;
        instance.cmbIDTipoTransmision.setSelectedIndex(1);
        boolean result = instance.DesactivarTransmision();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testDesactivarVehiculo() throws Exception {
        System.out.println("DesactivarVehiculo");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDVehiculo.setSelectedIndex(1);
        boolean result = instance.DesactivarVehiculo();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarVehiculo() throws Exception {
        System.out.println("ModificarVehiculo");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);

        boolean expResult = true;
        instance.cmbIDVehiculo.setSelectedIndex(1);
        instance.cmbMarcaVehiculo.setSelectedIndex(1);
        instance.cmbGasolinaVehiculo.setSelectedIndex(1);
        instance.cmbColorVehiculo.setSelectedIndex(1);
        instance.cmbTipoVehiculoVehiculo.setSelectedIndex(1);
        instance.cmbTransmisionVehiculo.setSelectedIndex(1);
        instance.cmbNumAsientos.setSelectedIndex(1);
        instance.cmbCabinaVehiculo.setSelectedIndex(1);
        instance.txtVin.setText("Trouble");
        instance.txtCilindraje.setText("6");
        instance.ftxtStock.setText("12");
        instance.ftxtStockMinimo.setText("5");
        instance.ftxtStockMaximo.setText("30");
        instance.txtPrecio.setText("400,000.00");
        boolean result = instance.ModificarVehiculo();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testAgregarVehiculos() throws Exception {
        System.out.println("AgregarVehiculos");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);

        boolean expResult = true;
        instance.cmbIDVehiculo.setSelectedIndex(0);
        instance.cmbMarcaVehiculo.setSelectedIndex(1);
        instance.cmbGasolinaVehiculo.setSelectedIndex(1);
        instance.cmbColorVehiculo.setSelectedIndex(1);
        instance.cmbTipoVehiculoVehiculo.setSelectedIndex(1);
        instance.cmbTransmisionVehiculo.setSelectedIndex(1);
        instance.cmbNumAsientos.setSelectedIndex(1);
        instance.cmbCabinaVehiculo.setSelectedIndex(1);
        instance.txtVin.setText("Wayber");
        instance.txtCilindraje.setText("6");
        instance.ftxtStock.setText("12");
        instance.ftxtStockMinimo.setText("5");
        instance.ftxtStockMaximo.setText("20");
        instance.txtPrecio.setText("430,000.00");
        boolean result = instance.AgregarVehiculos();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testAgregarNumeroAsientos() throws Exception {
        System.out.println("AgregarNumeroAsientos");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDNumeroAsientos.setSelectedIndex(0);
        instance.txtNumeroAsientos.setText("5");
        boolean result = instance.AgregarNumeroAsientos();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarNumeroAsientos() throws Exception {
        System.out.println("ModificarNumeroAsientos");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDNumeroAsientos.setSelectedIndex(1);
        instance.txtNumeroAsientos.setText("8");
        boolean result = instance.ModificarNumeroAsientos();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testDesactivarNumeroAsientos() throws Exception {
        System.out.println("DesactivarNumeroAsientos");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.cmbIDNumeroAsientos.setSelectedIndex(1);
        boolean result = instance.DesactivarNumeroAsientos();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

 

  
    @Test
    public void testValidacionNombreMayusculaYDemasMinus() {
        System.out.println("ValidacionNombreMayusculaYDemasMinus");
        String num = "Alfombra roja";
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        boolean result = instance.ValidacionNombreMayusculaYDemasMinus(num);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
        }
    }
    
        @Test
    public void testValidacionTresLetrasSeguidas() {
        System.out.println("ValidacionTresLetrasSeguidas");
        String num = "Alfombra";
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        boolean result = instance.ValidacionTresLetrasSeguidas(num);
        try{
        assertEquals(expResult, !result);
        }catch(Exception e){
        fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testValidacionRangoPrecioVehiculo() {
        System.out.println("ValidacionRangoPrecioVehiculo");
        String num = "400,000.00";
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        boolean result = instance.ValidacionRangoPrecioVehiculo(num);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
        }
    }
    @Test
    public void testValidacionRangoStockVehiculo() {
        System.out.println("ValidacionRangoStockVehiculo");
        String num = "100";
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        boolean result = instance.ValidacionRangoStockVehiculo(num);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
        }
    }
    public void testBuscarVehiculosTest() {
        System.out.println("BuscarVehiculosTest");
        Acceso a = null;
        FrmVehiculos instance = new FrmVehiculos(a);
        boolean expResult = true;
        instance.chkMarca.setEnabled(true);
        instance.cmbMarcaBusqueda.setSelectedIndex(1);
        boolean result = instance.BuscarVehiculosTest();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
 
}
