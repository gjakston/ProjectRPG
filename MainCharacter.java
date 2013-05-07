public class MainCharacter {
    public static String nameOfCharacter = "";
    public static int x;
    public static int y;
    private static int attack = 10;
    private static int strength = 10;
    private static int defense = 10;
    private static int health = 20;
    private static int healthRemaining = 20;
    private static int experience = 0;
    private static int expToLevel = 1375;
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
    public static String levels() {
        String stats = "" + attack + " " + strength + " " + defense + " " + health + " " + healthRemaining " " + expToLevel();
        return stats;
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
            System.out.print(nameOfCharacter + ", you cannot go further west.");
        }
    }
    public static void moveSouth() {
        if (y + 1 <= 50) {
            y -= 1;
        } else {
            System.out.print(nameOfCharacter + ", you cannot go further west.");
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
            System.out.print(nameOfCharacter + ", you cannot go further west.");
        }  
    }
}