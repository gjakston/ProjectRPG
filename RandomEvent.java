public class RandomEvent {
    public static byte[][] grid = new byte[50][50]; //false not travelled, true travelled
    public static String[] eventNames = new String[999];
    public static String[][] gridEventPast = new String[50][50];
    public static boolean arrayPopulated = false;
    public RandomEvent() {}
    public static void newRandomEvent(int x, int y) {
        if (arrayPopulated != true) {
            grid[x][y] = 0; 
            gridEventPast[x][y] = "The start of your adventure.";
            arrayPopulator();
            //
        }
        if (grid[x][y] == 1) {
            // Random Event
            
            
            
            
            
            
        } else {
            System.out.println(gridEventPast[x][y]);
        }
         // Tire treads //
        //             //
    }
    public static void arrayPopulator() {
        for (int k = 0; k < grid.length; k++) {
            for (int j = 0; j < grid.length; j++) {
                grid[k][j] = 1;
            }
        }
        arrayPopulated = true;
    }















}