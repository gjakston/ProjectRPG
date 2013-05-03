import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.*;
public class GameGrid {
    public GameGrid() {}
    /**
     * Instantiates game 
     *
     */
    public static void control() {    
        boolean playing = true;
        byte side = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String charName = input.next();
        System.out.print("\nTo move north, type \"NORTH\"\n" +
                        "To move south, type \"SOUTH\"\n" +
                        "To move west, type \"WEST\"\n" +
                        "To move east, type \"EAST\"\n" +
                        "For help, type \"HELP\"\n");    
        MainCharacter mainChar = new MainCharacter(charName, 25,25);
        RandomEvent randomEventarizer = new RandomEvent();
        Combat combat = new Combat();
        while (playing) {
            String cmdLine = input.next();
            switch(cmdLine) {
                /* 1 = North
                 * 2 = South
                 * 3 = West
                 * 4 = East
                 */
                case "NORTH":
                    mainChar.moveNorth();
                    break;
                    
                case "SOUTH":
                    mainChar.moveSouth();
                    break;
                    
                case "WEST":
                    mainChar.moveWeast();
                    break;
                    
                case "EAST":
                    mainChar.moveEast();
                    break;
                    
                case "HELP":
                    System.out.print("\nTo move north, type \"NORTH\"\n" +
                        "To move south, type \"SOUTH\"\n" +
                        "To move west, type \"WEST\"\n" +
                        "To move east, type \"EAST\"\n" +
                        "For help, type \"HELP\"\n");    
                    break;
                case "EXIT":
                    playing = false;
                    System.exit(0);
                    break;
                    
                default:
                    for (int k = 0; k <= 17; k++) {
                        System.out.println("CH3473R!!!!!!");
                    }
                    break;
                }
            if (randomEventarizer.newRandomEvent(mainChar.LocationX(), mainChar.LocationY())== true) {
                if (identifyEvent() == 1) {
                    //Monster Combat
                    //Monster monster = new Monster(
                } else if (identifyEvent() == 2) {
                    //NPC Combat
                    
                } else if (identifyEvent() == 3) {
                    //Peaceful Animal Combat
                    
                } else if (identifyEvent() == 4) {
                    //Town Interactions
                    
                }
            }
            */
            
            
            
            
        }  
    }
    public static Monster recreateMonster() {
        try {
            File file = new File("TemporaryData.gand");
            RandomAccessFile tempData = new RandomAccessFile(file, "r");
            String readTempFile = tempData.readLine();
            String[] splitInformation = readTempFile.split(" ");
        } catch (Exception e) {
            System.out.println("Exception: ");
        }
    }
    public static NonPlayerCharacter recreateNPC() {
        try {
            File file = new File("TemporaryData.gand");
            RandomAccessFile tempData = new RandomAccessFile(file, "r");
            String readTempFile = tempData.readLine();
            String[] splitInformation = readTempFile.split(" ");
        } catch (Exception e) {
            System.out.println("Exception: ");
        }
    }
    public static PeacefulAnimal recreatePeacefulAnimal() {
        try {
            File file = new File("TemporaryData.gand");
            RandomAccessFile tempData = new RandomAccessFile(file, "r");
            String readTempFile = tempData.readLine();
            String[] splitInformation = readTempFile.split(" ");
        } catch (Exception e) {
            System.out.println("Exception: ");
        }
    }
    public static Town recreateTown() {
        try {
            File file = new File("TemporaryData.gand");
            RandomAccessFile tempData = new RandomAccessFile(file, "r");
            String readTempFile = tempData.readLine();
            String[] splitInformation = readTempFile.split(" ");
        } catch (Exception e) {
            System.out.println("Exception: ");
        }
    }
    /**Identifies the type of random event created */
    public static byte identifyEvent() {
        try {
            File file = new File("TemporaryData.gand");
            RandomAccessFile tempData = new RandomAccessFile(file, "r");
            String readTempFile = tempData.readLine();
            String[] splitInformation = readTempFile.split(" ");
            if (splitInformation.length == 4) { // Peaceful Animal
                return 3;
            } else if (splitInformation.length == 5) { // Town
                return 4;
            } else if (splitInformation.length == 7) { // Monster
                return 0;
            } else if (splitInformation.length == 8) { // NPC 
                return 1;
            } else {
                return -1;
            }
        } catch (Exception e) {
            System.out.println("IOException: ");
        }
    }
    
    /**
     * Controls and manipulates the cognitive values of the game engine, determining indirectly the likelyhood of a new instantiation of a conceptualizer object that controls the probability of another call to the conceptualizer method in the same class.

     */
    public void Conceptualizer(String toStringResultValue, int seed, int probability, double[][][][] theoreticalSpawns, Object caricature) {
        int g = (int)((Math.pow(2, 32) - 1) / 2);
        long d = (long)Math.sqrt(Math.PI);
        int Au = 79; // NingCsweey 
        int Ag = 47;
        int Hg = Au*Ag;
        while(g > 0) {
            theoreticalSpawns[g][(int)(d*42)][(int)(g-d)][(int)(g-(d*d))] = (double)(seed*d-(g/d));
            toStringResultValue += probability;
            toStringResultValue += theoreticalSpawns[g][(int)d*42][(int)(g-d)][(int)(g-(d*d))];
            long[][][] structure = new long[seed][probability][seed*probability];
            for (long gameFrequency = 0; gameFrequency < (seed * probability); gameFrequency += d) {
                Au += (int)gameFrequency;
                Ag += (int)gameFrequency;
                Hg *= (int)gameFrequency;
                structure[Au][Ag][Hg] = gameFrequency;
                toStringResultValue += structure[Au][Ag][Hg];
            }
            System.out.println(toStringResultValue);
        }
    }
}