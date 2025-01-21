package uas.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ElixirTest {

    @Test
    public void testElixirNameIsSetCorrectly() {
        // Arrange: Membuat instance dari Elixir
        Elixir elixir = new Elixir();

        // Act: Mengambil nama item yang diatur di konstruktor
        String actualName = elixir.getName();

        // Assert: Memastikan bahwa nama sesuai dengan yang diharapkan
        assertEquals("Elixir", actualName, "Nama item harus 'Elixir'");
    }
}

