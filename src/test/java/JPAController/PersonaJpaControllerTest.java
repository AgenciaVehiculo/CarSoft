/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Persona;
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
 * @author EDUIN FLORES
 */
public class PersonaJpaControllerTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    PersonaJpaController PersonaDao = new PersonaJpaController(emf);
    
    public PersonaJpaControllerTest() {
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
     * Test of getEntityManager method, of class PersonaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        PersonaJpaController instance = new PersonaJpaController(emf);
        
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }
    

    /**
     * Test of create method, of class PersonaJpaController.
     */
        @Test
    public void testCreateTest() throws Exception {
        System.out.println("createTest");
        Persona persona = new Persona();
        persona.setID_tipo_documento(2);
        
        PersonaJpaController instance = new PersonaJpaController(emf);
        boolean expResult=true;
        boolean result = instance.createTest(persona);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of edit method, of class PersonaJpaController.
     */
    
            @Test
    public void testEditTest() throws Exception {
        System.out.println("editTest");
        PersonaJpaController instance = new PersonaJpaController(emf);
        Persona persona = instance.findPersona(1);
        persona.setId_persona(2);
         boolean expResult=true;
        boolean result = instance.editTest(persona);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        fail("The test case is a prototype.");
    }
    }


    /**
     * Test of destroy method, of class PersonaJpaController.
     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        int id = 0;
//        PersonaJpaController instance = null;
//        try{
//        instance.destroy(id);
//        } catch(Exception e){
//        fail("The test case is a prototype.");
//        }
//    }

    /**
     * Test of findPersonaEntities method, of class PersonaJpaController.
     */
    @Test
    public void testFindPersonaEntities_0args() {
        System.out.println("findPersonaEntities");
        PersonaJpaController instance = new PersonaJpaController(emf);
        
        try {
        instance.findPersonaEntities();
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    

    /**
     * Test of findPersonaEntities method, of class PersonaJpaController.
     */
    @Test
    public void testFindPersonaEntities_int_int() {
        System.out.println("findPersonaEntities");
        int maxResults = 2;
        int firstResult = 1;
        PersonaJpaController instance = new PersonaJpaController(emf);
        
        try {
        instance.findPersonaEntities(maxResults, firstResult);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
   

    /**
     * Test of findPersona method, of class PersonaJpaController.
     */
    @Test
    public void testFindPersona() {
        System.out.println("findPersona");
        PersonaJpaController instance = new PersonaJpaController(emf);
        int idPersona = (PersonaDao.findPersonaEntities().size());
        
        try {
        instance.findPersona(idPersona);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }


    /**
     * Test of getPersonaCount method, of class PersonaJpaController.
     */
    @Test
    public void testGetPersonaCount() {
        System.out.println("getPersonaCount");
        PersonaJpaController instance = new PersonaJpaController(emf);
        
        int expResult = instance.findPersonaEntities().size();
        int result = instance.getPersonaCount();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
    
}
