/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.PiezaFactura;
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
public class PiezaFacturaJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    public PiezaFacturaJpaControllerTest() {
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
     * Test of getEntityManager method, of class PiezaFacturaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        PiezaFacturaJpaController instance = new PiezaFacturaJpaController(emf);
        try{
        instance.getEntityManager();
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of create method, of class PiezaFacturaJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        PiezaFactura piezaFactura = new PiezaFactura();
        piezaFactura.setIdPieza(1);
        piezaFactura.setIdFactura(1);
        
        PiezaFacturaJpaController instance = new PiezaFacturaJpaController(emf);
        try{
        instance.create(piezaFactura);
        }catch(Exception e){
        fail("The test case is a ERROR.");
    }}

    /**
     * Test of edit method, of class PiezaFacturaJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        PiezaFactura piezaFactura = new PiezaFactura();
        piezaFactura.setIdFacturaPieza(1);
        piezaFactura.setIdPieza(1);
        piezaFactura.setIdFactura(1);
        PiezaFacturaJpaController instance =new PiezaFacturaJpaController(emf);
        try{
        instance.edit(piezaFactura);
        }catch(Exception e){
        fail("The test case is a ERROR.");
    }}

    /**
     * Test of destroy method, of class PiezaFacturaJpaController.
     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        int id = 0;
//        PiezaFacturaJpaController instance = null;
//        instance.destroy(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findPiezaFacturaEntities method, of class PiezaFacturaJpaController.
     */
    @Test
    public void testFindPiezaFacturaEntities_0args() {
        System.out.println("findPiezaFacturaEntities");
        PiezaFacturaJpaController instance = new PiezaFacturaJpaController(emf);
        try{
        List<PiezaFactura> result = instance.findPiezaFacturaEntities();
        
        }catch(Exception e){
        fail("The test case is a ERROR.");
    }}

    /**
     * Test of findPiezaFacturaEntities method, of class PiezaFacturaJpaController.
     */
    @Test
    public void testFindPiezaFacturaEntities_int_int() {
        System.out.println("findPiezaFacturaEntities");
        int maxResults = 0;
        int firstResult = 0;
        PiezaFacturaJpaController instance = new PiezaFacturaJpaController(emf);
        
        
        try{
        
        List<PiezaFactura> result = instance.findPiezaFacturaEntities(maxResults, firstResult);
        }catch(Exception e){
        fail("The test case is a ERROR.");
    }}


    /**
     * Test of findPiezaFactura method, of class PiezaFacturaJpaController.
     */
    @Test
    public void testFindPiezaFactura() {
        System.out.println("findPiezaFactura");
        int id = 0;
        PiezaFacturaJpaController instance = new PiezaFacturaJpaController(emf);
        PiezaFactura expResult = null;
        PiezaFactura result = instance.findPiezaFactura(id);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a ERROR.");
    }}

    /**
     * Test of getPiezaFacturaCount method, of class PiezaFacturaJpaController.
     */
    @Test
    public void testGetPiezaFacturaCount() {
        System.out.println("getPiezaFacturaCount");
        PiezaFacturaJpaController instance = new PiezaFacturaJpaController(emf);
        int expResult = instance.findPiezaFacturaEntities().size();
        int result = instance.getPiezaFacturaCount();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a ERROR.");
    }}
    
}
