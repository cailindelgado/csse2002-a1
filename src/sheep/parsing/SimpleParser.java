package sheep.parsing;

import sheep.expression.Expression;
import sheep.expression.ExpressionFactory;
import sheep.expression.InvalidExpression;

/**
 * Parser of basic expressions and arithmetic expressions.
 */
public class SimpleParser implements Parser {
    private final ExpressionFactory factory;

    /**
     * Construct a new parser,
     *
     * @param factory Factory used to construct parsed expressions
     */
    public SimpleParser(ExpressionFactory factory) {
        this.factory = factory;
    }

    /**
     * Attempt to parse a String expression into an expression.
     *
     * @param input A string to attempt to parse
     * @return The result of parsing the expression
     * @throws ParseException If the string is not recognisable as an expression.
     */
    public Expression parse(String input) throws ParseException {
        //if the input is an empty string return an empty expression
        if (input.trim().isEmpty()) {
            return factory.createEmpty();
        }

        //replace any escape characters that might get in the way
        input = input.replaceAll("[\t\n\r\f]", " ");

        //check if input is valid
        if (!checkInvalid(input)) {
            throw new ParseException();
        }

        //checker for if the given input contains any of the following
        if (input.contains("=")) {
            return parseOutput('=', input);

        } else if (input.contains("<")) {
            return parseOutput('<', input);

        } else if (input.contains("+")) {
            return parseOutput('+', input);

        } else if (input.contains("-") && !negCheck(input)) {
            return parseOutput('-', input);

        } else if (input.contains("*")) {
            return parseOutput('*', input);

        } else if (input.contains("/")) {
            return parseOutput('/', input);
        }

        //try to turn the remaining input into a constant, if it fails turn it into a reference
        try {
            return factory.createConstant(Long.parseLong(input.trim()));
        } catch (NumberFormatException e) {
            return factory.createReference(input.trim());
        }
    }

    /**
     * This helps the parse method by creating an array of expressions,
     * and putting each item of bits back into the parse method, to categorize it
     * bits.
     *
     * @param bits A broken up array depending on what the parse method deems appropriate
     * @return the resulting array of expressions
     * @throws ParseException Is thrown by the parse method when an invalid string is encountered
     */
    private Expression[] parseAssistant(String[] bits) throws ParseException {
        Expression[] result = new Expression[bits.length];
        for (int indx = 0; indx < bits.length; indx++) {
            result[indx] = parse(bits[indx]);
        }
        return result;
    }

    /**
     * Checks if the given input contains a negative value
     *
     * @param input A string input
     * @return a true if the input is a negative number, false otherwise
     */
    private boolean negCheck(String input) {
        String[] bits = input.trim().split("-");

        //if the input is just a constant i.e. -34567 the very first char is '-' so it is negative
        if (input.trim().charAt(0) == '-') {
            return true;
        }

        //iterate over the broken up bits of input to see if the chain can continue
        for (String bit : bits) {
            if (bit.contains("*") || bit.contains("/")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the string input is valid
     *
     * @param input a String input of an expression
     * @return true if the input is a valid expression, false otherwise.
     */
    private boolean checkInvalid(String input) {
        for (int pos = 0; pos < input.length(); pos++) {
            if (!(Character.isLetterOrDigit(input.charAt(pos)))) {
                if (!("+-*/<= ".contains("" + input.charAt(pos)))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Handles breaking the input up based on a given operator name, and creates new operators
     * which match the given name
     *
     * @param name  The operator
     * @param input is the operator that the method should know to use when splitting up the input
     *              and creating a new operator, this is of type char
     * @return returns an appropriate operator class containing an array of expressions
     * @throws ParseException When the createOperator method in
     *                        {@link sheep.expression.CoreFactory} throws an invalid expression
     */
    private Expression parseOutput(char name, String input) throws ParseException {
        String[] inputBits = input.trim().split("[" + name + "]");
        Expression[] subBits = parseAssistant(inputBits);

        try {
            return factory.createOperator("" + name, subBits);
        } catch (InvalidExpression e) {
            throw new ParseException("Invalid Expression");
        }
    }
}