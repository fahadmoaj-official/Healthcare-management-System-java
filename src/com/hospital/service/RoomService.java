package com.hospital.service;

import com.hospital.model.Patient;
import com.hospital.model.Room;
import com.hospital.repository.HospitalDatabase;
import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

import java.util.List;

public class RoomService {

    private final HospitalDatabase db = HospitalDatabase.getInstance();

    public void viewRooms() {
        ConsolePrinter.printSubHeader("ROOM LIST");
        List<Room> rooms = db.getRooms();

        for (Room r : rooms) {
            ConsolePrinter.printDivider();
            System.out.println("Room Number : " + r.getRoomNumber());
            System.out.println("Room Type   : " + r.getType());
            System.out.println("Bed Number  : " + r.getBedNumber());
            System.out.println("Status      : " + (r.isOccupied() ? "Occupied" : "Available"));

            if (r.isOccupied()) {
                Patient p = db.findPatient(r.getPatientId());
                System.out.println("Patient     : " + (p != null ? p.getName() : "Unknown"));
            }
        }
    }

    public void assignBed() {
        System.out.print("Room number: ");
        int roomNum = InputScanner.readInt();

        System.out.print("Bed number: ");
        int bedNum = InputScanner.readInt();

        Room r = db.findRoom(roomNum, bedNum);

        if (r == null) {
            System.out.println("Room/Bed not found!");
            return;
        }

        if (r.isOccupied()) {
            System.out.println("Bed is already occupied!");
            return;
        }

        System.out.print("Patient ID: ");
        int pid = InputScanner.readInt();

        if (db.findPatient(pid) == null) {
            System.out.println("Patient not found!");
            return;
        }

        r.setOccupied(true);
        r.setPatientId(pid);

        System.out.println("Bed assigned successfully!");
    }

    public void releaseBed() {
        System.out.print("Room number: ");
        int roomNum = InputScanner.readInt();

        System.out.print("Bed number: ");
        int bedNum = InputScanner.readInt();

        Room r = db.findRoom(roomNum, bedNum);

        if (r != null && r.isOccupied()) {
            r.setOccupied(false);
            r.setPatientId(-1);
            System.out.println("Bed released successfully!");
        } else {
            System.out.println("Occupied bed not found!");
        }
    }
}
