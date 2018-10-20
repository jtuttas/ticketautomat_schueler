package fiaeTest;

import java.util.ArrayList;

/**
 * Schnittstelle für die GUI
 * @author Jörg
 */
public interface TicketautomatListener {
    /**
     * Der Automat hat seinen Zustand geändert und die GUI muss drauf reagieren
     * @param s Der neue Zustand des Automaten
     */
    public void setState(States s);
    /**
     * Preisanzeige
     * @param t Das Ticket
     */
    public void dispayPrice(Ticket t);
    /**
     * GUI soll zurückgesetzt werden
     */
    public void reset();
    /**
     * Die eingezahlte Summe wird angezeigt
     * @param sum die anzuzeigende Summe
     */
    public void dispaySum(double sum);

    /**
     * Geld zurück geben
     * @param c die Münzen
     */
    public void returnCoins(ArrayList<Coin> c);
    
    /**
     * Ticket ausgeben
     * @param s das ausgedruckte Ticket
     */
    public void returnTicket(String s);
    
    /**
     * Die EC Karte wird zurückgegeben
     * @param ec die EC-Karte
     */
    public void returnECCard(ECCard ec);
}
