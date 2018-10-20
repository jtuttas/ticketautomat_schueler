package fiaeTest;

/**
 * Eine Münze für unsern Ticketautomat
 * @author Jörg
 */
public class Coin {
    
    /**
     * Handlet es sich um Falschgeld
     */
    private boolean falschgeld;
    /**
     * Der Wert der Münze
     */
    private double value;
    /**
     * Der Name der Münze
     */
    private String name;

    /**
     * Eine Münze erzeugen
     * @param c der Aufzählungstyp der Münze
     * @param b  true=Falschgeld
     */
    public Coin(Coins c,boolean  b) {
        
        falschgeld=b;
        value=Coins.getValue(c);
        name=Coins.getName(c);
    }

    /**
     * Münze in Klartext ausgeben
     * @return Zeichenkette der Münze
     */
    @Override
    public String toString() {
        return name;
    }
   
    
    /**
     * Handlet es sich um Flaschgeld
     * @return true=Falschgeld
     */
    public boolean isFalschgeld() {
        return falschgeld;
    }
    
    
    /**
     * Wert der Münze abfragen
     * @return Wert der Münze
     */
    public double getValue() {
        return (double)(Math.round(100*value))/100;
    }

    
    
    
}
