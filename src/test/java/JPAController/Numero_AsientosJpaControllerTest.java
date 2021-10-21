/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Numero_Asientos;
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
public class Numero_AsientosJpaControllerTest {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
   Numero_AsientosJpaController AsientosDao = new Numero_AsientosJpaController(emf);
    
    public Numero_AsientosJpaControllerTest() {
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
     * Test of getEntityManager method, of class Numero_AsientosJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() throws Exception{
        System.out.println("getEntityManager");
       Numero_AsientosJpaController instance = new Numero_AsientosJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class Numero_AsientosJpaController.
     */
    @org.junit.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Numero_Asientos numero_Asientos = new Numero_Asientos();
        numero_Asientos.setId_Numero_Asientos(AsientosDao.getNumero_AsientosCount()+1);
        numero_Asientos.setNumero_Asientos("4");
        numero_Asientos.setEstado(true);
        Numero_AsientosJpaController instance = new Numero_AsientosJpaController(emf);
        try{
        instance.create(numero_Asientos);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class Numero_AsientosJpaController.
     */
    @org.junit.Test
    public void testEdit() throws Exception {
       System.out.println("edit");
        Numero_Asientos numero_Asientos = new Numero_Asientos();
        numero_Asientos=AsientosDao.findNumero_Asientos(AsientosDao.findNumero_AsientosEntities().size());
        numero_Asientos.setNumero_Asientos("6");
        numero_Asientos.setEstado(true);
        Numero_AsientosJpaController instance = new Numero_AsientosJpaController(emf);
        try{
        instance.edit(numero_Asientos);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class Numero_AsientosJpaController.
     *//*
    @org.junit.Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        int id = 0;
        Numero_AsientosJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of findNumero_AsientosEntities method, of class Numero_AsientosJpaController.
     */
    @org.junit.Test
    public void testFindNumero_AsientosEntities_0args() {
       System.out.println("findNumero_AsientosEntities");
        Numero_AsientosJpaController instance = new Numero_AsientosJpaController(emf);
        /*List<Cargo_empleado> tempce = CargoDao.findCargo_empleadoEntities();
        List<Cargo_empleado> result = instance.findCargo_empleadoEntities();*/
        try{
        instance.findNumero_AsientosEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findNumero_AsientosEntities method, of class Numero_AsientosJpaController.
     */
    @org.junit.Test
    public void testFindNumero_AsientosEntities_int_int() {
        System.out.println("findNumero_Asientos");
        int maxResults = 0;
        int firstResult = 0;
        Numero_AsientosJpaController instance = new Numero_AsientosJpaController(emf);
        try{
        instance.findNumero_AsientosEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findNumero_Asientos method, of class Numero_AsientosJpaController.
     */
    @org.junit.Test
    public void testFindNumero_Asientos() {
        System.out.println("findNumero_Asientos");
        Numero_AsientosJpaController instance = new Numero_AsientosJpaController(emf);
        int idNumero_Asientos = AsientosDao.findNumero_Asientos(AsientosDao.findNumero_AsientosEntities().size()).getId_Numero_Asientos();
        try{
        instance.findNumero_Asientos(idNumero_Asientos);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getNumero_AsientosCount method, of class Numero_AsientosJpaController.
     */
    @org.junit.Test
    public void testGetNumero_AsientosCount() {
        System.out.println("getNumero_AsientosCount");
        Numero_AsientosJpaController instance = new Numero_AsientosJpaController(emf);

        if(instance.getNumero_AsientosCount()==AsientosDao.findNumero_AsientosEntities().size()){  
        }  
        else{
        fail("The test case is a prototype.");
        }
    }
    
}
