/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Detalle_Banco_Cliente;
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
public class Detalle_Banco_ClienteJpaControllerTest {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    public Detalle_Banco_ClienteJpaControllerTest() {
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
     * Test of getEntityManager method, of class Detalle_Banco_ClienteJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        Detalle_Banco_ClienteJpaController instance = new Detalle_Banco_ClienteJpaController(emf);
        try{
        EntityManager result = instance.getEntityManager();
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of create method, of class Detalle_Banco_ClienteJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Detalle_Banco_Cliente detalle_Banco_Cliente = new Detalle_Banco_Cliente();
        detalle_Banco_Cliente.setId_banco(1);
        detalle_Banco_Cliente.setId_cliente(1);
        detalle_Banco_Cliente.setEstado(true);
        detalle_Banco_Cliente.setFecha_inicio("2021-01-01");
        Detalle_Banco_ClienteJpaController instance =  new Detalle_Banco_ClienteJpaController(emf);
        try{
        instance.create(detalle_Banco_Cliente);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}


    /**
     * Test of edit method, of class Detalle_Banco_ClienteJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Detalle_Banco_Cliente detalle_Banco_Cliente = new Detalle_Banco_Cliente();
        detalle_Banco_Cliente.setId_banco(1);
        detalle_Banco_Cliente.setId_cliente(1);
        detalle_Banco_Cliente.setEstado(true);
        detalle_Banco_Cliente.setFecha_inicio("2021-01-01");
        detalle_Banco_Cliente.setFecha_final("2022-01-01");
        Detalle_Banco_ClienteJpaController instance =new Detalle_Banco_ClienteJpaController(emf);
        try{
        instance.edit(detalle_Banco_Cliente);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of destroy method, of class Detalle_Banco_ClienteJpaController.
     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        int id = 0;
//        Detalle_Banco_ClienteJpaController instance = null;
//        instance.destroy(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findDetalle_Banco_ClienteEntities method, of class Detalle_Banco_ClienteJpaController.
     */
    @Test
    public void testFindDetalle_Banco_ClienteEntities_0args() {
        System.out.println("findDetalle_Banco_ClienteEntities");
        Detalle_Banco_ClienteJpaController instance =new Detalle_Banco_ClienteJpaController(emf);
         try{
        List<Detalle_Banco_Cliente> result = instance.findDetalle_Banco_ClienteEntities();
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}
    /**
     * Test of findDetalle_Banco_ClienteEntities method, of class Detalle_Banco_ClienteJpaController.
     */
    @Test
    public void testFindDetalle_Banco_ClienteEntities_int_int() {
        System.out.println("findDetalle_Banco_ClienteEntities");
        int maxResults = 0;
        int firstResult = 0;
        Detalle_Banco_ClienteJpaController instance =new Detalle_Banco_ClienteJpaController(emf);
        
        try{
        List<Detalle_Banco_Cliente> result = instance.findDetalle_Banco_ClienteEntities(maxResults, firstResult);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of findDetalle_Banco_Cliente method, of class Detalle_Banco_ClienteJpaController.
     */
    @Test
    public void testFindDetalle_Banco_Cliente() {
        System.out.println("findDetalle_Banco_Cliente");
        int id = 0;
        Detalle_Banco_ClienteJpaController instance = new Detalle_Banco_ClienteJpaController(emf);
        Detalle_Banco_Cliente expResult = null;
        Detalle_Banco_Cliente result = instance.findDetalle_Banco_Cliente(id);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getDetalle_Banco_ClienteCount method, of class Detalle_Banco_ClienteJpaController.
     */
    @Test
    public void testGetDetalle_Banco_ClienteCount() {
        System.out.println("getDetalle_Banco_ClienteCount");
        Detalle_Banco_ClienteJpaController instance = new Detalle_Banco_ClienteJpaController(emf);
        int expResult = instance.findDetalle_Banco_ClienteEntities().size();
        int result = instance.getDetalle_Banco_ClienteCount();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    
}
