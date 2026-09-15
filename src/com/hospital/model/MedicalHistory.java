package com.hospital.model;

public class MedicalHistory {
    private int id;
    private int patientId;
    private String date;
    private String diagnosis;
    private String treatment;

    public MedicalHistory(int id, int patientId, String date, String diagnosis, String treatment) {
        this.id = id;
        this.patientId = patientId;
        this.date = date;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
