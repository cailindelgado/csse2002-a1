package sheep.expression;

import java.util.Map;
import java.util.Set;

/**
 * Is the base type from which all values extend.
 */
public abstract class Expression {
    //reference is true when expression is a reference,
    private boolean reference = false;

    /**
     * constructor method.
     */
    public Expression() {}

    /**
     * The set of references depended upon by the expression
     * @return A set containing all the transitive references depended upon by the expresson.
     */
    public abstract Set<String> dependencies();

    /**
     * Evaluate the expression to a numeric value.
     * @return A long that represents the numeric value of the expression.
     * @throws TypeError If the method is called on an expression that does not have a numeric
     * value
     */
    public abstract long value() throws TypeError;

    /**
     * The result of evaluating this expression
     * @param state A mapping of references to the expression they hold
     * @return Either the expression itself or a new expression resulting from evaluation
     * @throws TypeError If a type error occurs in the process of evaluation
     */
    public abstract Expression value(Map<String, Expression> state) throws TypeError;

    /**
     * True if the expression is a reference
     * @return true if the expression is a reference
     */
    public boolean isReference() {
        return reference;
    }

    /**
     * The string representation of the expression
     * @return the string representation of the expression
     */
    public abstract String render();

}

