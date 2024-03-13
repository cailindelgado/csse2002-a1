package sheep.core;

import org.junit.Test;
import sheep.core.UpdateResponse;

import static org.junit.Assert.assertEquals;

public class UpdateResponseTest {


    @Test
    public void testSuccess() {
        UpdateResponse.success();
        assertEquals("Regular multiplication should work", 1, 0);
    }

}
