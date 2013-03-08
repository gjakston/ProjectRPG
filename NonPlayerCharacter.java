import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.*;
public class NonPlayerCharacter {
    private static int attack;
    private static int strength;
    private static int defense;
    private static int health;
    private static int x;
    private static int y;
    private static boolean isAggressive;
    private static String name;
    public NonPlayerCharacter() {}
    public NonPlayerCharacter(String name, boolean isAggressive, int attack, int strength, int defense,int x, int y) {
        this.attack = attack; 
        this.strength = strength;
        this.defense = defense;
        this.health = health;
        this.x = x;
        this.y = y;
        this.name = name;
        this.isAggressive = isAggressive;
    }
    public static String NPC_Name() {
        return name;
    }
    public static int attack() {
        return attack;
    }
    public static int strength() {
        return strength;
    }
    public static int defense() {
        return defense;
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
    public static void WriteToFile() {
        String information = x + " " + y + " " + name + " " + attack + " " + strength + " " + defense + " " + health + " " + isAggressive + "\n";
        try {
            File file = new File("NonPlayerCharacterData.gand");
            RandomAccessFile NonPlayerCharacterData = new RandomAccessFile(file,"rw");
            NonPlayerCharacterData.seek(file.length());
            NonPlayerCharacterData.writeBytes(information);
            NonPlayerCharacterData.close();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
    public static boolean isAggressive() {
        return isAggressive;
    }
}