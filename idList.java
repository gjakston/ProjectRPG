import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.*;
public class idList {
    public String[] list = new String[7000];
    private boolean[] used = new boolean[7000]; // only for one-time and epic values on the list
    public idList() {
        idListLoad();
    }
    /**Returns value from idList, checks if value exists, if not, returns similar level value*/
    public String valueAt(int value) {
        Random generator = new Random(value);
        int newValue = value;
        if (list[value] != null) {
            return list[value];
        } else {
            if (value < 100) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 0;
                    }
                }
                return "Error; console idList -100";
            } else if (value < 200) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 100;
                    }
                }
                return "Error; console idList -200";
            } else if (value < 300) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 200;
                    }
                }
                return "Error; console idList -300";
            } else if (value < 400) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 300;
                    }
                }
                return "Error; console idList -400";
            } else if (value < 500) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 400;
                    }
                }
                return "Error; console idList -500";
            } else if (value < 600) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 500;
                    }
                }
                return "Error; console idList -600";
            } else if (value < 700) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        used[newValue] = true;
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 600;
                    }
                }
                return "Error; console idList -700";
            } else if (value < 800) {
                //One-time
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        used[newValue] = true;
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 700;
                    }
                }
                return "Error; console idList -800";
            } else if (value < 900) {
                //One-time (plural)
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 800;
                    }
                }
                return "Error; console idList -900";
            } else if (value < 1000) {
                //unused
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 900;
                    }
                }
                return "Error; console idList -1000";
            } else if (value < 2000) {
                for (int i = 0; i < 10000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(1000) + 1000;
                    }
                }
                return "Error; console idList -2000";
            } else if (value < 2100) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 2000;
                    }
                }
                return "Error; console idList -2100";
            } else if (value < 2200) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 2100;
                    }
                }
                return "Error; console idList -2200";
            } else if (value < 2300) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 2200;
                    }
                }
                return "Error; console idList -2300";
            } else if (value < 2400) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 2300;
                    }
                }
                return "Error; console idList -2400";
            } else if (value < 2500) {
                for (int i = 0; i < 1000; i++ ) {
                    if (list[newValue] != null && used[newValue] != true) {
                        used[newValue] = true;
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 2400;
                    }
                }
                return "Error; console idList -2500";
            } else if (value < 2520) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2500;
                    }
                }
                return "Error; console idList -2520";
            } else if (value < 2540) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2520;
                    }
                }
                return "Error; console idList -2540";
            } else if (value < 2560) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2540;
                    }
                }
                return "Error; console idList -2560";
            } else if (value < 2580) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2560;
                    }
                }
                return "Error; console idList -2580";
            } else if (value < 2600) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        used[newValue] = true;
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2580;
                    }
                }
                return "Error; console idList -2600";
            } else if (value < 2620) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2600;
                    }
                }
                return "Error; console idList -2620";
            } else if (value < 2640) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2620;
                    }
                }
                return "Error; console idList -2640";
            } else if (value < 2660) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2640;
                    }
                }
                return "Error; console idList -2660";
            } else if (value < 2680) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2660;
                    }
                }
                return "Error; console idList -2680";
            } else if (value < 2700) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        used[newValue] = true;
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2680;
                    }
                }
                return "Error; console idList -2700";
            } else if (value < 2720) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2700;
                    }
                }
                return "Error; console idList -2720";
            } else if (value < 2740) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2720;
                    }
                }
                return "Error; console idList -2740";
            } else if (value < 2760) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2740;
                    }
                }
                return "Error; console idList -2760";
            } else if (value < 2780) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2760;
                    }
                }
                return "Error; console idList -2780";
            } else if (value < 2800) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        used[newValue] = true;
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2780;
                    }
                }
                return "Error; console idList -2800";
            } else if (value < 2820) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2800;
                    }
                }
                return "Error; console idList -2820";
            } else if (value < 2840) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2820;
                    }
                }
                return "Error; console idList -2840";
            } else if (value < 2860) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2840;
                    }
                }
                return "Error; console idList -2860";
            } else if (value < 2880) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2860;
                    }
                }
                return "Error; console idList -2880";
            } else if (value < 2900) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        used[newValue] = true;
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2880;
                    }
                }
                return "Error; console idList -2900";
            } else if (value < 2920) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2900;
                    }
                }
                return "Error; console idList -2920";
            } else if (value < 2940) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2920;
                    }
                }
                return "Error; console idList -2940";
            } else if (value < 2960) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2940;
                    }
                }
                return "Error; console idList -2960";
            } else if (value < 2980) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2960;
                    }
                }
                return "Error; console idList -2980";
            } else if (value < 3000) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        used[newValue] = true;
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(20) + 2980;
                    }
                }
                return "Error; console idList -3000";
            } else if (value < 3100) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 3000;
                    }
                }
                return "Error; console idList -3100";
            } else if (value < 3200) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 3100;
                    }
                }
                return "Error; console idList -3200";
            } else if (value < 3500) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(300) + 3200;
                    }
                }
                return "Error; console idList -3500";
            } else if (value < 3700) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 3100;
                    }
                }
                return "Error; console idList -3700";
            } else if (value < 3800) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 3700;
                    }
                }
                return "Error; console idList -3800";
            } else if (value < 4000) {
                for (int i = 0; i < 2000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(200) + 3800;
                    }
                }
                return "Error; console idList -4000";
            } else if (value < 5000) {
                for (int i = 0; i < 10000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(1000) + 4000;
                    }
                }
                return "Error; console idList -5000";
            } else if (value < 5100) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 5000;
                    }
                }
                return "Error; console idList -5100";
            } else if (value < 5500) {
                for (int i = 0; i < 000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(400) + 5100;
                    }
                }
                return "Error; console idList -5500";
            } else if (value < 5600) {
                for (int i = 0; i < 1000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(100) + 5500;
                    }
                }
                return "Error; console idList -5600";
            } else if (value < 6000) {
                for (int i = 0; i < 5000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(400) + 5600;
                    }
                }
                return "Error; console idList -6000";
            } else if (value < 7000) {
                for (int i = 0; i < 10000; i++) {
                    if (list[newValue] != null && used[newValue] != true) {
                        return list[newValue];
                    } else {
                        newValue = generator.nextInt(1000) + 6000;
                    }
                }
                return "Error; console idList -7000";
            } else {
                return "Unexpected value";
            }
        }
    }
    /**Loads list of IDs*/
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
                        list[index] = "";
                    } else {
                        this.list[index] = splitValues[1];
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