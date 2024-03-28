package sheep.sheets;

import sheep.core.*;
import sheep.expression.Expression;
import sheep.expression.TypeError;
import sheep.parsing.ParseException;
import sheep.parsing.Parser;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Spreadsheet that evaluates its expressions and updates dependant cells.
 * Sheet is an implementation of a spreadsheet capable of evaluating its expressions.
 */
public class Sheet implements SheetView, SheetUpdate {

    private final Parser parser;
    private final Map<String, Expression> builtins;
    private final Expression defaultExpression;
    private final int rows;
    private final int columns;
    private final Expression[][] sheet;

    /**
     * Construct a new instance of the sheet class. Is initially populated in every cell with
     * defaultExpression
     *
     * @param parser            The parser instance used to create expressions
     * @param builtins          A mapping of built-in identifiers to expressions
     * @param defaultExpression The default expression to load in every cell
     * @param rows              Amount of rows for the new sheet
     * @param columns           Amount of columns for the new sheet
     * @require rows > 0, columns > 0 && columns < 26
     */
    Sheet(Parser parser, Map<String, Expression> builtins, Expression defaultExpression,
                 int rows, int columns) {
        this.parser = parser;
        this.builtins = builtins;
        this.defaultExpression = defaultExpression;

        this.rows = rows;
        this.columns = columns;

        sheet = new Expression[this.rows][this.columns];
        prepopulate();
    }

    /**
     * The number of rows in the spreadsheet
     *
     * @return The number of rows for this spreadsheet
     */
    public int getRows() {
        return rows;
    }

    /**
     * The number of columns in the spreadsheet
     *
     * @return The number of columns for this spreadsheet
     */
    public int getColumns() {
        return columns;
    }

    /**
     * The value to render at this location.
     *
     * @param row    The row index of the cell.
     * @param column The column index of the cell.
     * @return ViewElement
     */
    public ViewElement valueAt(int row, int column) {
        return new ViewElement(sheet[row][column].render(), "White", "Black");
    }

    /**
     * The formula to render at this location
     *
     * @param row    The row index of the cell.
     * @param column The column index of the cell.
     * @return The formula to render at this location
     * @require location is within the bounds (row/columns) of the spreadsheet
     */
    public ViewElement formulaAt(int row, int column) {
        return new ViewElement(sheet[row][column].toString(), "White", "Black");
    }

    /**
     * Attempt to update the cell at row and column within the sheet with the given input.
     *
     * @param row    The row index to update.
     * @param column The column index to update.
     * @param input  The value as a string to replace within the sheet.
     * @return Information about the status of performing the update
     */
    public UpdateResponse update(int row, int column, String input) {
        try {
            sheet[row][column] = parser.parse(input);
            return UpdateResponse.success();
        } catch (ParseException e) {
            return UpdateResponse.fail("Unable to parse: " + input);
        }
    }

    /**
     * The formula expression currently stored at the location in the spreadsheet
     *
     * @param location A cell location within the spreadsheet
     * @return The formula expression at the given cell location
     * @require location is within the bounds (row/column) of the spreadsheet
     */
    public Expression formulaAt(CellLocation location) {
        int row = location.getRow();
        int column = location.getColumn();

        return sheet[row][column];
    }

    /**
     * Determine which cells use the formula at the given cell location
     *
     * @param location A cell location within the spreadsheet
     * @return The value expression at the given cell location
     * @requires location is within the bounds (row/columns) of the spreadsheet
     */
    public Expression valueAt(CellLocation location) {
        return formulaAt(location);
    }

    /**
     * Determine which cells use the formula at the given cell location.
     * i.e. for a given location, find all the cells where the given location is a transitive
     * dependency for that cell.
     *
     * @param location A cell location within the spreadsheet
     * @return All the cells which use the given cell as a dependency
     * @requires location to be within the bounds (rows/columns) of the spreadsheet
     */
    public Set<CellLocation> usedBy(CellLocation location) {
        int cellRow = location.getRow();
        int cellColumn = location.getColumn();
        HashSet<CellLocation> dependencies = new HashSet<CellLocation>();

        HashSet<String> output = new HashSet<String>();
        output.addAll(sheet[cellRow][cellColumn].dependencies());

        for (String value : output) {
            if (CellLocation.maybeReference(value).isPresent()) {
                dependencies.add(CellLocation.maybeReference(value).get());
            }
        }
        return dependencies;
    }

    /**
     * Insert an expression into a cell location, updating the sheet as required.
     *
     * @param location A cell location to insert the expression into the sheet
     * @param cell     An expression to insert at the given location
     * @throws TypeError If the evaluation of the inserted cell or any of its usages results in a
     *                   TypeError being thrown
     */
    public void update(CellLocation location, Expression cell) throws TypeError {
        int cellRow = location.getRow();
        int cellColumn = location.getColumn();

        update(cellRow, cellColumn, cell.render());
//        if (!update(cellRow, cellColumn, cell.render()).isSuccess()) {
//            throw new TypeError();
//        } else {
//            sheet[cellRow][cellColumn] = cell;
//        }
    }

    /**
     * This prepopulates the current sheet with the given defaultExpression in the constructor
     */
    private void prepopulate() {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                sheet[row][column] = defaultExpression;
            }
        }
    }
}
