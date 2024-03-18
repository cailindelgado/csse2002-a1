package sheep.sheets;

import sheep.core.*;
import sheep.expression.Expression;
import sheep.expression.TypeError;
import sheep.parsing.Parser;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Sheet implements SheetView, SheetUpdate {

    private Parser parser;
    private Map<String, Expression> builtins;
    private Expression defaultExpression;
    private int rows;
    private int columns;


    /**
     * Construct a new instance of the sheet class. Is initially populated in every cell with
     * defaultExpression
     * @param parser The parser instance used to create expressions
     * @param builtins A mapping of built-in identifiers to expressions
     * @param defaultExpression The default expression to load in every cell
     * @param rows Amount of rows for the new sheet
     * @param columns Amount of columns for the new sheet
     * @require rows > 0, columns > 0 && columns < 26
     */
    public Sheet(Parser parser, Map<String, Expression> builtins, Expression defaultExpression,
                 int rows, int columns) {
        this.parser = parser;
        this.builtins = builtins;
        this.defaultExpression = defaultExpression;

        if ((rows > 0) && (columns > 0) && (columns < 26)) {
            this.rows = rows;
            this.columns = columns;
        } else {
            this.rows = this.columns = 10;
        }
    }

    /**
     * The number of rows in the spreadsheet
     * @return The number of rows for this spreadsheet
     */
    public int getRows() {
        return rows;
    }

    /**
     * The number of columns in the spreadsheet
     * @return The number of columns for this spreadsheet
     */
    public int getColumns() {
        return columns;
    }

    /**
     * The value to render at this location.
     * @param row The row index of the cell.
     * @param column The column index of the cell.
     * @return
     */
    public ViewElement valueAt(int row, int column) {
        return null;
    }

    /**
     * The formula to render at this location
     * @param row The row index of the cell.
     * @param column The column index of the cell.
     * @return The formula to render at this location
     * @require location is within the bounds (row/columns) of the spreadsheet
     */
    public ViewElement formulaAt(int row, int column) {
        if ((row < rows) && (row > 0) && (column < columns) && (column > 0)) {
            return null;
        }
        return null;
    }

   /**
     * Attempt to update the cell at row and column within the sheet with the given input.
     * @param row The row index to update.
     * @param column The column index to update.
     * @param input The value as a string to replace within the sheet.
     * @return Information about the status of performing the update
     */
   public UpdateResponse update(int row, int column, String input) {
       return null;
    }

   /**
     * The formula expression currently stores at the location in the spreadsheet
     * @param location A cell location within the spreadsheet
     * @return The formula expression at the given cell location
     * @require location is within the bounds (row/column) of the spreadsheet
     */
   public Expression formulaAt(CellLocation location) {
        return null;
    }

   /**
     *
     * @param location
     * @return
     */
   public Expression valueAt(CellLocation location) {
       return null;
    }

   /**
     *
     * @param location
     * @return
     */
   public Set<Collection> usedBy(CellLocation location) {
       return null;
    }

   /**
     *
     * @param location
     * @param cell
     * @throws TypeError
     */
   public void update(CellLocation location, Expression cell) throws TypeError {
      throw new TypeError();
   }
}
