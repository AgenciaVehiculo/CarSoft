/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Banco;
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
public class BancoJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    public BancoJpaControllerTest() {
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
     * Test of getEntityManager method, of class BancoJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        BancoJpaController instance = new BancoJpaController(emf);
        try{
        instance.getEntityManager();
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        Banco banco = new Banco();
        banco.setEstado(true);
        BancoJpaController instance = new BancoJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(banco);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        BancoJpaController instance = new BancoJpaController(emf);
        Banco banco = instance.findBanco(1);
        banco.setCorreo_electronico("");
         boolean expResult=true;
        boolean result = instance.editTest(banco);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    @Test
    public void testFindBancoEntities_0args() {
        System.out.println("findBancoEntities");
        BancoJpaController instance =  new BancoJpaController(emf);
         try{
        List<Banco> result = instance.findBancoEntities();
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of findBancoEntities method, of class BancoJpaController.
     */
    @Test
    public void testFindBancoEntities_int_int() {
        System.out.println("findBancoEntities");
        int maxResults = 0;
        int firstResult = 0;
        BancoJpaController instance =new BancoJpaController(emf);
        try{
        List<Banco> result = instance.findBancoEntities(maxResults, firstResult);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of findBanco method, of class BancoJpaController.
     */
    @Test
    public void testFindBanco() {
        System.out.println("findBanco");
        int id = 0;
        BancoJpaController instance = new BancoJpaController(emf);
        Banco expResult = null;
        Banco result = instance.findBanco(id);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getBancoCount method, of class BancoJpaController.
     */
    @Test
    public void testGetBancoCount() {
        System.out.println("getBancoCount");
        BancoJpaController instance = new BancoJpaController(emf);
        int expResult = instance.findBancoEntities().size();
        int result = instance.getBancoCount();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
}
