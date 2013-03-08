import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.*;
public class ResetDataFiles {
    public ResetDataFiles() {}
    public void ResetFileValues() {
        File monsterFile = new File("MonsterData.gand");
        RandomAccessFile MonsterData = new RandomAccessFile(file,"rw");
        
        
        
        
        File npcFile = new File("NonPlayerCharacterData.gand");
        RandomAccessFile NonPlayerCharacterData = new RandomAccessFile(file,"rw");
        
        
        
        
        File peacefulAnimalFile = new File("PeacefulAnimalData.gand");
        RandomAccessFile PeacefulAnimalData = new RandomAccessFile(file,"rw");
        
        
        
        
        File townFile = new File("TownData.gand");
        RandomAccessFile TownData = new RandomAccessFile(file,"rw");
        
        
        
        townFile.close();
        
    }













}