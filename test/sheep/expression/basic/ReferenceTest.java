package sheep.expression.basic;

import sheep.expression.basic.Reference;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReferenceTest {

    @Test public void ReferenceHello() {
        Reference ref = new Reference("Hello");
        Reference ref2 = new Reference("Hallo");
        assertEquals("Hello", ref.getIdentifier());

        assertFalse(ref2.getIdentifier().equals(ref.getIdentifier()));
    }

}
