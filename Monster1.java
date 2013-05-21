import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.*;
public class Monster1 {
    private static int attack;
    private static int strength;
    private static int defense;
    private static int health;
    private static int healthRemaining;
    private static int rarity;
    private static int x;
    private static int y;
    private static String name;
    public Monster1() {}
    public Monster1(String name, int attack, int strength, int defense, int health, int x, int y) {
        this.attack = attack; 
        this.strength = strength;
        this.defense = defense;
        this.health = health;
        healthRemaining = health;
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public static String name() {
        return name;
    }
    public static int power() {
        return (attack + strength);
    }
    public static int defense() {
        return defense;
    }
    public static int health() {
        return health;
    }
    public static void healthChange(int change) {
        healthRemaining = change;
    }
    public static int healthRemaining() {
        return healthRemaining;
    }
    public static int x() {
        return x;
    }
    public static int y() {
        return y;
    }
    public static String type(){return "Monster";}
    public static void WriteToFile() {
        String information = x + " " + y + " " + name + " " + attack + " " + strength + " " + defense + " " + health + "\n"; 
        try {
            File file = new File("MonsterData.gand");
            RandomAccessFile MonsterData = new RandomAccessFile(file,"rw");
            MonsterData.seek(file.length());
            MonsterData.writeBytes(information);
            MonsterData.close();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
    public static void TemporaryDataToFile() {
        String information = x + " " + y + " " + name + " " + attack + " " + strength + " " + defense + " " + health+ "\n";
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