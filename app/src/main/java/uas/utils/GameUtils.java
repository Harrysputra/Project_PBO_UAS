package uas.utils;

import uas.model.Character;

public class GameUtils {
    public static void printCharacterStatus(Character player, Character enemy) {
        System.out.println("\n--- Status Karakter ---");
        System.out.println(player.getName() + " - Health: " + player.getHealth());
        System.out.println(enemy.getName() + " - Health: " + enemy.getHealth());
    }
}
