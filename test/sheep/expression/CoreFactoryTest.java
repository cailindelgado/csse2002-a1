package sheep.expression;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import sheep.expression.CoreFactory;
import sheep.expression.Expression;
import sheep.expression.ExpressionFactory;
import sheep.expression.basic.Constant;

public class CoreFactoryTest {
    private ExpressionFactory factory;

    @Before public void setUp() {factory = new CoreFactory();}

    @Test public void operators() {
        Object[] args = {new Constant(4), new Constant(3)};
        try {
            factory.createOperator("+", args);
        } catch (InvalidExpression e) {
            System.out.println("foo");
        }

    }

    @Test public void references() {
        factory.createReference("A0");
        factory.createReference("hello");
    }
}
