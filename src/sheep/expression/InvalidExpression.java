package sheep.expression;

/**
 * This is an exception which will be thrown when a invalid expression is found
 */
public class InvalidExpression extends Exception {

    /**
     * Constructor for when InvalidExpression is thrown without any message or base
     */
    public InvalidExpression() {
        super();
    }

    /**
     * Construct a new exception with another exception as the base cause
     * @param message The description of the exception
     */
    public InvalidExpression(String message) {
        super(message);
    }

    /**
     * Construct a new exception with a description of the exception
     * @param base The exception that caused this exception to be thrown
     */
    public InvalidExpression(Exception base) {
        super(base);
    }
}

