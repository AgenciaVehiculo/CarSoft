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
 * @author EDUIN FLORES
 */
public class HashTest {
    
    public HashTest() {
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
     * Test of getHash method, of class Hash.
     */
    @Test
    public void testGetHash() {
        System.out.println("getHash");
        String txt = "";
        String expResult = "";
        
        try {
        String result = Hash.getHash(txt);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of md5 method, of class Hash.
     */
    @Test
    public void testMd5() {
        System.out.println("md5");
        String txt = "";
        String expResult = "";
        String result = Hash.md5(txt);
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of sha1 method, of class Hash.
     */
    @Test
    public void testSha1() {
        System.out.println("sha1");
        String txt = "";
        String expResult = "";
        String result = Hash.sha1(txt);
        try {
        assertEquals(expResult, result);
        }  catch (Exception e) {
        fail("The test case is a prototype.");
        }
    }
    
}
