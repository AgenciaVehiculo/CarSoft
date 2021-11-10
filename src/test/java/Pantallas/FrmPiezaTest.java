/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Pieza;
import JPAController.EmpleadoJpaController;
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
public class FrmPiezaTest {
    
    public FrmPiezaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    
   
    @Test
    public void testValidacionNombreMayusculaYDemasMinus() {
        System.out.println("ValidacionNombreMayusculaYDemasMinus");
        String num = "Espejo con detalles";
        FrmPieza instance = new FrmPieza();
        boolean expResult = true;
        boolean result = instance.ValidacionNombreMayusculaYDemasMinus(num);
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidacionCaracteristicas() {
        System.out.println("ValidacionCaracteristicas");
        String num = "Color rojo";
        FrmPieza instance = new FrmPieza();
        boolean expResult = true;
        boolean result = instance.ValidacionCaracteristicas(num);
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidacionRangoPrecioPieza() {
        System.out.println("ValidacionRangoPrecioPieza");
        String num = "100.00";
        FrmPieza instance = new FrmPieza();
        boolean expResult = true;
        boolean result = instance.ValidacionRangoPrecioPieza(num);
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidacionRangoStockPieza() {
        System.out.println("ValidacionRangoStockPieza");
        String num = "45";
        FrmPieza instance = new FrmPieza();
        boolean expResult = true;
        boolean result = instance.ValidacionRangoStockPieza(num);
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    @Test
    public void testAgregarTipoPieza() throws Exception {
        System.out.println("AgregarTipoPieza");
        FrmPieza instance = new FrmPieza();
        instance.txtIDTipoPieza.setSelectedIndex(0);
        instance.txtTipoPiezaNuevo.setText("Calibrador");
        boolean expResult = true;
        boolean result = instance.AgregarTipoPieza();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
@Test
    public void testAgregarPieza() throws Exception {
        System.out.println("AgregarPieza");
        FrmPieza instance = new FrmPieza();
        boolean expResult = true;
        instance.txtIDPieza.setSelectedIndex(0);
        instance.jCmbTipoPieza.setSelectedIndex(1);
        instance.jFtxtPrecio.setText("100.00");
        instance.jFtxtStock.setText("12");
        instance.jFtxtStockMaximo.setText("120");
        instance.jFtxtStockMinimo.setText("10");
        instance.jTxtAreaCaracteristica.setText("Color rojo");
        instance.jtxtNombre.setText("Espejo");
        boolean result = instance.AgregarPieza();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }


    @Test
    public void testModificarTipoPieza() throws Exception {
        System.out.println("ModificarTipoPieza");
        FrmPieza instance = new FrmPieza();
        instance.txtIDTipoPieza.setSelectedIndex(2);       
        instance.txtTipoPiezaNuevo.setText("Calibrador");
        boolean expResult = true;
        boolean result = instance.ModificarTipoPieza();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
        @Test
    public void tesDesactivarTipoPieza() throws Exception {
        System.out.println("ModificarTipoPieza");
        FrmPieza instance = new FrmPieza();
        instance.txtIDTipoPieza.setSelectedIndex(1);           
        boolean expResult = true;
        boolean result = instance.DesactivarTipoPieza();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    

    @Test
    public void testModificarPieza() throws Exception {
        System.out.println("AgregarPieza");
        FrmPieza instance = new FrmPieza();
        boolean expResult = true;
        instance.txtIDPieza.setSelectedIndex(1);
        instance.jCmbTipoPieza.setSelectedIndex(1);
        instance.jFtxtPrecio.setText("100.00");
        instance.jFtxtStock.setText("12");
        instance.jFtxtStockMaximo.setText("120");
        instance.jFtxtStockMinimo.setText("10");
        instance.jTxtAreaCaracteristica.setText("Color rojo");
        instance.jtxtNombre.setText("Espejo");
        boolean result = instance.ModificarPieza();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    
        @Test
    public void testDesactivarPieza() throws Exception {
        System.out.println("AgregarPieza");
        FrmPieza instance = new FrmPieza();
        boolean expResult = true;
        instance.txtIDPieza.setSelectedIndex(1);
        instance.jCmbTipoPieza.setSelectedIndex(0);
        boolean result = instance.DesactivarPieza();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    
    public void testBuscarPiezaTest() {
        System.out.println("BuscarPiezaTest");
        FrmPieza instance = new FrmPieza();
        boolean expResult = true;
        instance.txtNombreBusqueda.setText("Espejo");
        boolean result = instance.BuscarPiezaTest();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
}
    

