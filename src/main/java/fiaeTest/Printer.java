/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiaeTest;

/**
 * Ein Ticketdrucker
 * @author Jörg
 */
public class Printer {
    
    /**
     * Ausdrucken eines Tickets
     * @param t das Ticket
     * @return  Zeichenkette f. ein Ticket
     */
    public String print(Ticket t) {
        if (t!=null) return t.toString()+"\n";
        return "null";
    }
}
