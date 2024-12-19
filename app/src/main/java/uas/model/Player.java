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

    public void attack(Character target) {
        System.out
                .println("\n" + getName() + " menyerang " + target.getName() + " dengan kekuatan " + getAttackPower());
        target.takeDamage(getAttackPower());
        gainXP(40); // Tambah XP setiap kali menyerang
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
        xp += amount;
        if (xp >= 100) {
            levelUp();
        }
    }

    private void levelUp() {
        xp = 0;
        level++;
        System.out.println("Horee!!! Selamat! " + getName() + " naik ke level " + level + "!");
    }

    public void showLevel() {
        System.out.println("level Hero Saat Ini: " + level);
    }
}
