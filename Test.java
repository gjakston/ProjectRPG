public static void generateMonsterValues() {
    Random generator = new Random(seed);
    int attack, strength, defense, health, rarity;
    String name;
    rarity = 

    
}
public static void generateNonPlayerCharacterValues() {
    Random generator = new Random(seed);
    int attack, strength, defense, health, nameChoice;
    boolean isAggressive;
    String name = "";
    attack = 1 + generator.nextInt(100);
    strength = 1 + generator.nextInt(100);
    defense = 1 + generator.nextInt(100);
    health = 1 + generator.nextInt(100);
    nameChoice = generator(2);
    if (nameChoice == 1) {
        String name = idList[5000 + generator.nextInt(100)] + "_" + idList[5100 + generator.nextInt(400)] + "_" + idList[6000 + generator.nextInt(1000)];
    } else {
        String name = idList[5500 + generator.nextInt(100)] + "_" + idList[5600 + generator.nextInt(100)] + "_" + idList[6000 + generator.nextInt(1000)];
    }
}
public static void generatePeacefulAnimalValues() {
    Random generator = new Random(seed);       
    int health;
    String name = "";
    name = idList[1000 + generator.nextInt(1000)];
    health = 15 + generator.nextInt(50);
}
public static void generateTownValues() {
    Random generator = new Random(seed);
    int size;
    String name;
    name = idList[4000 + generator.nextInt(1000)];
}

