/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Marca;
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
public class MarcaJpaControllerTest {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
   MarcaJpaController MarcaDao = new MarcaJpaController(emf);
    
    public MarcaJpaControllerTest() {
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
     * Test of getEntityManager method, of class MarcaJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");
        MarcaJpaController instance = new MarcaJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class MarcaJpaController.
     */
    @org.junit.Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        Marca marca = new Marca();
        marca.setIdMarca(MarcaDao.getMarcaCount()+1);
        marca.setMarca("Nissan");
        marca.setEstado(true);
        MarcaJpaController instance = new MarcaJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(marca);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }


    /**
     * Test of edit method, of class MarcaJpaController.
     */
            @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        Marca marca;
        marca=MarcaDao.findMarca(MarcaDao.findMarcaEntities().size());
        marca.setMarca("Toyota");
        marca.setEstado(true);
        MarcaJpaController instance = new MarcaJpaController(emf);
        boolean expResult=true;
        boolean result = instance.editTest(marca);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of destroy method, of class MarcaJpaController.
     *//*
    @org.junit.Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        int id = 0;
        MarcaJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of findMarcaEntities method, of class MarcaJpaController.
     */
    @org.junit.Test
    public void testFindMarcaEntities_0args() {
        System.out.println("findMarcaEntities");
        MarcaJpaController instance = new MarcaJpaController(emf);
        /*List<Cargo_empleado> tempce = CargoDao.findCargo_empleadoEntities();
        List<Cargo_empleado> result = instance.findCargo_empleadoEntities();*/
        try{
        instance.findMarcaEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findMarcaEntities method, of class MarcaJpaController.
     */
    @org.junit.Test
    public void testFindMarcaEntities_int_int() {
        System.out.println("findMarca");
        int maxResults = 0;
        int firstResult = 0;
        MarcaJpaController instance = new MarcaJpaController(emf);
        try{
        instance.findMarcaEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findMarca method, of class MarcaJpaController.
     */
    @org.junit.Test
    public void testFindMarca() {
        System.out.println("findMarca");
        MarcaJpaController instance = new MarcaJpaController(emf);
        int idMarca = MarcaDao.findMarca(MarcaDao.findMarcaEntities().size()).getIdMarca();
        try{
        instance.findMarca(idMarca);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getMarcaCount method, of class MarcaJpaController.
     */
    @org.junit.Test
    public void testGetMarcaCount() {
        System.out.println("getMarcaCount");
        MarcaJpaController instance = new MarcaJpaController(emf);

        if(instance.getMarcaCount()==MarcaDao.findMarcaEntities().size()){  
        }  
        else{
        fail("The test case is a prototype.");
        }
    }
    
}
