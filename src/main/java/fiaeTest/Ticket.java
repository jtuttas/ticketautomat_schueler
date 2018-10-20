
package fiaeTest;

/**
 * Ticket 
 * @author Jörg
 */
public class Ticket {

    
    /**
     * Zone
     */
    private Zonen zone;
    /**
     * Ticket erzeugen
     * @param z Zone des Tickets
     */
    public Ticket(Zonen z) {
        zone=z;
    }

    /**
     * Preis für das Ticket abfragen
     * @return der Preis
     */
    public double getPreis() {
        return Zonen.getPrice(zone);
    }

    /**
     * Ticket ausgeben (zum drucken)
     * @return Ticketausdruck
     */
    @Override
    public String toString() {
        String s="##################";
        s+="\n# Ticket! "+Zonen.getName(zone);
        s+="\n# " + Zonen.getPrice(zone) + " EUR.";
        s+="\n##################";
        return s;
    }
    
    
    
    
}
