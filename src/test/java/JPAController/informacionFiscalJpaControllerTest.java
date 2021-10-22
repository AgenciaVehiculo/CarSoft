/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.informacionFiscal;
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
public class informacionFiscalJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    public informacionFiscalJpaControllerTest() {
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
     * Test of getEntityManager method, of class informacionFiscalJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        
        informacionFiscalJpaController instance = new informacionFiscalJpaController(emf);
        try{
        EntityManager result = instance.getEntityManager();
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of create method, of class informacionFiscalJpaController.
     */

    @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        informacionFiscal informacionFiscal = new informacionFiscal();
        informacionFiscal.setFechaInicio("2021-01-01");
        informacionFiscal.setFechaFinal("2024-01-01");
        informacionFiscal.setEstado(false);
        informacionFiscal.setCai("447000-8043A0-EDD99E-233579-9E");
        informacionFiscalJpaController instance = new informacionFiscalJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(informacionFiscal);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    

    /**
     * Test of edit method, of class informacionFiscalJpaController.
     */
 
    @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        informacionFiscalJpaController instance = new informacionFiscalJpaController(emf);
        informacionFiscal informacionFiscal = instance.findinformacionFiscal(1);
         boolean expResult=true;
        boolean result = instance.editTest(informacionFiscal);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of destroy method, of class informacionFiscalJpaController.
     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        int id = 0;
//        informacionFiscalJpaController instance = null;
//        instance.destroy(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findinformacionFiscalEntities method, of class informacionFiscalJpaController.
     */
    @Test
    public void testFindinformacionFiscalEntities_0args() {
        System.out.println("findinformacionFiscalEntities");
        informacionFiscalJpaController instance =  new informacionFiscalJpaController(emf);
        try{
        List<informacionFiscal> result = instance.findinformacionFiscalEntities();
        
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of findinformacionFiscalEntities method, of class informacionFiscalJpaController.
     */
    @Test
    public void testFindinformacionFiscalEntities_int_int() {
        System.out.println("findinformacionFiscalEntities");
        int maxResults = 0;
        int firstResult = 0;
        informacionFiscalJpaController instance = new informacionFiscalJpaController(emf);
        try{
        List<informacionFiscal> result = instance.findinformacionFiscalEntities(maxResults, firstResult);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}


    /**
     * Test of findinformacionFiscal method, of class informacionFiscalJpaController.
     */
    @Test
    public void testFindinformacionFiscal() {
        System.out.println("findinformacionFiscal");
        int id = 0;
        informacionFiscalJpaController instance = new informacionFiscalJpaController(emf);
        informacionFiscal expResult = null;
        informacionFiscal result = instance.findinformacionFiscal(id);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}


    /**
     * Test of getinformacionFiscalCount method, of class informacionFiscalJpaController.
     */
    @Test
    public void testGetinformacionFiscalCount() {
        System.out.println("getinformacionFiscalCount");
        informacionFiscalJpaController instance =  new informacionFiscalJpaController(emf);
        int expResult = instance.findinformacionFiscalEntities().size();
        int result = instance.getinformacionFiscalCount();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}
    
}
