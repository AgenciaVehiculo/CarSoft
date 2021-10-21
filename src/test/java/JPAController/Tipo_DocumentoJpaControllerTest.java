/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Tipo_Documento;
import JPAController.exceptions.NonexistentEntityException;
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
public class Tipo_DocumentoJpaControllerTest {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    Tipo_DocumentoJpaController Tipo_DocumentoDao = new Tipo_DocumentoJpaController(emf);
    
    public Tipo_DocumentoJpaControllerTest() {
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
     * Test of getEntityManager method, of class Tipo_DocumentoJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        Tipo_DocumentoJpaController instance = new Tipo_DocumentoJpaController(emf);
        
        try{
        instance.getEntityManager();
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class Tipo_DocumentoJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Tipo_Documento tipo_Documento = new Tipo_Documento();
        
        Tipo_DocumentoJpaController instance = new Tipo_DocumentoJpaController(emf);
        tipo_Documento.setId_Tipo_Documento(Tipo_DocumentoDao.getTipo_DocumentoCount()+1);
        
        try{
        instance.create(tipo_Documento);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class Tipo_DocumentoJpaController.
     */
    
                
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Tipo_Documento tipo_Documento = new Tipo_Documento();
        tipo_Documento=Tipo_DocumentoDao.findTipo_Documento(Tipo_DocumentoDao.findTipo_DocumentoEntities().size());
        Tipo_DocumentoJpaController instance = new  Tipo_DocumentoJpaController(emf);
        try{
        instance.edit(tipo_Documento);
        } catch(Exception e){
        fail("The test case is a prototype.");
        }
    }
        
        
    /**
     * Test of destroy method, of class Tipo_DocumentoJpaController.
     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        int id = 0;
//        Tipo_DocumentoJpaController instance = null;
//        try{
//        instance.destroy(id);
//        } catch(Exception e){
//        fail("The test case is a prototype.");
//        }
//    }

    /**
     * Test of findTipo_DocumentoEntities method, of class Tipo_DocumentoJpaController.
     */
    @Test
    public void testFindTipo_DocumentoEntities_0args() {
        System.out.println("findTipo_DocumentoEntities");
        Tipo_DocumentoJpaController instance = new Tipo_DocumentoJpaController(emf);
        
        try {
        instance.findTipo_DocumentoEntities();
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    

    /**
     * Test of findTipo_DocumentoEntities method, of class Tipo_DocumentoJpaController.
     */
    @Test
    public void testFindTipo_DocumentoEntities_int_int() {
        System.out.println("findTipo_DocumentoEntities");
        int maxResults = 2;
        int firstResult = 1;
        Tipo_DocumentoJpaController instance = new Tipo_DocumentoJpaController(emf);
        
        try {
        instance.findTipo_DocumentoEntities(maxResults, firstResult);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findTipo_Documento method, of class Tipo_DocumentoJpaController.
     */
    @Test
    public void testFindTipo_Documento() {
        System.out.println("findTipo_Documento");
        Tipo_DocumentoJpaController instance = new Tipo_DocumentoJpaController(emf);
        int idTipo_Documento = Tipo_DocumentoDao.findTipo_Documento(Tipo_DocumentoDao.findTipo_DocumentoEntities().size()).getId_Tipo_Documento();
        
        try {
        instance.findTipo_Documento(idTipo_Documento);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    

    /**
     * Test of getTipo_DocumentoCount method, of class Tipo_DocumentoJpaController.
     */
    @Test
    public void testGetTipo_DocumentoCount() {
        System.out.println("getTipo_DocumentoCount");
        Tipo_DocumentoJpaController instance = new Tipo_DocumentoJpaController(emf);
        
        int expResult = instance.findTipo_DocumentoEntities().size();
        int result = instance.getTipo_DocumentoCount();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
    
}
