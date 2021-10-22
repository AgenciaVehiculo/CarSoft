/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.TipoCabina;
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
public class TipoCabinaJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
   TipoCabinaJpaController CabinaDao = new TipoCabinaJpaController(emf);
    
    public TipoCabinaJpaControllerTest() {
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
     * Test of getEntityManager method, of class TipoCabinaJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");
       TipoCabinaJpaController instance = new TipoCabinaJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class TipoCabinaJpaController.
     */

    @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        TipoCabina tipoCabina = new TipoCabina();
        tipoCabina.setIdTipoCabina(CabinaDao.getTipoCabinaCount()+1);
        tipoCabina.setTipoCabina("sencilla");
        tipoCabina.setEstado(true);
        TipoCabinaJpaController instance = new TipoCabinaJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(tipoCabina);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    /**
     * Test of edit method, of class TipoCabinaJpaController.
     */

        @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        TipoCabina tipoCabina = new TipoCabina();
        tipoCabina=CabinaDao.findTipoCabina(CabinaDao.findTipoCabinaEntities().size());
        tipoCabina.setTipoCabina("doble");
        tipoCabina.setEstado(true);
        TipoCabinaJpaController instance = new TipoCabinaJpaController(emf);
         boolean expResult=true;
        boolean result = instance.editTest(tipoCabina);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    /**
     * Test of destroy method, of class TipoCabinaJpaController.
     *//*
    @org.junit.Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        int id = 0;
        TipoCabinaJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of findTipoCabinaEntities method, of class TipoCabinaJpaController.
     */
    @org.junit.Test
    public void testFindTipoCabinaEntities_0args() {
        System.out.println("findTipoCabinaEntities");
        TipoCabinaJpaController instance = new TipoCabinaJpaController(emf);
        /*List<Cargo_empleado> tempce = CargoDao.findCargo_empleadoEntities();
        List<Cargo_empleado> result = instance.findCargo_empleadoEntities();*/
        try{
        instance.findTipoCabinaEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findTipoCabinaEntities method, of class TipoCabinaJpaController.
     */
    @org.junit.Test
    public void testFindTipoCabinaEntities_int_int() {
        System.out.println("findTipoCabina");
        int maxResults = 0;
        int firstResult = 0;
        TipoCabinaJpaController instance = new TipoCabinaJpaController(emf);
        try{
        instance.findTipoCabinaEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findTipoCabina method, of class TipoCabinaJpaController.
     */
    @org.junit.Test
    public void testFindTipoCabina() {
        System.out.println("findTipoCabina");
        TipoCabinaJpaController instance = new TipoCabinaJpaController(emf);
        int idTipoCabina = CabinaDao.findTipoCabina(CabinaDao.findTipoCabinaEntities().size()).getIdTipoCabina();
        try{
        instance.findTipoCabina(idTipoCabina);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTipoCabinaCount method, of class TipoCabinaJpaController.
     */
    @org.junit.Test
    public void testGetTipoCabinaCount() {
        System.out.println("getTipoCabinaCount");
        TipoCabinaJpaController instance = new TipoCabinaJpaController(emf);

        if(instance.getTipoCabinaCount()==CabinaDao.findTipoCabinaEntities().size()){  
        }  
        else{
        fail("The test case is a prototype.");
        }
    }
    
}
