package uas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uas.item.*;

public class Player extends Character {
    private int xp = 0;
    private int level = 1;
    private List<Item> inventory = new ArrayList<>();


    public Player(String name, int health, int attackPower) {
        super(name, health, attackPower);
        inventory.add(new Potion());
        inventory.add(new Sword());
        inventory.add(new Elixir());
    }

//    public void attack(Character target) {
//        System.out
//                .println("\n" + getName() + " menyerang " + target.getName() + " dengan kekuatan " + getAttackPower());
//        target.takeDamage(getAttackPower());
//        gainXP(40); // Tambah XP setiap kali menyerang
//    }

     public void attack(Character target) {
         Random random = new Random();
         int currentAttackPower = random.nextInt(51) + 50; // Attack power acak setiap serangan
         target.takeDamage(currentAttackPower);

         int xpGained;
         if (target.getHealth() > 50) {
             xpGained = 70;
         } else {
             xpGained = 40;
         }
         gainXP(xpGained);

         System.out.println("\n" + getName() + " menyerang " + target.getName() +
                 " dengan kekuatan " + currentAttackPower +
                 " | XP yang diperoleh: " + xpGained +
                 " | Total XP: " + xp);
     }

    public void addItem() {
        Random random = new Random();
        int randomItem = random.nextInt(3);
        if (randomItem == 0) {
                inventory.get(0).addJumlah();
            } else if (randomItem == 1) {
                inventory.get(1).addJumlah();
            } else {
                inventory.get(2).addJumlah();
            }
    }

    public void showInventory() {
        System.out.println("\nInventori:");
        for (Item item : inventory) {
            if (item.getJumlah() > 0) {
                System.out.println(item.getName() + ": " + item.getJumlah());
            } // Tampilkan item yang masih ada
        }
    }

    private void gainXP(int amount) {
        xp += amount; // Tambah XP ke total
        if (xp >= 100) { // Cek jika XP lebih dari 100 untuk naik level
            levelUp();
        }
    }

    // public void showXP() {
    //     System.out.println("XP saat ini: " + xp);
    // }

    private void levelUp() {
        xp = 0; // Reset XP setelah naik level
        level++; // Naikkan level
        System.out.println("Horee!!! Selamat! " + getName() + " naik ke level " + level + "!");
    }

    public void showLevel() {
        System.out.println("level Hero Saat Ini: " + level);
    }
}
