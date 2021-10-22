/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Tipo_color;
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
public class Tipo_colorJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
   Tipo_colorJpaController ColorDao = new Tipo_colorJpaController(emf);
    
    public Tipo_colorJpaControllerTest() {
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
     * Test of getEntityManager method, of class Tipo_colorJpaController.
     */
    @org.junit.Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
       Tipo_colorJpaController instance = new Tipo_colorJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class Tipo_colorJpaController.
     */
    
    @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        Tipo_color tipo_color = new Tipo_color();
        tipo_color.setId_tipo_color(ColorDao.getTipo_colorCount()+1);
        tipo_color.setTipo_color("rojo");
        tipo_color.setEstado(true);
        Tipo_colorJpaController instance = new Tipo_colorJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(tipo_color);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of edit method, of class Tipo_colorJpaController.
     */
    
            @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        Tipo_color tipo_color = new Tipo_color();
        tipo_color=ColorDao.findTipo_color(ColorDao.findTipo_colorEntities().size());
        tipo_color.setTipo_color("negro");
        tipo_color.setEstado(true);
        Tipo_colorJpaController instance = new Tipo_colorJpaController(emf);
         boolean expResult=true;
        boolean result = instance.editTest(tipo_color);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of destroy method, of class Tipo_colorJpaController.
     *//*
    @org.junit.Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        int id = 0;
        Tipo_colorJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findTipo_colorEntities method, of class Tipo_colorJpaController.
     */
    @org.junit.Test
    public void testFindTipo_colorEntities_0args() {
        System.out.println("findTipo_colorEntities");
        Tipo_colorJpaController instance = new Tipo_colorJpaController(emf);
        /*List<Cargo_empleado> tempce = CargoDao.findCargo_empleadoEntities();
        List<Cargo_empleado> result = instance.findCargo_empleadoEntities();*/
        try{
        instance.findTipo_colorEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findTipo_colorEntities method, of class Tipo_colorJpaController.
     */
    @org.junit.Test
    public void testFindTipo_colorEntities_int_int() {
        System.out.println("findTipo_color");
        int maxResults = 0;
        int firstResult = 0;
        Tipo_colorJpaController instance = new Tipo_colorJpaController(emf);
        try{
        instance.findTipo_colorEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findTipo_color method, of class Tipo_colorJpaController.
     */
    @org.junit.Test
    public void testFindTipo_color() {
        System.out.println("findTipo_color");
        Tipo_colorJpaController instance = new Tipo_colorJpaController(emf);
        int idTipo_color = ColorDao.findTipo_color(ColorDao.findTipo_colorEntities().size()).getId_tipo_color();
        try{
        instance.findTipo_color(idTipo_color);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTipo_colorCount method, of class Tipo_colorJpaController.
     */
    @org.junit.Test
    public void testGetTipo_colorCount() {
        System.out.println("getTipo_colorCount");
        Tipo_colorJpaController instance = new Tipo_colorJpaController(emf);

        if(instance.getTipo_colorCount()==ColorDao.findTipo_colorEntities().size()){  
        }  
        else{
        fail("The test case is a prototype.");
        }
    }
    
}
