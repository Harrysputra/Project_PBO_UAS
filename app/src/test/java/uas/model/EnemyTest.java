package uas.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

import java.util.Random;

public class EnemyTest {

    @Test
    public void testAttack() {
        // Mock Random untuk memastikan nilai yang dihasilkan tetap
        Random mockRandom = Mockito.mock(Random.class);
        Mockito.when(mockRandom.nextInt(Mockito.anyInt())).thenReturn(5); // Damage tetap 5

        // Buat subclass Enemy dengan dependency Random dimodifikasi
        Enemy enemy = new Enemy("Goblin", 50, 10) {
            private Random random = mockRandom;

            @Override
            public void attack(Character target) {
                int damage = random.nextInt(getAttackPower());
                System.out.println(getName() + " menyerang " + target.getName() + " dengan kekuatan " + damage);
                target.takeDamage(damage);
            }
        };

        // Karakter target
        Character target = new Character("Hero", 100, 15) {
            @Override
            public void attack(Character target) {
                // Tidak ada implementasi untuk attack di unit test
            }
        };

        // Act
        enemy.attack(target);

        // Assert
        assertEquals(95, target.getHealth(), "Health target harus berkurang sesuai damage yang diberikan oleh Enemy.");
    }
}
