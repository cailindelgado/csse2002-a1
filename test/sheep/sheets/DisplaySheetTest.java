package sheep.sheets;


import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import sheep.expression.CoreFactory;
import sheep.expression.ExpressionFactory;
import sheep.expression.basic.Reference;
import sheep.parsing.SimpleParser;
import sheep.parsing.Parser;
import sheep.expression.Expression;

public class DisplaySheetTest {

    private Parser parser;
    private Expression defaultExpression;
    private ExpressionFactory factory;

    @Before
    public void setUp() {
        factory = new CoreFactory();
    }

    @Test
    public void getterTest() {
        Expression defaultExpression = new Reference("Hi");
        Parser parser = new SimpleParser(factory);
        DisplaySheet sheet1 = new DisplaySheet(parser, defaultExpression, 5, 10);
        DisplaySheet sheet2 = new DisplaySheet(parser, defaultExpression, 14, 15);

        assertEquals(5, sheet1.getRows());
        assertEquals(10, sheet1.getColumns());

        assertEquals(14, sheet2.getRows());
        assertEquals(15, sheet2.getColumns());
    }
}
