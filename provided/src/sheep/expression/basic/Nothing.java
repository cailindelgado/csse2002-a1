package sheep.expression.basic;

import sheep.expression.*;

import java.lang.reflect.Type;
import java.util.*;

/**
 *
 */
public class Nothing extends Expression{

    /**
     * Constructor method
     */
    public Nothing() {}

    /**
     * Dependencies of the empty expression
     * @return An empty set to represent no dependencies
     */
    public Set<String> dependencies() {
        return Collections.emptySet();

    }

    /**
     * The result of evaluating this expression.
     * @param state A mapping of references to the expression they hold
     * @return itself
     * @throws TypeError If a type error occurs in the process of evaluation
     */
   public Expression value(Map<String, Expression> state) throws TypeError {
        return this;
   }

    /**
     * Evaluate the expression to a numeric value
     * @return Nothing will be returned as a TypeError is always thrown
     * @throws TypeError Will always be thrown by {@link Nothing}
     */
    public long value() throws TypeError {
        throw new TypeError("Nothing");
    }

    /**
     * The string representation of the expression
     * @return the string representation of the expression
     */
    public String render() {
        return "";
    }

    /**
     * String representation of the empty expression
     * @return String representation of the expression
     */
    public String toString() {
        return "NOTHING";
    }
}
