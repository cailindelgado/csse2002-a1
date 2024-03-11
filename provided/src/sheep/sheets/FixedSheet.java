package sheep.sheets;

import sheep.core.SheetUpdate;
import sheep.core.SheetView;
import sheep.core.UpdateResponse;
import sheep.core.ViewElement;

import javax.swing.text.View;

/**
 * Spreadsheet that has fixed values in every cell.
 *
 * @extends Object
 * @implements {@link SheetView} and {@link SheetUpdate}
 */
public class FixedSheet {

    /**
     * Determines the formula to display at given cell.
     *
     * @param row The row index to update
     * @param column The column index to update
     * @return An approximately formatted cell based on whether it is highlighted or not.
     * @requires 0 <= row < getRows(), 0 <= column < getColumns()
     */
    public static ViewElement formulaAt(int row, int column) {
        if (checker(row, column, null)) {
            return ViewElement();
        }
    }

    /**
     * Determines the value to display at given cell.
     *
     * @param row The row index to update
     * @param column The column index to update
     * @return An approximately formatted cell based on whether it is highlighted or not.
     * @requires 0 <= row < getRows(), 0 <= column < getColumns()
     */
    public static ViewElement valueAt(int row, int column) {
        if (checker(row, column, null)) {
            return new ViewElement("W", "Green", "Black");
        }
        return new ViewElement(null, "White", "Black");
    }

    /**
     * The number of rows in the sheet.
     *
     * @return 6
     */
    public static int getRows() {
        return 6;
    }

    /**
     * The number of columns in the sheet.
     *
     * @return 6
     */
    public static int getColumns() {
        return 6;
    }

    /**
     * Attempts to update a cell in the position given
     *
     * @param row The row index to update
     * @param column The column index to update
     * @param input The value as a string to replace
     * @return "A failed update as the sheet is view only"
     * @requires 0 <= row < getRows(), 0 <= column < getColumns(), input!= null
     */
    public static UpdateResponse update(int row, int column, String input) {
        if (checker(row, column, input)) {
            return UpdateResponse.fail("A failed update as the sheet is view only");
        }
        return UpdateResponse.success();
    }


    /**
     * Performs a check on the given inputs and returns the appropriate response
     * performs the following check: 0 <= row < getRows(), 0 <= column < getColumns(), input!= null
     *
     * @param row The row index
     * @param column The column index
     * @param input  A String input
     * @return true or false, based off of the
     */
    private static boolean checker(int row, int column, String input) {
        boolean req1 = ((0 < row) || (0 == row)) && (row < getRows());
        boolean req2 = ((0 < column) || (0 == column)) && (column < getColumns());
        if (input == null) {
            return (req1 && req2);
        } else {
            return (input != null && req1 && req2);
        }
    }

}
