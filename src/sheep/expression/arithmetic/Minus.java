package sheep.expression.arithmetic;

import sheep.expression.Expression;

/**
 * A minus operation with the operator name '-'
 */
class Minus extends Arithmetic {

    /**
     * Construct a new minus expression
     *
     * @param arguments A sequence of sub-expressions to perform the operation upon.
     */
    public Minus(Expression[] arguments) {
        super("-", arguments);
    }

    /**
     * perform a minus operation over the list of arguments
     *
     * @param arguments A list of numbers to perform the operation upon
     * @return the result of minus
     */
    protected long perform(long[] arguments) {
        long result = arguments[0];
        for (int index = 1; index < arguments.length; index++) {
            result -= arguments[index];
        }
        return result;
    }
}