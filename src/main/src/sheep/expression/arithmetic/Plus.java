package sheep.expression.arithmetic;

import sheep.expression.Expression;

/**
 * A plus operation with the operator name +
 */
public class Plus extends Arithmetic {

    private long[] arguments;

    /**
     * construct a new plus expression
     * @param arguments A sequence of sub-expressions to perform the operation upon
     */
    public Plus(Expression[] arguments) {
        super("+", arguments);
        if (arguments.length > 0) {

        }
    }

    /**
     * Perform a plus operation over the list of arguments
     * @param arguments A list of numbers to perform the operation upon
     * @return The result of plus
     */
    protected long perform(long[] arguments) {
        long result = 0;
        for (long number : arguments) {
            result += number;
        }
        return result;
    }

}
