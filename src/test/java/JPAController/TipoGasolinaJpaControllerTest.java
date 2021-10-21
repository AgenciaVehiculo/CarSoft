/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.TipoGasolina;
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
public class TipoGasolinaJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
   TipoGasolinaJpaController GasolinaDao = new TipoGasolinaJpaController(emf);
    
    public TipoGasolinaJpaControllerTest() {
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
     * Test of getEntityManager method, of class TipoGasolinaJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");
       TipoGasolinaJpaController instance = new TipoGasolinaJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class TipoGasolinaJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        TipoGasolina tipoGasolina = new TipoGasolina();
        tipoGasolina.setIdTipoGasolina(GasolinaDao.getTipoGasolinaCount()+1);
        tipoGasolina.setTipoGasolina("regular");
        tipoGasolina.setEstado(true);
        TipoGasolinaJpaController instance = new TipoGasolinaJpaController(emf);
        try{
        instance.create(tipoGasolina);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class TipoGasolinaJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        TipoGasolina tipoGasolina = new TipoGasolina();
        tipoGasolina=GasolinaDao.findTipoGasolina(GasolinaDao.findTipoGasolinaEntities().size());
        tipoGasolina.setTipoGasolina("dieseel");
        tipoGasolina.setEstado(true);
        TipoGasolinaJpaController instance = new TipoGasolinaJpaController(emf);
        try{
        instance.edit(tipoGasolina);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class TipoGasolinaJpaController.
     *//*
    @org.junit.Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        int id = 0;
        TipoGasolinaJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findTipoGasolinaEntities method, of class TipoGasolinaJpaController.
     */
    @org.junit.Test
    public void testFindTipoGasolinaEntities_0args() {
        System.out.println("findTipoGasolinaEntities");
        TipoGasolinaJpaController instance = new TipoGasolinaJpaController(emf);
        /*List<Cargo_empleado> tempce = CargoDao.findCargo_empleadoEntities();
        List<Cargo_empleado> result = instance.findCargo_empleadoEntities();*/
        try{
        instance.findTipoGasolinaEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findTipoGasolinaEntities method, of class TipoGasolinaJpaController.
     */
    @org.junit.Test
    public void testFindTipoGasolinaEntities_int_int() {
        System.out.println("findTipoGasolina");
        int maxResults = 0;
        int firstResult = 0;
        TipoGasolinaJpaController instance = new TipoGasolinaJpaController(emf);
        try{
        instance.findTipoGasolinaEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findTipoGasolina method, of class TipoGasolinaJpaController.
     */
    @org.junit.Test
    public void testFindTipoGasolina() {
        System.out.println("findTipoGasolina");
        TipoGasolinaJpaController instance = new TipoGasolinaJpaController(emf);
        int idTipoGasolina = GasolinaDao.findTipoGasolina(GasolinaDao.findTipoGasolinaEntities().size()).getIdTipoGasolina();
        try{
        instance.findTipoGasolina(idTipoGasolina);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTipoGasolinaCount method, of class TipoGasolinaJpaController.
     */
    @org.junit.Test
    public void testGetTipoGasolinaCount() {
        System.out.println("getTipoGasolinaCount");
        TipoGasolinaJpaController instance = new TipoGasolinaJpaController(emf);

        if(instance.getTipoGasolinaCount()==GasolinaDao.findTipoGasolinaEntities().size()){  
        }  
        else{
        fail("The test case is a prototype.");
        }
    }
    
}
