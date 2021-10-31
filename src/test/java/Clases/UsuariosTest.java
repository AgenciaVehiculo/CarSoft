/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class UsuariosTest {
    
    public UsuariosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetId_Usuario() {
        System.out.println("getId_Usuario");
        Usuarios instance = new Usuarios();
        int expResult = 0;
        int result = instance.getId_Usuario();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId_Usuario() {
        System.out.println("setId_Usuario");
        int id_Usuario = 0;
        Usuarios instance = new Usuarios();
        try {
        instance.setId_Usuario(id_Usuario);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetId_Empleado() {
        System.out.println("getId_Empleado");
        Usuarios instance = new Usuarios();
        int expResult = 0;
        
        int result = instance.getId_Empleado();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId_Empleado() {
        System.out.println("setId_Empleado");
        int id_Empleado = 0;
        Usuarios instance = new Usuarios();
        try {
        instance.setId_Empleado(id_Empleado);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetId_Nombre() {
        System.out.println("getId_Nombre");
        Usuarios instance = new Usuarios();
        String expResult = "";
        instance.setId_Nombre(expResult);
        String result = instance.getId_Nombre();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        } 
    }

    @Test
    public void testSetId_Nombre() {
        System.out.println("setId_Nombre");
        String id_Nombre = "";
        Usuarios instance = new Usuarios();
        try {
        instance.setId_Nombre(id_Nombre);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetContraseña() {
        System.out.println("getContrase\u00f1a");
        Usuarios instance = new Usuarios();
        String expResult = "";
        instance.setContraseña(expResult);
        String result = instance.getContraseña();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        } 
    }

    @Test
    public void testSetContraseña() {
        System.out.println("setContrase\u00f1a");
        String Contraseña = "";
        Usuarios instance = new Usuarios();
        try {
        instance.setContraseña(Contraseña);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testIsEstado() {
        System.out.println("isEstado");
        Usuarios instance = new Usuarios();
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
        Usuarios instance = new Usuarios();
        try {
        instance.setEstado(estado);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetContrasenia() {
        System.out.println("getContrasenia");
        Usuarios instance = new Usuarios();
        String expResult = "";
        instance.setContrasenia(expResult);
        String result = instance.getContrasenia();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetContrasenia() {
        System.out.println("setContrasenia");
        String Contrasenia = "";
        Usuarios instance = new Usuarios();
        try {
        instance.setContrasenia(Contrasenia);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetIntentos() {
        System.out.println("getIntentos");
        Usuarios instance = new Usuarios();
        int expResult = 0;
        int result = instance.getIntentos();
        try {
        assertEquals(expResult, result);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetIntentos() {
        System.out.println("setIntentos");
        int intentos = 0;
        Usuarios instance = new Usuarios();
        try {
        instance.setIntentos(intentos);
        } catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
