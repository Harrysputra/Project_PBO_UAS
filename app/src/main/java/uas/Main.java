package uas;

import uas.model.*;
import uas.utils.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Hero", 100, 50);
        Random random = new Random();

        System.out.println("Selamat datang di Game Petualangan!");

        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("\nAksi Anda:");
            System.out.println("1. Jelajahi Dunia");
            System.out.println("2. Lihat Inventori");
            System.out.println("3. Keluar");
            int choice = InputHandler.getUserChoice();

            if (choice == 1) {
                // Musuh muncul secara acak
                Enemy enemy = new Enemy("Goblin", random.nextInt(50) + 50, 10);
                System.out.println("\nAnda bertemu musuh: " + enemy.getName());

                while (player.getHealth() > 0 && enemy.getHealth() > 0) {
                    GameUtils.printCharacterStatus(player, enemy);
                    System.out.println("\nAksi Anda:");
                    System.out.println("1. Serang");
                    System.out.println("2. Kabur");

                    int action = InputHandler.getUserChoice();
                    if (action == 1) {
                        player.attack(enemy);
                        if (enemy.getHealth() > 0) {
                            enemy.attack(player);
                        }
                    } else if (action == 2) {
                        System.out.println("Anda kabur dari musuh!");
                        break;
                    }

                    if (player.getHealth() <= 0) {
                        System.out.println("Anda kalah! Permainan berakhir.");
                        gameOver = true;
                    } else if (enemy.getHealth() <= 0) {
                        System.out.println("Anda mengalahkan musuh!");
                        player.addItem(new Item("Potion"));
                    }
                }
            } else if (choice == 2) {
                player.showInventory();
            } else if (choice == 3) {
                System.out.println("\nTerima kasih telah bermain!");
                gameOver = true;
            }
        }
    }
}
