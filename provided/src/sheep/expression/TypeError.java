package sheep.expression;

/**
 * Thrown if an expression cannot be resolved into a numeric value.
 */
public class TypeError extends Exception {

    /**
     * @param message The description of the exception.
     */
    public TypeError(String message) {
        super(message);
    }

    /**
     * @param base The exception that caused this exception to be thrown.
     */
    public TypeError(Exception base) {
        super(base);
    }
}