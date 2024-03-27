package sheep.sheets;

//Stage 2
import java.util.Optional;

/**
 * A location of a cell within a grid. This class represents a location via a row,
 * column and coordinate system.
 */
public class CellLocation {
    private final int row;
    private final int column;

    /**
     * Construct a new cell location at the given row and column
     * @param row A number representing the row number.
     * @param column A character representing the column.
     * @require row >= 0, column is between 'A' and 'Z' inclusive
     */
    public CellLocation(int row, char column) {
        this.row = row;
        this.column = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(column);
    }

    /**
     * Construct a new cell location at the given row and column.
     * @param row A number representing the row number.
     * @param column A number representing the column.
     * @require row and column to be between 0 and 25 inclusive.
     */
    public CellLocation(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Attempts to parse a string into a cell location.
     * @param ref A string that may represent a cell location
     * @return An optional containing a cell reference if the string is a reference, otherwise an
     * empty optional.
     * @require ref not null.
     */
    public static Optional<CellLocation> maybeReference(String ref) {
        if (ref != null) {
            return Optional.empty();
        }
        return null;
    }

    /**
     * return row number of this cell location
     * @return The row number of this cell location
     */
    public int getRow() {
        return row;
    }

    /**
     * return the column number of this cell location
     * @return The column number of this cell location
     */
    public int getColumn() {
        return column;
    }

    /**
     * If two instances of cell locations are equal to each other. Equality is defined by having
     * the same row and column.
     * @param obj another instance to compare against
     * @return true if the other object is a cell location with the same row and column number as
     * the current cell location.
     */
    @Override
    public boolean equals(Object obj) {
        return false;
    }

    /**
     * A hashcode method that respects the equals(Object) method
     * @return An appropriate hashcode value for this instance
     */
    public int hashCode() {
        return 0;
    }

    /**
     * A string representation of a cell location.*
     * @return A string representation of this cell location, e.g. A2 or C23.
     */
    public String toString() {
        return String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(column)) + row;
    }


}
