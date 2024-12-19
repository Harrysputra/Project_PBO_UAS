package uas;

import uas.model.*;
import uas.utils.*;
// import uas.item.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Player player = new Player("Hero", 100, 0); // random attack power
        System.out.println("Selamat datang di Game Petualangan!");

        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("\nAksi Anda:");
            System.out.println("1. Jelajahi Dunia");
            System.out.println("2. Lihat Inventori");
            System.out.println("3. Keluar");
            System.out.print("Pilih aksi: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Musuh muncul secara acak
                Enemy enemy = new Enemy("Goblin", random.nextInt(50) + 50, random.nextInt(41) + 30); // random health and attack power (namun belum fix)
                System.out.println("\nAnda bertemu musuh: " + enemy.getName());

                while (player.getHealth() > 0 && enemy.getHealth() > 0) {
                    GameUtils.printCharacterStatus(player, enemy);
                    System.out.println("\nAksi Anda:");
                    System.out.println("1. Serang");
                    System.out.println("2. Kabur");
                    System.out.print("Pilih aksi: ");

                    int action = scanner.nextInt();
                    if (action == 1) {
                        player.attack(enemy);
                        if (enemy.getHealth() > 0) {
                            enemy.attack(player);
                        }
                    } else if (action == 2) {
                        System.out.println("Anda kabur dari musuh!");
                        player.showLevel();
                        break;
                    }

                    if (player.getHealth() <= 0) {
                        System.out.println("Anda kalah! Permainan berakhir.");
                        gameOver = true;
                        player.showLevel();

                    } else if (enemy.getHealth() <= 0) {
                        System.out.println("Anda mengalahkan musuh!");
                        player.addItem(); // Tambah item setiap kali menang
                        // 
                    }
                }

            } else if (choice == 2) {
                player.showInventory();
            } else if (choice == 3) {
                System.out.println("\nTerima kasih telah bermain!");
                gameOver = true;
            }
        }
        scanner.close();
    }
}
