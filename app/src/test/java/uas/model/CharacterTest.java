package uas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    // Subclass sederhana untuk pengujian
    private static class TestCharacter extends Character {
        public TestCharacter(String name, int health, int attackPower) {
            super(name, health, attackPower);
        }

        @Override
        public void attack(Character target) {
            // Implementasi sederhana: target menerima damage sebesar attackPower
            target.takeDamage(getAttackPower());
        }
    }

    @Test
    public void testConstructor() {
        // Arrange
        Character character = new TestCharacter("Hero", 100, 20);

        // Assert
        assertEquals("Hero", character.getName(), "Nama karakter harus sesuai dengan konstruktor");
        assertEquals(100, character.getHealth(), "Health karakter harus sesuai dengan konstruktor");
        assertEquals(20, character.getAttackPower(), "Attack power karakter harus sesuai dengan konstruktor");
    }

    @Test
    public void testTakeDamage() {
        // Arrange
        Character character = new TestCharacter("Hero", 100, 20);

        // Act
        character.takeDamage(30);

        // Assert
        assertEquals(70, character.getHealth(), "Health harus berkurang sebesar damage yang diterima");
    }

    @Test
    public void testAttack() {
        // Arrange
        Character attacker = new TestCharacter("Hero", 100, 20);
        Character target = new TestCharacter("Enemy", 100, 15);

        // Act
        attacker.attack(target);

        // Assert
        assertEquals(80, target.getHealth(), "Health target harus berkurang sebesar attack power attacker");
        assertEquals(100, attacker.getHealth(), "Health attacker tidak boleh berubah setelah menyerang");
    }
}

