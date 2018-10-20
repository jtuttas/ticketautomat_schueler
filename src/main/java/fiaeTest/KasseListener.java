
package fiaeTest;

import java.util.ArrayList;

/**
 * Listener für die Kasse
 * @author Jörg
 */
public interface KasseListener {
    
    /**
     * Bezahlung abgeschlossen
     * @param coins das Wechselgeld
     */
    public void paymentCompletet(ArrayList<Coin>coins);
}
