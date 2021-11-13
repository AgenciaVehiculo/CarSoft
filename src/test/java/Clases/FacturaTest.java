/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

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
public class FacturaTest {
    
    public FacturaTest() {
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
     * Test of getIdTipoPago method, of class Factura.
     */
    @Test
    public void testGetIdTipoPago() {
        System.out.println("getIdTipoPago");
        Factura instance = new Factura();
        instance.setIDFactura(0);
        int expResult = 0;
        int result = instance.getIdTipoPago();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");}
        
    }

    /**
     * Test of setIdTipoPago method, of class Factura.
     */
    @Test
    public void testSetIdTipoPago() {
        System.out.println("setIdTipoPago");
        int idTipoPago = 0;
        Factura instance = new Factura();
        try{
        instance.setIdTipoPago(idTipoPago);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");}
    }

    /**
     * Test of getCantidadPago method, of class Factura.
     */
    @Test
    public void testGetCantidadPago() {
        System.out.println("getCantidadPago");
        Factura instance = new Factura();
        double expResult = 0.0;
        double result = instance.getCantidadPago();
        try{
        assertEquals(expResult, result, 0.0);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");}
    }

    /**
     * Test of setCantidadPago method, of class Factura.
     */
    @Test
    public void testSetCantidadPago() {
        System.out.println("setCantidadPago");
        double cantidadPago = 0.0;
        Factura instance = new Factura();
        try{
        instance.setCantidadPago(cantidadPago);
        // TODO review the generated test code and remove the default call to fail.
        }catch(Exception e){fail("The test case is a prototype.");}
    }

    /**
     * Test of getNumeroTarjeta method, of class Factura.
     */
    @Test
    public void testGetNumeroTarjeta() {
        System.out.println("getNumeroTarjeta");
        Factura instance = new Factura();
        String expResult = "";
        instance.setNumeroTarjeta(expResult);
        String result = instance.getNumeroTarjeta();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of setNumeroTarjeta method, of class Factura.
     */
    @Test
    public void testSetNumeroTarjeta() {
        System.out.println("setNumeroTarjeta");
        String numeroTarjeta = "";
        Factura instance = new Factura();
        
        try{
        instance.setNumeroTarjeta(numeroTarjeta);
        }// TODO review the generated test code and remove the default call to fail.
        catch(Exception e){fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of getIdRazonSocial method, of class Factura.
     */
    @Test
    public void testGetIdRazonSocial() {
        System.out.println("getIdRazonSocial");
        Factura instance = new Factura();
        int expResult = 0;
        int result = instance.getIdRazonSocial();
        try{
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        }catch(Exception e){fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setIdRazonSocial method, of class Factura.
     */
    @Test
    public void testSetIdRazonSocial() {
        System.out.println("setIdRazonSocial");
        int idRazonSocial = 0;
        Factura instance = new Factura();
        try{
        instance.setIdRazonSocial(idRazonSocial);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");}
        
    }

    /**
     * Test of getNumFactura method, of class Factura.
     */
    @Test
    public void testGetNumFactura() {
        System.out.println("getNumFactura");
        Factura instance = new Factura();
        String expResult = "";
        instance.setNumFactura(expResult);
        String result = instance.getNumFactura();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setNumFactura method, of class Factura.
     */
    @Test
    public void testSetNumFactura() {
        System.out.println("setNumFactura");
        String numFactura = "";
        Factura instance = new Factura();
        try{
        instance.setNumFactura(numFactura);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getIdInf method, of class Factura.
     */
    @Test
    public void testGetIdInf() {
        System.out.println("getIdInf");
        Factura instance = new Factura();
        int expResult = 0;
        int result = instance.getIdInf();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setIdInf method, of class Factura.
     */
    @Test
    public void testSetIdInf() {
        System.out.println("setIdInf");
        int idInf = 0;
        Factura instance = new Factura();
        try{
        instance.setIdInf(idInf);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getiDFactura method, of class Factura.
     */
    @Test
    public void testGetiDFactura() {
        System.out.println("getiDFactura");
        Factura instance = new Factura();
        Integer expResult = null;
        Integer result = instance.getiDFactura();
      
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setiDFactura method, of class Factura.
     */
    @Test
    public void testSetiDFactura() {
        System.out.println("setiDFactura");
        Integer iDFactura = null;
        Factura instance = new Factura();
        try{
        instance.setiDFactura(iDFactura);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getFechaHora method, of class Factura.
     */
    @Test
    public void testGetFechaHora() {
        System.out.println("getFechaHora");
        Factura instance = new Factura();
        String expResult = "";
        instance.setFechaHora(expResult);
        String result = instance.getFechaHora();
        try{
        assertEquals(expResult, result);
  }catch(Exception e){      // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
  }  }

    /**
     * Test of setFechaHora method, of class Factura.
     */
    @Test
    public void testSetFechaHora() {
        System.out.println("setFechaHora");
        String fechaHora = "";
        Factura instance = new Factura();
        try{
        instance.setFechaHora(fechaHora);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getIdEmpleado method, of class Factura.
     */
    @Test
    public void testGetIdEmpleado() {
        System.out.println("getIdEmpleado");
        Factura instance = new Factura();
        int expResult = 0;
        int result = instance.getIdEmpleado();
        try{
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        }catch(Exception e){fail("The test case is a prototype.");
    }}

    /**
     * Test of setIdEmpleado method, of class Factura.
     */
    @Test
    public void testSetIdEmpleado() {
        System.out.println("setIdEmpleado");
        int idEmpleado = 0;
        Factura instance = new Factura();
        try{
        instance.setIdEmpleado(idEmpleado);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getIdCliente method, of class Factura.
     */
    @Test
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        Factura instance = new Factura();
        int expResult = 0;
        int result = instance.getIdCliente();
        try{
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        }catch(Exception e){fail("The test case is a prototype.");
    }}

    /**
     * Test of setIdCliente method, of class Factura.
     */
    @Test
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        int idCliente = 0;
        Factura instance = new Factura();
        try{
        instance.setIdCliente(idCliente);
        // TODO review the generated test code and remove the default call to fail.
        }catch(Exception e){
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getiDtipofactura method, of class Factura.
     */
    @Test
    public void testGetiDtipofactura() {
        System.out.println("getiDtipofactura");
        Factura instance = new Factura();
        int expResult = 0;
        
        int result = instance.getiDtipofactura();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setiDtipofactura method, of class Factura.
     */
    @Test
    public void testSetiDtipofactura() {
        System.out.println("setiDtipofactura");
        int iDtipofactura = 0;
        Factura instance = new Factura();
        try{
        instance.setiDtipofactura(iDtipofactura);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getIDFactura method, of class Factura.
     */
    @Test
    public void testGetIDFactura() {
        System.out.println("getIDFactura");
        Factura instance = new Factura();
        Integer expResult = null;
        Integer result = instance.getIDFactura();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setIDFactura method, of class Factura.
     */
    @Test
    public void testSetIDFactura() {
        System.out.println("setIDFactura");
        Integer iDFactura = null;
        Factura instance = new Factura();
        try{
        instance.setIDFactura(iDFactura);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getEstado method, of class Factura.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Factura instance = new Factura();
        Boolean expResult = null;
        Boolean result = instance.getEstado();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of setEstado method, of class Factura.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        Boolean estado = null;
        Factura instance = new Factura();
        try{
        instance.setEstado(estado);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of hashCode method, of class Factura.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Factura instance = new Factura();
        int expResult = 0;
        int result = instance.hashCode();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of equals method, of class Factura.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Factura instance = new Factura();
        boolean expResult = false;
        boolean result = instance.equals(object);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of toString method, of class Factura.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Factura instance = new Factura();
        String expResult = null;
        
        try{
        String result = instance.toString();
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}
    
}
