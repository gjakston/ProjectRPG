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
 *      02 = 
 *      03 = 
 *      04 = 
 *      05 = 
 *      06 = 
 *      07 = Wild Life
 *      08 = Slain Monster  
 *      09 = Unslain Monster
 *      10 = Town
 * 
 * 
 */
public class RandomEvent {
    public static byte[][] grid = new byte[50][50];
    public static String[] idList = new String[6999];   
    public static boolean arrayPopulated = false;
    public static int seed = 0; 
    public RandomEvent() {}
    /** Creates the event encountered on the position of int x and int y*/
    public static void newRandomEvent(int x, int y) {
        Random generator = new Random(778578458);
        int attack, strength, defense, size, health, generationValue, rarity;
        boolean isAggressive = false;
        String name = "";
        generationValue = generator.nextInt(1000);
        if (arrayPopulated != true) {
            grid[x][y] = 0; 
            arrayPopulator();
            accessIDs();
        }
        if (grid[x][y] == 1) { // Random Event
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
                    health = 100 + generator.nextInt(1000);
                    if (generationValue > 740) {
                        isAggressive = true;
                    }
                    NonPlayerCharacter npc = new NonPlayerCharacter(name,isAggressive, attack, strength, defense, health, x, y);
                } else {
                    //Generate Monster
                    rarity = generator.nextInt(900);
                    attack = generator.nextInt(1000);
                    strength = generator.nextInt(1000);
                    defense = generator.nextInt(1000);
                    health = 100 + generator.nextInt(1000); 
                    Monster monster = new Monster(name, attack, strength, defense, health, x, y);
                    
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
    /** Generates and creates values used to create a monster object, uses rarity in generation */
    public static void generateMonsterValues() {
        Random generator = new Random(seed);
        int attack, strength, defense, health, rarity, incomplete = 0;
        String name;
        rarity = rarityValue(generator.nextInt(200000));
        if (idList[rarity] != "") {
            name = idList[rarity];
        } else {
            while(idList[rarity] == "") {
                incomplete++;
                if(incomplete > 50) {
                    System.out.println("Error, no name found in idList");
                    break;
                }
                rarity = newRarityListValue(rarity);
            }            
            name = idList[rarity];
        }
    }
    /** Generates new rarity value if current one is invalid in the idList array */
    public static int newRarityListValue(int rarity) {
        Random generator = new Random(rarity);
        if (rarity < 200) {
            rarity = generator.nextInt(200);
        } else if (rarity < 400) {
            rarity = 100 + generator.nextInt(200);
        } else if (rarity < 600) {
            rarity = 400 + generator.nextInt(200);
        } else if (rarity < 800) {
            rarity = 600 + generator.nextInt(100);
        } else {
            rarity = 800 + generator.nextInt(200);
        }
        return rarity;
    }
    /** Creates the rarity value used to generate a monster in-game */
    public static int rarityValue(int randomValue) { 
        Random generator = new Random(randomValue);
        randomValue++;
        if (randomValue <= 5000) {
            return (generator.nextInt(200) + 800);   // 2.50%
        } else if (randomValue <= 17500) {
            return (generator.nextInt(100) + 600);   // 6.25%
        } else if (randomValue <= 31000) {
            return (generator.nextInt(200) + 400);   // 6.75%
        } else if (randomValue <= 75000) {
            return (generator.nextInt(200) + 100);   // 22.0%
        } else { 
            return (generator.nextInt(200));         // 62.5%
        }
    }
    public static void generateNonPlayerCharacterValues() {
        Random generator = new Random(seed);
        int attack, strength, defense, health, nameChoice;
        boolean isAggressive;
        String name = "";
        attack = 1 + generator.nextInt(100);
        strength = 1 + generator.nextInt(100);
        defense = 1 + generator.nextInt(100);
        health = 1 + generator.nextInt(100);
        nameChoice = generator.nextInt(2);
        if (nameChoice == 1) {
            name = idList[5000 + generator.nextInt(100)] + "_" + idList[5100 + generator.nextInt(400)] + "_" + idList[6000 + generator.nextInt(1000)];
        } else {
            name = idList[5500 + generator.nextInt(100)] + "_" + idList[5600 + generator.nextInt(100)] + "_" + idList[6000 + generator.nextInt(1000)];
        }
    }
    public static void generatePeacefulAnimalValues() {
        Random generator = new Random(seed);       
        int health;
        String name = "";
        name = idList[1000 + generator.nextInt(1000)];
        health = 15 + generator.nextInt(50);
    }
    public static void generateTownValues() {
        Random generator = new Random(seed);
        int size;
        String name;
        name = idList[4000 + generator.nextInt(1000)];
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