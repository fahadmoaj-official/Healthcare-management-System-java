package com.hospital.service;

import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

public class AuthService {

    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "1234";

    public static boolean login() {
        for (int attempt = 1; attempt <= 3; attempt++) {
            ConsolePrinter.printSubHeader("LOGIN SYSTEM");

            System.out.print("Username: ");
            String username = InputScanner.readString();

            System.out.print("Password: ");
            String password = InputScanner.readString();

            if (ADMIN_USER.equals(username) && ADMIN_PASS.equals(password)) {
                System.out.println("\nLogin successful!");
                return true;
            }

            System.out.println("Invalid username or password.");
            System.out.println("Attempts remaining: " + (3 - attempt));
        }

        return false;
    }
}
