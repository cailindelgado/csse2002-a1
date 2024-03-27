package sheep.sheets;

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
        String refColumn;
        String refRow;
        if ((ref != null)) {

            refRow = ref.substring(1);

            refColumn = "" + ref.charAt(0);
            //check if the first position of ref is a Capital letter,
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(refColumn)) {
                if (checkValid(refRow)) {
                    return Optional.of(new CellLocation(Integer.parseInt(refRow), ref.charAt(0)));
                }
            }
        }
        return Optional.empty();
    }

    /**
     * checks if the string is a number, that is positive
     * @param row a string input of the row to check
     * @return true if the string can be evaluated to a positive number, false otherwise
     */
    private static boolean checkValid(String row) {
        for (int pos = 0; pos < row.length(); pos++) {
            if (!Character.isDigit(row.charAt(pos))) {
                return false;
            }
        }
        return true;
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
        if (obj instanceof CellLocation cellLocation) {
            return (this.row == cellLocation.getRow()) && (this.column == cellLocation.getColumn());
        }
        return false;
    }

    /**
     * A hashcode method that respects the equals(Object) method
     * @return An appropriate hashcode value for this instance
     */
    public int hashCode() {
        return (int) Math.pow(((row + column) >>> 30), (row + column));
    }

    /**
     * A string representation of a cell location.*
     * @return A string representation of this cell location, e.g. A2 or C23.
     */
    public String toString() {
        return String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(column)) + row;
    }


}
