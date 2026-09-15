package com.hospital.service;

import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import com.hospital.model.Prescription;
import com.hospital.repository.HospitalDatabase;
import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

import java.util.List;

public class PrescriptionService {

    private final HospitalDatabase db = HospitalDatabase.getInstance();

    public void addPrescription() {
        System.out.print("Patient ID: ");
        int pid = InputScanner.readInt();

        if (db.findPatient(pid) == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Doctor ID: ");
        int did = InputScanner.readInt();

        if (db.findDoctor(did) == null) {
            System.out.println("Doctor not found!");
            return;
        }

        System.out.print("Medicine name: ");
        String medicine = InputScanner.readString();

        System.out.print("Dosage: ");
        String dosage = InputScanner.readString();

        System.out.print("Instructions: ");
        String instructions = InputScanner.readString();

        int newId = db.generatePrescriptionId();
        Prescription p = new Prescription(newId, pid, did, medicine, dosage, instructions);
        db.getPrescriptions().add(p);

        System.out.println("Prescription added successfully!");
    }

    public void viewPrescriptions() {
        List<Prescription> prescriptions = db.getPrescriptions();

        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions found.");
            return;
        }

        for (Prescription p : prescriptions) {
            Patient patient = db.findPatient(p.getPatientId());
            Doctor doctor = db.findDoctor(p.getDoctorId());

            ConsolePrinter.printDivider();
            System.out.println("Prescription ID: " + p.getId());
            System.out.println("Patient        : " + (patient != null ? patient.getName() : "Unknown"));
            System.out.println("Doctor         : " + (doctor != null ? doctor.getName() : "Unknown"));
            System.out.println("Medicine       : " + p.getMedicine());
            System.out.println("Dosage         : " + p.getDosage());
            System.out.println("Instructions   : " + p.getInstructions());
        }
    }
}
