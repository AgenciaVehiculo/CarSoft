/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.HistoricoSueldo_empleado;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class HistoricoSueldo_empleadoJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    HistoricoSueldo_empleadoJpaController HistoricoSueldoDao = new HistoricoSueldo_empleadoJpaController(emf);
    public HistoricoSueldo_empleadoJpaControllerTest() {
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
        
        HistoricoSueldo_empleadoJpaController instance = new HistoricoSueldo_empleadoJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    
        @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        HistoricoSueldo_empleado historicoSueldo_empleado = new HistoricoSueldo_empleado();
        HistoricoSueldo_empleadoJpaController instance = new  HistoricoSueldo_empleadoJpaController(emf);
        historicoSueldo_empleado.setId_sueldo(HistoricoSueldoDao.getHistoricoSueldo_empleadoCount()+1);
        historicoSueldo_empleado.setId_empleado(4);
        historicoSueldo_empleado.setEstado(true);
        boolean expResult=true;
        boolean result = instance.createTest(historicoSueldo_empleado);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }


           @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        HistoricoSueldo_empleado historicoSueldo_empleado;
        HistoricoSueldo_empleadoJpaController instance = new  HistoricoSueldo_empleadoJpaController(emf);
        historicoSueldo_empleado=HistoricoSueldoDao.findHistoricoSueldo_empleado(HistoricoSueldoDao.findHistoricoSueldo_empleadoEntities().size());
        historicoSueldo_empleado.setId_empleado(4);
         boolean expResult=true;
        boolean result = instance.editTest(historicoSueldo_empleado);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    @Test
    public void testFindHistoricoSueldo_empleadoEntities_0args() {
        System.out.println("findHistoricoSueldo_empleadoEntities");
        HistoricoSueldo_empleadoJpaController instance = new HistoricoSueldo_empleadoJpaController(emf);
        try{
        instance.findHistoricoSueldo_empleadoEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        
        }
    }

    @Test
    public void testFindHistoricoSueldo_empleadoEntities_int_int() {
        System.out.println("findHistoricoSueldo_empleadoEntities");
        int maxResults = 2;
        int firstResult = 1;
         HistoricoSueldo_empleadoJpaController instance = new  HistoricoSueldo_empleadoJpaController(emf);
        try{
        instance.findHistoricoSueldo_empleadoEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testFindHistoricoSueldo_empleado() {
        System.out.println("findHistoricoSueldo_empleado");
        HistoricoSueldo_empleadoJpaController instance = new HistoricoSueldo_empleadoJpaController(emf);
        int idSueldo = HistoricoSueldoDao.findHistoricoSueldo_empleado(HistoricoSueldoDao.findHistoricoSueldo_empleadoEntities().size()).getId_sueldo();
        try{
        instance.findHistoricoSueldo_empleado(idSueldo);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetHistoricoSueldo_empleadoCount() {
        System.out.println("getHistoricoSueldo_empleadoCount");
        HistoricoSueldo_empleadoJpaController instance = new HistoricoSueldo_empleadoJpaController(emf);
        int expResult = instance.findHistoricoSueldo_empleadoEntities().size();
        int result = instance.getHistoricoSueldo_empleadoCount();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
}
