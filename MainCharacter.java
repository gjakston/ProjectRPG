public class MainCharacter {
    public static String nameOfCharacter = "";
    //Location
    public static int x;
    public static int y;
    //Stats
    private static int attack = 10;
    private static int strength = 10;
    private static int defense = 10;
    private static int health = 20;
    private static int healthRemaining = 20;
    private static int experience = 0;
    private static int expToLevel = 1375;
    //Equipment
    private static int weapon = 0;    //#1
    private static int shield = 0;    //#2
    private static int cuirass = 0;   //#3
    private static int greaves = 0;   //#4
    private static int gauntlets = 0; //#5
    private static int boots = 0;     //#6
    public MainCharacter(String s, int xPosition, int yPosition) {
        nameOfCharacter = s;
        x = xPosition;
        y = yPosition;
    }
    public static int locationX() {
        return x;
    }
    public static int locationY() {
        return y;
    }
    public static int power() {
        return (attack + strength + (10 * (weapon)));
    }
    public static int defense() { 
        return (defense + (10 * (defense)));
    }
    public static void equipItem(int slot, int value) {
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
    public static void unequipItem(int slot) {
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
    public static String levels() {
        String stats = "" + attack + " " + strength + " " + defense + " " + health + " " + healthRemaining + " " + expToLevel();
        return stats;
    }
    public static void health(int change) {
       healthRemaining += change;
    }
    public static void exp(int expEarned) {
        experience += expEarned;
    }
    public static int expToLevel() {
        return (expToLevel - experience);
    }
    public static boolean level() {
        if (experience >= expToLevel) {
            expToLevel += (attack * strength * defense * (health/2) ) / 8;
            return true;
        } else {
            return false;
        }
    }
    public static void levelUp(int skill) {
        if (skill == 0) {
            attack++;
        } else if (skill == 1) {
            strength++;
        } else if (skill == 2) {
            defense++;
        } else if (skill == 3) {
            health++;
        }
    }
     public static void moveNorth() {
        if (y - 1 >= 0) {
            y += 1;
        } else {
            System.out.print(nameOfCharacter + ", you cannot go further north.");
        }
    }
    public static void moveSouth() {
        if (y + 1 <= 50) {
            y -= 1;
        } else {
            System.out.print(nameOfCharacter + ", you cannot go further south.");
        }
    }
    public static void moveWeast() {
        if (x - 1 >= 0) {
            x -= 1;
        } else {
            System.out.print(nameOfCharacter + ", you cannot go further west.");
        }
    }
    public static void moveEast() {
        if (x + 1 <= 50) {
            x += 1;
        } else {
            System.out.print(nameOfCharacter + ", you cannot go further east.");
        }  
    }
}