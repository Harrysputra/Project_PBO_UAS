package uas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;
    private Player target;

    @BeforeEach
    void setUp() {
        player = new Player("Hero", 100, 20);
        target = new Player("Monster", 100, 15);
    }

    @Test
    void testAttackIncreasesXP() {
        int initialXP = player.getXP();
        player.attack(target);
        assertTrue(player.getXP() > initialXP, "XP should increase after attacking");
    }

    @Test
    void testLevelUp() {
        player.gainXP(90);
        assertEquals(1, player.getLevel(), "Player should not level up before gaining 100 XP");
        player.gainXP(10);
        assertEquals(2, player.getLevel(), "Player should level up after gaining 100 XP");
    }

    @Test
    void testInventoryItemCount() {
        player.showInventory();
        assertEquals(3, player.getInventorySize(), "Player should have 3 items in inventory initially");
    }

    @Test
    void testAttackReducesTargetHealth() {
        int initialHealth = target.getHealth(); // Menggunakan getter
        player.attack(target);
        assertTrue(target.getHealth() < initialHealth, "Target's health should decrease after being attacked");
    }

}