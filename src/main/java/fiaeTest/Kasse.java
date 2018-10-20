package fiaeTest;

import java.util.ArrayList;

/**
 * Kassensystem (erlaubt einzahlungen und gibt ggf. den Restbetrag zurück)
 * @author Jörg
 */
class Kasse {
    
    /**
     * Inhalt der Kasse
     */
    private ArrayList<Coin> inhalt=new ArrayList<Coin>();
    
    /**
     * Der zu zahlende Preis
     */
    private double price;
    
    /**
     * Münzprüfsystem
     */
    private CoinValidator coinValidator;
    
    /**
     * Münzwechsler in der Kasse
     */
    private CoinChanger coinChanger;
    
    private KasseListener listener;
    
    public Kasse(KasseListener l) {
        listener=l;
        coinChanger = new CoinChanger();
        coinValidator = new CoinValidator();
    }

    /**
     * Inhalt der Kasse abfragen
     * @return Summe der gezahlten Beträge
     */
    public double getSum() {
        // TODO zu implementieren
        return 0.0;
    }
    
    /**
     * Zu zahlender Betrag
     * @param d Der Betrag
     */
    public void setPrice(double d) {
        // TODO zu implementieren
    }
    
    /**
     * Münzen einwerfen
     * @param c die Münze
     * @return  Münzen die zurück gegeben werden (entweder Wechselgeld oder Falschgeld)
     */
    public ArrayList<Coin> addCoin(Coin c) {
        // TODO zu implementieren
        return null;
    }


   
    /**
     * Kasse zurücksetzen, d.h. bisher gezahlter Betrag erstatten
     * @return 
     */
    public ArrayList reset() {
         // TODO zu implementieren
        return null;        
    }

    
    
    
    
}
