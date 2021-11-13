/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Pieza;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class PiezaJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    PiezaJpaController PiezaDao = new PiezaJpaController(emf);
    public PiezaJpaControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        PiezaJpaController instance = new PiezaJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    
    @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        Pieza pieza = new Pieza();
        pieza.setId_Pieza(PiezaDao.getPiezaCount()+1);
        pieza.setId_Tipo_Pieza(2);
        PiezaJpaController instance = new PiezaJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(pieza);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }


       @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        Pieza pieza;
        pieza=PiezaDao.findPieza(PiezaDao.findPiezaEntities().size());
        pieza.setId_Tipo_Pieza(1);
        PiezaJpaController instance = new PiezaJpaController(emf);
         boolean expResult=true;
        boolean result = instance.editTest(pieza);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    @Test
    public void testFindPiezaEntities_0args() {
        System.out.println("findPiezaEntities");
        PiezaJpaController instance = new PiezaJpaController(emf);
        try{
        instance.findPiezaEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
        
    }

    @Test
    public void testFindPiezaEntities_int_int() {
        System.out.println("findPiezaEntities");
        int maxResults = 2;
        int firstResult = 1;
        PiezaJpaController instance = new PiezaJpaController(emf);
        try{
        instance.findPiezaEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testFindPieza() {
        System.out.println("findPieza");
        PiezaJpaController instance = new PiezaJpaController(emf);
        int idPieza = PiezaDao.findPieza(PiezaDao.findPiezaEntities().size()).getId_Pieza();
        try{
        instance.findPieza(idPieza);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetPiezaCount() {
        System.out.println("getPiezaCount");
        PiezaJpaController instance = new PiezaJpaController(emf);       
        int expResult = instance.findPiezaEntities().size();
        int result = instance.getPiezaCount();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    
}
