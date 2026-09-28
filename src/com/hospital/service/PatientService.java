package com.hospital.service;

import com.hospital.model.Patient;
import com.hospital.repository.HospitalDatabase;
import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

import java.util.List;

public class PatientService implements HospitalService {

    private final HospitalDatabase db = HospitalDatabase.getInstance();

    @Override
    public void displaySummary() {
        System.out.println("Total Registered Patients: " + db.getPatients().size());
    }

    public void addPatient() {
        System.out.print("Enter patient name: ");
        String name = InputScanner.readString();

        System.out.print("Enter age: ");
        int age = InputScanner.readInt();

        System.out.print("Enter gender: ");
        String gender = InputScanner.readString();

        System.out.print("Enter phone: ");
        String phone = InputScanner.readString();

        System.out.print("Enter disease/problem: ");
        String disease = InputScanner.readString();

        int newId = db.generatePatientId();
        Patient p = new Patient(newId, name, age, gender, phone, disease);
        db.getPatients().add(p);

        System.out.println("\nPatient added successfully!");
        System.out.println("Patient ID: " + p.getId());
    }

    public void viewPatients() {
        ConsolePrinter.printSubHeader("PATIENT LIST");
        List<Patient> patients = db.getPatients();

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
            //
        }

        for (Patient p : patients) {
            ConsolePrinter.printDivider();
            // Polymorphic call to getDetails()
            System.out.println(p.getDetails());
        }
    }

    public void updatePatient() {
        System.out.print("Enter Patient ID: ");
        int id = InputScanner.readInt();

        Patient p = db.findPatient(id);
        if (p != null) {
            System.out.print("New phone: ");
            p.setPhone(InputScanner.readString());

            System.out.print("New disease/problem: ");
            p.setDisease(InputScanner.readString());

            System.out.println("Patient updated successfully!");
        } else {
            System.out.println("Patient not found!");
        }
    }

    public void deletePatient() {
        System.out.print("Enter Patient ID: ");
        int id = InputScanner.readInt();

        Patient p = db.findPatient(id);
        if (p != null) {
            db.getPatients().remove(p);
            System.out.println("Patient deleted successfully!");
        } else {
            System.out.println("Patient not found!");
        }
    }
}
