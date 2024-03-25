package sheep.expression.basic;

import sheep.expression.Expression;
import sheep.expression.TypeError;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A reference to a given identifier
 */
public class Reference extends Expression {

    private final String identifier;

    /**
     * construct a new reference to an identifier
     * @param identifier An identifier of a cell or a built-in.
     */
    public Reference(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Returns the identifier of the reference
     * @return The identifier of this reference
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * String representation of the reference
     * @return The string representation of the expression
     */
    @Override
    public String toString() {
        return "REFERENCE(" + identifier + ")";
    }

    /**
     * Returns whether the expression is a reference
     * @return always returns true
     */
    @Override
    public boolean isReference() {
        return true;
    }

    /**
     * If two instances of reference are equal to each other returns true
     * @param obj another instance to compare against
     * @return true if the other object is a reference with the same identifier
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Reference reference) {
            //if identifiers are the same length then continue
            if (getIdentifier().length() == reference.getIdentifier().length()) {
                for (int pos = 0; pos < getIdentifier().length(); pos++) {
                    if (!(getIdentifier().charAt(pos) == reference.getIdentifier().charAt(pos))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;

        // write your own equals method, not java's implemented one.
        //      if (obj instanceof Reference reference) {
        //          return reference.getIdentifier().equals(identifier);
        //      } else return false;
    }

    /**
     * A hashcode method that respect the equals(Object) method
     * @return An appropriate hashcode for this instance
     */
    @Override
    public int hashCode() {
        //write own hashcode method, not the one java has.
        //        return identifier.hashCode();
        int hash = 0;
        for (int pos = 0; pos < (identifier.length() - 1); pos++) {
            hash += (int) (identifier.charAt(pos) * Math.pow(30, identifier.length() - 2));
        }

        return hash;
    }

    /**
     * Dependencies of the reference expression
     * @return A set containing the references' identifier
     */
    public Set<String> dependencies() {
        Set<String> dependency = new HashSet<String>();
        dependency.add(identifier);
        return dependency;
    }

    /**
     * The result of evaluating this expression
     * @param state A mapping of references to the expression they hold
     * @return The result of evaluating this expression
     * @throws TypeError If a type error occurs in the process of evaluation
     */
    public Expression value(Map<String, Expression> state) throws TypeError {
        if (state.get(identifier) == null) {
            return this;
        } else {
            return state.get(identifier);
        }
    }

    /**
     * Evaluate the expression to a numeric value
     * @return Nothing will be returned as a type error will be thrown
     * @throws TypeError Will always be thrown by {@link Reference}
     */
    public long value() throws TypeError {
        throw new TypeError();
    }

    /**
     * The string representation of the expression
     * @return the string representation of the expression
     */
    public String render() {
        return identifier;
    }
}
