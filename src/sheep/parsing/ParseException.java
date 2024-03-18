package sheep.parsing;

/**
 * An exception that is thrown if an expression cannot be parsed
 */
public class ParseException extends Exception {

    /**
     * Constructor for when no message or base passed in
     */
    public ParseException() {
        super();
    }

    /**
     * Construct a new exception with a description of the exception
     * @param message The description of the exception
     */
    public ParseException(String message) {
        super(message);
    }

    /**
     * Construct a new exception with another exception as the base cause
     * @param base The exception that caused this exception to be thrown
     */
    public ParseException(Exception base) {
        super(base);
    }

}
