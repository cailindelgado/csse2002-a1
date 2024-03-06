package sheep.core;

//do we need to create a new file for sheep.sheets? 
//are we allowed to add imports?
//

public class FixedSheet {

    public static void formulaAt(int a, int b) {
        System.out.println("Returns View element");
    }

    public static void valueAt(int a, int b) {
        System.out.println("Returns View element");

    }

    public static int getRows() {
        return 0;
    }

    public static int getColumns() {
        return 0;
    }

    public static void update(int a, int b, String c) {
        System.out.println("Returns UpdateResponse");
    }

}
