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

    @Before
    public void setUp() {
        //using corefactory because it implements the interface
        factory = new CoreFactory();
    }

    @Test
    public void testParseEmptyString() throws ParseException {
        Parser parser = new SimpleParser(factory);
        Expression result = parser.parse("");
        assertEquals(factory.createEmpty(), result);

    }

    @Test
    public void testParseEqualExpression() throws ParseException {
        Parser parser = new SimpleParser(factory);
        Expression result = parser.parse("1=2");
        System.out.println(result.toString());
//        assertEquals(new Equal(new Constant(1), new Constant(2)), result.toString());

    }


}


