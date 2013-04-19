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
            //RandomEvent(int x, int y)
            randomEventarizer.newRandomEvent(mainChar.LocationX(), mainChar.LocationY());
            
        }  
    }
    /**
     * Controls and manipulates the cognitive values of the game engine, determining indirectly the likelyhood of a new instantiation of a conceptualizer object that controls the probability of another call to the conceptualizer method in the same class.

     */
    public void Conceptualizer(String toStringResultValue, int seed, int probability, double[][][][] theoreticalSpawns, Object caricature) {
        int g = (int)((Math.pow(2, 32) - 1) / 2);
        long d = (long)Math.sqrt(Math.PI);
        int Au = 79;
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