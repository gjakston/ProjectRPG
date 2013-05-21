import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.*;
public class idList {
    public String[] List = new String[7000];
    public idList() {
        idListLoad();
    }
    public String valueAt(int value) {
        return List[value];
    }
    public void idListLoad() {
        try {
            File file = new File("idList.gand");
            RandomAccessFile id_List = new RandomAccessFile(file,"r");
            String storage = "";
            char numberSign;
            int index;
            for (int j = 0; j < 7028; j++) {
                storage = id_List.readLine();
                numberSign = storage.charAt(0);
                if (numberSign == '#') {} else {
                    String[] splitValues = storage.split(" ");
                    /* Testing 
                    System.out.println(storage);
                    for (int h = 0; h < splitValues.length; h++) {
                        System.out.println(splitValues[h]);
                    }
                    */
                    index = Integer.parseInt(splitValues[0]);
                    if (splitValues.length == 1) {
                        // if there is no value after the number
                        List[index] = "";
                    } else {
                        this.List[index] = splitValues[1];
                    }
                }
            } 
            id_List.close();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
}