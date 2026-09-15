package com.hospital;

import com.hospital.repository.HospitalDatabase;
import com.hospital.service.AuthService;
import com.hospital.ui.MainMenu;
import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

public class Main {

    public static void main(String[] args) {
        // Initialize Database & Sample Records
        HospitalDatabase.getInstance();

        ConsolePrinter.printHeader("WELCOME TO HOSPITAL MANAGEMENT");

        if (AuthService.login()) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.start();
        } else {
            System.out.println("\nToo many failed attempts.");
            System.out.println("Program terminated.");
        }

        InputScanner.close();
    }
}
