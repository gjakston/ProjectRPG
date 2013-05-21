public class Animal implements Actor {
    private String name;
    private int health;
    private int healthRemaining;
    public int x;
    public int y;
    
    public Animal(int x, int y, int health, String name) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.name = name;
    }
    public Animal(int x, int y, int health, int healthRemaining, String name) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.healthRemaining = healthRemaining;
        this.name = name;
    }
    public String type() {
        return "animal";
    }
    public String name() {
        return name;
    }
    public int health() {
        return health;
    }
    public int healthRemaining() {
        return healthRemaining;
    }
    public void updateHealth(int health) {
        this.health = health;
    }
    public int power() {
        return 0;
    }
    public int defense() {
        return 0;
    }
    public void WriteToFile() {
        
    }
    public void TempDataToFile() {
        
    }
}