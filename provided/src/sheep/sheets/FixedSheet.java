package sheep.sheets;
import sheep.core.SheetUpdate;
import sheep.core.SheetView;
import sheep.core.UpdateResponse;
import sheep.core.ViewElement;

//do we need to create a new file for sheep.sheets? 
//are we allowed to add imports?
//

public class FixedSheet {

    public static ViewElement formulaAt(int x, int y) {
        System.out.println("Returns Viewelement");
    }

    public static ViewElement valueAt(int x, int y) {
        System.out.println("Returns Viewelement");

    }

    /*
     * @returns 6
     */
    public static int getRows() {
        return 6;
    }

    /*
     * @returns 6
     */
    public static int getColumns() {
        return 6;
    }

    /*
     * @params row The row index to update
     * @param column The column index to update
     * @param input The value as a string to replace
     * 
     * @returns 
     */
    public static UpdateResponse update(int x, int y, String conents) {
        System.out.println("A failed update as the sheet is view only");
    }

}
