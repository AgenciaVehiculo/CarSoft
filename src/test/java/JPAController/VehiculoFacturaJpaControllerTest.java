/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.VehiculoFactura;
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
public class VehiculoFacturaJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    public VehiculoFacturaJpaControllerTest() {
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
     * Test of getEntityManager method, of class VehiculoFacturaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        VehiculoFacturaJpaController instance = new VehiculoFacturaJpaController(emf);
        
        try{
            instance.getEntityManager();
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of create method, of class VehiculoFacturaJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        VehiculoFactura vehiculoFactura = new VehiculoFactura();
        vehiculoFactura.setIdFactura(1);
        vehiculoFactura.setIdVehiculo(1);
        vehiculoFactura.setEstado(true);
        VehiculoFacturaJpaController instance = new VehiculoFacturaJpaController(emf);
        try{
            instance.create(vehiculoFactura);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of edit method, of class VehiculoFacturaJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        VehiculoFactura vehiculoFactura = new VehiculoFactura();
        vehiculoFactura.setIdFactura(1);
        vehiculoFactura.setIdVehiculo(1);
        vehiculoFactura.setIdFacturaVehiculo(1);
        VehiculoFacturaJpaController instance =  new VehiculoFacturaJpaController(emf);
        try{
        instance.edit(vehiculoFactura);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of destroy method, of class VehiculoFacturaJpaController.
     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        int id = 0;
//        VehiculoFacturaJpaController instance = null;
//        instance.destroy(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findVehiculoFacturaEntities method, of class VehiculoFacturaJpaController.
     */
    @Test
    public void testFindVehiculoFacturaEntities_0args() {
        System.out.println("findVehiculoFacturaEntities");
        VehiculoFacturaJpaController instance =  new VehiculoFacturaJpaController(emf);
         try{
        List<VehiculoFactura> result = instance.findVehiculoFacturaEntities();
         
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of findVehiculoFacturaEntities method, of class VehiculoFacturaJpaController.
     */
    @Test
    public void testFindVehiculoFacturaEntities_int_int() {
        System.out.println("findVehiculoFacturaEntities");
        int maxResults = 0;
        int firstResult = 0;
        VehiculoFacturaJpaController instance =  new VehiculoFacturaJpaController(emf);
        try{
        List<VehiculoFactura> result = instance.findVehiculoFacturaEntities(maxResults, firstResult);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}


    /**
     * Test of findVehiculoFactura method, of class VehiculoFacturaJpaController.
     */
    @Test
    public void testFindVehiculoFactura() {
        System.out.println("findVehiculoFactura");
        int id = 0;
        VehiculoFacturaJpaController instance = new VehiculoFacturaJpaController(emf);
        VehiculoFactura expResult = null;
        VehiculoFactura result = instance.findVehiculoFactura(id);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getVehiculoFacturaCount method, of class VehiculoFacturaJpaController.
     */
    @Test
    public void testGetVehiculoFacturaCount() {
        System.out.println("getVehiculoFacturaCount");
        VehiculoFacturaJpaController instance = new VehiculoFacturaJpaController(emf);
        int expResult = instance.findVehiculoFacturaEntities().size();
        int result = instance.getVehiculoFacturaCount();
        try{
        assertEquals(expResult, result);
         
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}
    
}
