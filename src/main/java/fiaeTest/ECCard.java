
package fiaeTest;

/**
 * Eine EC-Karte
 * @author Tuttas
 */
public class ECCard {
    /**
     * PIN der EC-Karte
     */
    private String pin;
    
    /**
     * EC Karte erzeugen
     * @param pin PIN der EC-Karte
     */
    public ECCard(String pin) {
        this.pin=pin;
    }
    
    /**
     * Pin Abfragen
     * @return die Pin
     */
    public String getPin() {
        return pin;
    }
    
}
