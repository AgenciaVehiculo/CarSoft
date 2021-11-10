/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Facturarechazada;
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
public class FacturarechazadaJpaControllerTest {
    
    public FacturarechazadaJpaControllerTest() {
    }
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
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
     * Test of getEntityManager method, of class FacturarechazadaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        FacturarechazadaJpaController instance = new FacturarechazadaJpaController(emf);
        try{
            instance.getEntityManager();
        }
        catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of create method, of class FacturarechazadaJpaController.
     */
    @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        Facturarechazada facturarechazada = new Facturarechazada();
        FacturarechazadaJpaController instance = new FacturarechazadaJpaController(emf);
        facturarechazada.setId(1);
        facturarechazada.setFechaRechazo("20210101");
        boolean expResult=true;
        boolean result = instance.createTest(facturarechazada);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    /**
     * Test of edit method, of class FacturarechazadaJpaController.
     */
    
            @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        Facturarechazada facturarechazada = new Facturarechazada();
        facturarechazada.setId(1);
//        facturarechazada.setIdRechazo(1);
        FacturarechazadaJpaController instance =new FacturarechazadaJpaController(emf);
         boolean expResult=true;
        boolean result = instance.editTest(facturarechazada);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of destroy method, of class FacturarechazadaJpaController.
     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        Integer id = null;
//        FacturarechazadaJpaController instance = null;
//        instance.destroy(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findFacturarechazadaEntities method, of class FacturarechazadaJpaController.
     */
    @Test
    public void testFindFacturarechazadaEntities_0args() {
        System.out.println("findFacturarechazadaEntities");
        FacturarechazadaJpaController instance = new FacturarechazadaJpaController(emf);;
        
        try{
        List<Facturarechazada> result = instance.findFacturarechazadaEntities();
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of findFacturarechazadaEntities method, of class FacturarechazadaJpaController.
     */
    @Test
    public void testFindFacturarechazadaEntities_int_int() {
        System.out.println("findFacturarechazadaEntities");
        int maxResults = 0;
        int firstResult = 0;
        FacturarechazadaJpaController instance = new FacturarechazadaJpaController(emf);
        
        try{
        List<Facturarechazada> result = instance.findFacturarechazadaEntities(maxResults, firstResult);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of findFacturarechazada method, of class FacturarechazadaJpaController.
     */
    @Test
    public void testFindFacturarechazada() {
        System.out.println("findFacturarechazada");
        Integer id = 0;
        FacturarechazadaJpaController instance =  new FacturarechazadaJpaController(emf);
        Facturarechazada expResult = null;
        Facturarechazada result = instance.findFacturarechazada(id);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getFacturarechazadaCount method, of class FacturarechazadaJpaController.
     */
    @Test
    public void testGetFacturarechazadaCount() {
        System.out.println("getFacturarechazadaCount");
        FacturarechazadaJpaController instance = new FacturarechazadaJpaController(emf);
        int expResult = instance.findFacturarechazadaEntities().size();
        int result = instance.getFacturarechazadaCount();
        try{
        assertEquals(expResult, result);
       }catch(Exception e){
        fail("The test case is a prototype.");
    }}
    
}