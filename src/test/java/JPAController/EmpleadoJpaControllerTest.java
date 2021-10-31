/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Empleado;
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
public class EmpleadoJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    EmpleadoJpaController EmpleadoDao = new EmpleadoJpaController(emf);
    public EmpleadoJpaControllerTest() {
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
        EmpleadoJpaController instance = new EmpleadoJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }
        @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        Empleado empleado = new Empleado();
        empleado.setId_Persona(2);
        empleado.setEstado(true);
        empleado.setFecha_ingreso("2020-01-01");
        EmpleadoJpaController instance = new EmpleadoJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(empleado);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

        @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
         EmpleadoJpaController instance = new EmpleadoJpaController(emf);
        Empleado empleado = instance.findEmpleado(1);
        empleado.setId_Persona(2);
         boolean expResult=true;
        boolean result = instance.editTest(empleado);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    @Test
    public void testFindEmpleadoEntities_0args() {
        System.out.println("findEmpleadoEntities");
        EmpleadoJpaController instance = new EmpleadoJpaController(emf);
        try{
        instance.findEmpleadoEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testFindEmpleadoEntities_int_int() {
        System.out.println("findEmpleadoEntities");
        int maxResults = 2;
        int firstResult = 1;
        EmpleadoJpaController instance = new EmpleadoJpaController(emf);
        try{
        instance.findEmpleadoEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
        
        
    }

    @Test
    public void testFindEmpleado() {
        System.out.println("findEmpleado");
        EmpleadoJpaController instance = new EmpleadoJpaController(emf);
        int idEmpleado = EmpleadoDao.findEmpleado(EmpleadoDao.findEmpleadoEntities().size()).getId_Empleado();
        try{
        instance.findEmpleado(idEmpleado);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetEmpleadoCount() {
        System.out.println("getEmpleadoCount");
        EmpleadoJpaController instance = new EmpleadoJpaController(emf);
        int expResult = instance.findEmpleadoEntities().size();
        int result = instance.getEmpleadoCount();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }
    
}
