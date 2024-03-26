package sheep.expression.basic;

import sheep.expression.Expression;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * A constant numeric value
 */
public class Constant extends Expression {
    private final long number;

    /**
     * construct a new constant to represent the given number
     * @param number The number to represent as an expression
     */
    public Constant(long number) {
        this.number = number;
    }

    /**
     * get the numeric value stored within the constant expression
     * @return value stored within the expression
     */
    public long getValue() {
        return number;
    }

    /**
     * String representation of the constant.
     * @return String representation of the constant.
     */
    @Override
    public String toString() {
        return "CONSTANT(" + (int) number + ")";
    }

    /**
     * Determine if two constants are equal
     * @param object Another object to compare against
     * @return If the given object is equal to this object
     */
    @Override
    public boolean equals(Object object) {
        //check if the object is a Constant instance
        if (object instanceof Constant constant) {
            return constant.getValue() == getValue();
        }
        return false;
    }

    /**
     * A hashcode method that respects the equals(Object) method.
     * @return An appropriate hashcode value for this instance.
     */
    @Override
    public int hashCode() {
        //create a unique number using the value of the constant instance
        // return toString().hashCode();
        return (int) Math.pow((value() >>> 30), value());
    }

    /**
     * Dependencies of the constant expression
     * @return An empty set to represent no dependencies
     */
    public Set<String> dependencies() {
        return Collections.emptySet();
    }

    /**
     * The result of evaluating this expression
     * @param state A mapping of references to the expression they hold
     * @return Itself
     */
    public Expression value(Map<String, Expression> state) {
        return this;
    }

    /**
     * Evaluate the exopression to a numeric value
     * @return A long that represents the numeric value of the Expression
     */
    public long value() {
        return number;
    }

    /**
     * The string representation of the expression
     * @return The string representation of the expression
     */
    public String render() {
        return "" + number;
    }

}