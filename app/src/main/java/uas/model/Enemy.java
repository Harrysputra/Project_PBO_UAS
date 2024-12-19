package uas.model;

import java.util.Random;

public class Enemy extends Character {
    private Random random = new Random();

    public Enemy(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public void attack(Character target) {
        int damage = random.nextInt(getAttackPower()) + 1; // Damage acak
        System.out.println(getName() + " menyerang " + target.getName() + " dengan kekuatan " + damage + "\n");
        target.takeDamage(damage);
    }
}
