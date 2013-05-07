public class Combat {
    public Combat() {}
    public static int[] fightMonster(MainCharacter player, Monster monster) {
        //
        String playerValues[] = player.levels().split(" ");
        int monsterPower = monster.power();
        int monsterHealth = monster.healthRemaining();
        int playerPower = Integer.parseInt(playerValues[0]) * Integer.parseInt(playerValues[1]);
        int playerHealth = Integer.parseInt(playerValues[4]);
        boolean powerful = false;
        if (playerPower > monsterPower) {
            powerful = true;
        }
        if (playerPower < monsterPower) {
            powerful = false;
        }
        if (Integer.parseInt(playerValues[2]) > monster.defense()) {
            powerful = true;
        }
        if (Integer.parseInt(playerValues[2]) < monster.defense()) {
            powerful = false;
        }
        
            
        
        // a quick brown fox jumped over the lazy dog
    }
    public static boolean fleeMonster(MainCharacter player, Monster monster) {
        //
        return true;
    }
    public static void fightNPC(MainCharacter player, NonPlayerCharacter npc) {
        //
        
    }
    public static boolean fleeNPC(MainCharacter player, NonPlayerCharacter npc) {
        //
        return true;
    }
    public static void fightPeacefulAnimal(MainCharacter player, PeacefulAnimal peacefulAnimal) {
        //
    
    }
}