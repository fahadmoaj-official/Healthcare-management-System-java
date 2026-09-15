package com.hospital.service;

import com.hospital.model.MedicalHistory;
import com.hospital.model.Patient;
import com.hospital.repository.HospitalDatabase;
import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

import java.util.List;

public class MedicalHistoryService {

    private final HospitalDatabase db = HospitalDatabase.getInstance();

    public void addMedicalHistory() {
        System.out.print("Patient ID: ");
        int pid = InputScanner.readInt();

        if (db.findPatient(pid) == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Date: ");
        String date = InputScanner.readString();

        System.out.print("Diagnosis: ");
        String diagnosis = InputScanner.readString();

        System.out.print("Treatment: ");
        String treatment = InputScanner.readString();

        int newId = db.generateHistoryId();
        MedicalHistory h = new MedicalHistory(newId, pid, date, diagnosis, treatment);
        db.getHistories().add(h);

        System.out.println("Medical history added!");
    }

    public void viewMedicalHistory() {
        System.out.print("Enter Patient ID: ");
        int pid = InputScanner.readInt();

        boolean found = false;
        List<MedicalHistory> histories = db.getHistories();

        for (MedicalHistory h : histories) {
            if (h.getPatientId() == pid) {
                Patient p = db.findPatient(pid);

                ConsolePrinter.printDivider();
                System.out.println("Patient    : " + (p != null ? p.getName() : "Unknown"));
                System.out.println("Date       : " + h.getDate());
                System.out.println("Diagnosis  : " + h.getDiagnosis());
                System.out.println("Treatment  : " + h.getTreatment());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No medical history found!");
        }
    }
}
