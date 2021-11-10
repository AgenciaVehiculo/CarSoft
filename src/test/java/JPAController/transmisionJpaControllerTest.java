/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.transmision;
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
 * @author neos9
 */
public class transmisionJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
   transmisionJpaController transmisionDao = new transmisionJpaController(emf);
    
    public transmisionJpaControllerTest() {
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
     * Test of getEntityManager method, of class transmisionJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
       transmisionJpaController instance = new transmisionJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class transmisionJpaController.
     */

        @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        transmision Transmision = new transmision();
        Transmision.setId_transmision(transmisionDao.gettransmisionCount()+1);
        Transmision.setTransmision("manual");
        Transmision.setEstado(true);
        transmisionJpaController instance = new transmisionJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(Transmision);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of edit method, of class transmisionJpaController.
     */


    @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        transmision Transmision = new transmision();
        Transmision=transmisionDao.findtransmision(transmisionDao.findtransmisionEntities().size());
        Transmision.setTransmision("automatica");
        Transmision.setEstado(true);
        transmisionJpaController instance = new transmisionJpaController(emf);
         boolean expResult=true;
        boolean result = instance.editTest(Transmision);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    /**
     * Test of destroy method, of class transmisionJpaController.
     *//*
    @org.junit.Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        int id = 0;
        transmisionJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findtransmisionEntities method, of class transmisionJpaController.
     */
    @org.junit.Test
    public void testFindtransmisionEntities_0args() {
        System.out.println("findtransmisionEntities");
        transmisionJpaController instance = new transmisionJpaController(emf);
        /*List<Cargo_empleado> tempce = CargoDao.findCargo_empleadoEntities();
        List<Cargo_empleado> result = instance.findCargo_empleadoEntities();*/
        try{
        instance.findtransmisionEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findtransmisionEntities method, of class transmisionJpaController.
     */
    @org.junit.Test
    public void testFindtransmisionEntities_int_int() {
        System.out.println("findtransmision");
        int maxResults = 0;
        int firstResult = 0;
        transmisionJpaController instance = new transmisionJpaController(emf);
        try{
        instance.findtransmisionEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findtransmision method, of class transmisionJpaController.
     */
    @org.junit.Test
    public void testFindtransmision() {
        System.out.println("findtransmision");
        transmisionJpaController instance = new transmisionJpaController(emf);
        int idtransmision = transmisionDao.findtransmision(transmisionDao.findtransmisionEntities().size()).getId_transmision();
        try{
        instance.findtransmision(idtransmision);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of gettransmisionCount method, of class transmisionJpaController.
     */
    @org.junit.Test
    public void testGettransmisionCount() {
        System.out.println("gettransmisionCount");
        transmisionJpaController instance = new transmisionJpaController(emf);

        if(instance.gettransmisionCount()==transmisionDao.findtransmisionEntities().size()){  
        }  
        else{
        fail("The test case is a prototype.");
        }
    }
    
}
