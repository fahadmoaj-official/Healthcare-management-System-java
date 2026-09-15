package com.hospital.util;

import java.util.Scanner;

public class InputScanner {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readString() {
        return scanner.nextLine().trim();
    }

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    public static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Please enter a valid amount: ");
            }
        }
    }

    public static void close() {
        scanner.close();
    }
}
