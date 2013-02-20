import java.util.*;
public class GameGrid {
    public GameGrid() {}
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
    public void Conceptualizer() {}
}