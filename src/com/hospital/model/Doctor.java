package com.hospital.model;

public class Doctor extends Person {
    private String specialization;
    private String department;
    private boolean available;

    public Doctor(int id, String name, String specialization, String department, String phone, boolean available) {
        super(id, name, phone);
        this.specialization = specialization;
        this.department = department;
        this.available = available;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Method Overriding (Polymorphism)
    @Override
    public String getDetails() {
        return super.getDetails() + " | Spec: " + specialization + " | Dept: " + department + " | Status: " + (available ? "Available" : "Not Available");
    }
}
