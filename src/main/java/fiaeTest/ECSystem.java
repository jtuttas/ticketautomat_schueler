package fiaeTest;

/**
 * EC Bank System
 * @author Tuttas
 */
public class ECSystem {

    /**
     * Überprüft ob die PIN richtig ist (die richtige PIN lautet 1234)
     * @param e die EC-Karte
     * @return true=gültig
     */
    public boolean checkCard(ECCard e) {
        return (e.getPin().compareTo("1234") == 0);
    }
}
