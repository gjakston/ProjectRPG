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
    public Player(String name, int x, int y ) {
        this.x = x;
        this.y = y;
        this.name = name;
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