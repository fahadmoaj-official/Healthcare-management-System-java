package com.hospital.model;

public class Room {
    private int roomNumber;
    private String type;
    private int bedNumber;
    private boolean occupied;
    private int patientId;

    public Room(int roomNumber, String type, int bedNumber) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.bedNumber = bedNumber;
        this.occupied = false;
        this.patientId = -1;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
