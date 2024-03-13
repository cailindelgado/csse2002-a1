package sheep.expression.arithmetic;

import sheep.expression.Expression;

/**
 * A minus operation with the operator name '-'
 */
public class Minus extends Arithmetic {

    private Expression[] arguments;
    public Minus(Expression[] arguments) {
        super("-", arguments);
        this.arguments = arguments;
    }

    protected long perform(long[] arguments) {
        return 0;
    }
}
