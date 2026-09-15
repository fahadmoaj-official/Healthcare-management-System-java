package com.hospital.model;

public class MedicalTest {
    private int id;
    private int patientId;
    private String testName;
    private String result;
    private String date;
    private String status;

    public MedicalTest(int id, int patientId, String testName, String result, String date, String status) {
        this.id = id;
        this.patientId = patientId;
        this.testName = testName;
        this.result = result;
        this.date = date;
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

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
