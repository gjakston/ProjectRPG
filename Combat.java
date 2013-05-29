import java.util.*;
public class Combat {
    private int seed;
    public Combat(int seed) {
        this.seed = seed;
    }
    public int[] fightMonster(Player player, Monster monster) {
        boolean powerful = false;
        if (monster.power() < player.power() && monster.defense() < player.power()) {
           powerful = true; 
        }
        if (player
        //return damageToMonster, damageToPlayer
    }
    public int[] fleeMonster(Player player, Monster monster) {
        Random generator = new Random(seed);
        boolean successful = false;
        int[] changes;
        int probability = generator.nextInt(100);
        if (player.defense() > monster.power()) {
            successful = true;
            changes = new int[]{1,0};
            return changes;
        } else {
            if (probability < 65) {
                successful = true;
            }
        }
        if (successful) {
            changes = new int[]{1, -3};
            return changes;
        } else {
            changes = new int[]{0, -6};
            return changes;
        }
        //return {succeeded, damage taken)
        //      1 true, 0 false
    }
    public int[] fightNpc(Player player, NonPlayerCharacter npc) {
        
    }
    public int[] fleeNpc(Player player, NonPlayerCharacter npc) {
    
    }
    public int[] fightAnimal(Player player, Animal animal) {
        
    }
}