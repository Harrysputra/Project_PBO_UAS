package uas.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SwordTest {

    @Test
    public void testSwordNameIsSetCorrectly() {
        // Arrange
        Sword sword = new Sword();

        // Act
        String actualName = sword.getName();

        // Assert
        assertEquals("Sword", actualName, "Nama item harus 'Sword'");
    }

    @Test
    public void testSwordDefaultJumlahIsZero() {
        // Arrange
        Sword sword = new Sword();

        // Act
        int defaultJumlah = sword.getJumlah();

        // Assert
        assertEquals(0, defaultJumlah, "Jumlah default harus 0");
    }

    @Test
    public void testSwordAddJumlah() {
        // Arrange
        Sword sword = new Sword();

        // Act
        sword.addJumlah(); // Tambah 1 ke jumlah
        int updatedJumlah = sword.getJumlah();

        // Assert
        assertEquals(1, updatedJumlah, "Jumlah harus bertambah menjadi 1 setelah addJumlah dipanggil");
    }
}

