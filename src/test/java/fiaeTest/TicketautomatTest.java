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
 * @author Jörg
 */
public class TicketautomatTest {
    boolean ok=false;
    double sum=0;
    
    public TicketautomatTest() {
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
     * Test of select method, of class Ticketautomat.
     * Viae Select wird die Zone ausgewählt und der Preis angezeigt
     */
    @Test
    public void testSelect() {
        System.out.println("setSelect()");
        ok=false;
        final Ticket ti = new Ticket(Zonen.Zone1);
        Ticketautomat ta = new Ticketautomat( new TicketautomatListener() {

            @Override
            public void setState(States s) {
            }

            @Override
            public void dispayPrice(Ticket t) {
                if (t.getPreis()==ti.getPreis()) ok=true;
            }

            @Override
            public void reset() {
            }

            @Override
            public void dispaySum(double sum) {
            }

            @Override
            public void returnCoins(ArrayList<Coin> c) {
            }

            @Override
            public void returnTicket(String s) {
            }

            @Override
            public void returnECCard(ECCard ec) {
            }
        });
        
        System.out.println("select");
        ta.select(Zonen.Zone1);
        assertTrue("Ein Ticker der Zone 1 sollde einen Preis anzeigen von "+ti.getPreis()+" EUR",ok);        
    }

    /**
     * Test of reset method, of class Ticketautomat.
     */
    @Test
    public void testReset() {
        System.out.println("reset()");
        ok=false;
        Ticketautomat ta = new Ticketautomat(new TicketautomatListener() {

            @Override
            public void setState(States s) {
            }

            @Override
            public void dispayPrice(Ticket t) {
            }

            @Override
            public void reset() {
            }

            @Override
            public void dispaySum(double sum) {
            }

            @Override
            public void returnCoins(ArrayList<Coin> c) {
               sum=getSum(c);
               if (getSum(c)==0.8) ok=true;
            }

            @Override
            public void returnTicket(String s) {
            }

            @Override
            public void returnECCard(ECCard ec) {
            }
        });
        ta.select(Zonen.Zone1);
        ta.setPayment(Payment.BAR);
        ta.addCoin(new Coin(Coins.CT10,false));
        ta.addCoin(new Coin(Coins.CT20,false));
        ta.addCoin(new Coin(Coins.CT50,false));
        ta.reset();
        assertTrue("Habe 80 ct eingeworfen, nach einem Reset aber nicht die Summe zurück erhalten! Summe="+sum,ok);
        
        ok=false;
        ta = new Ticketautomat(new TicketautomatListener() {

            @Override
            public void setState(States s) {
            }

            @Override
            public void dispayPrice(Ticket t) {
            }

            @Override
            public void reset() {
               ok=true;
            }

            @Override
            public void dispaySum(double sum) {
            }

            @Override
            public void returnCoins(ArrayList<Coin> c) {
            }

            @Override
            public void returnTicket(String s) {
            }

            @Override
            public void returnECCard(ECCard ec) {
            }
        });
        ta.select(Zonen.Zone1);
        ta.setPayment(Payment.BAR);
        ta.addCoin(new Coin(Coins.CT10,false));
        ta.addCoin(new Coin(Coins.CT20,false));
        ta.addCoin(new Coin(Coins.CT50,false));
        
        ta.reset();
        assertTrue("Nach einem Reset sollte auch die GUI zurück gesetzt werden via der Methode reset()",ok);
        
    }

    private double getSum(ArrayList<Coin> c) {
        try {
        double s=0;
        for (Coin co : c) {
            s+=co.getValue();
        }
        return (double)(Math.round(100*s))/100;
        }
        catch (java.lang.NullPointerException nux) {
            fail("kann keine Summe über ein null ArrayList Objekt bilden");
        }
        return 0.0;
    }
    /**
     * Test of addCoin method, of class Ticketautomat.
     */
    @Test
    public void testAddCoin() {
        System.out.println("addCoin()");
        ok=false;
        Ticketautomat ta = new Ticketautomat(new TicketautomatListener() {

            @Override
            public void setState(States s) {
            }

            @Override
            public void dispayPrice(Ticket t) {
            }

            @Override
            public void reset() {
            }

            @Override
            public void dispaySum(double sum) {
            }

            @Override
            public void returnCoins(ArrayList<Coin> c) {
               sum=getSum(c);
               if (getSum(c)==0.5) ok=true;
            }

            @Override
            public void returnTicket(String s) {
            }

            @Override
            public void returnECCard(ECCard ec) {
            }
        });
        ta.addCoin(new Coin(Coins.CT50,false));
        assertTrue("Der Automat sollte nur Münzen annehmen, wenn er auch im Zustand PAY_BAR ist, sonst sollten die Münzen wieder ausfallen, dieses ist aber nicht geschehen!",ok);

        ta = new Ticketautomat(new TicketautomatListener() {

            @Override
            public void setState(States s) {
            }

            @Override
            public void dispayPrice(Ticket t) {
            }

            @Override
            public void reset() {
            }

            @Override
            public void dispaySum(double sum) {
            }

            @Override
            public void returnCoins(ArrayList<Coin> c) {
               sum=getSum(c);
               if (getSum(c)==0.5) ok=true;
            }

            @Override
            public void returnTicket(String s) {
            }

            @Override
            public void returnECCard(ECCard ec) {
            }
        });
        ta.select(Zonen.Zone1);
        ta.setPayment(Payment.BAR);
        ta.addCoin(new Coin(Coins.CT50,true));
        assertTrue("Habe eine 50ct Münze Falschgeld eingeworfen, die ist aber nicht wieder herausgekommen?",ok);
        ta = new Ticketautomat(new TicketautomatListener() {

            @Override
            public void setState(States s) {
            }

            @Override
            public void dispayPrice(Ticket t) {
            }

            @Override
            public void reset() {
            }

            @Override
            public void dispaySum(double sum) {
                if (sum==0.6) ok=true;
            }

            @Override
            public void returnCoins(ArrayList<Coin> c) {
            }

            @Override
            public void returnTicket(String s) {
            }

            @Override
            public void returnECCard(ECCard ec) {
            }
        });
        ta.select(Zonen.Zone1);
        ta.setPayment(Payment.BAR);
        ta.addCoin(new Coin(Coins.CT50,false));
        ta.addCoin(new Coin(Coins.CT10,false));
        assertTrue("Habe 60ct eingeworfen, der Preis wird aber nicht auf dem Display angezeigt",ok);
      
    }

    /**
     * Test of getState method, of class Ticketautomat.
     */
    @Test
    public void testGetState() {
        System.out.println("getState()");
        Ticketautomat ta = new Ticketautomat(new TicketautomatListener() {

            @Override
            public void setState(States s) {
            }

            @Override
            public void dispayPrice(Ticket t) {
            }

            @Override
            public void reset() {
            }

            @Override
            public void dispaySum(double sum) {
                
            }

            @Override
            public void returnCoins(ArrayList<Coin> c) {
            }

            @Override
            public void returnTicket(String s) {
            }

            @Override
            public void returnECCard(ECCard ec) {
            }
        });
        assertTrue("Zu Beginn sollte der Automat im Zustand SELECT_ZONE sein",ta.getState()==States.SELECT_ZONE);
        
        ta.reset();
        assertTrue("Nach einem Reset der Automat im Zustand SELECT_ZONE sein",ta.getState()==States.SELECT_ZONE);
        ta.select(Zonen.Zone1);
        assertTrue("Nachdem eine Zone gewählt wurde, sollte der Automat im Zustand SELECT_PAYMENT sein",ta.getState()==States.SELECT_PAYMENT);
        ta.setPayment(Payment.BAR);
        assertTrue("Nachdem die Bezahlart BAR gewählt wurde , sollte der Automat im Zustand PAY_BAR sein",ta.getState()==States.PAY_BAR);
        ta.addCoin(new Coin(Coins.EUR2,false));
        ta.addCoin(new Coin(Coins.EUR2,false));
        assertTrue("Nach einem erfolgreichen BAR Kauf sollte der Automatwieder im Zustand SELECT_ZONE sein",ta.getState()==States.SELECT_ZONE);
        ta.reset();
        ta.select(Zonen.Zone1);
        ta.setPayment(Payment.ECCARD);
        assertTrue("Nachdem die Bezahlart ECCARD gewählt wurde , sollte der Automat im Zustand PAY_EC sein",ta.getState()==States.PAY_EC);
        ta.insertEcCard(new ECCard("1111"));
        assertTrue("Wird eine ungültige EC-Karte eingegeben, sollte der Automat wieder im Zustand SELECT_ZONE sein",ta.getState()==States.SELECT_ZONE);
        ta.reset();
        ta.select(Zonen.Zone1);
        ta.setPayment(Payment.ECCARD);
        ta.insertEcCard(new ECCard("1234"));
        assertTrue("Wird eine gültige EC-Karte eingegeben, sollte der Automat wieder im Zustand SELECT_ZONE sein",ta.getState()==States.SELECT_ZONE);
    }

    /**
     * Test of insertEcCard method, of class Ticketautomat.
     */
    @Test
    public void testInsertEcCard() {
        System.out.println("insertEcCard()");
        ok=false;
        Ticketautomat ta = new Ticketautomat(new TicketautomatListener() {

            @Override
            public void setState(States s) {
            }

            @Override
            public void dispayPrice(Ticket t) {
            }

            @Override
            public void reset() {
            }

            @Override
            public void dispaySum(double sum) {
                
            }

            @Override
            public void returnCoins(ArrayList<Coin> c) {
            }

            @Override
            public void returnTicket(String s) {
            }

            @Override
            public void returnECCard(ECCard ec) {
                ok=true;
            }
        });
        ta.insertEcCard(new ECCard("1234"));
        assertTrue("Ist der Automat nicht im Zustand PAY_EC, soll die EC-Karte immer wieder heraus kommen!",ok);
        ok=false;
        ta.select(Zonen.Zone1);
        ta.setPayment(Payment.ECCARD);
        ta.insertEcCard(new ECCard("1111"));
        assertTrue("Eine ungültige EC-Karte sollte immer wieder heraus kommen!",ok);
        ok=false;
        ta.select(Zonen.Zone1);
        ta.setPayment(Payment.ECCARD);
        ta.insertEcCard(new ECCard("1234"));
        assertTrue("Eine gültige EC-Karte sollte immer wieder heraus kommen!",ok);
        
        ok=false;
        ta = new Ticketautomat(new TicketautomatListener() {

            @Override
            public void setState(States s) {
            }

            @Override
            public void dispayPrice(Ticket t) {
            }

            @Override
            public void reset() {
            }

            @Override
            public void dispaySum(double sum) {
                
            }

            @Override
            public void returnCoins(ArrayList<Coin> c) {
            }

            @Override
            public void returnTicket(String s) {
                ok=true;
            }

            @Override
            public void returnECCard(ECCard ec) {
            }
        });
        ta.select(Zonen.Zone1);
        ta.setPayment(Payment.ECCARD);
        ta.insertEcCard(new ECCard("1234"));
        assertTrue("Beim bezahlen mit einer gültige EC-Karte sollte auch ein Ticket ausgegeben werden!",ok);

    }

    /**
     * Test of setPayment method, of class Ticketautomat.
     */
    @Test
    public void testSetPayment() {
        System.out.println("setPayment()");
        ok=false;
        Ticketautomat ta = new Ticketautomat(new TicketautomatListener() {

            @Override
            public void setState(States s) {
                if (s==States.PAY_BAR) ok=true;
            }

            @Override
            public void dispayPrice(Ticket t) {
            }

            @Override
            public void reset() {
            }

            @Override
            public void dispaySum(double sum) {
                
            }

            @Override
            public void returnCoins(ArrayList<Coin> c) {
            }

            @Override
            public void returnTicket(String s) {
            }

            @Override
            public void returnECCard(ECCard ec) {
                ok=true;
            }
        });
        ta.select(Zonen.Zone1);
        ta.setPayment(Payment.BAR);
        assertTrue("Wird selectPayment(Payment.BAR) gewählt, muss auch die GUI via setState() auf die Bezahlmethode geändert werden!",ok);
 
        ok=false;
        ta = new Ticketautomat(new TicketautomatListener() {

            @Override
            public void setState(States s) {
                if (s==States.PAY_EC) ok=true;
            }

            @Override
            public void dispayPrice(Ticket t) {
            }

            @Override
            public void reset() {
            }

            @Override
            public void dispaySum(double sum) {
                
            }

            @Override
            public void returnCoins(ArrayList<Coin> c) {
            }

            @Override
            public void returnTicket(String s) {
            }

            @Override
            public void returnECCard(ECCard ec) {
                ok=true;
            }
        });
        ta.select(Zonen.Zone1);
        ta.setPayment(Payment.ECCARD);
        assertTrue("Wird selectPayment(Payment.ECCARD) gewählt, muss auch die GUI via setState() auf die Bezahlmethode geändert werden!",ok);
      
    }

    
}
