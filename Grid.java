import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.*;
public class Grid {
    /* -1 = no event
     *
     *  1 = 
     *
     *
     * 
     */
    public byte[][] grid = new byte[50][50];
    public Grid() {}
    public void game() {
        boolean validMovementInput = false;
        boolean play = true;
        String cmdLine = "";
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = input.next();
        System.out.print("\nTo move north, type \"NORTH\"\n" +
                        "To move south, type \"SOUTH\"\n" +
                        "To move west, type \"WEST\"\n" +
                        "To move east, type \"EAST\"\n" +
                        "For help, type \"HELP\"\n");    
        Player player = new Player(playerName, 25, 25);
        RandomEvent randomEvent = new RandomEvent(274);
        idList list = new idList();
        while (play) {
            //Movement
            while (validMovementInput = false) {
                cmdLine = input.next();
                switch(cmdLine) {
                    case "NORTH":
                        validMovementInput = player.moveNorth();
                        break; 
                    case "SOUTH":
                        validMovementInput = player.moveSouth();
                        break; 
                    case "WEST":
                        validMovementInput = player.moveWest();
                        break;
                    case "EAST":
                        validMovementInput = player.moveEast();
                        break;        
                    case "HELP":
                        help(1);
                        validMovementInput = false;
                        break;
                    case "EXIT":
                        play = false;
                        System.exit(0);
                        break; 
                    default:
                        validMovementInput = false;
                        break;
                }
            }
            //Generation 
            int[] generation = randomEvent.newEvent();
            switch(generation[0]) {
                case 0:
                    grid[player.x][player.y] = -1;
                    System.out.println("There is nothing here.");
                    break;
                case 1:
                    Monster monster = new Monster(player.x, player.y, generation[1],
                                                  generation[2], generation[3],
                                                  generation[4], generation[5],
                                                  list.valueAt(generation[5]));
                    break;
                case 2:
                    Animal animal = new Animal(player.x, player.y, generation[1],
                                               list.valueAt(generaton[2]));
                    break;
                case 3:
                    break;
                case 4:
                    break;    
            }
            
            
            
            
            
            
            
        }
    }
    
    public void help(int directory) {
        switch(directory) {
            case 1: //Movement help
                System.out.println("");
                break;
            case 2:
                System.out.println("");
                break;
            case 3:
                System.out.println("");
                break;
        }
    }
}