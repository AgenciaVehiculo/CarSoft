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
 * @author EDUIN FLORES
 */
public class FrmClienteTest {
    
    public FrmClienteTest() {
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
    public void testAgregarCliente() throws Exception {
        System.out.println("AgregarCliente");
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        instance.cmbIDCliente.setSelectedIndex(0);
        instance.txtNombre.setText("Borja Sainz");
        instance.txtApellidos.setText("Padilla Buezo");
        instance.txtTel.setText("96789493");
        instance.txtCorreo.setText("robert@gmail.com");
        instance.txtaDirec.setText("Colonia Alameda");
        instance.cmbTipoDocumentoCli.setSelectedIndex(2);
        instance.txtDocumento.setText("0301199900023");

        boolean result = instance.AgregarCliente();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarCliente() throws Exception {
        System.out.println("ModificarCliente");
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        instance.cmbIDCliente.setSelectedIndex(2);
        instance.txtNombre.setText("Borja Sainz");
        instance.txtApellidos.setText("Padilla Buezo");
        instance.txtTel.setText("96789493");
        instance.txtCorreo.setText("robert@gmail.com");
        instance.txtaDirec.setText("Colonia Alameda");
        instance.cmbTipoDocumentoCli.setSelectedIndex(2);
        instance.txtDocumento.setText("0301199900023");
        boolean result = instance.ModificarCliente();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testDesactivarCliente() throws Exception {
        System.out.println("DesactivarCliente");
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        instance.cmbIDCliente.setSelectedIndex(2);
        boolean result = instance.DesactivarCliente();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    
        @Test
    public void testBuscarClienteDocumento() {
        System.out.println("BuscarClienteDocumento");
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        instance.txtDocumento.setText("9999999999999");
        boolean result = instance.BuscarClienteDocumento();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testAgregarTipoDocumento() throws Exception {
        System.out.println("AgregarTipoDocumento");
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        instance.cmbIDTipoDocumento.setSelectedIndex(0);
        instance.txtTipoDocumento.setText("Residencia");
        boolean result = instance.AgregarTipoDocumento();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarTipoDocumento() {
        System.out.println("ModificarTipoDocumento");
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        instance.cmbIDTipoDocumento.setSelectedIndex(2);
        instance.txtDocumento.setText("Boleta");
        boolean result = instance.ModificarTipoDocumento();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }


    @Test
    public void testDesactivarTipoDocumento() throws Exception {
        System.out.println("DesactivarTipoDocumento");
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        instance.cmbIDTipoDocumento.setSelectedIndex(2);
        boolean result = instance.DesactivarTipoDocumento();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

       @Test
    public void testValidacionIdentidad3() {
        System.out.println("ValidacionIdentidad3");
        String num = "0301199900001";
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        boolean result = instance.ValidacionIdentidad3(num);
        try{
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    @Test
    public void testValidacionNombreMayuscula() {
        System.out.println("ValidacionNombreMayuscula");
        String num = "Eugenio Lopez";
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        boolean result = instance.ValidacionNombreMayuscula(num);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidacionRTN3() {
        System.out.println("ValidacionRTN3");
        String num = "03011999000012";
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        boolean result = instance.ValidacionRTN3(num);
        try{
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidacionVISA() {
        System.out.println("ValidacionVISA");
        String num = "F1234567";
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        boolean result = instance.ValidacionVISA(num);
        try{
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidacionPasaporte() {
        System.out.println("ValidacionPasaporte");
        String num = "XR1001R58";
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        boolean result = instance.ValidacionPasaporte(num);
        try{
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testTelefono() {
        System.out.println("telefono");
        String tel = "98482848";
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        boolean result = instance.telefono(tel);
        try{
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }



    @Test
    public void testValidacionDireccion() {
        System.out.println("ValidacionDireccion");
        String num = "Comayagua, comayagua";
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        boolean result = instance.ValidacionDireccion(num);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidacionNombreMayusculaYDemasMinus() {
        System.out.println("ValidacionNombreMayusculaYDemasMinus");
        String num = "Alfombra roja";
        Acceso a = null;
        FrmCliente instance = new FrmCliente(a);
        boolean expResult = true;
        boolean result = instance.ValidacionNombreMayusculaYDemasMinus(num);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
        }
    }


    /**
     * Test of btnActivarDesactivar method, of class FrmCliente.
     */


}
