package uas.model;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {
    private int xp = 0;
    private int level = 1;
    private List<Item> inventory = new ArrayList<>();

    public Player(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack(Character target) {
        System.out.println("\n" + getName() + " menyerang " + target.getName() + " dengan kekuatan " + getAttackPower());
        target.takeDamage(getAttackPower());
        gainXP(40); // Tambah XP setiap kali menyerang
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(item.getName() + " ditambahkan ke inventori! \n");
    }

    public void showInventory() {
        System.out.println("\nInventori:");
        if (inventory.isEmpty()) {
            System.out.println("Kosong.");
        } else {
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
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
}
