/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiaeTest;

import static org.junit.Assert.assertEquals;
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
public class KasseTest {
    private boolean ok;
    
    public KasseTest() {
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
     * Test of getSum method, of class Kasse.
     * Die Methode gibt den Inhalt der Kasse als double wieder!
     */
    @Test
    public void testGetSum() {
        System.out.println("getSum()");
        Kasse k = new Kasse(null);
        k.addCoin(new Coin(Coins.CT10,false));
        k.addCoin(new Coin(Coins.CT20,false));
        k.addCoin(new Coin(Coins.CT50,false));
        k.addCoin(new Coin(Coins.CT20,false));
        k.addCoin(new Coin(Coins.CT5,false));
        assertEquals("Habe 1,05 EUR eingeworfen, die Summe der Kasse ist aber "+k.getSum(),1.05, k.getSum(),0.01);
        k = new Kasse(null);
        k.addCoin(new Coin(Coins.EUR1,false));
        k.addCoin(new Coin(Coins.EUR1,true));
        k.addCoin(new Coin(Coins.EUR1,false));
        assertEquals("Habe 3 EUR eingeworfen (1 EUR war Flaschgeld), die Summe der Kasse ist nicht 2 EUR sondern "+k.getSum(),2.0, k.getSum(),0.01);
    }

        
        
    

    /**
     * Test of setPrice method, of class Kasse.
     * Mittels SetPrice wird der Preis gesetzt der zu bezahlen ist, ist der Betrag erreicht, so Wird über
     * das Interface die Methode paymentCompletet(ArrayList) afugerufen, die den zuviel gezahlten Betrag als
     * Münzen enthält
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        ok=false;
        Kasse k;
        k = new Kasse(new KasseListener() {
            
            @Override
            public void paymentCompletet(ArrayList<Coin> coins) {
                setTest(true);
            }

        });
        k.setPrice(1.1);
        k.addCoin(new Coin(Coins.EUR2, false));
        assertTrue("Habe 2 Euro bezahlt, der Bezahlvorgang ist aber nicht abgeschlossen paymentCompletet()",ok);

        ok=false;
        k = new Kasse(new KasseListener() {
            
            @Override
            public void paymentCompletet(ArrayList<Coin> coins) {
                setTest(true);
            }

        });
        k.setPrice(1.1);
        k.addCoin(new Coin(Coins.EUR1, false));
        k.addCoin(new Coin(Coins.CT50, false));
        assertTrue("Habe 1.5 Euro bezahlt, der Bezahlvorgang ist aber nicht abgeschlossen paymentCompletet()",ok);

        ok=false;
        k = new Kasse(new KasseListener() {
            
            @Override
            public void paymentCompletet(ArrayList<Coin> coins) {
                if (getSum(coins)==0.4) setTest(true);
            }

        });
        k.setPrice(1.1);
        k.addCoin(new Coin(Coins.EUR1, false));
        k.addCoin(new Coin(Coins.CT50, false));
        assertTrue("Habe 1.5 Euro bezahlt für ein Ticket was 1,10 EUR kostet jedoch keine 40 ct zurück erhalten!",ok);

    
    }
    private void setTest(boolean b) {
        ok=b;
    }
    
    private double getSum(ArrayList<Coin> c) {
        try {
        double s=0;
        for (Coin co : c) {
            s+=co.getValue();
        }
        return s;
        }
        catch (java.lang.NullPointerException nux) {
            fail("Kann keine Summe von einem null Objekt bilden");
            return 0.0;
        }
    }

    /**
     * Test of addCoin method, of class Kasse.
     * Geld wird der Kasse hinzugefügt, Falschgeld wird nicht angenommen!
     */
    @Test
    public void testAddCoin() {
        System.out.println("addCoin()");
        Kasse k = new Kasse(null);
        k.addCoin(new Coin(Coins.CT10,false));
        k.addCoin(new Coin(Coins.CT20,false));
        k.addCoin(new Coin(Coins.CT50,false));
        k.addCoin(new Coin(Coins.CT20,false));
        k.addCoin(new Coin(Coins.CT5,false));
        assertEquals("Habe 1,05 EUR eingeworfen, die Summe der Kasse ist aber "+k.getSum(),1.05, k.getSum(),0.01);
        k = new Kasse(null);
        k.addCoin(new Coin(Coins.EUR1,false));
        k.addCoin(new Coin(Coins.EUR1,true));
        k.addCoin(new Coin(Coins.EUR1,false));
        assertEquals("Habe 3 EUR eingeworfen (1 EUR war Flaschgeld), die Summe der Kasse ist nicht 2 EUR sondern "+k.getSum(),2.0, k.getSum(),0.01);    }

    /**
     * Test of reset method, of class Kasse.
     * Ein reset muss die Kasse leeren und den enthaltenen Betrag zurück geben!
     */
    @Test
    public void testReset() {
        System.out.println("reset()");
        Kasse k = new Kasse(null);
        k.addCoin(new Coin(Coins.CT10,false));
        k.addCoin(new Coin(Coins.CT20,false));
        k.addCoin(new Coin(Coins.CT50,false));
        k.addCoin(new Coin(Coins.CT20,false));
        k.addCoin(new Coin(Coins.CT5,false));
        double i=getSum(k.reset());
        assertEquals("Habe 1,05 EUR eingeworfen, nach einem Reset jedoch nur  "+i+" EUR zurück erhalten",1.05, i,0.01);
        k = new Kasse(null);
        k.addCoin(new Coin(Coins.EUR1,false));
        k.addCoin(new Coin(Coins.EUR1,true));
        k.addCoin(new Coin(Coins.EUR1,false));
        k.reset();
        assertEquals("Nach einem Reset muss die Kasse leer sein! ",0.0, k.getSum(),0.01);        
    }
    
}
