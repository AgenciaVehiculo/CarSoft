/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.TipoPago;
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
 * @author User
 */
public class TipoPagoJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    public TipoPagoJpaControllerTest() {
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
     * Test of getEntityManager method, of class TipoPagoJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        TipoPagoJpaController instance = new TipoPagoJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class TipoPagoJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        TipoPago tipoPago = new TipoPago();
        tipoPago.setEstado(true);
        tipoPago.setNombre("efectivo");
        TipoPagoJpaController instance = new TipoPagoJpaController(emf);
        try{
        instance.create(tipoPago);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }   
    }

    /**
     * Test of edit method, of class TipoPagoJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        TipoPago tipoPago = new TipoPago();
        TipoPagoJpaController instance = new TipoPagoJpaController(emf);
        tipoPago = instance.findTipoPago(1);
        try{
        instance.edit(tipoPago);
         }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }   
    }

    /**
     * Test of destroy method, of class TipoPagoJpaController.
     */
   // @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        Integer id = null;
//        TipoPagoJpaController instance = null;
//        instance.destroy(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findTipoPagoEntities method, of class TipoPagoJpaController.
     */
    @Test
    public void testFindTipoPagoEntities_0args() {
        System.out.println("findTipoPagoEntities");
        TipoPagoJpaController instance = new TipoPagoJpaController(emf);
       // List<TipoPago> expResult = null;
       // List<TipoPago> result = instance.findTipoPagoEntities();
        try{
            List<TipoPago> findTipoPagoEntities = instance.findTipoPagoEntities();
         }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }   
    }

    /**
     * Test of findTipoPagoEntities method, of class TipoPagoJpaController.
     */
    @Test
    public void testFindTipoPagoEntities_int_int() {
        System.out.println("findTipoPagoEntities");
        int maxResults = 0;
        int firstResult = 0;
        TipoPagoJpaController instance = new TipoPagoJpaController(emf);
        
        
        try{
        List<TipoPago> result = instance.findTipoPagoEntities(maxResults, firstResult);
         }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }   
    }

    /**
     * Test of findTipoPago method, of class TipoPagoJpaController.
     */
    @Test
    public void testFindTipoPago() {
        System.out.println("findTipoPago");
        Integer id = 0;
        TipoPagoJpaController instance = new TipoPagoJpaController(emf);
        TipoPago expResult = null;
        TipoPago result = instance.findTipoPago(id);
        try{
        assertEquals(expResult, result);
         }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }   
    }

    /**
     * Test of getTipoPagoCount method, of class TipoPagoJpaController.
     */
    @Test
    public void testGetTipoPagoCount() {
        System.out.println("getTipoPagoCount");
        TipoPagoJpaController instance = new TipoPagoJpaController(emf);
        int expResult = instance.findTipoPagoEntities().size();
        int result = instance.getTipoPagoCount();
        try{
        assertEquals(expResult, result);
         }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }   
    }
    
}
