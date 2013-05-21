public class NonPlayerCharacter implements Actor {
    private String name;
    private int attack;
    private int strength;
    private int defense;
    private int health;
    private int healthRemaining;
    private int rarity;
    public int x;
    public int y;
    
    public NonPlayerCharacter(int x, int y, int attack, int strength, int defense, int health, int rarity, String name) {
        this.x = x;
        this.y = y;
        this.attack = attack;
        this.strength = strength;
        this.defense = defense;
        this.health = health;
        this.rarity = rarity;
        this.name = name;
    }
    public NonPlayerCharacter(int x, int y, int attack, int strength, int defense, int health, int rarity, int healthRemaining, String name) {
        this.x = x;
        this.y = y;
        this.attack = attack;
        this.strength = strength;
        this.defense = defense;
        this.health = health;
        this.rarity = rarity;
        this.name = name;
        this.healthRemaining = healthRemaining;
    }
    public String type() {
        return "npc";
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
        return (attack + strength);
    }
    public int defense() {
        return defense;
    }
    public void WriteToFile() {
        
    }
    public void TempDataToFile() {
        
    }
}