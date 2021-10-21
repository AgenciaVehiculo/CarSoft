/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.TipoVehiculo;
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
public class TipoVehiculoJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
   TipoVehiculoJpaController VehiculoDao = new TipoVehiculoJpaController(emf);
    
    public TipoVehiculoJpaControllerTest() {
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
     * Test of getEntityManager method, of class TipoVehiculoJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");
       TipoVehiculoJpaController instance = new TipoVehiculoJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class TipoVehiculoJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        tipoVehiculo.setIdTipoVehiculo(VehiculoDao.getTipoVehiculoCount()+1);
        tipoVehiculo.setTipoVehiculo("pickup");
        tipoVehiculo.setEstado(true);
        TipoVehiculoJpaController instance = new TipoVehiculoJpaController(emf);
        try{
        instance.create(tipoVehiculo);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class TipoVehiculoJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        tipoVehiculo=VehiculoDao.findTipoVehiculo(VehiculoDao.findTipoVehiculoEntities().size());
        tipoVehiculo.setTipoVehiculo("turismo");
        tipoVehiculo.setEstado(true);
        TipoVehiculoJpaController instance = new TipoVehiculoJpaController(emf);
        try{
        instance.edit(tipoVehiculo);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class TipoVehiculoJpaController.
     *//*
    @org.junit.Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        int id = 0;
        TipoVehiculoJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findTipoVehiculoEntities method, of class TipoVehiculoJpaController.
     */
    @org.junit.Test
    public void testFindTipoVehiculoEntities_0args() {
        System.out.println("findTipoVehiculoEntities");
        TipoVehiculoJpaController instance = new TipoVehiculoJpaController(emf);
        /*List<Cargo_empleado> tempce = CargoDao.findCargo_empleadoEntities();
        List<Cargo_empleado> result = instance.findCargo_empleadoEntities();*/
        try{
        instance.findTipoVehiculoEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findTipoVehiculoEntities method, of class TipoVehiculoJpaController.
     */
    @org.junit.Test
    public void testFindTipoVehiculoEntities_int_int() {
        System.out.println("findTipoVehiculo");
        int maxResults = 0;
        int firstResult = 0;
        TipoVehiculoJpaController instance = new TipoVehiculoJpaController(emf);
        try{
        instance.findTipoVehiculoEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findTipoVehiculo method, of class TipoVehiculoJpaController.
     */
    @org.junit.Test
    public void testFindTipoVehiculo() {
        System.out.println("findTipoVehiculo");
        TipoVehiculoJpaController instance = new TipoVehiculoJpaController(emf);
        int idTipoVehiculo = VehiculoDao.findTipoVehiculo(VehiculoDao.findTipoVehiculoEntities().size()).getIdTipoVehiculo();
        try{
        instance.findTipoVehiculo(idTipoVehiculo);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTipoVehiculoCount method, of class TipoVehiculoJpaController.
     */
    @org.junit.Test
    public void testGetTipoVehiculoCount() {
        System.out.println("getTipoVehiculoCount");
        TipoVehiculoJpaController instance = new TipoVehiculoJpaController(emf);

        if(instance.getTipoVehiculoCount()==VehiculoDao.findTipoVehiculoEntities().size()){  
        }  
        else{
        fail("The test case is a prototype.");
        }
    }
    
}
