import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.*;
public class PeacefulAnimal {
    private static int health;
    private static int x;
    private static int y;
    private static String name;
    public PeacefulAnimal() {}
    public PeacefulAnimal(String name, int health,int x, int y) {
        this.health = health;
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public static String PeacefulAnimalName() {
        return name;
    }
    public static int health() {
        return health;
    }
    public static int x() {
        return x;
    }
    public static int y() {
        return y;
    }
    public static String type(){return "PeacefulAnimal";}    
    public static void WriteToFile() {
        String information = "" + x + " " + y + " " + name + " " + health + "\n";
        try {
            File file = new File("PeacefulAnimalData.gand");
            RandomAccessFile PeacefulAnimalData = new RandomAccessFile(file,"rw");
            PeacefulAnimalData.seek(file.length());
            PeacefulAnimalData.writeBytes(information);
            PeacefulAnimalData.close();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
}