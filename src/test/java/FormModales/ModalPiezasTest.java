/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormModales;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ModalPiezasTest {
    
    public ModalPiezasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        java.awt.Frame parent = new java.awt.Frame ();
        ModalPiezas instance =new ModalPiezas(parent,true);
        int expResult = 0;
        int result = instance.getId();
        try {
        assertEquals(expResult, result);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        java.awt.Frame parent = new java.awt.Frame ();
        ModalPiezas instance =new ModalPiezas(parent,true);
        try {
        instance.setId(id);
        }catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
