package com.hospital.model;

public class EmergencyPatient {
    private int id;
    private int patientId;
    private String emergencyType;
    private String priority;
    private String status;

    public EmergencyPatient(int id, int patientId, String emergencyType, String priority, String status) {
        this.id = id;
        this.patientId = patientId;
        this.emergencyType = emergencyType;
        this.priority = priority;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
