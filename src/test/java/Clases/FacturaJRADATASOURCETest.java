/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
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
public class FacturaJRADATASOURCETest {
    
    public FacturaJRADATASOURCETest() {
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
     * Test of next method, of class FacturaJRADATASOURCE.
     */
    @Test
    public void testNext() throws Exception {
        System.out.println("next");
        FacturaJRADATASOURCE instance = new FacturaJRADATASOURCE(new ArrayList[1][1]);
        boolean expResult = true;
        boolean result = instance.next();
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}

    /**
     * Test of getFieldValue method, of class FacturaJRADATASOURCE.
     */
    /*@Test
    public void testGetFieldValue() throws Exception {
        System.out.println("getFieldValue");
        JRField jrf = null;
        Object [][] arrayDetallesFactura;
        arrayDetallesFactura = new Object[2][5];
        FacturaJRADATASOURCE instance = null;
        Object expResult = null;
        Object result = instance.getFieldValue(jrf);
        try{
        assertEquals(expResult, result);
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }}*/

    /**
     * Test of getDataSource method, of class FacturaJRADATASOURCE.
     */
    @Test
    public void testGetDataSource() {
        System.out.println("getDataSource");
        Object[][] w = new Object[2][2];
        
        JRDataSource expResult = new FacturaJRADATASOURCE(w);
        JRDataSource result = FacturaJRADATASOURCE.getDataSource(w);
        try{
            if(expResult==result){
                
            }
        }catch(Exception e){// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    }
}
