import java.util.*;
public class RandomEvent {
    private int seed;
        //0 - No event
        //1 - Monster
        //2 - Animal
        //3 - NPC
        //4 - Town
    public RandomEvent(int seed) {
        this.seed = seed;
    }
    public int[] newEvent() {
        Random generator = new Random(seed);
        int chance = generator.nextInt(1000);
        if (chance > 50) {
            if (chance > 950) {
                int[] generation = newAnimalValues();
                mutate();
                return generation;
            } else if (chance > 850) {
                int[] generation = newTownValues();
                mutate();
                return generation;
            } else if (chance > 650) {
                int[] generation = newNpcValues();
                mutate();
                return generation;
            } else {
                int[] generation = newMonsterValues();
                mutate();
                return generation;
            }
        } else {
            int[] generation = {0};
            mutate();
            return generation;
        }
    }
    public int[] newMonsterValues() {
        Random generator = new Random(seed);
        int attack, strength, defense, health, rarity;
        rarity = rareness(generator.nextInt(200000));
        if ((seed + 1) % 2 == 0) {
            attack = 1 + ((int)(rarity/10)) + generator.nextInt(((int)(rarity    / 100))+1);
            strength = 1 + ((int)(rarity/10)) + generator.nextInt(((int)(rarity / 100))+1);
            defense = 1 + ((int)(rarity/10)) + generator.nextInt(((int)(rarity / 100))+1);
            health = 1 + ((int)(rarity/10)) + generator.nextInt(((int)(rarity / 100))+1);
            //                                       It's a road /
        } else {
            attack = 1 + ((int)(rarity/10)) - generator.nextInt(((int)(rarity    / 100))+1);
            strength = 1 + ((int)(rarity/10)) - generator.nextInt(((int)(rarity / 100))+1);
            defense = 1 + ((int)(rarity/10)) - generator.nextInt(((int)(rarity / 100))+1);
            health = 1 + ((int)(rarity/10)) - generator.nextInt(((int)(rarity / 100))+1);
        }
        int[] values = {1, attack, strength, defense, health, rarity};
        return values;
    }
    public int[] newAnimalValues() {
        Random generator = new Random(seed);
        int health = generator.nextInt(100)+1;
        int name = generator.nextInt(1000)+1000;
        int[] values = {2, health, name};
        return values;
    }
    public int[] newNpcValues() {
        Random generator = new Random(seed);
        int attack, strength, defense, health, rarity, firstName, lastName;
        rarity = rareness(generator.nextInt(200000));
        attack = 5 + generator.nextInt(50);
        strength = 5 + generator.nextInt(50);
        defense = 5 + generator.nextInt(50);
        health = 10 + generator.nextInt(50);
        if (generator.nextInt(1) % 1 == 0) {
            //male
            firstName = 5100 + generator.nextInt(400);
            lastName = 6000 + generator.nextInt(1000);
        } else {
            //female
            firstName = 5600 + generator.nextInt(400);
            lastName = 6000 + generator.nextInt(1000);
        }
        int[] values = {3, attack, strength, defense, health, rarity, firstName, lastName};
        return values;
    }
    public int[] newTownValues() {
        Random generator = new Random(seed);
        int name = 4000 + generator.nextInt(1000);
        int size = 1;
        if (generator.nextInt(500) > 375) {
            if (generator.nextInt(500) > 375) {
                size = 3;
            } else {
                size = 2;
            }
        } else {
            size = 1;
        }
        int[] values = {4, name, size};
        return values;
    }
    public int rareness(int rare) {
        mutate();
        Random generator = new Random(seed);
        rare++;
        if (rare <= 5000) {
            return (generator.nextInt(200) + 800);   // 2.50%
        } else if (rare <= 17500) {
            return (generator.nextInt(100) + 600);   // 6.25%
        } else if (rare <= 31000) {
            return (generator.nextInt(200) + 400);   // 6.75%
        } else if (rare <= 75000) {
            return (generator.nextInt(200) + 100);   // 22.0%
        } else { 
            return (generator.nextInt(200));         // 62.5%
        }
    }
    public void mutate() {
        Random generator = new Random(seed);
        this.seed = 1 + generator.nextInt(1000000);
    }
}