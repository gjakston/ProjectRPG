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
        boolean action = false;
        boolean play = true;
        boolean secondAction = false;
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
        RandomLoot randomLoot = new RandomLoot(274);
        while (play) {
            //Movement
            while (action != true) {
                cmdLine = input.next();
                switch(cmdLine) {
                    case "NORTH":
                        action = player.moveNorth();
                        break; 
                    case "SOUTH":
                        action = player.moveSouth();
                        break; 
                    case "WEST":
                        action = player.moveWest();
                        break;
                    case "EAST":
                        action = player.moveEast();
                        break;        
                    case "HELP":
                        help(1);
                        action = false;
                        break;
                    case "EXIT":
                        play = false;
                        System.exit(0);
                        break; 
                    default:
                        action = false;
                        System.out.println("Input unrecognized");
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
                                               list.valueAt(generation[2]));
                    break;
                case 3:
                    NonPlayerCharacter npc = new NonPlayerCharacter(player.x, player.y,
                                                                    generation[1],
                                                                    generation[2],
                                                                    generation[3],
                                                                    generation[4],
                                                                    generation[5],
                                                                    name(generation[6],
                                                                    generation[7]));
                    break;
                case 4:
                    Town town = new Town(player.x, player.y, generation[2], list.valueAt(generation[1]));
                    break;    
            }
            action = false;
            //Interaction
            if (generation[0] > 0) {
                cmdLine = input.next();
            } else {
                action = true;
            }
            while(action != true) {
                if (generation[0] == 1) {
                    
                } else if (generation[0] == 2) {
                    
                } else if (generation[0] == 3) {
                    
                } else if (generation[0] == 4) {
                    
                } else {
                    action = true;
                }
                
                
                //Monster
                    //Combat - loot
                    //flee
                //NPC
                    //aggressive, Combat - loot
                    //flee
                    //Interact
                        //manage inventory
                        //trade
                //Town
                    //interact
                        //manage inventory
                        //trade 
            }
            while(secondAction != true) {
                cmdLine = input.nextLine();
                
            }
        }
    }
    public String name(int firstName, int lastName) {
        idList list = new idList();
        String fullname = list.valueAt(firstName) + " " + list.valueAt(lastName);
        return fullname;
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