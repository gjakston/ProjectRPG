import java.util.*;
public class NewGame {
    public NewGame() {}
    public static void run() {
        Scanner input = new Scanner(System.in);
        ResetDataFiles resetGame = new ResetDataFiles();
        resetGame.ResetFileValuesAll();
        GameGrid gridOfGame = new GameGrid();
        GameGrid.control();
    }
    public static void controls() {
        System.out.print("\nTo move north, type \"NORTH\"\n" +
                         "To move south, type \"SOUTH\"\n" +
                         "To move west, type \"WEST\"\n" +
                         "To move east, type \"EAST\"\n" +
                         "For help, type \"HELP\"\n");       
    }
}