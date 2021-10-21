/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import JPAController.EmpleadoJpaController;
import JPAController.UsuariosJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class FrmEmpleadosTest {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    UsuariosJpaController UsuarioDao = new UsuariosJpaController(emf);
    EmpleadoJpaController EmpleadoDao = new EmpleadoJpaController(emf);
    @Test
    public void testCorreo() {
        System.out.println("correo");
        String correo_elec = "rey@gmail.com";
        FrmCliente instance = new FrmCliente();
        boolean expResult = true;
        boolean result = instance.correo(correo_elec);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
        }
    }
@Test
    public void testModificarUsuario() {
        System.out.println("ModificarUsuario");
        FrmEmpleados instance = new FrmEmpleados();
        boolean expResult = true;
        instance.txtIDUsuario.setText("1");
        instance.cmbIDEmpleado.setSelectedIndex(1);
        instance.txtNombre.setText("martin.montoya1");
        instance.txtConfirmarContraseña.setText("Holacomo1$");
        instance.txtContraseña.setText("Holacomo1$");
        boolean result = instance.ModificarUsuario();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testDesactivarUsuario() {
        System.out.println("ModificarUsuario");
        FrmEmpleados instance = new FrmEmpleados();
        boolean expResult = true;
        instance.txtIDUsuario.setText("1");
        boolean result = instance.DesactivarUsuario();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testAgregarUsuario() {
        System.out.println("AgregarUsuario");
        FrmEmpleados instance = new FrmEmpleados();
        boolean expResult = true;
        instance.txtIDUsuario.setText(String.valueOf(UsuarioDao.getUsuariosCount()+1));
        instance.cmbIDEmpleado.setSelectedIndex(2);
        instance.txtNombre.setText("martin.montoya1");
        instance.txtConfirmarContraseña.setText("Holacomo1$");
        instance.txtContraseña.setText("Holacomo1$");
        boolean result = instance.AgregarUsuario();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }



    @Test
    public void testModificarCargo() {
        System.out.println("ModificarCargo");
        FrmEmpleados instance = new FrmEmpleados();
        boolean expResult = true;
        instance.cmbIDNuevoCargo.setSelectedIndex(2);
        instance.txtNuevoCargo.setText("Administrador");
        boolean result = instance.ModificarCargo();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    @Test
    public void testDesactivarCargo() {
        System.out.println("ModificarCargo");
        FrmEmpleados instance = new FrmEmpleados();
        boolean expResult = true;
        instance.cmbIDNuevoCargo.setSelectedIndex(2);
        boolean result = instance.DesactivarCargo();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testAgregarCargo() {
        System.out.println("AgregarCargo");
        FrmEmpleados instance = new FrmEmpleados();
        instance.AgregarCargo();
        boolean expResult = true;
        instance.cmbIDNuevoCargo.setSelectedIndex(0);
        instance.txtNuevoCargo.setText("Administrador");
        boolean result = instance.AgregarCargo();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }


    @Test
    public void testModificarEmpleado() {
        System.out.println("ModificarEmpleado");
        FrmEmpleados instance = new FrmEmpleados();
        boolean expResult = true;
        instance.cmbIDEmpleado1.setSelectedIndex(2);
        instance.txtNombre1.setText("Borja Sainz");
        instance.txtApellidos.setText("Padilla Buezo");
        instance.txtTel.setText("96789493");
        instance.txtCorreo.setText("robert@gmail.com");
        instance.txtaDirec.setText("Colonia Alameda");
        instance.cmbTipoDocumentoEmpleado.setSelectedIndex(2);
        instance.txtDocumento.setText("0301199900023");
        instance.cmbCargoEmpleado.setSelectedIndex(2);
        instance.txtSueldo.setText("10,000.00");
        boolean result = instance.ModificarEmpleado();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    @Test
    public void testDesactivarEmpleado() {
        System.out.println("DesactivarEmpleado");
        FrmEmpleados instance = new FrmEmpleados();
        boolean expResult = true;
        instance.cmbIDEmpleado1.setSelectedIndex(2);
        boolean result = instance.DesactivarEmpleado();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
       @Test
    public void testBuscarEmpleadoDocumento() {
        System.out.println("BuscarEmpleadoDocumento");
        FrmEmpleados instance = new FrmEmpleados();
        boolean expResult = true;
        instance.txtDocumento.setText("J3838383");
        boolean result = instance.BuscarEmpleadoDocumento();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }
    @Test
    public void testAgregarEmpleado() {
        System.out.println("AgregarEmpleado");
        FrmEmpleados instance = new FrmEmpleados();
        boolean expResult = true;
        instance.cmbIDEmpleado1.setSelectedIndex(0);
        instance.txtNombre1.setText("Borja Sainz");
        instance.txtApellidos.setText("Padilla Buezo");
        instance.txtTel.setText("96789493");
        instance.txtCorreo.setText("robert@gmail.com");
        instance.txtaDirec.setText("Colonia Alameda");
        instance.cmbTipoDocumentoEmpleado.setSelectedIndex(2);
        instance.txtDocumento.setText("0301199900023");
        instance.cmbCargoEmpleado.setSelectedIndex(2);
        instance.txtSueldo.setText("10,000.00");
        boolean result = instance.AgregarEmpleado();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
        
    }

   @Test
    public void testValidacionContrasenia2() {
        System.out.println("ValidacionContrasenia2");
        String num = "HolaComo1$";
        FrmEmpleados instance = new FrmEmpleados();
        boolean expResult = true;
        boolean result = instance.ValidacionContrasenia2(num);
        try{
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidacionNombreUsuario() {
        System.out.println("ValidacionNombreUsuario");
        String num = "adrian.lopez1";
        FrmEmpleados instance = new FrmEmpleados();
        boolean expResult = true;
        boolean result = instance.ValidacionNombreUsuario(num);
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
        FrmEmpleados instance = new FrmEmpleados();
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
        FrmEmpleados instance = new FrmEmpleados();
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
        FrmEmpleados instance = new FrmEmpleados();
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
        FrmEmpleados instance = new FrmEmpleados();
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
        FrmEmpleados instance = new FrmEmpleados();
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
        FrmEmpleados instance = new FrmEmpleados();
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
        FrmEmpleados instance = new FrmEmpleados();
        boolean expResult = true;
        boolean result = instance.ValidacionNombreMayusculaYDemasMinus(num);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
        }
    }
    
}
