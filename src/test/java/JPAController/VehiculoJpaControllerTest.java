/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Vehiculo;
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
public class VehiculoJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
   VehiculoJpaController VehiculoDao = new VehiculoJpaController(emf);
    
    public VehiculoJpaControllerTest() {
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
     * Test of getEntityManager method, of class VehiculoJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");
       VehiculoJpaController instance = new VehiculoJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class VehiculoJpaController.
     */
    @org.junit.Test

    
    
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        Vehiculo vehiculo = new Vehiculo();
        //vehiculo.setId_vehiculo(VehiculoDao.getVehiculoCount()+1);
        vehiculo.setVin("algo");
        vehiculo.setEstado(true);
        vehiculo.setId_marca(1);
        vehiculo.setId_numero_asientos(1);
        vehiculo.setId_tipo_cabina(1);
        vehiculo.setId_tipo_color(1);
        vehiculo.setId_tipo_gasolina(1);
        vehiculo.setId_tipo_vehiculo(1);
        vehiculo.setId_transmision(1);
        vehiculo.setId_marca(1);
        VehiculoJpaController instance = new VehiculoJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(vehiculo);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of edit method, of class VehiculoJpaController.
     */

    @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        Vehiculo vehiculo = new Vehiculo();
        vehiculo=VehiculoDao.findVehiculo(VehiculoDao.findVehiculoEntities().size());
        vehiculo.setVin("algo mas");
        vehiculo.setEstado(true);
        VehiculoJpaController instance = new VehiculoJpaController(emf);
         boolean expResult=true;
        boolean result = instance.editTest(vehiculo);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of destroy method, of class VehiculoJpaController.
     *//*
    @org.junit.Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        int id = 0;
        VehiculoJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        
        fail("The test case is a prototype.");
    }

    /**
     * Test of findVehiculoEntities method, of class VehiculoJpaController.
     */
    @org.junit.Test
    public void testFindVehiculoEntities_0args() {
        System.out.println("findVehiculoEntities");
        VehiculoJpaController instance = new VehiculoJpaController(emf);
        /*List<Cargo_empleado> tempce = CargoDao.findCargo_empleadoEntities();
        List<Cargo_empleado> result = instance.findCargo_empleadoEntities();*/
        try{
        instance.findVehiculoEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findVehiculoEntities method, of class VehiculoJpaController.
     */
    @org.junit.Test
    public void testFindVehiculoEntities_int_int() {
        System.out.println("findVehiculo");
        int maxResults = 0;
        int firstResult = 0;
        VehiculoJpaController instance = new VehiculoJpaController(emf);
        try{
        instance.findVehiculoEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findVehiculo method, of class VehiculoJpaController.
     */
    @org.junit.Test
    public void testFindVehiculo() {
        System.out.println("findVehiculo");
        VehiculoJpaController instance = new VehiculoJpaController(emf);
        int idVehiculo = VehiculoDao.findVehiculo(VehiculoDao.findVehiculoEntities().size()).getId_vehiculo();
        try{
        instance.findVehiculo(idVehiculo);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getVehiculoCount method, of class VehiculoJpaController.
     */
    @org.junit.Test
    public void testGetVehiculoCount() {
        System.out.println("getVehiculoCount");
        VehiculoJpaController instance = new VehiculoJpaController(emf);

        if(instance.getVehiculoCount()==VehiculoDao.findVehiculoEntities().size()){  
        }  
        else{
        fail("The test case is a prototype.");
        }
    }
    
}
