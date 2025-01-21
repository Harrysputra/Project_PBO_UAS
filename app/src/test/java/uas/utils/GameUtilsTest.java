package uas.utils;

import org.junit.jupiter.api.Test;
import uas.model.Player;
import uas.model.Enemy;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class GameUtilsTest {

    @Test
    void testPrintCharacterStatus() {
        // Setup untuk menangkap output ke console
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Membuat objek Player dan Enemy
        Player player = new Player("Hero", 100, 50);
        Enemy enemy = new Enemy("Goblin", 80, 30);

        // Memanggil metode yang akan diuji
        GameUtils.printCharacterStatus(player, enemy);

        // Mengembalikan output ke sistem aslinya
        System.setOut(System.out);

        // Mendefinisikan hasil yang diharapkan
        String expectedOutput = "\n--- Status Karakter ---\n" +
                "Hero - Health: 100\n" +
                "Goblin - Health: 80\n";

        // Membandingkan output aktual dengan hasil yang diharapkan
        assertEquals(expectedOutput, outputStream.toString());
    }
}
