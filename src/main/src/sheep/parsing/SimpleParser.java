package sheep.parsing;

import sheep.expression.*;
import sheep.expression.arithmetic.*;

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

        if (input.contains("=")) {
            String[] inputBits = input.trim().split("=");
            Expression[] subBits = parseAssistant(inputBits);
            return new Equal(subBits);

        } else if (input.contains("<")) {
            String[] inputBits = input.trim().split("<");
            Expression[] subBits = parseAssistant(inputBits);
            return new Less(subBits);

        }  else if (input.contains("+")) {
            String[] inputBits = input.trim().split("[+]"); //+ is a quantifier so [] required
            Expression[] subBits = parseAssistant(inputBits);
            return new Plus(subBits);

        } else if (input.contains("-")) {
            String[] inputBits = input.trim().split("-");
            Expression[] subBits = parseAssistant(inputBits);
            return new Minus(subBits);

        } else if (input.contains("*")) {
            String[] inputBits = input.trim().split("[*]"); //* is a quantifier so [] required
            Expression[] subBits = parseAssistant(inputBits);
            return new Times(subBits);

        }

        if (input.contains("/")) {
            String[] inputBits = input.trim().split("/");
            Expression[] subBits = parseAssistant(inputBits);
            return new Divide(subBits);
        }

        return null;
    }

    private Expression[] parseAssistant(String[] bits) throws ParseException {
        Expression[] result = new Expression[bits.length];
        for (int indx = 0; indx < bits.length; indx++) {
            result[indx] = parse(bits[indx]);
        }
        return result;
    }
}
