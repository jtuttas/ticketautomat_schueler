
package fiaeTest;

/**
 * Währungsprüfer
 * @author Jörg
 */
public class CoinValidator {
    
    public boolean validate(Coin c) {
        return !c.isFalschgeld();
    }
}
