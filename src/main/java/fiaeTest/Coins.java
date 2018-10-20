package fiaeTest;

/**
 * Gültige Münzen
 *
 * @author Jörg
 */
public enum Coins {

    CT1, CT2, CT5, CT10, CT20, CT50, EUR1, EUR2;

    /**
     * Den Wert einer Münze ermitteln
     * @param c die Münze
     * @return der Wert
     */
    public static  double getValue(Coins c) {
         switch (c) {
            case CT1:
                return 0.01;
            case CT2:
                return 0.02;
            case CT5:
                return 0.05;
            case CT10:
                return 0.10;
            case CT20:
                return 0.20;
            case CT50:
                return 0.50;
            case EUR1:
                return 1.00;
            case EUR2:
                return 2.00;
            
        }
         return 0.0;

    }

    /**
     * Name des Coins ausgeben
     * @param c der Coin
     * @return der Name z.b. (ct1)
     */
    public static String getName(Coins c) {
                switch (c) {
            case CT1:              
                return "(1ct)";
            case CT2:
                return "(2ct)";
            case CT5:
                return "(5ct)";
            case CT10:
                return "(10ct)";
            case CT20:
                return "(20ct)";
            case CT50:
                return "(50ct)";
            case EUR1:
                return "(1eur)";
            case EUR2:
                return "(2eur)";
            
        }
        return null;

    }
}
