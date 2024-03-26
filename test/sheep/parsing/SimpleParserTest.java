package sheep.parsing;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import sheep.expression.CoreFactory;
import sheep.expression.Expression;
import sheep.expression.ExpressionFactory;
import sheep.parsing.ParseException;

public class SimpleParserTest {

    private ExpressionFactory factory;

    @Before public void setUp() {
        //using corefactory because it implements the interface
        factory = new CoreFactory();
    }

    @Test public void testParseEmptyString() throws ParseException {
        Parser parser = new SimpleParser(factory);
        Expression result = parser.parse("");
        assertEquals(factory.createEmpty().toString(), result.toString());
    }

    @Test public void testParseEqualExpression() throws ParseException {
        Parser parser = new SimpleParser(factory);
        Expression result = parser.parse("1=2");
        System.out.println(result.toString());
    }

    @Test public void testParsePlusExpression() throws ParseException {
        Parser parser = new SimpleParser(factory);
        Expression result = parser.parse("1 +3");
        Expression result2 = parser.parse("1+ 3 + 4 + 5");
        Expression result3 = parser.parse("1+3+4+5");
        assertEquals("1 + 3", result.toString());
        assertEquals("1 + 3 + 4 + 5", result2.toString());
        assertEquals("1 + 3 + 4 + 5", result3.toString());
    }

    @Test public void testParseMinusExpression() throws ParseException {
        Parser parser = new SimpleParser(factory);
        Expression result = parser.parse("1 -3");
        Expression result2 = parser.parse("1- 3 - 4-5");
        assertEquals("1 - 3", result.toString());
        assertEquals("1 - 3 - 4 - 5", result2.toString());
    }

    @Test public void testParseDivideExpression() throws ParseException {
        Parser parser = new SimpleParser(factory);
        Expression result = parser.parse("1 /3");
        Expression result2 = parser.parse("1/ 3 / 4/5");
        assertEquals("1 / 3", result.toString());
        assertEquals("1 / 3 / 4 / 5", result2.toString());
    }

    @Test public void testParseTimesExpression() throws ParseException {
        Parser parser = new SimpleParser(factory);
        Expression result = parser.parse("1 *3");
        Expression result2 = parser.parse("1* 3 * 4*5");
        assertEquals("1 * 3", result.toString());
        assertEquals("1 * 3 * 4 * 5", result2.toString());
    }

    @Test public void testParseExceptionAdv() throws ParseException {
        Parser parser = new SimpleParser(factory);
        Expression result = parser.parse("1 < 3+4 * 6 / 5 -43 + 88");
        Expression result2 = parser.parse("1 - ( 3+4)* 6 / 5 -43 + 88");
        Expression result3 = parser.parse("1 = 3+4 * 6 / 5 -43 + 88");

        System.out.println(result.toString());
        System.out.println(result2.toString());
        System.out.println(result3.toString());

    }

    @Test public void testParseNegs() throws ParseException {
        Parser parser = new SimpleParser(factory);
        Expression result = parser.parse("-2");
        Expression result2 = parser.parse("4 --3");
        Expression result3 = parser.parse("4 + -3");
        Expression result4 = parser.parse("4 * -3");
        Expression result5 = parser.parse("4 = -3");
        Expression result6 = parser.parse("4 / -3");
        Expression result7 = parser.parse("-A0");           // Should it be -A0 as a reference or a type error?
        Expression result8 = parser.parse("-Hell*o");       // same argument as above
    }

    @Test public void testParseGrdScp() throws ParseException {
        Parser parser = new SimpleParser(factory);
        Expression result = parser.parse("3 2  20 - 2/15 +12* 100");
    }

    @Test (expected = ParseException.class)
    public void testParseInvalid() throws ParseException {
        Parser parser = new SimpleParser(factory);
        Expression inv = parser.parse("3!502;]i");
        Expression inv2 = parser.parse("2 + 5 / 6 * &");
        Expression inv3 = parser.parse("2 + 5 / 6 * 5_");
        Expression inv4 = parser.parse("2 - 4 ^ ] + 4");
    }



}