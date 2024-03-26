package sheep.sheets;

import sheep.core.SheetUpdate;
import sheep.core.SheetView;
import sheep.core.UpdateResponse;
import sheep.core.ViewElement;
import sheep.expression.Expression;
import sheep.parsing.ParseException;
import sheep.parsing.Parser;


/**
 *
 */
public class DisplaySheet implements SheetUpdate, SheetView {
    private final int rows;
    private final int columns;
    private final Parser parser;
    private final Expression defaultExpression;

    /**
     * Constructor for DisplaySheet
     * @param parser A parser to use for parsing any updates to the sheet
     * @param defaultExpression The default expression with which to populate the empty sheet
     * @param rows Amount of rows for the new sheet
     * @param columns Amount of columns for the new sheet
     * @requires rows > 0, columns > 0
     */
    public DisplaySheet(Parser parser, Expression defaultExpression, int rows, int columns) {
        if ((rows > 0) && (columns > 0)) {
            this.rows = rows;
            this.columns = columns;
        } else {
            this.rows = this.columns = 30;
        }
        this.parser = parser;
        this.defaultExpression = defaultExpression;
    }

    /**
     * Attempt to update cell in the position. input string will attempt to be parsed.
     * If parsing fails update response fails with "Unable to parse:[input]".
     * Else sheet is updated to render the parsed expression
     * @param row The row index to update
     * @param column The column index to update
     * @param input The value as a string to replace within the sheet
     * @return Whether the update was successful or not with details
     * @requires 0 <= row < getRows(), 0 <= column < getColumns()
     */
    public UpdateResponse update(int row, int column, String input) {
        if (checker(row, column)) {
            try {
                parser.parse(input);
                return UpdateResponse.success();
            } catch (ParseException e) {
                return UpdateResponse.fail("Unable to parse: " + input);
            }
        }
        return null;
    }

    /**
     * The number of rows in the sheet
     * @return Ammount of rows in the sheet
     */
    public int getRows() {
        return rows;
    }

    /**
     * The number of columns in the sheet
     * @return Ammount of columns in the sheet
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Determine the value to display at this cell. The background and foreground colours may be
     * any appropriate combination.
     * @param row The row index of the cell.
     * @param column The column index of the cell.
     * @return A {@link ViewElement} that details how to render the cell's formula.
     * @require 0 <= row < getRows(), 0 <= column < getColumns()
     */
    public ViewElement valueAt(int row, int column) {
        //is the 2 + 2 result (4) in the cell.
        return formulaAt(row, column);
    }

    /**
     * determine the formula to display at this cell.
     * @param row The row index of the cell.
     * @param column The column index of the cell.
     * @require 0 <= row < getRows(), 0 <= column < getColumns()
     */
    public ViewElement formulaAt(int row, int column) {
        //is the 2 + 2 in a cell
        //find a way to store the values on the sheet use an array of arrays to pul the expression
        // in each cell
        if (checker(row, column)) {
            if (UpdateResponse.success().isSuccess()) {
//                return new ViewElement(, "White", "Black");
            }
//            return new ViewElement(, "White", "Black");
        }
        return null;
    }

    /**
     * a checker that is used to check the requirements of the other methods in this class
     * @param row The row index of the cell.
     * @param column The column index of the cell.
     * @return true if condition passes, false otherwise
     */
    private boolean checker(int row, int column) {
        boolean req1 = ((0 == row) || (0 < row)) && (row < getRows());
        boolean req2 = ((0 == column) || (0 < column)) && (column < getColumns());

        return (req1 && req2);
    }
}