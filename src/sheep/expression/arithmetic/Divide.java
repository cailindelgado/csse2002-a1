package sheep.expression.arithmetic;

import sheep.expression.Expression;

class Divide extends Arithmetic {

    /**
     * construct a new divide expression
     * @param arguments A sequence of sub-expressions to perform the operation upon
     */
    public Divide(Expression[] arguments) {
        super("/", arguments);
    }

    /**
     * Perform integer division over the list of arguments
     * @param arguments a list of numbers to perform the operation upon
     * @return the result of the division
     */
    protected long perform(long[] arguments) {
        long result = arguments[0];
        for (int index = 1; index < arguments.length; index++) {
            result /= arguments[index];
        }
        return result;
    }
}