package sheep.expression.arithmetic;

import sheep.expression.Expression;

public class Times extends Arithmetic {

    /**
     * construct a new times expression
     * @param arguments A sequence of sub-expressions to perform the operation upon
     */
    public Times(Expression[] arguments) {
        super("*", arguments);
    }

    /**
     * perform a times operation over the list of arguments
     * @param arguments A list of numbers to perform the operation upon
     * @return The result of times
     */
    protected long perform(long[] arguments) {
        long result = 1;
        for (long number : arguments) {
            result *= number;
        }
        return result;
    }
}
