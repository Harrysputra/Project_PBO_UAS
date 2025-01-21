package uas.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PotionTest {

    @Test
    public void testPotionNameIsSetCorrectly() {
        // Arrange
        Potion potion = new Potion();

        // Act
        String actualName = potion.getName();

        // Assert
        assertEquals("Potion", actualName, "Nama item harus 'Potion'");
    }

    @Test
    public void testPotionDefaultJumlahIsZero() {
        // Arrange
        Potion potion = new Potion();

        // Act
        int defaultJumlah = potion.getJumlah();

        // Assert
        assertEquals(0, defaultJumlah, "Jumlah default harus 0");
    }

    @Test
    public void testPotionAddJumlah() {
        // Arrange
        Potion potion = new Potion();

        // Act
        potion.addJumlah();
        int updatedJumlah = potion.getJumlah();

        // Assert
        assertEquals(1, updatedJumlah, "Jumlah harus bertambah menjadi 1 setelah addJumlah dipanggil");
    }
}
