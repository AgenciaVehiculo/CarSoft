/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Detalle_Pedido_pieza;
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
public class Detalle_Pedido_piezaJpaControllerTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    Detalle_Pedido_piezaJpaController Detalle_Pedido_piezaDao = new Detalle_Pedido_piezaJpaController(emf);
    
    
    public Detalle_Pedido_piezaJpaControllerTest() {
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
     * Test of getEntityManager method, of class Detalle_Pedido_piezaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        Detalle_Pedido_piezaJpaController instance = new Detalle_Pedido_piezaJpaController(emf);
        
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class Detalle_Pedido_piezaJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        
        Detalle_Pedido_pieza detalle_Pedido_pieza = new Detalle_Pedido_pieza();
        detalle_Pedido_pieza.setPrecio(0.00);
        detalle_Pedido_pieza.setId_pieza(1);
        detalle_Pedido_pieza.setId_pedido(1);
        
        
        Detalle_Pedido_piezaJpaController instance = new Detalle_Pedido_piezaJpaController(emf);
        try{
        instance.create(detalle_Pedido_pieza);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class Detalle_Pedido_piezaJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Detalle_Pedido_piezaJpaController instance = new Detalle_Pedido_piezaJpaController(emf);
        Detalle_Pedido_pieza detalle_Pedido_pieza = instance.findDetalle_Pedido_pieza(1);
        detalle_Pedido_pieza.setId_pedido(2);
        
        try{
        instance.edit(detalle_Pedido_pieza);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findDetalle_Pedido_piezaEntities method, of class Detalle_Pedido_piezaJpaController.
     */
    @Test
    public void testFindDetalle_Pedido_piezaEntities_0args() {
        System.out.println("findDetalle_Pedido_piezaEntities");
        Detalle_Pedido_piezaJpaController instance = new Detalle_Pedido_piezaJpaController(emf);
        
        try {
        instance.findDetalle_Pedido_piezaEntities();
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findDetalle_Pedido_piezaEntities method, of class Detalle_Pedido_piezaJpaController.
     */
    @Test
    public void testFindDetalle_Pedido_piezaEntities_int_int() {
        System.out.println("findDetalle_Pedido_piezaEntities");
        int maxResults = 2;
        int firstResult = 1;
        Detalle_Pedido_piezaJpaController instance = new Detalle_Pedido_piezaJpaController(emf);
        
        try {
        instance.findDetalle_Pedido_piezaEntities(maxResults, firstResult);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
    
    /**
     * Test of findDetalle_Pedido_pieza method, of class Detalle_Pedido_piezaJpaController.
     */
    @Test
    public void testFindDetalle_Pedido_pieza() {
        System.out.println("findDetalle_Pedido_pieza");
        Detalle_Pedido_piezaJpaController instance = new Detalle_Pedido_piezaJpaController(emf);
        int idPedido = (Detalle_Pedido_piezaDao.findDetalle_Pedido_piezaEntities().size());
        
        try {
        instance.findDetalle_Pedido_pieza(idPedido);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    

    /**
     * Test of getDetalle_Pedido_piezaCount method, of class Detalle_Pedido_piezaJpaController.
     */
    @Test
    public void testGetDetalle_Pedido_piezaCount() {
        System.out.println("getDetalle_Pedido_piezaCount");
        Detalle_Pedido_piezaJpaController instance = new Detalle_Pedido_piezaJpaController(emf);
        
        int expResult = instance.findDetalle_Pedido_piezaEntities().size();
        int result = instance.getDetalle_Pedido_piezaCount();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
    
}
