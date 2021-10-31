/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Cargo_empleado;
import Clases.TipoPieza;
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
public class TipoPiezaJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    TipoPiezaJpaController TipoPiezaDao = new TipoPiezaJpaController(emf);
    
    public TipoPiezaJpaControllerTest() {
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
        TipoPiezaJpaController instance = new TipoPiezaJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    


            @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        TipoPieza tipopieza = new TipoPieza();
        tipopieza=TipoPiezaDao.findTipoPieza(TipoPiezaDao.findTipoPiezaEntities().size());
        TipoPiezaJpaController instance = new  TipoPiezaJpaController(emf);
         boolean expResult=true;
        boolean result = instance.editTest(tipopieza);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    @Test
    public void testFindTipoPiezaEntities_0args() {
        System.out.println("findTipoPiezaEntities");
        TipoPiezaJpaController instance = new TipoPiezaJpaController(emf);
        try{
        instance.findTipoPiezaEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testFindTipoPiezaEntities_int_int() {
        System.out.println("findTipoPiezaEntities");
        int maxResults = 2;
        int firstResult = 1;
        TipoPiezaJpaController instance = new TipoPiezaJpaController(emf);
        try{
        instance.findTipoPiezaEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testFindTipoPieza() {
        System.out.println("findTipoPieza");
        TipoPiezaJpaController instance = new TipoPiezaJpaController(emf);
        int idTipoPieza = TipoPiezaDao.findTipoPieza(TipoPiezaDao.findTipoPiezaEntities().size()).getIDtipopieza();
        try{
        instance.findTipoPieza(idTipoPieza);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetTipoPiezaCount() {
        System.out.println("getTipoPiezaCount");       
        TipoPiezaJpaController instance = new TipoPiezaJpaController(emf);
        int expResult = instance.findTipoPiezaEntities().size();
        int result = instance.getTipoPiezaCount();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }


    
        @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        TipoPieza tipoPieza = new TipoPieza();
        TipoPiezaJpaController instance = new  TipoPiezaJpaController(emf);
        tipoPieza.setiDtipopieza(TipoPiezaDao.getTipoPiezaCount()+1);
        boolean expResult=true;
        boolean result = instance.createTest(tipoPieza);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
  
}
