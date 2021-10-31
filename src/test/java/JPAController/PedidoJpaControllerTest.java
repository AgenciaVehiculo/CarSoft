/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Pedido;
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
public class PedidoJpaControllerTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    PedidoJpaController PedidoDao = new PedidoJpaController(emf);
    
    public PedidoJpaControllerTest() {
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
     * Test of getEntityManager method, of class PedidoJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        PedidoJpaController instance = new PedidoJpaController(emf);
        
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class PedidoJpaController.
     */
    
        @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        Pedido pedido = new Pedido();
        //pedido.setId_pedido(1);
        pedido.setEstado(true);
        pedido.setFecha_entrega("20210101");
        pedido.setFecha_pedido("20210101");
        PedidoJpaController instance = new PedidoJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(pedido);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    

    /**
     * Test of edit method, of class PedidoJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        PedidoJpaController instance = new PedidoJpaController(emf);
        Pedido pedido = instance.findPedido(1);
        pedido.setId_pedido(2);
        
        try{
        instance.edit(pedido);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }
    
            @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        PedidoJpaController instance = new PedidoJpaController(emf);
        Pedido pedido = instance.findPedido(1);
        pedido.setId_pedido(2);
         boolean expResult=true;
        boolean result = instance.editTest(pedido);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of destroy method, of class PedidoJpaController.
     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        int id = 0;
//        PedidoJpaController instance = null;
//        try{
//        instance.destroy(id);
//        } catch(Exception e){
//        fail("The test case is a prototype.");
//        }
//    }

    /**
     * Test of findPedidoEntities method, of class PedidoJpaController.
     */
    @Test
    public void testFindPedidoEntities_0args() {
        System.out.println("findPedidoEntities");
        PedidoJpaController instance = new PedidoJpaController(emf);
        
        try {
        instance.findPedidoEntities();
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findPedidoEntities method, of class PedidoJpaController.
     */
    @Test
    public void testFindPedidoEntities_int_int() {
        System.out.println("findPedidoEntities");
        int maxResults = 2;
        int firstResult = 1;
        PedidoJpaController instance = new PedidoJpaController(emf);
      
        try {
        instance.findPedidoEntities(maxResults, firstResult);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findPedido method, of class PedidoJpaController.
     */
    @Test
    public void testFindPedido() {
        System.out.println("findPedido");
        PedidoJpaController instance = new PedidoJpaController(emf);
        int idPedido = PedidoDao.findPedido(PedidoDao.findPedidoEntities().size()).getId_pedido();
    
        try {
        instance.findPedido(idPedido);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getPedidoCount method, of class PedidoJpaController.
     */
    @Test
    public void testGetPedidoCount() {
        System.out.println("getPedidoCount");
        PedidoJpaController instance = new PedidoJpaController(emf);
        
        int expResult = instance.findPedidoEntities().size();
        int result = instance.getPedidoCount();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
    
}
