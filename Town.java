import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
public class Town {
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
}