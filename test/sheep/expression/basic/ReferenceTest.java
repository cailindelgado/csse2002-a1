package sheep.expression.basic;

import sheep.expression.basic.Reference;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReferenceTest {

    @Test public void ReferenceHello() {
        Reference ref = new Reference("Hello");
        assertEquals("Hello", ref.getIdentifier());
    }

}
