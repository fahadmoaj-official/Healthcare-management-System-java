package com.hospital.service;

import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import com.hospital.repository.HospitalDatabase;
import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

import java.util.List;

public class AppointmentService {

    private final HospitalDatabase db = HospitalDatabase.getInstance();

    public void createAppointment() {
        System.out.print("Patient ID: ");
        int pid = InputScanner.readInt();

        Patient patient = db.findPatient(pid);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Doctor ID: ");
        int did = InputScanner.readInt();

        Doctor doctor = db.findDoctor(did);
        if (doctor == null) {
            System.out.println("Doctor not found!");
            return;
        }

        if (!doctor.isAvailable()) {
            System.out.println("Doctor is currently unavailable!");
            return;
        }

        System.out.print("Date (DD-MM-YYYY): ");
        String date = InputScanner.readString();

        System.out.print("Time: ");
        String time = InputScanner.readString();

        int newId = db.generateAppointmentId();
        Appointment a = new Appointment(newId, pid, did, date, time, "Confirmed");
        db.getAppointments().add(a);

        System.out.println("\nAppointment created successfully!");
        System.out.println("Appointment ID: " + a.getId());
    }

    public void viewAppointments() {
        ConsolePrinter.printSubHeader("APPOINTMENTS");
        List<Appointment> appointments = db.getAppointments();

        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment a : appointments) {
            Patient p = db.findPatient(a.getPatientId());
            Doctor d = db.findDoctor(a.getDoctorId());

            ConsolePrinter.printDivider();
            System.out.println("Appointment ID : " + a.getId());
            System.out.println("Patient        : " + (p != null ? p.getName() : "Unknown"));
            System.out.println("Doctor         : " + (d != null ? d.getName() : "Unknown"));
            System.out.println("Date           : " + a.getDate());
            System.out.println("Time           : " + a.getTime());
            System.out.println("Status         : " + a.getStatus());
        }
    }

    public void cancelAppointment() {
        System.out.print("Appointment ID: ");
        int id = InputScanner.readInt();

        Appointment a = db.findAppointment(id);
        if (a != null) {
            a.setStatus("Cancelled");
            System.out.println("Appointment cancelled!");
        } else {
            System.out.println("Appointment not found!");
        }
    }
}
