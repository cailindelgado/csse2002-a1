package sheep.expression;

public class InvalidExpression extends Exception {

	public InvalidExpression() {super();}
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

