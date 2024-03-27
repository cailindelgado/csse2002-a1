package sheep.sheets;

import sheep.sheets.CellLocation;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class CellLocationTest {

    @Test
    public void holdsValue() {
        assertEquals(Optional.of(new CellLocation(0,'A')), CellLocation.maybeReference("A0"));
        assertNotEquals(Optional.of(new CellLocation(0,'A')), CellLocation.maybeReference("A1"));

    }

}
