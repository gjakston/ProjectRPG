import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
public class RandomEvent {
    public static byte[][] grid = new byte[50][50]; //false not travelled, true travelled
    public static String[] idList = new String[6999];
    public static String[][] gridEventPast = new String[50][50];
    public static boolean arrayPopulated = false;
    public RandomEvent() {}
    public static void newRandomEvent(int x, int y) {
        if (arrayPopulated != true) {
            grid[x][y] = 0; 
            gridEventPast[x][y] = "The start of your adventure.";
            arrayPopulator();
            accessIDs();
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
    public static void accessIDs() {
        try {
            File file = new File("idList.gand");
            RandomAccessFile idList = new RandomAccessFile(file, "r");
            /*
            while (idList.readLine()!= null) {
                System.out.println(idList.readLine());
            }
            */
            String storage = "";
            char numberSign;
            for (int j = 0; j < 30; j++) {
                storage = idList.readLine();
                numberSign = storage.charAt(0);
                if (numberSign == '#') {
                    System.out.println("Line ignored");
                } else {
                    // split into 2 number and word
                    // use number to store in array idList the word
                    
                }
                
            } 
            idList.close();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
        
    }














}