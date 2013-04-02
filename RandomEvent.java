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
                    generateTown(generationValue, x, y);
                } else if (generationValue > 700) {
                    //Generate NPC
                    generateNonPlayerCharacter(generationValue, x, y); 
                } else {
                    //Generate Monster
                    generateMonster(generationValue, x, y);
                    generatePeacefulAnimal(generationValue, x, y);
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
    /** Generates a Monster, uses rarity in generation */
    public static Object generateMonster(int seed, int x, int y) {
        Random generator = new Random(seed);
        int attack, strength, defense, health, rarity, incomplete = 0;
        String name;
        rarity = rarityValue(generator.nextInt(200000));
        //Checks to if there is a string value at rarity
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
        //randomizes values monster stats
        if ((seed + 1) % 2 == 0) {
            attack = 1 + rarity + generator.nextInt(((int)(rarity    / 100)));
            strength = 1 + rarity + generator.nextInt(((int)(rarity / 100)));
            defense = 1 + rarity + generator.nextInt(((int)(rarity / 100)));
            health = 1 + rarity + generator.nextInt(((int)(rarity / 100)));
            //                                       It's a road /
        } else {
            attack = 1 + rarity - generator.nextInt(((int)(rarity    / 100)));
            strength = 1 + rarity - generator.nextInt(((int)(rarity / 100)));
            defense = 1 + rarity - generator.nextInt(((int)(rarity / 100)));
            health = 1 + rarity - generator.nextInt(((int)(rarity / 100)));
        }
        Monster monster = new Monster(name, attack, strength, defense, health, x, y);
        return monster;
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
    /**Generates a NonPlayerCharacter */
    public static void generateNonPlayerCharacter(int seed, int x, int y) {
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
    /** Generates a PeacefulAnimal */
    public static void generatePeacefulAnimal(int seed, int x, int y) {
        Random generator = new Random(seed);       
        int health;
        String name = "";
        name = idList[1000 + generator.nextInt(1000)];
        health = 15 + generator.nextInt(50);
    }
    /** Generates a Town */
    public static void generateTown(int seed, int x, int y) {
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
            int valueAtidList;
            for (int j = 0; j < 7028; j++) {
                storage = idList.readLine();
                numberSign = storage.charAt(0);
                if (numberSign == '#') {} else {
                    String[] splitValues = storage.split(" ");
                    /* Testing
                    System.out.println(storage);
                    for (int h = 0; h < splitValues.length; h++) {
                        System.out.println(splitValues[h]);
                    }
                    */
                    valueAtidList = Integer.parseInt(splitValues[0]);
                    if (splitValues.length == 2) {
                        idList[valueAtidList] = SplitValues[1];
                    } else {
                        idList[valueAtidList] = "";
                    }
                }
            } 
            idList.close();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
}