package com.hospital.service;

import com.hospital.model.Appointment;
import com.hospital.model.Bill;
import com.hospital.model.Room;
import com.hospital.repository.HospitalDatabase;
import com.hospital.util.ConsolePrinter;

public class ReportService {

    private final HospitalDatabase db = HospitalDatabase.getInstance();

    public void displayHospitalStatistics() {
        double totalIncome = 0;
        int paidBills = 0;

        for (Bill b : db.getBills()) {
            if ("Paid".equalsIgnoreCase(b.getStatus())) {
                totalIncome += b.getAmount();
                paidBills++;
            }
        }

        int availableBeds = 0;
        for (Room r : db.getRooms()) {
            if (!r.isOccupied()) {
                availableBeds++;
            }
        }

        int activeAppointments = 0;
        for (Appointment a : db.getAppointments()) {
            if ("Confirmed".equalsIgnoreCase(a.getStatus())) {
                activeAppointments++;
            }
        }

        ConsolePrinter.printHeader("HOSPITAL STATISTICS");
        System.out.println("Total Patients       : " + db.getPatients().size());
        System.out.println("Total Doctors        : " + db.getDoctors().size());
        System.out.println("Total Appointments   : " + db.getAppointments().size());
        System.out.println("Active Appointments  : " + activeAppointments);
        System.out.println("Prescriptions        : " + db.getPrescriptions().size());
        System.out.println("Medical Tests        : " + db.getTests().size());
        System.out.println("Total Bills          : " + db.getBills().size());
        System.out.println("Paid Bills           : " + paidBills);
        System.out.println("Total Income         : " + totalIncome + " BDT");
        System.out.println("Total Rooms/Beds     : " + db.getRooms().size());
        System.out.println("Available Beds       : " + availableBeds);
        System.out.println("Emergency Patients   : " + db.getEmergencyPatients().size());
        System.out.println("Departments          : " + db.getDepartments().size());
        System.out.println("Medical Histories    : " + db.getHistories().size());
        System.out.println("==============================================");
    }
}
