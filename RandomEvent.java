import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.*;
/* 
 * 10% Towns 1% large, 3% medium, 6% small 
 * 70% Monster
 * 20% NPCs - 80% aggressive
 * 
 * byte[][] grid Values:
 *      01 = Unexplored
 *      05 = 
 *      06 = 
 *      07 = 
 *      08 = Wild Life  
 *      09 = Unslain Monster
 *      10 = Town
 * 
 * 
 */
public class RandomEvent {
    public static byte[][] grid = new byte[50][50];
    public static String[] idList = new String[6999];   
    public static boolean arrayPopulated = false;
    public RandomEvent() {}
    public static void newRandomEvent(int x, int y) {
        Random generator = new Random(778578458);
        int attack, strength, defense, size, generationValue;
        boolean isAggressive = false;
        String name = "";
        generationValue = generator.nextInt(1000);
        if (arrayPopulated != true) {
            grid[x][y] = 0; 
            arrayPopulator();
            accessIDs();
        }
        if (grid[x][y] == 1) {
            // Random Event
            if (generationValue > 300) { //Do Random Event
                generationValue = generator.nextInt(1000);
                if (generationValue > 900) {
                    //Generate Town
                    size = generator.nextInt(3) + 1;
                    Town town = new Town(name, size, x, y);
                    
                    
                } else if (generationValue > 700) {
                    //Generate NPC
                    attack = generator.nextInt(1000);
                    strength = generator.nextInt(1000);
                    defense = generator.nextInt(1000);
                    if (generationValue > 740) {
                        isAggressive = true;
                    }
                    NonPlayerCharacter npc = new NonPlayerCharacter(name,isAggressive, attack, strength, defense, x, y);
                } else {
                    //Generate Monster
                    
                }
            } else { // No random Event
                //
            }
        }
        if (grid[x][y] == 10) { // 
            //
            
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
            RandomAccessFile idList = new RandomAccessFile(file,"r");
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