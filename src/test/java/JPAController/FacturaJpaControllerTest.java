/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Factura;
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
 * @author User
 */
public class FacturaJpaControllerTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarSoft");
    public FacturaJpaControllerTest() {
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
     * Test of getEntityManager method, of class FacturaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        FacturaJpaController instance = new FacturaJpaController(emf);
        
        
        try{
        instance.getEntityManager();
        }catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of create method, of class FacturaJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Factura factura = new Factura();
        factura.setIdCliente(1);
        factura.setIdEmpleado(1);
        factura.setIdRazonSocial(1);
        factura.setIdTipoPago(1);
        factura.setIdTipoPago(1);
        factura.setiDtipofactura(1);
        factura.setCantidadPago(1);
        factura.setEstado(true);
        factura.setNumeroTarjeta("");
        factura.setFechaHora("20210101010101");
        factura.setIdInf(1);
        
        FacturaJpaController instance = new FacturaJpaController(emf);
        try{
        instance.create(factura);
        }catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of edit method, of class FacturaJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Factura factura = new Factura();
        
        factura.setIdCliente(1);
        factura.setIdEmpleado(1);
        factura.setIdRazonSocial(1);
        factura.setIdTipoPago(1);
        factura.setIdTipoPago(1);
        factura.setiDtipofactura(1);
        factura.setCantidadPago(1);
        factura.setEstado(true);
        factura.setNumeroTarjeta("");
        factura.setFechaHora("20210101010101");
        factura.setIdInf(1);
        factura.setIDFactura(0);
        FacturaJpaController instance = new FacturaJpaController(emf);
        try{
        instance.edit(factura);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of destroy method, of class FacturaJpaController.
     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        Integer id = null;
//        FacturaJpaController instance = null;
//        instance.destroy(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findFacturaEntities method, of class FacturaJpaController.
     */
    @Test
    public void testFindFacturaEntities_0args() {
        System.out.println("findFacturaEntities");
        FacturaJpaController instance = new FacturaJpaController(emf);
       try{
        List<Factura> result = instance.findFacturaEntities();
       }catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of findFacturaEntities method, of class FacturaJpaController.
     */
    @Test
    public void testFindFacturaEntities_int_int() {
        System.out.println("findFacturaEntities");
        int maxResults = 0;
        int firstResult = 0;
        FacturaJpaController instance = new FacturaJpaController(emf) ;
        try{
        List<Factura> result = instance.findFacturaEntities(maxResults, firstResult);
        }catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of findFactura method, of class FacturaJpaController.
     */
    @Test
    public void testFindFactura() {
        System.out.println("findFactura");
        Integer id = 0;
        FacturaJpaController instance = new FacturaJpaController(emf) ;
        Factura expResult = null;
        Factura result = instance.findFactura(id);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getFacturaCount method, of class FacturaJpaController.
     */
    @Test
    public void testGetFacturaCount() {
        System.out.println("getFacturaCount");
        FacturaJpaController instance =new FacturaJpaController(emf) ;
        int expResult = instance.findFacturaEntities().size();
        int result = instance.getFacturaCount();
        
        try{
        assertEquals(expResult, result);
         }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }   
    }
    
}
