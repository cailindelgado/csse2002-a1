package sheep.expression;

import java.util.*;

/**
 * Is the base type from which all values extend.
 */
public abstract class Expression {
    //reference is true when expression is a reference,
    private boolean reference = false;

    public Expression() {}

    /**
     * The set of references depended upon by the expression
     * @return A set containing all the transitive references depended upon by the expresson.
     */
//    public abstract Set<String> dependencies() {
//        return empty set;
//    }

    /**
     * Evaluate the expression to a numeric value.
     * @return A long that represents the numeric value of the expression.
     * @throws TypeError If the method is called on an expression that does not have a numberic
     * value
     */
//    public abstract long value() throws TypeError {
//        throw new TypeError("Method called on expression that doesn't have a numeric value");
//    }

//    public abstract Expression value(Map<String, Expression> state) throws TypeError {
//    }

    /**
     * True if the expression is a reference
     * @return true if the expression is a reference
     */
    public boolean isReference() {
        return reference;
    }

//    public abstract String render() {
//
//    }

}

