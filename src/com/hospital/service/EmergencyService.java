package com.hospital.service;

import com.hospital.model.EmergencyPatient;
import com.hospital.model.Patient;
import com.hospital.repository.HospitalDatabase;
import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

import java.util.List;

public class EmergencyService {

    private final HospitalDatabase db = HospitalDatabase.getInstance();

    public void registerEmergency() {
        System.out.print("Patient ID: ");
        int pid = InputScanner.readInt();

        if (db.findPatient(pid) == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Emergency type: ");
        String type = InputScanner.readString();

        System.out.print("Priority (High/Medium/Low): ");
        String priority = InputScanner.readString();

        int newId = db.generateEmergencyId();
        EmergencyPatient e = new EmergencyPatient(newId, pid, type, priority, "Under Treatment");
        db.getEmergencyPatients().add(e);

        System.out.println("Emergency patient registered!");
    }

    public void viewEmergencyPatients() {
        List<EmergencyPatient> list = db.getEmergencyPatients();

        if (list.isEmpty()) {
            System.out.println("No emergency patients.");
            return;
        }

        for (EmergencyPatient e : list) {
            Patient p = db.findPatient(e.getPatientId());

            ConsolePrinter.printDivider();
            System.out.println("Emergency ID : " + e.getId());
            System.out.println("Patient      : " + (p != null ? p.getName() : "Unknown"));
            System.out.println("Emergency    : " + e.getEmergencyType());
            System.out.println("Priority     : " + e.getPriority());
            System.out.println("Status       : " + e.getStatus());
        }
    }

    public void updateEmergencyStatus() {
        System.out.print("Emergency ID: ");
        int id = InputScanner.readInt();

        EmergencyPatient e = db.findEmergency(id);

        if (e != null) {
            System.out.print("New status: ");
            e.setStatus(InputScanner.readString());
            System.out.println("Status updated!");
        } else {
            System.out.println("Emergency record not found!");
        }
    }
}
