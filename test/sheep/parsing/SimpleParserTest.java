package sheep.parsing;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import sheep.expression.CoreFactory;
import sheep.expression.Expression;
import sheep.expression.ExpressionFactory;
import sheep.expression.basic.Constant;

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
        assertEquals("1 + 3", result.toString());
        assertEquals("1 + 3 + 4 + 5", result2.toString());
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

}


