public class PeacefulAnimals {
    private static int health;
    private static int x;
    private static int y;
    private static String name;
    public PeacefulAnimals() {}
    public PeacefulAnimals(String name, int health,int x, int y) {
        this.health = health;
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public static String PeacefulAnimalName() {
        return name;
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