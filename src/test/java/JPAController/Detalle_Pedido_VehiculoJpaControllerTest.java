/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Detalle_Pedido_Vehiculo;
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
public class Detalle_Pedido_VehiculoJpaControllerTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    Detalle_Pedido_VehiculoJpaController Detalle_Pedido_VehiculoDao = new Detalle_Pedido_VehiculoJpaController(emf);
    
    public Detalle_Pedido_VehiculoJpaControllerTest() {
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
     * Test of getEntityManager method, of class Detalle_Pedido_VehiculoJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        Detalle_Pedido_VehiculoJpaController instance = new Detalle_Pedido_VehiculoJpaController(emf);
        
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }
    

    /**
     * Test of create method, of class Detalle_Pedido_VehiculoJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Detalle_Pedido_Vehiculo detalle_Pedido_Vehiculo = new Detalle_Pedido_Vehiculo();
        
        detalle_Pedido_Vehiculo.setId_pedido(1);
        detalle_Pedido_Vehiculo.setId_vehiculo(1);
        Detalle_Pedido_VehiculoJpaController instance = new Detalle_Pedido_VehiculoJpaController(emf);
        
        try{
        instance.create(detalle_Pedido_Vehiculo);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class Detalle_Pedido_VehiculoJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Detalle_Pedido_VehiculoJpaController instance = new Detalle_Pedido_VehiculoJpaController(emf);
        Detalle_Pedido_Vehiculo detalle_Pedido_Vehiculo = instance.findDetalle_Pedido_Vehiculo(1);
        detalle_Pedido_Vehiculo.setId_pedido(2);
        try{
        instance.edit(detalle_Pedido_Vehiculo);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    
    
    /**
     * Test of findDetalle_Pedido_VehiculoEntities method, of class Detalle_Pedido_VehiculoJpaController.
     */
    @Test
    public void testFindDetalle_Pedido_VehiculoEntities_0args() {
        System.out.println("findDetalle_Pedido_VehiculoEntities");
        Detalle_Pedido_VehiculoJpaController instance = new Detalle_Pedido_VehiculoJpaController(emf);
       
        try {
        instance.findDetalle_Pedido_VehiculoEntities();
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findDetalle_Pedido_VehiculoEntities method, of class Detalle_Pedido_VehiculoJpaController.
     */
    @Test
    public void testFindDetalle_Pedido_VehiculoEntities_int_int() {
        System.out.println("findDetalle_Pedido_VehiculoEntities");
        int maxResults = 2;
        int firstResult = 1;
        Detalle_Pedido_VehiculoJpaController instance = new Detalle_Pedido_VehiculoJpaController(emf);
        
        try {
        instance.findDetalle_Pedido_VehiculoEntities(maxResults, firstResult);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findDetalle_Pedido_Vehiculo method, of class Detalle_Pedido_VehiculoJpaController.
     */
    @Test
    public void testFindDetalle_Pedido_Vehiculo() {
        System.out.println("findDetalle_Pedido_Vehiculo");
        Detalle_Pedido_VehiculoJpaController instance = new Detalle_Pedido_VehiculoJpaController(emf);
        int idPedido = Detalle_Pedido_VehiculoDao.findDetalle_Pedido_Vehiculo(Detalle_Pedido_VehiculoDao.findDetalle_Pedido_VehiculoEntities().size()).getId_pedido_Vehiculo();
        
        try {
        instance.findDetalle_Pedido_Vehiculo(idPedido);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    

    /**
     * Test of getDetalle_Pedido_VehiculoCount method, of class Detalle_Pedido_VehiculoJpaController.
     */
    @Test
    public void testGetDetalle_Pedido_VehiculoCount() {
        System.out.println("getDetalle_Pedido_VehiculoCount");
        Detalle_Pedido_VehiculoJpaController instance = new Detalle_Pedido_VehiculoJpaController(emf);
        
        int expResult = instance.findDetalle_Pedido_VehiculoEntities().size();
        int result = instance.getDetalle_Pedido_VehiculoCount();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
