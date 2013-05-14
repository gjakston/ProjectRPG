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
        ResetDataFiles data = new ResetDataFiles();
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
            if (randomEventarizer.newRandomEvent(mainChar.locationX(), mainChar.locationY())== true) {
                boolean eventOccuring = true, validInput = false, fight = false;
                data.ResetTemporaryData();
                if (identifyEvent() == 0) {
                    //Monster Combat
                    Monster monster = recreateMonster();
                    while (eventOccuring) {
                        System.out.println("fight or flee?: " + monster.name());
                        while (validInput == false) {
                            cmdLine = input.next();
                            switch(cmdLine) {
                                case "FIGHT":
                                    fight = true;
                                    validInput = true;
                                    break;
                                case "FLEE":
                                    fight = false;
                                    validInput = true;
                                    break;
                                default:
                                    System.out.println("Invalid input, please either use \"FIGHT\" or \"FLEE\"");
                                    break;
                            }
                        }
                        if (fight == true) {
                            while (fight == true) {
                                int[] results = combat.fightMonster(mainChar, monster);
                                mainChar.health(results[0]);
                                monster.healthChange(results[1]);
                                if (mainChar.healthRemaining <= 0) {
                                    System.out.println("You have died in battle to " + monster.name());
                                    System.exit(0);
                                }
                                if (monster.healthRemaining <= 0) {
                                    System.out.println("You have slain " + monster.name());
                                    mainChar.
                                }
                                System.out.println("Continue? Y/N");
                                cmdLine = input.nextLine();
                                switch(cmdLine) {
                                    case "Y":
                                        break;
                                    case "N":
                                        fight = false;
                                        break;
                                    default:
                                        System.out.println("Invalid input, please use \"Y\" or \"N\"");
                                        break;
                                }
                            }
                        }
                        if (fight == false) {
                            String results[] = combat.fleeMonster();
                            int damageTaken = Integer.parseInt(results[1]);
                            if (results[0] == "true") {
                                mainChar.health(damageTaken);
                                if (mainChar.healthRemaining <= 0) {
                                    System.out.println("You have died in battle to " + monster.name());
                                    System.exit(0);
                                }
                                System.out.println("You successfully evaded " + monster.name());
                                System.out.println("You took " + damageTaken + " damage");
                                mainChar.health(damageTaken);
                            } else {
                                mainChar.health(damageTaken);
                                if (mainChar.healthRemaining <= 0) {
                                    System.out.println("You have died in battle to " + monster.name());
                                    System.exit(0);
                                }
                                System.out.println("You failed to evade " + monster.name());
                                System.out.println("You took " + damageTaken + " damage");
                            }
                        }
                    }
                } else if (identifyEvent() == 1) {
                    //NPC Combat or Interaction
                    NonPlayerCharacter npc = recreateNPC();
                    System.out.println("Fight, flee, or talk?: " + npc.NPC_Name());
                    
                } else if (identifyEvent() == 2) {
                    //Peaceful Animal Combat
                    PeacefulAnimal peacefulAnimal = recreatePeacefulAnimal();
                    while (eventOccuring) {
                        System.out.println("fight or flee?: " + peacefulAnimal.name());
                        while (validInput == false) {
                            cmdLine = input.next();
                            switch(cmdLine) {
                                case "FIGHT":
                                    fight = true;
                                    validInput = true;
                                    break;
                                case "FLEE":
                                    fight = false;
                                    validInput = true;
                                    break;
                                default:
                                    System.out.println("Invalid input, please either use \"FIGHT\" or \"FLEE\"");
                                    break;
                            }
                        }
                        if (fight == true) {
                            while (fight == true) {
                                combat.fightPeacefulAnimal(mainChar, peacefulAnimal);
                                System.out.println("Continue? Y/N");
                                cmdLine = input.nextLine();
                                switch(cmdLine) {
                                    case "Y":
                                        break;
                                    case "N":
                                        fight = false;
                                        break;
                                    default:
                                        System.out.println("Invalid input, please use \"Y\" or \"N\"");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("You successfully evaded " + peacefulAnimal.name());
                            eventOccuring = false;
                        }
                    }
                } else if (identifyEvent() == 3) {
                    //Town Interactions
                    Town town = recreateTown();
                }
            }
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
                return 2;
            } else if (splitInformation.length == 5) { // Town
                return 3;
            } else if (splitInformation.length == 7) { // Monster
                return 0;
            } else if (splitInformation.length == 8) { // NPC 
                return 1;
            }
        } catch (Exception e) {
            System.out.println("IOException: ");
        }
        return -1;
    }
    public static Monster recreateMonster() {
        int x = 0, y = 0, attack = 0, strength = 0, defense = 0, health = 0;
        String name = "";
        try {
            File file = new File("TemporaryData.gand");
            RandomAccessFile tempData = new RandomAccessFile(file, "r");
            String readTempFile = tempData.readLine();
            String[] splitInformation = readTempFile.split(" ");
            x = Integer.parseInt(splitInformation[0]);
            y = Integer.parseInt(splitInformation[1]);
            name = splitInformation[2];
            attack = Integer.parseInt(splitInformation[3]);
            strength = Integer.parseInt(splitInformation[4]);
            defense = Integer.parseInt(splitInformation[5]);
            health = Integer.parseInt(splitInformation[6]);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        Monster monster = new Monster(name, attack, strength, defense, health,x, y);
        return monster;
    }
    public static NonPlayerCharacter recreateNPC() {
        int x = 0, y = 0, attack = 0, strength = 0, defense = 0, health = 0;
        String name = "";
        boolean isAggressive = false;
        try {
            File file = new File("TemporaryData.gand");
            RandomAccessFile tempData = new RandomAccessFile(file, "r");
            String readTempFile = tempData.readLine();
            String[] splitInformation = readTempFile.split(" ");
            x = Integer.parseInt(splitInformation[0]);
            y = Integer.parseInt(splitInformation[1]);
            name = splitInformation[2];
            attack = Integer.parseInt(splitInformation[3]);
            strength = Integer.parseInt(splitInformation[4]);
            defense = Integer.parseInt(splitInformation[5]);
            health = Integer.parseInt(splitInformation[6]);
            if (splitInformation[7].equals("true")) {
                isAggressive = true;
            }
        } catch (Exception e) {
            System.out.println("Exception: ");
        }
        NonPlayerCharacter npc = new NonPlayerCharacter(name,isAggressive, attack, strength, defense, health, x, y);
        return npc;
    }
    public static PeacefulAnimal recreatePeacefulAnimal() {
        int x = 0, y = 0, health = 0;
        String name = "";
        try {
            File file = new File("TemporaryData.gand");
            RandomAccessFile tempData = new RandomAccessFile(file, "r");
            String readTempFile = tempData.readLine();
            String[] splitInformation = readTempFile.split(" ");
            x = Integer.parseInt(splitInformation[0]);
            y = Integer.parseInt(splitInformation[1]);
            name = splitInformation[2];
            health = Integer.parseInt(splitInformation[3]);
        } catch (Exception e) {
            System.out.println("Exception: ");
        }
        PeacefulAnimal peacefulAnimal = new PeacefulAnimal(name, health, x, y);
        return peacefulAnimal;
    }
    public static Town recreateTown() {
        int x = 0, y = 0, size = 0, relationToTown = 0;
        String townName = "";
        try {
            File file = new File("TemporaryData.gand");
            RandomAccessFile tempData = new RandomAccessFile(file, "r");
            String readTempFile = tempData.readLine();
            String[] splitInformation = readTempFile.split(" ");
            x = Integer.parseInt(splitInformation[0]);
            y = Integer.parseInt(splitInformation[1]);
            townName = splitInformation[2];
            size = Integer.parseInt(splitInformation[3]);
            relationToTown = Integer.parseInt(splitInformation[4]);
        } catch (Exception e) {
            System.out.println("Exception: ");
        }
        Town town = new Town(townName, size, x, y, relationToTown);
        return town;
    }
    /**
     * Controls and manipulates the cognitive values of the game engine, determining indirectly the 
     * likelyhood of a new instantiation of a conceptualizer object that controls the probability of
     * another call to the conceptualizer method in the same class.
     */
    public void Conceptualizer(String toStringResultValue, int seed, int probability, 
                                double[][][][] theoreticalSpawns, Object caricature) {
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