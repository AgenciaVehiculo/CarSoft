/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.HistoricoCargo_empleado;
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
public class HistoricoCargo_empleadoJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    HistoricoCargo_empleadoJpaController HistoricoCargoDao = new HistoricoCargo_empleadoJpaController(emf);
    
    public HistoricoCargo_empleadoJpaControllerTest() {
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
        HistoricoCargo_empleadoJpaController instance = new HistoricoCargo_empleadoJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        HistoricoCargo_empleadoJpaController instance = new  HistoricoCargo_empleadoJpaController(emf);
        HistoricoCargo_empleado historicoCargo_empleado = new HistoricoCargo_empleado();
        historicoCargo_empleado.setId_empleado(4);   
        historicoCargo_empleado.setId_cargo(2);
        historicoCargo_empleado.setEstado(true);
        try{
        instance.create(historicoCargo_empleado);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        HistoricoCargo_empleadoJpaController instance = new  HistoricoCargo_empleadoJpaController(emf);
        HistoricoCargo_empleado historicoCargo_empleado = instance.findHistoricoCargo_empleado(1);
        historicoCargo_empleado.setId_empleado(4);   
        historicoCargo_empleado.setId_cargo(2);
        try{
        instance.edit(historicoCargo_empleado);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    @Test
    public void testFindHistoricoCargo_empleadoEntities_0args() {
        System.out.println("findHistoricoCargo_empleadoEntities");
        
        HistoricoCargo_empleadoJpaController instance = new  HistoricoCargo_empleadoJpaController(emf);
        try{
        instance.findHistoricoCargo_empleadoEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        
        }
    }

    @Test
    public void testFindHistoricoCargo_empleadoEntities_int_int() {
        int maxResults = 2;
        int firstResult = 1;
        HistoricoCargo_empleadoJpaController instance = new  HistoricoCargo_empleadoJpaController(emf);
        try{
        instance.findHistoricoCargo_empleadoEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testFindHistoricoCargo_empleado() {
        HistoricoCargo_empleadoJpaController instance = new  HistoricoCargo_empleadoJpaController(emf);
        int idCargo = HistoricoCargoDao.findHistoricoCargo_empleado(HistoricoCargoDao.findHistoricoCargo_empleadoEntities().size()).getId_cargo();
        try{
        instance.findHistoricoCargo_empleado(idCargo);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetHistoricoCargo_empleadoCount() {
        System.out.println("getHistoricoCargo_empleadoCount");      
        HistoricoCargo_empleadoJpaController instance = new  HistoricoCargo_empleadoJpaController(emf);
        int expResult = instance.findHistoricoCargo_empleadoEntities().size();
        int result = instance.getHistoricoCargo_empleadoCount();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    
}
