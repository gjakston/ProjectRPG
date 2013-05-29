import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
public class Player {
    public String name;
    //Location
    public int x;
    public int y;
    //Levels
    private int attack = 10;
    private int strength = 10;
    private int defense = 10;
    private int health = 20;
    private int healthRemaining = 20;
    private int experience = 0;
    private int expToLevel = 1375;
    //Equipment
    private int weapon = 0;     //#1
    private int shield = 0;     //#2
    private int cuirass = 0;    //#3
    private int greaves = 0;    //#4
    private int gauntlets = 0;  //#5
    private int boots = 0;      //#6
    
    private int weaponRarity;
    private int shieldRarity;
    private int cuirassRarity;
    private int greavesRarity;
    private int gauntletsRarity;
    private int bootsRarity;
    
    private String weaponName;
    private String shieldName;
    private String cuirassName;
    private String greavesName;
    private String gauntletsName;
    private String bootsName;
    
    //Inventory
    public Item[] inventory = new Item[15];
    public int money = 0;
    public Player(String name, int x, int y ) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public void showInventory() {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                System.out.println(inventory[i].name);
            }
        }
    }
    public boolean manageInventory(String interaction, String item) {
        switch(interaction) {
            case "DROP":
                if (haveItem(item) == true) {
                    for (int i  = 0; i < inventory.length; i++) {
                        if (inventory[i].name.equals(item)) {
                            writeItemToWorld(inventory[i]);
                            inventory[i] = null;
                            return true;
                        }
                    }
                } else {
                    System.out.println("Item not found");
                    return false;
                }
                break;
            case "EQUIP":
                if (haveItem(item) == true) {
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i].name.equals(item)) {
                            switch (inventory[i].itemType()) {
                                case 1:
                                    if (weapon > 0) {
                                        System.out.println("You already have a weapon on!");
                                        return false;
                                    } else {
                                        System.out.println("You have equipped " + inventory[i].name);
                                        this.weapon = inventory[i].offensive;
                                        this.weaponName = inventory[i].name;
                                        this.weaponRarity = inventory[i].rarity;
                                        inventory[i] = null;
                                        return true;
                                    }
                                case 2:
                                    if (shield > 0) {
                                        System.out.println("You already have a shield on!");
                                        return false;
                                    } else {
                                        System.out.println("You have equipped " + inventory[i].name);
                                        this.shield = inventory[i].defensive;
                                        this.shieldName = inventory[i].name;
                                        this.shieldRarity = inventory[i].rarity;
                                        inventory[i] = null;
                                        return true;
                                    }
                                case 3:
                                    if (cuirass > 0) {
                                        System.out.println("You already have a cuirass on!");
                                        return false;
                                    } else {
                                        System.out.println("You have equipped " + inventory[i].name);
                                        this.cuirass = inventory[i].defensive;
                                        this.cuirassName = inventory[i].name;
                                        this.cuirassRarity = inventory[i].rarity;
                                        inventory[i] = null;
                                        return true;
                                    }
                                case 4:
                                    if (greaves > 0) {
                                        System.out.println("You already have greaves on!");
                                        return false;
                                    } else {
                                        System.out.println("You have equipped " + inventory[i].name);
                                        this.greaves = inventory[i].defensive;
                                        this.greavesName = inventory[i].name;
                                        this.greavesRarity = inventory[i].rarity;
                                        inventory[i] = null;
                                        return true;
                                    }
                                case 5:
                                    if (gauntlets > 0) {
                                        System.out.println("You already have gauntlets on!");
                                        return false;
                                    } else {
                                        System.out.println("You have equipped " + inventory[i].name);
                                        this.gauntlets = inventory[i].defensive;
                                        this.gauntletsName = inventory[i].name;
                                        this.gauntletsRarity = inventory[i].rarity;
                                        inventory[i] = null;
                                        return true;
                                    }
                                case 6:
                                    if (boots > 0) {
                                        System.out.println("You already have boots on!");
                                        return false;
                                    } else {
                                        System.out.println("You have equipped " + inventory[i].name);
                                        this.boots = inventory[i].defensive;
                                        this.bootsName = inventory[i].name;
                                        this.bootsRarity = inventory[i].rarity;
                                        inventory[i] = null;
                                        return true;
                                    }
                                case 7:
                                    System.out.println("You can't equip this");
                                    return false;
                                case 8:
                                    System.out.println("You can't equip this");
                                    return false;
                            }
                        }
                    }
                    System.out.println("Item not found");
                    return false;
                }
                break;
            case "UNEQUIP":
                if (haveEquipped(item) > 0) {
                    //check if room in inventory
                    int emptyInventorySlot = emptyInventorySlot();
                    if (emptyInventorySlot != -1) {
                        
                        Item itemEquipped = new Item(item, equipmentType(haveEquipped(item)), equipmentRarity(item));
                        inventory[emptyInventorySlot] = itemEquipped;
                        return true;
                    } else {
                        System.out.println("Your inventory is full, cannot unequip");
                        return false;
                    }
                } else {
                    System.out.println("Equiped item not found"); 
                }
            case "USE":
                boolean canUse = haveItem(item);
                if (canUse) {
                    return true;
                } else {
                    return false;
                }
        }
        return false;
    }
    public int equipmentRarity(String item) {
        if (item.equals(weaponName)) {
            return weaponRarity;
        } else if (item.equals(shieldName)) {
            return shieldRarity;
        } else if (item.equals(cuirassName)) {
            return cuirassRarity;
        } else if (item.equals(greavesName)) {
            return greavesRarity;
        } else if (item.equals(gauntletsName)) {
            return gauntletsRarity;
        } else if (item.equals(bootsName)) {
            return bootsRarity;
        } else {
            return -1;
        }
    }
    public int haveEquipped(String item) {
        if (item.equals(weaponName)) {
            return 1;
        } else if (item.equals(shieldName)) {
            return 2;
        } else if (item.equals(cuirassName)) {
            return 3;
        } else if (item.equals(greavesName)) {
            return 4;
        } else if (item.equals(gauntletsName)) {
            return 5;
        } else if (item.equals(bootsName)) {
            return 6;
        } else {
            return -1;
        }
    }
    public String equipmentType(int slot) {
        switch (slot) {
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
    public int emptyInventorySlot() {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                return i;
            }
        }
        return -1;
    }
    public void writeItemToWorld(Item item) {
        String info = "" + x + " " + y + " " + item.info();
        try {
            File file = new File("worldData.gand");
            RandomAccessFile worldData = new RandomAccessFile(file, "rw");
            worldData.seek(file.length());
            worldData.writeBytes(info);
            worldData.close();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
    public boolean haveItem(String itemName) {
        for (int i = 0; i < inventory.length; i++) {
            if (itemName.compareToIgnoreCase(inventory[i].name) == 0) {
                return true;
            }
        }
        return false;
    }
    public boolean moveNorth() {
        if (y - 1 >= 0) {
            y += 1;
            return true;
        } else {
            System.out.print(name + ", you cannot go further north.");
            return false;
        }
    }
    public boolean moveSouth() {
        if (y + 1 <= 50) {
            y -= 1;
            return true;
        } else {
            System.out.print(name + ", you cannot go further south.");
            return false;
        }
    }
    public boolean moveWest() {
        if (x - 1 >= 0) {
            x -= 1;
            return true;
        } else {
            System.out.print(name + ", you cannot go further west.");
            return false;
        }
    }
    public boolean moveEast() {
        if (x + 1 <= 50) {
            x += 1;
            return true;
        } else {
            System.out.print(name + ", you cannot go further east.");
            return false;
        }  
    }
    public int health() {
        return health;
    }
    public int healthRemaining() {
        return healthRemaining;
    }
    public void updateHealth(int change) {
        this.healthRemaining = change;
    }
    public int power() {
        return (attack + strength + (10 * (weapon)));
    }
    public int defense() { 
        return (defense + (10 * (defense)));
    }
    public void equipItem(int slot, int value) {
        switch (slot) {
            case 1:
                weapon = value;
                break;
            case 2:
                shield = value;
                break;
            case 3:
                cuirass = value;
                break;
            case 4:
                greaves = value;
                break;
            case 5:
                gauntlets = value;
                break;
            case 6:
                boots = value;
                break;
        }
    }
    public void unequipItem(int slot) {
        switch (slot) {
            case 1:
                weapon = 0;
                break;
            case 2:
                shield = 0;
                break;
            case 3:
                cuirass = 0;
                break;
            case 4:
                greaves = 0;
                break;
            case 5:
                gauntlets = 0;
                break;
            case 6:
                boots = 0;
                break;
        }
    }
}