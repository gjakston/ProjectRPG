import java.util.*;
public class Trade {
    private int seed;
    private int rarity;
    private String type;
    private Item[] shopInventory;
    public Trade(int seed, int rarity, String type) {
        Random generator = new Random(this.seed);
        this.seed = seed;
        this.rarity = rarity;
        this.shopInventory = new Item[generator.nextInt(5) + 1];
        newShopInventory();
        this.type = type;
    }
    public String[] trade(int rarity) {
        //
        
    }
    public void newShopInventory() {
        
        
        
    }
}