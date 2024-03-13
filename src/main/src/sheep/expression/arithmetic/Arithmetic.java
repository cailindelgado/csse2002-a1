package sheep.expression.arithmetic;

import sheep.expression.Expression;

public class Arithmetic {
    private String operator;
    private Expression[] arguments;
    /**
     * Construct a new expression
     * @param operator The name of the arithmetic expression
     * @param arguments A sequence of sub-expressions to perform the operation upon
     */
    public Arithmetic(String operator, Expression[] arguments) {
        if (arguments.length > 0) {
            this.operator = operator;
            //do i need to declare a private arguments variable?
            this.arguments = arguments;
        }
    }

    public static Arithmetic plus(Expression[] arguments) {
        return null;
    }

}
