/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
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
 * @author EDUIN FLORES
 */
public class ClienteJpaControllerTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    ClienteJpaController ClienteDao = new ClienteJpaController(emf);
    
    public ClienteJpaControllerTest() {
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
     * Test of getEntityManager method, of class ClienteJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        ClienteJpaController instance = new ClienteJpaController(emf);
        
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class ClienteJpaController.
     */

    @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        Cliente cliente = new Cliente();
        cliente.setId_Persona(1);
        cliente.setEstado(true);
        cliente.setFecha_ingreso_sistema("2021-01-01");
        ClienteJpaController instance = new ClienteJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(cliente);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    

    /**
     * Test of edit method, of class ClienteJpaController.
     */

        @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        ClienteJpaController instance = new ClienteJpaController(emf);
        Cliente cliente = instance.findCliente(1);
        cliente.setId_Persona(3);
         boolean expResult=true;
        boolean result = instance.editTest(cliente);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    
    /**
     * Test of destroy method, of class ClienteJpaController.
     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        int id = 0;
//        ClienteJpaController instance = null;
//        try{
//        instance.destroy(id);
//        } catch(Exception e){
//        fail("The test case is a prototype.");
//        }
//    }

    /**
     * Test of findClienteEntities method, of class ClienteJpaController.
     */
    @Test
    public void testFindClienteEntities_0args() {
        System.out.println("findClienteEntities");
        ClienteJpaController instance = new ClienteJpaController(emf);
        
        try {
        instance.findClienteEntities();
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    

    /**
     * Test of findClienteEntities method, of class ClienteJpaController.
     */
    @Test
    public void testFindClienteEntities_int_int() {
        System.out.println("findClienteEntities");
        int maxResults = 2;
        int firstResult = 1;
        ClienteJpaController instance = new ClienteJpaController(emf);
        
        try {
        instance.findClienteEntities(maxResults, firstResult);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    
    /**
     * Test of findCliente method, of class ClienteJpaController.
     */
    @Test
    public void testFindCliente() {
        System.out.println("findCliente");
        ClienteJpaController instance = new ClienteJpaController(emf);
        int idCliente = (ClienteDao.findClienteEntities().size());
        
        try {
        instance.findCliente(idCliente);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    

    /**
     * Test of getClienteCount method, of class ClienteJpaController.
     */
    @Test
    public void testGetClienteCount() {
        System.out.println("getClienteCount");
        ClienteJpaController instance = new ClienteJpaController(emf);
        int expResult = instance.findClienteEntities().size();
        int result = instance.getClienteCount();
        
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}


