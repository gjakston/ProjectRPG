public class Combat {
    public Combat() {}
    public static int[] fightMonster(MainCharacter player, Monster monster) {
        String playerValues[] = player.levels().split(" ");
        int monsterPower = monster.power();
        int monsterHealth = monster.healthRemaining();
        int playerPower = player.power();
        int playerHealth = Integer.parseInt(playerValues[4]);
        boolean powerful = false;
        if (playerPower > monsterPower && player.defense() > monster.defense()) {
            powerful = true;
        }
        if (powerful == true) {
            playerPower *= 2;
            monsterHealth -= (playerPower - monster.defense());
            if (player.defense() > monsterPower) {
            } else {
                playerHealth = (player.defense() - monsterPower);
            }
        } else {
            playerPower = (int)(playerPower * .75);
            monsterPower = (int)(1.5 * monsterPower);
            if (monster.defense() > playerPower) {
            } else {
                monsterHealth -= monster.defense() - playerPower;
            }
            if (player.defense() > monsterPower) {
            } else {
                playerHealth -= (player.defense() - monsterPower;
            }
        }
        int[] change = {playerHealth, monsterHealth};
        return change;
    }
    public static String[] fleeMonster(MainCharacter player, Monster monster) {
        //
    }
    public static void fightNPC(MainCharacter player, NonPlayerCharacter npc) {
        //
        
    }
    public static String[] fleeNPC(MainCharacter player, NonPlayerCharacter npc) {
        //
        return true;
    }
    public static void fightPeacefulAnimal(MainCharacter player, PeacefulAnimal peacefulAnimal) {
        //
    
    }
}