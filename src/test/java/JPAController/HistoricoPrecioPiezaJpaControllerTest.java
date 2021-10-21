/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.HistoricoPrecioPieza;
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
public class HistoricoPrecioPiezaJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    HistoricoPrecioPiezaJpaController HistoricoPiezaDao = new HistoricoPrecioPiezaJpaController(emf);
    public HistoricoPrecioPiezaJpaControllerTest() {
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
        HistoricoPrecioPiezaJpaController instance = new HistoricoPrecioPiezaJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testCreate() throws Exception{
        System.out.println("create");       
        HistoricoPrecioPieza historicoPrecioPieza = new HistoricoPrecioPieza();
        HistoricoPrecioPiezaJpaController instance = new HistoricoPrecioPiezaJpaController(emf);   
        historicoPrecioPieza.setIdPieza(2);   
        historicoPrecioPieza.setEstado(true);
        historicoPrecioPieza.setFechaFinal("2021-01-02");
        historicoPrecioPieza.setFechaInicial("2021-01-04");
        try{
        instance.create(historicoPrecioPieza);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
        
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        
        HistoricoPrecioPieza historicoPrecioPieza;
        HistoricoPrecioPiezaJpaController instance = new  HistoricoPrecioPiezaJpaController(emf);
        historicoPrecioPieza=HistoricoPiezaDao.findHistoricoPrecioPieza(HistoricoPiezaDao.findHistoricoPrecioPiezaEntities().size());
        historicoPrecioPieza.setIdPieza(2);
        try{
        instance.edit(historicoPrecioPieza);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }  
        
    
    }

    @Test
    public void testFindHistoricoPrecioPiezaEntities_0args() {
        System.out.println("findHistoricoPrecioPiezaEntities");
        HistoricoPrecioPiezaJpaController instance = new  HistoricoPrecioPiezaJpaController(emf);
        try{
        instance.findHistoricoPrecioPiezaEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        
        }
    }

    @Test
    public void testFindHistoricoPrecioPiezaEntities_int_int() {
        System.out.println("findHistoricoPrecioPiezaEntities");
        int maxResults = 2;
        int firstResult = 1;
        HistoricoPrecioPiezaJpaController instance = new  HistoricoPrecioPiezaJpaController(emf);
        try{
        instance.findHistoricoPrecioPiezaEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testFindHistoricoPrecioPieza() {
        System.out.println("findHistoricoPrecioPieza");
        HistoricoPrecioPiezaJpaController instance = new  HistoricoPrecioPiezaJpaController(emf);
        int idPrecio = HistoricoPiezaDao.findHistoricoPrecioPieza(HistoricoPiezaDao.findHistoricoPrecioPiezaEntities().size()).getIdPrecioHistorico();
        try{
        instance.findHistoricoPrecioPieza(idPrecio);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetHistoricoPrecioPiezaCount() {
        System.out.println("getHistoricoPrecioPiezaCount");
        HistoricoPrecioPiezaJpaController instance = new  HistoricoPrecioPiezaJpaController(emf);
        int expResult = instance.findHistoricoPrecioPiezaEntities().size();
        int result = instance.getHistoricoPrecioPiezaCount();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    
}
