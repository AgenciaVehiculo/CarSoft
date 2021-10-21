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
        FrmBanco instance = new FrmBanco();
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
        FrmBanco instance = new FrmBanco();
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
    public void testBtnDesactivarActionPerformedTest() {
        System.out.println("btnDesactivarActionPerformedTest");
        int cmbIDBanco = 1;
        FrmBanco instance = new FrmBanco();
        int expResult = 100;
        int result = instance.btnDesactivarActionPerformedTest(cmbIDBanco);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

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
        FrmBanco instance = new FrmBanco();
        int expResult = 0;
        int result = instance.btnAgrear1ActionPerfomed(cmbIDPrestamo, cmbIDBancoPrestamo, cmbIDClientePrestamo, txtMontoPrestamo, txtCuotasPrestamo, txtTasaPrestamo);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of LimpiarPre method, of class FrmBanco.
     */
//    @Test
//    public void testLimpiarPre() {
//        System.out.println("LimpiarPre");
//        FrmBanco instance = new FrmBanco();
//        instance.LimpiarPre();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of btnModificar1ActionPerfomed method, of class FrmBanco.
     */
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
        FrmBanco instance = new FrmBanco();
        int expResult = 0;
        int result = instance.btnModificar1ActionPerfomed(cmbIDPrestamo, cmbIDBancoPrestamo, 
                cmbIDClientePrestamo, txtMontoPrestamo, txtCuotasPrestamo, txtTasaPrestamo, 
                txtFechaFinalPrestamo);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        e.printStackTrace();
    }}


    /**
     * Test of btnActivarDesactivarPrestamo method, of class FrmBanco.
     */
//    @Test
//    public void testBtnActivarDesactivarPrestamo() {
//        System.out.println("btnActivarDesactivarPrestamo");
//        FrmBanco instance = new FrmBanco();
//        instance.btnActivarDesactivarPrestamo();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
