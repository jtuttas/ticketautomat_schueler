/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiaeTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Tuttas
 */
public class CoinChangerTest {
    
    public CoinChangerTest() {
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
     * Test of change method, of class CoinChanger.
     */
    @Test
    public void testChange() {
        System.out.println("change()");
        boolean found1eur,found50ct,found20ct,found5ct,found2eur;
        found1eur=found50ct=found20ct=found5ct=found2eur=false;
        CoinChanger cc = new CoinChanger();
        ArrayList<Coin> result =cc.change(1.75);
        try {
        for (Coin c:result) {
            if (c.getValue()==1.0) found1eur=true;
            if (c.getValue()==0.5) found50ct=true;
            if (c.getValue()==0.2) found20ct=true;
            if (c.getValue()==0.05) found5ct=true;
        }
        boolean test = (found20ct && found1eur && found50ct && found5ct);
        assertTrue("1,75 EUR müssen gewechselt werden in 1 EUR+0,5 ct+0,2 ct+0.05 ct",test);
        ArrayList<Coin> result2 =cc.change(2.0);
        assertTrue("2 EUR müssen gewechselt werden in 2 EUR",result2.get(0).getValue()==2.0);
        }
        catch (java.lang.NullPointerException nux) {
            fail ("coinChanger.change() gab null zurück");
        }
    }
    
}
