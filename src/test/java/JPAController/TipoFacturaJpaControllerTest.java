/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.TipoFactura;
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
public class TipoFacturaJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    public TipoFacturaJpaControllerTest() {
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
     * Test of getEntityManager method, of class TipoFacturaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        TipoFacturaJpaController instance = new TipoFacturaJpaController(emf);
       
        try{
            instance.getEntityManager();
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of create method, of class TipoFacturaJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        TipoFactura tipoFactura = new TipoFactura();
        tipoFactura.setEstado(false);
        TipoFacturaJpaController instance = new TipoFacturaJpaController(emf);
        try{
        instance.create(tipoFactura);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of edit method, of class TipoFacturaJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        TipoFactura tipoFactura = new TipoFactura();
        TipoFacturaJpaController instance =  new TipoFacturaJpaController(emf);
        tipoFactura = instance.findTipoFactura(1);
        try{
        instance.edit(tipoFactura);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}


    /**
     * Test of destroy method, of class TipoFacturaJpaController.
     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        Integer id = null;
//        TipoFacturaJpaController instance = null;
//        instance.destroy(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findTipoFacturaEntities method, of class TipoFacturaJpaController.
     */
    @Test
    public void testFindTipoFacturaEntities_0args() {
        System.out.println("findTipoFacturaEntities");
        TipoFacturaJpaController instance = new TipoFacturaJpaController(emf);
        try{
            List<TipoFactura> result = instance.findTipoFacturaEntities();
        }catch(Exception e){
            fail("The test case is a prototype.");
    }}

    /**
     * Test of findTipoFacturaEntities method, of class TipoFacturaJpaController.
     */
    @Test
    public void testFindTipoFacturaEntities_int_int() {
        System.out.println("findTipoFacturaEntities");
        int maxResults = 0;
        int firstResult = 0;
        TipoFacturaJpaController instance = new TipoFacturaJpaController(emf);
        
        try{
            List<TipoFactura> result = instance.findTipoFacturaEntities(maxResults, firstResult);
        
        }catch(Exception e){
            fail("The test case is a prototype.");
    }}

    /**
     * Test of findTipoFactura method, of class TipoFacturaJpaController.
     */
    @Test
    public void testFindTipoFactura() {
        System.out.println("findTipoFactura");
        Integer id = 0;
        TipoFacturaJpaController instance = new TipoFacturaJpaController(emf);
        TipoFactura expResult = null;
        TipoFactura result = instance.findTipoFactura(id);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
            fail("The test case is a prototype.");
    }}
    /**
     * Test of getTipoFacturaCount method, of class TipoFacturaJpaController.
     */
    @Test
    public void testGetTipoFacturaCount() {
        System.out.println("getTipoFacturaCount");
        TipoFacturaJpaController instance = new TipoFacturaJpaController(emf);
        int expResult = instance.findTipoFacturaEntities().size();
        int result = instance.getTipoFacturaCount();
        try{
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        }catch(Exception e){
            fail("The test case is a prototype.");
    }}
    
}
