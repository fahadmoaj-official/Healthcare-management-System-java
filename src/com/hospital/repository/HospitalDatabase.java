package com.hospital.repository;

import com.hospital.model.*;

import java.util.ArrayList;
import java.util.List;

public class HospitalDatabase {

    private static HospitalDatabase instance;

    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();
    private final List<Prescription> prescriptions = new ArrayList<>();
    private final List<MedicalTest> tests = new ArrayList<>();
    private final List<Bill> bills = new ArrayList<>();
    private final List<Room> rooms = new ArrayList<>();
    private final List<EmergencyPatient> emergencyPatients = new ArrayList<>();
    private final List<Department> departments = new ArrayList<>();
    private final List<MedicalHistory> histories = new ArrayList<>();

    private int nextPatientId = 1001;
    private int nextDoctorId = 501;
    private int nextAppointmentId = 1;
    private int nextPrescriptionId = 1;
    private int nextTestId = 1;
    private int nextBillId = 1;
    private int nextEmergencyId = 1;
    private int nextDepartmentId = 1;
    private int nextHistoryId = 1;

    private HospitalDatabase() {
        initializeData();
    }

    public static synchronized HospitalDatabase getInstance() {
        if (instance == null) {
            instance = new HospitalDatabase();
        }
        return instance;
    }

