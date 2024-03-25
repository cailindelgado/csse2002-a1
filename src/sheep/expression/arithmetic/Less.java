package sheep.expression.arithmetic;

import sheep.expression.Expression;

class Less extends Arithmetic {

    /**
     * construct a new less expression
     * @param arguments A sequence of sub-expressions to perform the operation upon
     */
    public Less(Expression[] arguments) {
        super("<", arguments);
    }

    /**
     * Perform a less than operation over the list of arguments to ensur they're increasing.
     * @param arguments A list of numbers to perform the operation upon
     * @return 1 if all arguments are equal, 0 otherwise
     */
    protected long perform(long[] arguments) {
        int counter = -1; //starts at -1 as final counter val will be 1 less than the array length
        for (int index = 0; index < arguments.length; index++) {
            if ((index + 1) > arguments.length) {
                break;
            }

            if ((arguments[index] < arguments[index + 1])) {
                counter++;
            }
        }
        return (counter == arguments.length) ? 1 : 0;
    }

}
