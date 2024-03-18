package sheep.expression;

/**
 * Thrown if an expression cannot be resolved into a numeric value.
 */
public class TypeError extends Exception {

    /**
     * constructor for when no message or base is passed in
     */
    public TypeError() {
        super();
    }

    /**
     * Constructor for when message pasesd in
     * @param message The description of the exception.
     */
    public TypeError(String message) {
        super(message);
    }

    /**
     * constructor for when base is passed in
     * @param base The exception that caused this exception to be thrown.
     */
    public TypeError(Exception base) {
        super(base);
    }
}