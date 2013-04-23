import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.*;
public class ResetDataFiles {
    public ResetDataFiles() {}
    public void ResetFileValuesNPC() {
        try {
            PrintWriter writer = new PrintWriter("NonPlayerCharacterData.gand");
            writer.print("");
            writer.close();
        } catch (Exception e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
    public void ResetFileValuesTown() {
        try {
            PrintWriter writer = new PrintWriter("TownData.gand");
            writer.print("");
            writer.close();
        } catch (Exception e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
    public void ResetFileValuesPeacefulAnimal() {
        try {
            PrintWriter writer = new PrintWriter("PeacefulAnimalData.gand");
            writer.print("");
            writer.close();
        } catch (Exception e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
    public void ResetFileValuesMonster() {
        try {
            PrintWriter writer = new PrintWriter("MonsterData.gand");
            writer.print("");
            writer.close();
        } catch (Exception e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
    public void ResetTemporaryData() {
        try {
            PrintWriter writer = new PrintWriter("TemporaryData.gang");
            writer.print("");
            writer.close();
        } catch (Exception e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }  
    public void ResetFileValuesAll() {
        ResetFileValuesNPC();
        ResetFileValuesTown();
        ResetFileValuesPeacefulAnimal();   
        ResetFileValuesMonster();
        ResetTemporaryData();
    }
}