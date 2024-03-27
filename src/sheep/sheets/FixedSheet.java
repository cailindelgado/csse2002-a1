package sheep.sheets;

import sheep.core.SheetUpdate;
import sheep.core.SheetView;
import sheep.core.UpdateResponse;
import sheep.core.ViewElement;

/**
 * Spreadsheet that has fixed values in every cell.
 */
public class FixedSheet implements SheetView, SheetUpdate {

    /**
     * Determines the formula to display at given cell.
     * @param row The row index to update
     * @param column The column index to update
     * @return An approximately formatted cell based on whether it is highlighted or not.
     * @require 0 <= row < getRows(), 0 <= column < getColumns()
     */
    public  ViewElement formulaAt(int row, int column) {
        if (checker(row, column)) {
            if ((row >= 2) && (row <= 3) && (column >= 2) && (column <= 3)) {
                return new ViewElement("GREEN", "Green", "Black");
            }
        }
        return new ViewElement("", "White", "Black");
    }

    /**
     * Determines the value to display at given cell.
     *
     * @param row The row index to update
     * @param column The column index to update
     * @return An approximately formatted cell based on whether it is highlighted or not.
     * @require 0 <= row < getRows(), 0 <= column < getColumns()
     */
    public ViewElement valueAt(int row, int column) {
        if (checker(row, column)) {
            if ((row >= 2) && (row <= 3) && (column >= 2) && (column <= 3)) {
                return new ViewElement("W", "Green", "Black");
            }
        }
        return new ViewElement("", "White", "Black");
    }

    /**
     * The number of rows in the sheet.
     * @return 6
     */
    public int getRows() {
        return 6;
    }

    /**
     * The number of columns in the sheet.
     * @return 6
     */
    public int getColumns() {
        return 6;
    }

    /**
     * Attempts to update a cell in the position given
     * @param row The row index to update
     * @param column The column index to update
     * @param input The value as a string to replace
     * @return "A failed update as the sheet is view only"
     * @requires 0 <= row < getRows(), 0 <= column < getColumns(), input!= null
     */
    public UpdateResponse update(int row, int column, String input) {
        if (checker(row, column) && input.isEmpty()) {
            return UpdateResponse.fail("Sheet is view only.");
        }
        return UpdateResponse.success();
    }

    /**
     * Performs a check on the given inputs and returns the appropriate response
     * performs the following check: 0 <= row < getRows(), 0 <= column < getColumns(), input!= null
     * @param row The row index
     * @param column The column index
     * @return true or false, based off of the
     */
    private boolean checker(int row, int column) {
        boolean req1 = ((0 < row) || (0 == row)) && (row < getRows());
        boolean req2 = ((0 < column) || (0 == column)) && (column < getColumns());
        return (req1 && req2);
    }

}
