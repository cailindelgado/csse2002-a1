package sheep.parsing;

import sheep.expression.*;

/**
 * Parser of basic expressions and arithmetic expressions.
 */
public class SimpleParser implements Parser{
    private ExpressionFactory factory;

    /**
     * Construct a new parser,
     * @param factory Factory used to construct parsed expressions
     */
    public SimpleParser(ExpressionFactory factory) {
        this.factory = factory;
    }

    /**
     * Attempt to parse a String expression into an expression.
     * @param input A string to attempt to parse
     * @return The result of parsing the expression
     * @throws ParseException If the string is not recognisable as an expression.
     */
    public Expression parse(String input) throws ParseException {
        if (input.trim().equals("")) {
            return factory.createEmpty();
        }
        String[] inputParts = input.trim().split(" ");

    }
}
