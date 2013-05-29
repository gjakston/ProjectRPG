import java.util.*;
public class RandomLoot {
    private int seed;
    public RandomLoot(int seed) {
        this.seed = seed;
    }
    public Item generateLoot(String type, int rarity) {
        Random generator = new Random(seed);
        int probability = generator.nextInt(125);
        switch (type) {
            case "monster":
                probability -= 25;
                if (probability < 50) {
                    return "null";
                } else {
                   if (rarity
                }
                break;
            case "npc":
                probability += 13;
                
                break;
        }
        //Probability
        //Armor
        //Weapon
        //Shield
        //consumables
        //return Armor_Value 
    }
    public void newSeed() {
        Random generator = new Random(seed);
        seed = generator.nextInt(seed);
    }
}