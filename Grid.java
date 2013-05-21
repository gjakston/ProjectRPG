import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.*;
public class Grid {
    public byte[][] grid = new byte[50][50];
    public Grid() {}
    public void game() {
        boolean play = true;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = input.next();
        System.out.print("\nTo move north, type \"NORTH\"\n" +
                        "To move south, type \"SOUTH\"\n" +
                        "To move west, type \"WEST\"\n" +
                        "To move east, type \"EAST\"\n" +
                        "For help, type \"HELP\"\n");    
        Player player = new Player(playerName, 25, 25);
        while (play) {
            String cmdLine = input.next();
        }
        
        
        
    }
}