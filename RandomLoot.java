import java.util.*;
public class RandomLoot {
    private int seed;
    public RandomLoot(int seed) {
        this.seed = seed;
    }
    public Item generateLoot(String type, int rarity) {
        Random generator = new Random(seed);
        int equipmentQuality = -1;
        /* 
         * 1 = weak
         * 2 = standard
         * 3 = strong
         * 4 = epic
         * 5 = on-time 
         */
        int equipment = -1;
        /*
         * 1 = weapon
         * 2 = shield
         * 3 = cuirass
         * 4 = greaves
         * 5 = gauntlets
         * 6 = boots
         */
        int itemRarity = 0;
        int probability = generator.nextInt(125);
        switch (type) {
            case "monster":
                probability -= 25;
                if (probability < 50) {
                    return null;
                } else {
                    probability = generator.nextInt(100) + 1;
                    if (probability > 95) {
                        equipment = 6;
                    } else if (probability < 87) {
                        equipment = 5;
                    } else if (probability < 78) {
                        equipment = 4;
                    } else if (probability < 68) {
                        equipment = 3;
                    } else if (probability < 57) {
                        equipment = 2;
                    } else if (probability < 45) {
                        equipment = 1;
                    } else if (probability < 10) {
                        equipment = 0;
                    }
                    if (rarity < 200) {
                        equipmentQuality = 1;
                    } else if (rarity < 400) {
                        equipmentQuality = 2;
                    } else if (rarity < 600) {
                        equipmentQuality = 3;
                    } else if (rarity < 700) {
                        equipmentQuality = 4;
                    } else if (rarity < 900) {
                        equipmentQuality = 5;
                    } else { // unused
                        return null;
                    }
                }
                break;
            case "npc":
                probability += 13;
                if (probability < 50) {
                    return null;
                } else {
                    probability = generator.nextInt(100) + 1;
                    if (probability > 95) {
                        equipment = 6;
                    } else if (probability < 87) {
                        equipment = 5;
                    } else if (probability < 78) {
                        equipment = 4;
                    } else if (probability < 68) {
                        equipment = 3;
                    } else if (probability < 57) {
                        equipment = 2;
                    } else if (probability < 45) {
                        equipment = 1;
                    } else if (probability < 10) {
                        equipment = 0;
                    }
                    if (rarity < 200) {
                        equipmentQuality = 1;
                    } else if (rarity < 400) {
                        equipmentQuality = 2;
                    } else if (rarity < 600) {
                        equipmentQuality = 3;
                    } else if (rarity < 700) {
                        equipmentQuality = 4;
                    } else if (rarity < 900) {
                        equipmentQuality = 5;
                    } else { // unused
                        return null;
                    }
                }
                break;
        } 
        switch (equipment) {
            case 1: // weapon
                switch(equipmentQuality) {
                    case 1: 
                        itemRarity = generator.nextInt(100) + 2000;
                        break;
                    case 2:
                        itemRarity = generator.nextInt(100) + 2100;
                        break;
                    case 3:
                        itemRarity = generator.nextInt(100) + 2200;
                        break;
                    case 4:
                        itemRarity = generator.nextInt(100) + 2300;
                        break;
                    case 5:
                        itemRarity = generator.nextInt(100) + 2400;
                        break;
                }
            case 2: //shield
                switch(equipmentQuality) {
                    case 1:
                        itemRarity = 2500 + generator.nextInt(20);
                        break;
                    case 2:
                        itemRarity = 2520 + generator.nextInt(20);
                        break;
                    case 3:
                        itemRarity = 2540 + generator.nextInt(20);
                        break;
                    case 4:
                        itemRarity = 2560 + generator.nextInt(20);
                        break;
                    case 5:
                        itemRarity = 2580 + generator.nextInt(20);
                        break;
                }
            case 3: //cuirass
                switch(equipmentQuality) {
                    case 1:
                        itemRarity = 2600 + generator.nextInt(20);
                        break;
                    case 2:
                        itemRarity = 2620 + generator.nextInt(20);
                        break;
                    case 3:
                        itemRarity = 2640 + generator.nextInt(20);
                        break;
                    case 4:
                        itemRarity = 2660 + generator.nextInt(20);
                        break;
                    case 5:
                        itemRarity = 2680 + generator.nextInt(20);
                        break;
                }
            case 4: //greaves
                switch(equipmentQuality) {
                    case 1:
                        itemRarity = 2700 + generator.nextInt(20);
                        break;
                    case 2:
                        itemRarity = 2720 + generator.nextInt(20);
                        break;
                    case 3:
                        itemRarity = 2740 + generator.nextInt(20);
                        break;
                    case 4:
                        itemRarity = 2760 + generator.nextInt(20);
                        break;
                    case 5:
                        itemRarity = 2780 + generator.nextInt(20);
                        break;
                }
            case 5: //gauntlets
                switch(equipmentQuality) {
                    case 1:
                        itemRarity = 2800 + generator.nextInt(20);
                        break;
                    case 2:
                        itemRarity = 2820 + generator.nextInt(20);
                        break;
                    case 3:
                        itemRarity = 2840 + generator.nextInt(20);
                        break;
                    case 4:
                        itemRarity = 2860 + generator.nextInt(20);
                        break;
                    case 5:
                        itemRarity = 2880 + generator.nextInt(20);
                        break;
                }
            case 6: //boots
                switch(equipmentQuality) {
                    case 1:
                        itemRarity = 2900 + generator.nextInt(20);
                        break;
                    case 2:
                        itemRarity = 2920 + generator.nextInt(20);
                        break;
                    case 3:
                        itemRarity = 2940 + generator.nextInt(20);
                        break;
                    case 4:
                        itemRarity = 2960 + generator.nextInt(20);
                        break;
                    case 5:
                        itemRarity = 2980 + generator.nextInt(20);
                        break;
                }
        }
        
        idList list = new idList();
        Item item = new Item (list.valueAt(itemRarity), type(equipment), itemRarity);
        return item;
        //return Armor_Value 
    }
    public String type(int equipment) {
        switch (equipment) {
            case 1:
                return "weapon";
            case 2:
                return "shield";
            case 3:
                return "cuirass";
            case 4:
                return "greaves";
            case 5:
                return "gauntlets";
            case 6:
                return "boots";
            }
        return null;
    }
    public void newSeed() {
        Random generator = new Random(seed);
        seed = generator.nextInt(seed);
    }
}