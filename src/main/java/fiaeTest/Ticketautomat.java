package fiaeTest;

import java.util.ArrayList;

/**
 * Der Ticketautomat
 * @author Jörg
 */
public class Ticketautomat implements KasseListener
{
    /**
     * Zustände des Automaten
     */
    private States state=States.SELECT_ZONE;
    
    /**
     * Listener zur Änderung der GUI
     */
    private TicketautomatListener listener;
    
    /**
     * Das (gewählte Ticket)
     */
    private Ticket ticket;
    
    /**
     * Die EC-Karte
     */
    private ECCard ecCard;
    
    /**
     * Das Kassensystem
     */
    private Kasse kasse;
    
    /**
     * Der Ticket Drucker
     */
    private Printer printer;
    
    /**
     * Erzeugen eines Ticketautomaten
     * @param l Listener für die GUI
     */
    public Ticketautomat(TicketautomatListener l)
    {
        this.listener=l;
        kasse=new Kasse(this);
        printer = new Printer();
        l.setState(States.SELECT_ZONE);
    }

 

    /**
     * Eine Zone Wählen. Wenn eine Zone gewählt wird, dann wird ein Ticket erzeugt und der Preis angezeigt. Der 
     * Automat wechselt in den Zustand SELECT_PAYMENT
     * @param z die Zone
     */
    public void select(Zonen z) {
        // TODO zum implementieren
    }

    /**
     * Der Ticketautomat wird zurückgesetzt, d.h. im Falle der Barzahlung muss der gezahlte Betrag ausgegeben werden, bei der Zahlungsart 
     * EC-Karte muss die EC-Karte ausgegeben werden. Der Automat befindet sich anschließed wieder im Zustand SELECT_ZONE
     */
    public void reset() {
         // TODO zu implementieren
    }

   
    /**
     * Münzen werden in die Kasse geworfen, dabei können Münzen auch wieder zurückgegeben werden (falls es sich um Flaschgeld handelt oder 
     * als Wechselgeld nach erfolgter Zahlung
     * @param coin Die Münze
     */
    public void addCoin(Coin coin) {
         // TODO zu implementieren
    }

    /**
     * Abfrage des Zustandes des Automaten
     * @return der Zustand
     */
    public States getState() {
        return state;
    }

    

    /**
     * Es wird via EC-Karte bezahlt! Ist die Karte gültig wird das Ticket gedruck. Ansonsten die EC-Karte wieder ausgeworfen
     * @param ecCard Die EC-Karte
     */
    public void insertEcCard(ECCard ecCard) {
         // TODO zu implementieren
    }

    /**
     * Bezahlart für den Automaten wählen
     * @param payment Bezahlart
     */
    public void setPayment(Payment payment) {
         // TODO zu implementieren
    }

    @Override
    public void paymentCompletet(ArrayList<Coin> coins) {
         // TODO zu implementieren            
    }
}