    private void initializeData() {
        // Patients (14 sample records)
        patients.add(new Patient(nextPatientId++, "Rahim Ahmed", 25, "Male", "01711111111", "Fever"));
        patients.add(new Patient(nextPatientId++, "Nusrat Jahan", 30, "Female", "01822222222", "Diabetes"));
        patients.add(new Patient(nextPatientId++, "Milon Ahmed", 28, "Male", "0183467892", "Ulcer"));
        patients.add(new Patient(nextPatientId++, "Fahim Ahmed", 22, "Male", "0171125311", "Fever"));
        patients.add(new Patient(nextPatientId++, "Ayesha Rahman", 35, "Female", "01912345678", "Hypertension"));
        patients.add(new Patient(nextPatientId++, "Tanvir Hasan", 40, "Male", "01623456789", "Heart Problem"));
        patients.add(new Patient(nextPatientId++, "Sadia Islam", 27, "Female", "01834567890", "Migraine"));
        patients.add(new Patient(nextPatientId++, "Imran Hossain", 32, "Male", "01745678901", "Asthma"));
        patients.add(new Patient(nextPatientId++, "Jannatul Ferdous", 24, "Female", "01956789012", "Skin Allergy"));
        patients.add(new Patient(nextPatientId++, "Rafiul Karim", 45, "Male", "01667890123", "Chest Pain"));
        patients.add(new Patient(nextPatientId++, "Mim Akter", 19, "Female", "01878901234", "Flu"));
        patients.add(new Patient(nextPatientId++, "Sakib Khan", 38, "Male", "01789012345", "Kidney Stone"));
        patients.add(new Patient(nextPatientId++, "Farzana Yasmin", 29, "Female", "01990123456", "Gastric Problem"));
        patients.add(new Patient(nextPatientId++, "Arif Mahmud", 50, "Male", "01601234567", "Arthritis"));

        // Doctors (14 sample records)
        doctors.add(new Doctor(nextDoctorId++, "Dr. Ahmed Hassan", "Cardiologist", "Cardiology", "01933333333", true));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Sara Khan", "Medicine Specialist", "Medicine", "01644444444", true));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Karim Rahman", "Surgeon", "Surgery", "01555555555", false));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Nishat Jahan Jimu", "Surgeon", "Surgery", "01555555556", false));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Sayeeda Sumaiya Islam Oyshi", "Heart Surgeon", "Cardiology", "01637850319", false));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Fariha Ahmed", "General Surgeon", "Surgery", "0136489393", false));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Tasnim Jara", "Dermatologist", "Dermatology", "0146325555", false));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Asad Ahmed", "Gynecologist", "Gynecology", "0193645390", false));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Mahmudul Hasan", "Neurologist", "Neurology", "01712345678", true));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Rima Akter", "Pediatrician", "Pediatrics", "01823456789", true));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Saiful Islam", "Orthopedic Specialist", "Orthopedics", "01934567890", true));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Sumaiya Rahman", "Gynecologist", "Gynecology", "01645678901", true));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Nayeem Chowdhury", "Urologist", "Urology", "01756789012", false));
        doctors.add(new Doctor(nextDoctorId++, "Dr. Priya Sultana", "Psychiatrist", "Psychiatry", "01867890123", true));

        // Prescriptions (14 sample records)
        prescriptions.add(new Prescription(nextPrescriptionId++, 1001, 502, "Paracetamol", "500mg", "1 tablet after meal, 3 times daily"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1002, 502, "Metformin", "500mg", "1 tablet after breakfast and dinner"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1003, 502, "Omeprazole", "20mg", "1 capsule before breakfast"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1004, 502, "Paracetamol", "500mg", "1 tablet when needed for fever"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1005, 502, "Amlodipine", "5mg", "1 tablet once daily"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1006, 509, "Sumatriptan", "50mg", "Take during migraine attack as prescribed"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1007, 501, "Atorvastatin", "20mg", "1 tablet at night"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1008, 510, "Ferrous Sulfate", "200mg", "1 tablet once daily after meal"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1009, 502, "Pantoprazole", "40mg", "1 tablet before breakfast"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1010, 502, "Salbutamol", "2mg", "Use as directed by doctor"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1011, 507, "Cetirizine", "10mg", "1 tablet at night"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1012, 513, "Losartan", "50mg", "1 tablet once daily"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1013, 502, "Levothyroxine", "50mcg", "Take in the morning before food"));
        prescriptions.add(new Prescription(nextPrescriptionId++, 1014, 511, "Naproxen", "250mg", "1 tablet after meal"));

        // Departments
        departments.add(new Department(nextDepartmentId++, "Cardiology", "Dr. Ahmed Hassan"));
        departments.add(new Department(nextDepartmentId++, "Medicine", "Dr. Sara Khan"));
        departments.add(new Department(nextDepartmentId++, "Surgery", "Dr. Karim Rahman"));
        departments.add(new Department(nextDepartmentId++, "Dermatology", "Dr. Tasnim Jara"));
        departments.add(new Department(nextDepartmentId++, "Gynecology", "Dr. Asad Ahmed"));
        departments.add(new Department(nextDepartmentId++, "Neurology", "Dr. Mahmudul Hasan"));
        departments.add(new Department(nextDepartmentId++, "Pediatrics", "Dr. Rima Akter"));
        departments.add(new Department(nextDepartmentId++, "Orthopedics", "Dr. Saiful Islam"));
        departments.add(new Department(nextDepartmentId++, "Urology", "Dr. Nayeem Chowdhury"));
        departments.add(new Department(nextDepartmentId++, "Psychiatry", "Dr. Priya Sultana"));

        // Rooms / Beds
        rooms.add(new Room(101, "General", 1));
        rooms.add(new Room(101, "General", 2));
        rooms.add(new Room(101, "General", 3));
        rooms.add(new Room(102, "General", 1));
        rooms.add(new Room(102, "General", 2));
        rooms.add(new Room(102, "General", 3));
        rooms.add(new Room(103, "General", 1));
        rooms.add(new Room(103, "General", 2));
        rooms.add(new Room(201, "Cabin", 1));
        rooms.add(new Room(202, "Cabin", 1));
        rooms.add(new Room(203, "Cabin", 1));
        rooms.add(new Room(204, "Cabin", 1));
        rooms.add(new Room(301, "ICU", 1));
        rooms.add(new Room(302, "ICU", 1));
        rooms.add(new Room(303, "ICU", 1));
        rooms.add(new Room(401, "VIP", 1));
        rooms.add(new Room(402, "VIP", 1));
        rooms.add(new Room(403, "VIP", 1));
    }

    // Getters for Collections
    public List<Patient> getPatients() { return patients; }
    public List<Doctor> getDoctors() { return doctors; }
    public List<Appointment> getAppointments() { return appointments; }
    public List<Prescription> getPrescriptions() { return prescriptions; }
    public List<MedicalTest> getTests() { return tests; }
    public List<Bill> getBills() { return bills; }
    public List<Room> getRooms() { return rooms; }
    public List<EmergencyPatient> getEmergencyPatients() { return emergencyPatients; }
    public List<Department> getDepartments() { return departments; }
    public List<MedicalHistory> getHistories() { return histories; }

    // ID Generators
    public int generatePatientId() { return nextPatientId++; }
    public int generateDoctorId() { return nextDoctorId++; }
    public int generateAppointmentId() { return nextAppointmentId++; }
    public int generatePrescriptionId() { return nextPrescriptionId++; }
    public int generateTestId() { return nextTestId++; }
    public int generateBillId() { return nextBillId++; }
    public int generateEmergencyId() { return nextEmergencyId++; }
    public int generateDepartmentId() { return nextDepartmentId++; }
    public int generateHistoryId() { return nextHistoryId++; }

    // Finder Helper Methods
    public Patient findPatient(int id) {
        for (Patient p : patients) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public Doctor findDoctor(int id) {
        for (Doctor d : doctors) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    public Appointment findAppointment(int id) {
        for (Appointment a : appointments) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    public MedicalTest findTest(int id) {
        for (MedicalTest t : tests) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    public Bill findBill(int id) {
        for (Bill b : bills) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    public EmergencyPatient findEmergency(int id) {
        for (EmergencyPatient e : emergencyPatients) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public Room findRoom(int roomNumber, int bedNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber && r.getBedNumber() == bedNumber) {
                return r;
            }
        }
        return null;
    }
}
