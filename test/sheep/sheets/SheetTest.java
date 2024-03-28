package sheep.sheets;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import sheep.expression.CoreFactory;
import sheep.expression.ExpressionFactory;
import sheep.expression.basic.Nothing;
import sheep.expression.basic.Reference;
import sheep.parsing.SimpleParser;
import sheep.parsing.Parser;
import sheep.expression.Expression;

import java.util.HashMap;
import java.util.Map;


public class SheetTest {

    private Parser parser;
    private Expression defaultExpression;
    private HashMap<String, Expression> builtins = new HashMap<String, Expression>();
    private int rows;
    private int columns;
    private ExpressionFactory factory;


    @Before
    public void setUp() {
        factory = new CoreFactory();
        rows = columns = 5;
        builtins.put("foo", new Reference("bar"));
        defaultExpression = new Nothing();
    }

    @Test public void getterTest() {
        Parser parser = new SimpleParser(factory);
        Sheet sheet = new Sheet(parser, builtins, defaultExpression, rows, columns);
        sheet.usedBy(new CellLocation('A', 1));
        assertEquals(rows, sheet.getRows());
        assertEquals(columns, sheet.getColumns());
        assertEquals(sheet.getRows(), sheet.getColumns());
    }

    @Test
    public void fn(){
        Parser parser = new SimpleParser(factory);
        defaultExpression = new Reference("A0");
        Sheet sheet = new Sheet(parser, builtins, defaultExpression, rows, columns);
        sheet.usedBy(new CellLocation(1, 'A'));

    }

}
