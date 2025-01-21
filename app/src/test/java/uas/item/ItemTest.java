package uas.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ItemTest {

    // Subclass untuk pengujian
    private static class TestItem extends Item {
        public TestItem() {
            // Konstruktor default
        }
    }

    @Test
    public void testDefaultJumlahIsZero() {
        // Arrange
        Item item = new TestItem();

        // Act
        int defaultJumlah = item.getJumlah();

        // Assert
        assertEquals(0, defaultJumlah, "Jumlah default harus 0");
    }

    @Test
    public void testSetName() {
        // Arrange
        Item item = new TestItem();

        // Act
        item.setName("TestItem");
        String name = item.getName();

        // Assert
        assertEquals("TestItem", name, "Nama harus diatur sesuai dengan nilai yang diberikan");
    }

    @Test
    public void testSetJumlah() {
        // Arrange
        Item item = new TestItem();

        // Act
        item.setJumlah(5);
        int jumlah = item.getJumlah();

        // Assert
        assertEquals(5, jumlah, "Jumlah harus diatur sesuai dengan nilai yang diberikan");
    }

    @Test
    public void testAddJumlah() {
        // Arrange
        Item item = new TestItem();

        // Act
        item.addJumlah(); // Tambah 1 ke jumlah
        int updatedJumlah = item.getJumlah();

        // Assert
        assertEquals(1, updatedJumlah, "Jumlah harus bertambah menjadi 1 setelah addJumlah dipanggil");
    }
}

