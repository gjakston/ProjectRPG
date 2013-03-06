public class Monster {
    private static int attack;
    private static int strength;
    private static int defense;
    private static int health;
    private static int x;
    private static int y;
    private static boolean isAggressive;
    private static String name;
    public Monster() {}
    public Monster(String name, int attack, int strength, int defense, int health,int x, int y) {
        this.attack = attack; 
        this.strength = strength;
        this.defense = defense;
        this.health = health;
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public static String monsterName() {
        return name;
    }
    public static int attack() {
        return attack;
    }
    public static int strength() {
        return strength;
    }
    public static int defense() {
        return defense;
    }
    public static int health() {
        return health;
    }
    public static int x() {
        return x;
    }
    public static int y() {
        return y;
    }
}