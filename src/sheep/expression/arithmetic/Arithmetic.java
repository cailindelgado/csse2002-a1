package sheep.expression.arithmetic;

import sheep.expression.Expression;
import sheep.expression.TypeError;
import sheep.expression.basic.Constant;
import sheep.expression.basic.Reference;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An arithmetic expression. Performs arithmetic operations on a sequence of sub-expressions.
 */
public abstract class Arithmetic extends Expression {
    private final String operator;
    private final Expression[] arguments;

    /**
     * Construct a new expression
     * @param operator The name of the arithmetic expression
     * @param arguments A sequence of sub-expressions to perform the operation upon
     * @require arguments length > 0
     */
    protected Arithmetic(String operator, Expression[] arguments) {
        this.operator = operator;
        if (arguments.length > 0) {
            this.arguments = arguments;
        } else {
            throw new IllegalArgumentException("arguments length is less than 0");
        }
    }

    /**
     * construct a new addition (plus) operation
     * @param arguments A sequence of sub-expressions to perform the operation upon.
     * @return A plus expression
     * @require arguments.length > 0
     */
    public static Arithmetic plus(Expression[] arguments) {
        return new Plus(arguments);
    }

    /**
     * Construct a new subtraction (minus) operation
     * @param arguments A sequence of sub-expressions to perform the operation upon
     * @return A minus expression
     * @require arguments.length > 0
     */
    public static Arithmetic minus(Expression[] arguments) {
        return new Minus(arguments);
    }

    /**
     * construct a new multiplication (times) operation
     * @param arguments A sequence of sub-expressions to perform the operation upon
     * @return A times expression
     * @require arguments.length > 0
     */
    public static Arithmetic times(Expression[] arguments) {
        return new Times(arguments);
    }

    /**
     * construct a new division (divide) operation
     * @param arguments A sequence of sub-expressions to perform the operation upon
     * @return a divide expression
     * @require arguments.length > 0
     */
    public static Arithmetic divide(Expression[] arguments) {
        return new Divide(arguments);
    }

    /**
     * construct a new less than (less) operation
     * @param arguments A sequence of sub-expressions to perform the operation upon
     * @return a less expression
     * @require arguments.length > 0
     */
    public static Arithmetic less(Expression[] arguments) {
        return new Less(arguments);
    }

    /**
     * construct a new equal to (equal) operation
     * @param arguments A sequence of sub-expressions to perform the operation upon
     * @return a equal expression
     * @require arguments.length > 0
     */
    public static Arithmetic equal(Expression[] arguments) {
        return new Equal(arguments);
    }

    /**
     * Dependencies of the arithmetic expression.
     * The dependencies of  an arithmetic expression are the union of all the sub-expressions
     * @return A set containing the union of all sub-expression dependencies
     */
    public Set<String> dependencies() {
        HashSet<String> dependencies = new HashSet<String>();
        for (Expression expression : arguments) {
            if (expression instanceof Reference reference) {
                dependencies.add(reference.getIdentifier());
            } else if (expression instanceof Constant constant) {
                dependencies.add(constant.render());
            }
        }
        return dependencies;

    }

    /**
     * The result of evaluating this expression
     * @param state A mapping of references to the expression they hold
     * @return A constant expression of the result
     * @throws TypeError If any of the sub-expressions cannot be converted to a numeric value
     */
    public Expression value(Map<String, Expression> state) throws TypeError {
        for (Expression expression : arguments) {

        }
        return null;

    }




    /**
     * Perform the arithmetic operation over a list of arguments
     * @param arguments A list of numbers to perform the operation upon
     * @return The result of performing the arithmetic operation
     */
    protected abstract long perform(long[] arguments);

    /**
     * Evaluate the expression to a numeric value
     * @return Nothing will be returned as a TypeError will always be thrown
     * @throws TypeError Will always be thrown by {@link Arithmetic}
     */
    public long value() throws TypeError {
        throw new TypeError("Arithmetic class error.");
    }

    /**
     * The string representation of the expression
     * @return the string representation of the expression
     */
    public String render() {
        StringBuilder result = new StringBuilder(); //String builder avoids waste of memory
        for (Expression arg : arguments) {
            if (arg instanceof Reference reference) {
                result.append(reference.render()).append(" ").append(operator).append(" ");
            } else if (arg instanceof Constant constant) {
                result.append(constant.render()).append(" ").append(operator).append(" ");
            }
        }
        return result.substring(0, result.length() - 3);
    }

    /**
     * Returns the exact same thing as render()
     * @return the string representation of the expression.
     */
    public String toString() {
        return render();
    }
}
