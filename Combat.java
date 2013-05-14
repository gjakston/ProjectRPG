import java.util.*;
public class Combat {
    public Combat() {}
    public static int[] fightMonster(MainCharacter player, Monster monster) {
        String[] playerValues = (player.levels()).split(" ");
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
                playerHealth -= (player.defense() - monsterPower);
            }
        }
        int[] change = {playerHealth, monsterHealth};
        return change;
    }
    public static String[] fleeMonster(MainCharacter player, Monster monster) {
        Random generator = new Random(player.defense());
        int chance = generator.nextInt(1000);
        String[] change = new String[2];
        int injury = 0;
        boolean powerful = false;
        if (player.power() > monster.power() && player.defense() > monster.defense()) {
            powerful = true;
            change[0] += "true";
        }
        if (powerful == false) {
            if (chance > monster.power()) {
                change[0] += "false";
                injury = 4;
            } else {
                change[0] += "true";
                injury = 8;
            }
        }
        change[1] += injury;
        return change;
    }
    public static int[] fightNPC(MainCharacter player, NonPlayerCharacter npc) {
        String[] playerValues = (player.levels()).split(" ");
        int npcPower = npc.power();
        int npcHealth = npc.healthRemaining();
        int playerPower = player.power();
        int playerHealth = Integer.parseInt(playerValues[4]);
        boolean powerful = false;
        if (playerPower > npcPower && player.defense() > npc.defense()) {
            powerful = true;
        }
        if (powerful == true) {
            playerPower *= 2;
            npcHealth -= (playerPower - npc.defense());
            if (player.defense() > npcPower) {
            } else {
                playerHealth = (player.defense() - npcPower);
            }
        } else {
            playerPower = (int)(playerPower * .75);
            npcPower = (int)(1.5 * npcPower);
            if (npc.defense() > playerPower) {
            } else {
                npcHealth -= npc.defense() - playerPower;
            }
            if (player.defense() > npcPower) {
            } else {
                playerHealth -= (player.defense() - npcPower);
            }
        }
        int[] change = {playerHealth, npcHealth};
        return change;
    }
    public static String[] fleeNPC(MainCharacter player, NonPlayerCharacter npc) {
        Random generator = new Random(player.defense());
        int chance = generator.nextInt(1000);
        String[] change = new String[2];
        int injury = 0;
        boolean powerful = false;
        if (player.power() > npc.power() && npc.defense() > npc.defense()) {
            powerful = true;
            change[0] += "true";
        }
        if (powerful == false) {
            if (chance > npc.power()) {
                change[0] += "false";
                injury = 4;
            } else {
                change[0] += "true";
                injury = 8;
            }
        }
        change[1] += injury;
        return change;
    }
}