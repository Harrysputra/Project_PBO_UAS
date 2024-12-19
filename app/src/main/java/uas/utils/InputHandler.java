package uas.utils;

import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static int getUserChoice() {
        System.out.print("Pilih aksi: ");
        return scanner.nextInt();
    }
}
