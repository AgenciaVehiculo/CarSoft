/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.HistoricoPrecioVehiculos;
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
public class HistoricoPrecioVehiculosJpaControllerTest {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    HistoricoPrecioVehiculosJpaController HistoricoDao = new HistoricoPrecioVehiculosJpaController(emf);
    
    public HistoricoPrecioVehiculosJpaControllerTest() {
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
     * Test of getEntityManager method, of class HistoricoPrecioVehiculosJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
       System.out.println("getEntityManager");
        HistoricoPrecioVehiculosJpaController instance = new HistoricoPrecioVehiculosJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class HistoricoPrecioVehiculosJpaController.
     */
    
        @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        HistoricoPrecioVehiculos historicoPrecioVehiculos = new HistoricoPrecioVehiculos();
        //historicoPrecioVehiculos.setIdPrecioHistorico(HistoricoDao.getHistoricoPrecioVehiculosCount()+1);
        historicoPrecioVehiculos.setPrecio(100.00);
        historicoPrecioVehiculos.setEstado(true);
        historicoPrecioVehiculos.setFechaInicial("20210102");
        historicoPrecioVehiculos.setFechaFinal("20210101");
        historicoPrecioVehiculos.setId_vehiculo(2);
        HistoricoPrecioVehiculosJpaController instance = new HistoricoPrecioVehiculosJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(historicoPrecioVehiculos);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of edit method, of class HistoricoPrecioVehiculosJpaController.
     */

           @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        HistoricoPrecioVehiculos historicoPrecioVehiculos = new HistoricoPrecioVehiculos();
        historicoPrecioVehiculos=HistoricoDao.findHistoricoPrecioVehiculos(HistoricoDao.findHistoricoPrecioVehiculosEntities().size());
        historicoPrecioVehiculos.setPrecio(200.00);
        historicoPrecioVehiculos.setEstado(true);
        HistoricoPrecioVehiculosJpaController instance = new HistoricoPrecioVehiculosJpaController(emf);
         boolean expResult=true;
        boolean result = instance.editTest(historicoPrecioVehiculos);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of destroy method, of class HistoricoPrecioVehiculosJpaController.
     */
   /* @org.junit.Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        HistoricoPrecioVehiculosJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of findHistoricoPrecioVehiculosEntities method, of class HistoricoPrecioVehiculosJpaController.
     */
    @org.junit.Test
    public void testFindHistoricoPrecioVehiculosEntities_0args() {
       System.out.println("findHistoricoPrecioVehiculosEntities");
        HistoricoPrecioVehiculosJpaController instance = new HistoricoPrecioVehiculosJpaController(emf);
        /*List<Cargo_empleado> tempce = CargoDao.findCargo_empleadoEntities();
        List<Cargo_empleado> result = instance.findCargo_empleadoEntities();*/
        try{
        instance.findHistoricoPrecioVehiculosEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findHistoricoPrecioVehiculosEntities method, of class HistoricoPrecioVehiculosJpaController.
     */
    @org.junit.Test
    public void testFindHistoricoPrecioVehiculosEntities_int_int() {
       System.out.println("findHistoricoPrecioVehiculosEntities");
        int maxResults = 0;
        int firstResult = 0;
        HistoricoPrecioVehiculosJpaController instance = new HistoricoPrecioVehiculosJpaController(emf);
        try{
        instance.findHistoricoPrecioVehiculosEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findHistoricoPrecioVehiculos method, of class HistoricoPrecioVehiculosJpaController.
     */
    @org.junit.Test
    public void testFindHistoricoPrecioVehiculos() {
        System.out.println("findHistoricoPrecioVehiculos");
        HistoricoPrecioVehiculosJpaController instance = new HistoricoPrecioVehiculosJpaController(emf);
        int idHistoricoPrecioVehiculos = HistoricoDao.findHistoricoPrecioVehiculos(HistoricoDao.findHistoricoPrecioVehiculosEntities().size()).getIdPrecioHistorico();
        try{
        instance.findHistoricoPrecioVehiculos(idHistoricoPrecioVehiculos);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getHistoricoPrecioVehiculosCount method, of class HistoricoPrecioVehiculosJpaController.
     */
    @org.junit.Test
    public void testGetHistoricoPrecioVehiculosCount() {
       System.out.println("getHistoricoPrecioVehiculosCount");
        HistoricoPrecioVehiculosJpaController instance = new HistoricoPrecioVehiculosJpaController(emf);

        if(instance.getHistoricoPrecioVehiculosCount()==HistoricoDao.findHistoricoPrecioVehiculosEntities().size()){  
        }  
        else{
        fail("The test case is a prototype.");
        }
    }
    
}
