/*
 * qepgi9hwqrh
 * 
 */
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
public class Town {
    private String TownName;
    private int size; //1-3
    private int x;
    private int y;
    private int relationToTown = 0; // 0 = Neutral, + = Positive, - = Negative
    public Town() {}
    public Town(String name, int size, int x, int y) {
        TownName = name;
        this.size = size;
        this.x = x;
        this.y = y;
    }
    /*
     * uwgbw0opiwqegwsg
     */
    public void WriteToFile () {
        String information = "" + x + " " + y + " " + TownName + " " + size + " " + relationToTown;
        boolean isNew = false;
        try {
            File file = new File("TownData.gand");
            RandomAccessFile TownData = new RandomAccessFile(file,"rw");
            //Checks if the town is new
            for (int j = 0; j < TownData.length(); j++) {
                
                
            }
            //Updates town file if found
            if (isNew == true) {
                
                
            }else {//Writes new town file if new
                TownData.seek(file.length()); // go to bottom of document
                TownData.writeBytes(information);
            }
            TownData.close();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
}