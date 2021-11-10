/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Usuarios;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class IniciodeSesionTest {
    
    public IniciodeSesionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    //@Test
/*    public void testInicioSesion() {
        System.out.println("InicioSesion");
        
        IniciodeSesion instance = new IniciodeSesion();
        instance.txt_usuario.setText("jose.rivera1");
        instance.btn_password.setText("Dyprestige1$");
        if (!instance.txt_usuario.getText().isEmpty()) {
            if (instance.InicioSesion()==true) { 
            fail("No hay ningún nombre");
        }
        } else {
            fail("Error de inicio de sesión");
        }
    }*/
    
    @Test
    public void testInicioSesion() {
        System.out.println("InicioSesion");
        IniciodeSesion instance = new IniciodeSesion();
        boolean expResult = true;
        instance.txt_usuario.setText("root");
        instance.btn_password.setText("admin");    
        boolean result = instance.InicioSesion();
        try{
        assertEquals(expResult, result);
        }catch (Exception e){
        fail("The test case is a prototype.");
        }
    }

 /*  @Test
    public void testInicioSesion() {
        System.out.println("InicioSesion");
        IniciodeSesion instance = new IniciodeSesion();;
        boolean expResult = false;
        boolean result = instance.InicioSesion();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
        }
    }*/


    
}
