package sheep.expression.basic;

import sheep.expression.Expression;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Constant extends Expression {
    private long number;

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
        return "CONSTANT(" + (int)number + ")";
    }

    /**
     * Determine if two constants are equal
     * @param object Another object to compare against
     * @return If the given object is equal to this object
     */
    public boolean equals(Object object) {
        if (object instanceof Constant constant) {
            //Downcasting object as an instance of Constant, since above condition true
            return (constant.getValue() == getValue()) ? true : false;
        }
        return false;
    }

    /**
     * A hashcode method that respects the equals(Object) method.
     * @return An appropriate hashcode value for this instance.
     */
    @Override
    public int hashCode() {
        return toString().hashCode();
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
    } //might be wrong

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