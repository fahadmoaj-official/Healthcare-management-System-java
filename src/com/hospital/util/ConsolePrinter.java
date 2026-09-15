package com.hospital.util;

public class ConsolePrinter {

    public static void printHeader(String title) {
        System.out.println("\n==============================================");
        System.out.println("       " + title.toUpperCase());
        System.out.println("==============================================");
    }

    public static void printSubHeader(String title) {
        System.out.println("\n----------- " + title.toUpperCase() + " -----------");
    }

    public static void printDivider() {
        System.out.println("----------------------------------------------");
    }
}
