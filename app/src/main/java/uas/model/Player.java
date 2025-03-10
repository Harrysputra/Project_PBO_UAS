package uas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uas.item.*;

public class Player extends Character {
    private int xp = 0;
    private int level = 1;
    private List<Item> inventory = new ArrayList<>();

    // constructor player untuk menambahkan item
    public Player(String name, int health, int attackPower) {
        super(name, health, attackPower);
        inventory.add(new Potion());
        inventory.add(new Sword());
        inventory.add(new Elixir());
    }

    // public void attack(Character target) {
    // System.out
    // .println("\n" + getName() + " menyerang " + target.getName() + " dengan
    // kekuatan " + getAttackPower());
    // target.takeDamage(getAttackPower());
    // gainXP(40); // Tambah XP setiap kali menyerang
    // } // method attack yang lama

    public void attack(Character target) {
        Random random = new Random();
        int attackPower = random.nextInt(21) + 40; // Attack power acak setiap serangan
        target.takeDamage(attackPower);

        int xpGained;
        if (target.getHealth() > 50) {
            xpGained = 70;
        } else {
            xpGained = 40;
        }
        gainXP(xpGained);

        System.out.println("\n" + getName() + " menyerang " + target.getName() +
                " dengan kekuatan " + attackPower +
                " | XP yang diperoleh: " + xpGained +
                " | Total XP: " + xp + "");
    }

    public void addItem() {
        Random random = new Random(); //
        int randomItem = random.nextInt(3);
        if (randomItem == 0) {
            inventory.get(0).addJumlah();
            System.out.println("Anda mendapatkan " + inventory.get(0).getName() + "!");
        } else if (randomItem == 1) {
            inventory.get(1).addJumlah();
            System.out.println("Anda mendapatkan " + inventory.get(1).getName() + "!");
        } else {
            inventory.get(2).addJumlah();
            System.out.println("Anda mendapatkan " + inventory.get(2).getName() + "!"); // untuk menampilkan item yang
                                                                                        // didapat setiap hero menang
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

    public void gainXP(int amount) {
        xp += amount;
        if (xp >= 100) {
            levelUp();
        }
    }

    private void levelUp() {
        xp = 0; // Reset XP setelah naik level
        level++; // Naikkan level
        System.out.println("Horee!!! Selamat! " + getName() + " naik ke level " + level + "!");
    }

    public int getXP() {
        return xp;
    }


    public int getLevel() {
        return level;
    }

    // public int getInventorySize() {
    //     return inventory.size();
    // }

    public void showLevel() {
        System.out.println("level Hero Saat Ini: " + level  + "\n");
    }
}
