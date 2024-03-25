package sheep.expression.arithmetic;

import sheep.expression.Expression;

class Equal extends Arithmetic {

    /**
     * construct a new equal expression
     * @param arguments A sequence of sub-expressions to perform the operation upon
     */
    public Equal(Expression[] arguments) {
        super("=", arguments);
    }

    /**
     * perform an equal to operation over the list of arguments
     * @param arguments A list of numbers to perform the operation upon
     * @return 1 if all arguments are equal, 0 otherwise.
     */
    protected long perform(long[] arguments) {
        //option 1
        for (long number : arguments) {
            for (long number2 : arguments) {
                if (!(number == number2)) {
                    break;
                }
            }
        }
        return 0;
    }
//    protected long perform(long[] arguments) {
//        for (long number : arguments) {
//            for (long number2 : arguments) {
//                if (!(number == number2)){
//                    break;
//                    }
//                }
//            }
//        return 0;
//    }
}
