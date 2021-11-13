/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Hash;
import Clases.Usuarios;
import Pantallas.FrmEmpleados;
import java.util.List;
import javax.persistence.EntityManager;
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
public class UsuariosJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    UsuariosJpaController UsuarioDao = new UsuariosJpaController(emf);
    
    public UsuariosJpaControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        UsuariosJpaController instance = new UsuariosJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    
    @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        Usuarios usuarios = new Usuarios();
        UsuariosJpaController instance = new  UsuariosJpaController(emf);
        usuarios.setId_Usuario(UsuarioDao.getUsuariosCount()+1);
        usuarios.setId_Empleado(2);
        usuarios.setEstado(true);
        boolean expResult=true;
        boolean result = instance.createTest(usuarios);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }


    
          @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        Usuarios usuarios;
        usuarios=UsuarioDao.findUsuarios(UsuarioDao.findUsuariosEntities().size());
        UsuariosJpaController instance = new  UsuariosJpaController(emf);
        usuarios.setId_Empleado(2);
         boolean expResult=true;
        boolean result = instance.editTest(usuarios);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    @Test
    public void testFindUsuariosEntities_0args() {
        System.out.println("findUsuariosEntities"); 
        UsuariosJpaController instance = new UsuariosJpaController(emf);
        try{
        instance.findUsuariosEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        
        }
    }

    @Test
    public void testFindUsuariosEntities_int_int() {
        System.out.println("findUsuariosEntities");       
        int maxResults = 2;
        int firstResult = 1;
        UsuariosJpaController instance = new UsuariosJpaController(emf);
        try{
        instance.findUsuariosEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testFindUsuarios() {
        System.out.println("findUsuarios");
        UsuariosJpaController instance = new UsuariosJpaController(emf);
        int idUsuario = UsuarioDao.findUsuarios(UsuarioDao.findUsuariosEntities().size()).getId_Usuario();
        try{
        instance.findUsuarios(idUsuario);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetUsuariosCount() {
        System.out.println("getUsuariosCount");
        UsuariosJpaController instance = new UsuariosJpaController(emf);
        int expResult = instance.findUsuariosEntities().size();
        int result = instance.getUsuariosCount();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    
}
