package com.hospital.service;

import com.hospital.model.Bill;
import com.hospital.model.Patient;
import com.hospital.repository.HospitalDatabase;
import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

import java.util.List;

public class BillingService {

    private final HospitalDatabase db = HospitalDatabase.getInstance();

    public void createBill() {
        System.out.print("Patient ID: ");
        int pid = InputScanner.readInt();

        if (db.findPatient(pid) == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Bill amount: ");
        double amount = InputScanner.readDouble();

        System.out.print("Payment method (Cash/Card/Mobile): ");
        String method = InputScanner.readString();

        int newId = db.generateBillId();
        Bill bill = new Bill(newId, pid, amount, method, "Unpaid");
        db.getBills().add(bill);

        System.out.println("Bill created successfully!");
        System.out.println("Bill ID: " + bill.getId());
    }

    public void viewBills() {
        List<Bill> bills = db.getBills();

        if (bills.isEmpty()) {
            System.out.println("No bills found.");
            return;
        }

        for (Bill b : bills) {
            Patient p = db.findPatient(b.getPatientId());

            ConsolePrinter.printDivider();
            System.out.println("Bill ID        : " + b.getId());
            System.out.println("Patient        : " + (p != null ? p.getName() : "Unknown"));
            System.out.println("Amount         : " + b.getAmount() + " BDT");
            System.out.println("Payment Method : " + b.getPaymentMethod());
            System.out.println("Status         : " + b.getStatus());
        }
    }

    public void payBill() {
        System.out.print("Bill ID: ");
        int id = InputScanner.readInt();

        Bill b = db.findBill(id);

        if (b != null) {
            b.setStatus("Paid");
            System.out.println("Payment successful!");
        } else {
            System.out.println("Bill not found!");
        }
    }
}
