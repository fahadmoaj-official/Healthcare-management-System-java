package com.hospital.service;

import com.hospital.model.Doctor;
import com.hospital.repository.HospitalDatabase;
import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

import java.util.List;

public class DoctorService implements HospitalService {

    private final HospitalDatabase db = HospitalDatabase.getInstance();

    @Override
    public void displaySummary() {
        System.out.println("Total Registered Doctors: " + db.getDoctors().size());
    }

    public void addDoctor() {
        System.out.print("Doctor name: ");
        String name = InputScanner.readString();

        System.out.print("Specialization: ");
        String specialization = InputScanner.readString();

        System.out.print("Department: ");
        String department = InputScanner.readString();

        System.out.print("Phone: ");
        String phone = InputScanner.readString();

        int newId = db.generateDoctorId();
        Doctor d = new Doctor(newId, name, specialization, department, phone, true);
        db.getDoctors().add(d);

        System.out.println("\nDoctor added successfully!");
        System.out.println("Doctor ID: " + d.getId());
    }

    public void viewDoctors() {
        ConsolePrinter.printSubHeader("DOCTOR LIST");
        List<Doctor> doctors = db.getDoctors();

        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        for (Doctor d : doctors) {
            ConsolePrinter.printDivider();
            // Polymorphic call to getDetails()
            System.out.println(d.getDetails());
        }
    }

    public void updateDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = InputScanner.readInt();

        Doctor d = db.findDoctor(id);
        if (d != null) {
            System.out.print("New phone: ");
            d.setPhone(InputScanner.readString());

            System.out.print("Available? (yes/no): ");
            String answer = InputScanner.readString();
            d.setAvailable(answer.equalsIgnoreCase("yes"));

            System.out.println("Doctor updated successfully!");
        } else {
            System.out.println("Doctor not found!");
        }
    }

    public void checkAvailability() {
        ConsolePrinter.printSubHeader("DOCTOR AVAILABILITY");
        List<Doctor> doctors = db.getDoctors();

        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }

        for (Doctor d : doctors) {
            ConsolePrinter.printDivider();
            System.out.println("Doctor ID     : " + d.getId());
            System.out.println("Doctor Name   : " + d.getName());
            System.out.println("Department    : " + d.getDepartment());
            System.out.println("Specialization: " + d.getSpecialization());
            System.out.println("Status        : " + (d.isAvailable() ? "AVAILABLE" : "NOT AVAILABLE"));
        }
    }
}
