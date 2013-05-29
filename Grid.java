import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.*;
public class Grid {
    /* -1 = no event
     *  0 = unexplored
     *  1 = killed monster
     *  2 = killed npc
     *  3 = killed animal
     *  4 = town
     *  5 = monster
     *  6 = aggresive npc
     *  7 = unnagresive npc
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
        //combat object
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
                    System.out.println("You encountered" + monster.name);
                    break;
                case 2:
                    Animal animal = new Animal(player.x, player.y, generation[1],
                                               list.valueAt(generation[2]));
                    System.out.println("You encountered" + animal.name);
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
                    System.out.println("You encountered a person");
                    break;
                case 4:
                    Town town = new Town(player.x, player.y, generation[2], list.valueAt(generation[1]));
                    System.out.println("You find and enter a town known as " + town.name());
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
                if (generation[0] == 1) { //monster
                    
                } else if (generation[0] == 2) { //npc
                    
                } else if (generation[0] == 3) { //animal
                    
                } else if (generation[0] == 4) { //town
                    
                } else {
                    action = true;
                }
                
                
                //Monster
                    //Combat - loot
                    //flee - skip secondAction
                //NPC
                    //aggressive, Combat - loot
                    //flee - skip secondAction
                    //Interact
                        //trade
                //Town
                    //interact
                        //trade 
            }
            // Second Action
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
                System.out.println("use \"NORTH\" to move north");
                System.out.println("use \"SOUTH\" to move south");
                System.out.println("use \"WEST\" to move west");
                System.out.println("use \"EAST\" to move east");
                System.out.println("use \"EXIT\" to exit the game without saving");
                break;
            case 2: //Monster help
                System.out.println("use \"FIGHT\" to fight the monster");
                System.out.println("use \"FLEE\" to attempt to flee the monster");
                break;
            case 3: //NPC help
                System.out.println("use \"FIGHT\" to fight the other person");
                System.out.println("use \"FLEE\" to attempt to flee the other person");
                System.out.println("use \"TALK\" to interact with the other person");
                break;
            case 4: //NPC help if used talk
                System.out.println("use \"TRADE\" to trade with the other person");
                break;
            case 5: //NPC trading
                System.out.println("use \"BUY\" to buy an item from the other person");
                System.out.println("use \"SELL\" to attempt to sell an item to the other person");
                break;
            case 6: //Town Interaction
                System.out.println("");
                break;
        }
    }
}