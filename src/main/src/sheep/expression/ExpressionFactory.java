package sheep.expression;

/**
 * This is a way of hidin the creation of objects. By hiding the object creation.
 */
public interface ExpressionFactory {

    /**
     * construct an expression representing a reference to the given identifier
     * @param identifier A reference to either a cell or a built-in
     * @return A reference expression to the identifier
     */
    Expression createReference(String identifier);

    /**
     * construct a numeric constant expression that holds the given value
     * @param value A constant long value of the expression
     * @return A numeric constant expression
     */
    Expression createConstant(long value);

    /**
     * create an expression that represents an empty cell and stores no information
     * @return An empty expression
     */
    Expression createEmpty();

    /**
     * construct an operator based on the given identifying name and with the provided operator
     * arguments
     * @param name An identifier for the operator, e.g. +, -, *
     * @param args Arguments to the operator
     * @return An appropriate operator expression
     * @throws InvalidExpression If the operator name is invalid(not known), or the arguments to
     * the operator are inapproprite (e.g. wrong type, too few, too many etc)
     */
    Expression createOperator(String name, Object[] args) throws InvalidExpression;
}
