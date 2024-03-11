package sheep.parsing;

import sheep.expression.Expression;

public interface Parser {

    /**
     * Attempt to parse a string expression into an expression
     * @param input A string to attempt to parse
     * @return The result of parsing the expression
     * @throws ParseException If the string input is not recognisable as an expression
     */
    Expression parse(String input) throws ParseException;
}
