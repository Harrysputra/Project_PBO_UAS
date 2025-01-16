package uas.model;

public abstract class Character {
    private String name;
    private int health;
    private int attackPower;

    // constructor
    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // getter
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public abstract void attack(Character target);
}
