package com.hospital.service;

import com.hospital.model.MedicalTest;
import com.hospital.model.Patient;
import com.hospital.repository.HospitalDatabase;
import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

import java.util.List;

public class MedicalTestService {

    private final HospitalDatabase db = HospitalDatabase.getInstance();

    public void addTest() {
        System.out.print("Patient ID: ");
        int pid = InputScanner.readInt();

        if (db.findPatient(pid) == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Test name: ");
        String testName = InputScanner.readString();

        System.out.print("Date: ");
        String date = InputScanner.readString();

        int newId = db.generateTestId();
        MedicalTest test = new MedicalTest(newId, pid, testName, "Pending", date, "Pending");
        db.getTests().add(test);

        System.out.println("Medical test added successfully!");
    }

    public void viewTests() {
        List<MedicalTest> tests = db.getTests();

        if (tests.isEmpty()) {
            System.out.println("No medical tests found.");
            return;
        }

        for (MedicalTest t : tests) {
            Patient p = db.findPatient(t.getPatientId());

            ConsolePrinter.printDivider();
            System.out.println("Test ID    : " + t.getId());
            System.out.println("Patient    : " + (p != null ? p.getName() : "Unknown"));
            System.out.println("Test Name  : " + t.getTestName());
            System.out.println("Date       : " + t.getDate());
            System.out.println("Result     : " + t.getResult());
            System.out.println("Status     : " + t.getStatus());
        }
    }

    public void updateTestResult() {
        System.out.print("Test ID: ");
        int id = InputScanner.readInt();

        MedicalTest test = db.findTest(id);

        if (test != null) {
            System.out.print("Enter result: ");
            test.setResult(InputScanner.readString());
            test.setStatus("Completed");

            System.out.println("Test result updated!");
        } else {
            System.out.println("Test not found!");
        }
    }
}
