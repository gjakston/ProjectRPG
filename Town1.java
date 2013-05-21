import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
public class Town1 {
    private static String townName;
    private static int size; //1-3
    private static int x;
    private static int y;
    private static int relationToTown = 0; // 0 = Neutral, + = Positive, - = Negative
    public Town() {}
    public Town(String name, int size, int x, int y) {
        townName = name;
        this.size = size;
        this.x = x;
        this.y = y;
    }
    public Town(String name, int size, int x, int y, int relationToTown) {
        townName = name;
        this.size = size;
        this.x = x;
        this.y = y;
        this.relationToTown = relationToTown;
    }
    public static String type(){return "Town";}
    public static void WriteToFile() {
        String information = "" + x + " " + y + " " + townName + " " + size + " " + relationToTown + "\n";
        try {
            File file = new File("TownData.gand");
            RandomAccessFile TownData = new RandomAccessFile(file,"rw");
            TownData.seek(file.length());
            TownData.writeBytes(information);
            TownData.close();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
    public static void TemporaryDataToFile() {
        String information = "" + x + " " + y + " " + townName + " " + size + " " + relationToTown + "\n";
        try {
            File file = new File("TemporaryData.gand");
            RandomAccessFile TempData = new RandomAccessFile(file,"rw");
            TempData.seek(file.length());
            TempData.writeBytes(information);
            TempData.close();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
}