/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Cargo_empleado;
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
public class Cargo_empleadoJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    Cargo_empleadoJpaController CargoDao = new Cargo_empleadoJpaController(emf);
    //Cargo_empleadoJpaController instance = new ModalPiezasCombo(parent,true);
    
    public Cargo_empleadoJpaControllerTest() {
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
        Cargo_empleadoJpaController instance = new Cargo_empleadoJpaController(emf);
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }
    @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        Cargo_empleado cargo_empleado = new Cargo_empleado();
        cargo_empleado.setEstado(true);
        Cargo_empleadoJpaController instance = new Cargo_empleadoJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(cargo_empleado);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

        @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        Cargo_empleadoJpaController instance = new Cargo_empleadoJpaController(emf);
        Cargo_empleado cargo_empleado = instance.findCargo_empleado(1);
         boolean expResult=true;
        boolean result = instance.editTest(cargo_empleado);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }



 
    @Test
    public void testFindCargo_empleado() {
        System.out.println("findCargo_empleado");
        Cargo_empleadoJpaController instance = new Cargo_empleadoJpaController(emf);
        int idCargo = CargoDao.findCargo_empleado(CargoDao.findCargo_empleadoEntities().size()).getId_cargo();
        try{
        instance.findCargo_empleado(idCargo);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testFindCargo_empleadoEntities_0args() {
        System.out.println("findCargo_empleadoEntities");
        Cargo_empleadoJpaController instance = new Cargo_empleadoJpaController(emf);
        try{
        instance.findCargo_empleadoEntities();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testFindCargo_empleadoEntities_int_int() {
        System.out.println("findCargo_empleadoEntities");
        int maxResults = 2;
        int firstResult = 1;
        Cargo_empleadoJpaController instance = new Cargo_empleadoJpaController(emf);
        try{
        instance.findCargo_empleadoEntities(maxResults, firstResult);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGetCargo_empleadoCount() {
        System.out.println("getCargo_empleadoCount");
        Cargo_empleadoJpaController instance = new Cargo_empleadoJpaController(emf);
        int expResult = instance.findCargo_empleadoEntities().size();
        int result = instance.getCargo_empleadoCount();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
        }
    }



}
