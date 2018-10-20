
package fiaeTest;

/**
 * Zutsände des Automaten
 * @author Jörg
 */
public enum States {
    /**
     * Zone wählen
    */
    SELECT_ZONE,
    /**
     *Bezahlungsart Wählen 
     */
    SELECT_PAYMENT,
    /**
     * Barzahlung
     */
    PAY_BAR,
    /**
     * Bezahlung via EC Karte
     */
    PAY_EC,
    
}
