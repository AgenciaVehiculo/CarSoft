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
 * @author User
 */
public class FrmBancoTest {
    
    public FrmBancoTest() {
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
     * Test of btnAgregarActionPerfomed method, of class FrmBanco.
     */
    @Test
    public void testBtnAgregarActionPerfomed() {
        System.out.println("btnAgregarActionPerfomed");
        String txtNombreBanco = "Atlantida";
        String txtNombreContacto = "Allan Rodriguez";
        String txtTelContacto = "95904010";
        String txtCorreoBanco = "Allan.rod@ujcv.edu.hn";
        Acceso a = null;
        FrmBanco instance = new FrmBanco(a);
        int expResult = 100;
        int result = instance.btnAgregarActionPerfomed(txtNombreBanco, txtNombreContacto, txtTelContacto, txtCorreoBanco);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of btnModificarActionPerfomed method, of class FrmBanco.
     */
    @Test
    public void testBtnModificarActionPerfomed() {
        System.out.println("btnModificarActionPerfomed");
        int cmbIDBanco = 0;
        String txtNombreBanco = "Atlantida";
        String txtNombreContacto = "Allan Rodriguez";
        String txtTelContacto = "95904010";
        String txtCorreoBanco = "Allan.rod@ujcv.edu.hn";
        Acceso a = null;
        FrmBanco instance = new FrmBanco(a);
        int expResult = 100;
        int result = instance.btnModificarActionPerfomed(cmbIDBanco, txtNombreBanco, txtNombreContacto, txtTelContacto, txtCorreoBanco);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}


    /**
     * Test of btnDesactivarActionPerformedTest method, of class FrmBanco.
     */
    @Test
    public void testDesactivarBanco(){
        System.out.println("btnDesactivarBanco");
        Acceso a = null;
        FrmBanco instance = new FrmBanco(a);        
        boolean expResult = true;
        instance.cmbIDBanco.setSelectedIndex(1);
        boolean result = instance.DesactivarBanco();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
        
    }
    

    /**
     * Test of btnAgrear1ActionPerfomed method, of class FrmBanco.
     */
    @Test
    public void testBtnAgrear1ActionPerfomed() {
        System.out.println("btnAgrear1ActionPerfomed");
        int cmbIDPrestamo = 0;
        int cmbIDBancoPrestamo = 1;
        int cmbIDClientePrestamo = 1;
        String txtMontoPrestamo = "15,0000.00";
        String txtCuotasPrestamo = "12";
        String txtTasaPrestamo = "0.12";
        Acceso a = null;
        FrmBanco instance = new FrmBanco(a);
        int expResult = 0;
        int result = instance.btnAgrear1ActionPerfomed(cmbIDPrestamo, cmbIDBancoPrestamo, cmbIDClientePrestamo, txtMontoPrestamo, txtCuotasPrestamo, txtTasaPrestamo);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    @Test
    public void testBtnModificar1ActionPerfomed() {
        System.out.println("btnModificar1ActionPerfomed");
        int cmbIDPrestamo = 1;
        int cmbIDBancoPrestamo = 1;
        int cmbIDClientePrestamo = 1;
        String txtMontoPrestamo = "15,000.00";
        String txtCuotasPrestamo = "12";
        String txtTasaPrestamo = "0.15";
        String txtFechaFinalPrestamo = "2022-01-01";
        Acceso a = null;
        FrmBanco instance = new FrmBanco(a);
        int expResult = 0;
        int result = instance.btnModificar1ActionPerfomed(cmbIDPrestamo, cmbIDBancoPrestamo, 
                cmbIDClientePrestamo, txtMontoPrestamo, txtCuotasPrestamo, txtTasaPrestamo, 
                txtFechaFinalPrestamo);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        e.printStackTrace();
    }}

    @Test
    public void testDesactivarPrestamo() {
        System.out.println("DesactivarPrestamo");
        Acceso a = null;
        FrmBanco instance = new FrmBanco(a);
        boolean expResult = true;
        instance.cmbIDPrestamo.setSelectedIndex(1);
        boolean result = instance.DesactivarPrestamo();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    
       @Test
    public void testBuscarBancoTest() {
        System.out.println("BuscarBancoTest");
        Acceso a = null;
        FrmBanco instance = new FrmBanco(a);
        boolean expResult = true;
        instance.txtNombreBanco.setText("Atlantida");
        boolean result = instance.BuscarBancoTest();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

}
