package sheep.sheets;

import sheep.expression.Expression;
import sheep.parsing.Parser;

import java.util.Map;

/**
 * Builder pattern to construct sheet instances
 * A sheet builder maintains a collection of built-in expressions.
 * These map identifiers to expressions such that any expression within
 * the constructed sheet can reference the identifier and evaluate to the expression.
 */
public class SheetBuilder {
    private final Parser parser;
    private final Expression defaultExpression;
    private final Map<String, Expression> builtints;

    /**
     * Construct an instance of SheetBuilder than will create Sheet instances using the given
     * Parser and Expression instances.
     *
     * @param parser            a parser to parse expressions
     * @param defaultExpression an expression which is used as the default expression
     */
    public SheetBuilder(Parser parser, Expression defaultExpression) {
        this.parser = parser;
        this.defaultExpression = defaultExpression;

    }

    /**
     * Include a new built-in expression for the given identifier within any sheet constructed by
     * this builder instance.
     *
     * @param identifier A string identifier to be used in the constructed sheet
     * @param expression The value that the identifier should resolve to within the constructed
     *                   sheet
     * @return The current instance of the SheetBuilder
     * @requires identifier cannot be a valid cell location reference, e.g. A1.
     */
    public SheetBuilder includeBuiltIn(String identifier, Expression expression) {
        return new SheetBuilder(parser, defaultExpression);

    }

    /**
     * Construct a new empty sheet with the given number of rows and columns.
     *
     * @param rows    Amount of rows for the new sheet
     * @param columns Amount of columns for the new sheet
     * @return A new sheet with the appropriate built-ins and of the specified dimensions.
     */
    public Sheet empty(int rows, int columns) {
        return new Sheet(parser, builtints, defaultExpression, rows, columns);
    }
}
