package com.hospital.ui;

import com.hospital.service.*;
import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

public class MainMenu {

    private final PatientService patientService = new PatientService();
    private final DoctorService doctorService = new DoctorService();
    private final AppointmentService appointmentService = new AppointmentService();
    private final PrescriptionService prescriptionService = new PrescriptionService();
    private final MedicalTestService medicalTestService = new MedicalTestService();
    private final BillingService billingService = new BillingService();
    private final RoomService roomService = new RoomService();
    private final EmergencyService emergencyService = new EmergencyService();
    private final DepartmentService departmentService = new DepartmentService();
    private final MedicalHistoryService medicalHistoryService = new MedicalHistoryService();
    private final ReportService reportService = new ReportService();

    public void start() {
        while (true) {
            ConsolePrinter.printHeader("HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Doctor Availability");
            System.out.println("5. Prescription System");
            System.out.println("6. Medical Test System");
            System.out.println("7. Billing & Payment");
            System.out.println("8. Room/Bed Management");
            System.out.println("9. Emergency Patient");
            System.out.println("10. Department System");
            System.out.println("11. Medical History");
            System.out.println("12. Hospital Statistics");
            System.out.println("13. Logout");
            System.out.println("==============================================");

            System.out.print("Enter your choice: ");
            int choice = InputScanner.readInt();

            switch (choice) {
                case 1:
                    patientManagementMenu();
                    break;
                case 2:
                    doctorManagementMenu();
                    break;
                case 3:
                    appointmentManagementMenu();
                    break;
                case 4:
                    doctorService.checkAvailability();
                    break;
                case 5:
                    prescriptionSystemMenu();
                    break;
                case 6:
                    medicalTestSystemMenu();
                    break;
                case 7:
                    billingSystemMenu();
                    break;
                case 8:
                    roomBedManagementMenu();
                    break;
                case 9:
                    emergencySystemMenu();
                    break;
                case 10:
                    departmentSystemMenu();
                    break;
                case 11:
                    medicalHistorySystemMenu();
                    break;
                case 12:
                    reportService.displayHospitalStatistics();
                    break;
                case 13:
                    System.out.println("\nLogged out successfully.");
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void patientManagementMenu() {
        while (true) {
            ConsolePrinter.printSubHeader("PATIENT MANAGEMENT");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Back");

            System.out.print("Enter choice: ");
            int choice = InputScanner.readInt();

            switch (choice) {
                case 1: patientService.addPatient(); break;
                case 2: patientService.viewPatients(); break;
                case 3: patientService.updatePatient(); break;
                case 4: patientService.deletePatient(); break;
                case 5: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void doctorManagementMenu() {
        while (true) {
            ConsolePrinter.printSubHeader("DOCTOR MANAGEMENT");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Update Doctor");
            System.out.println("4. Back");

            System.out.print("Enter choice: ");
            int choice = InputScanner.readInt();

            switch (choice) {
                case 1: doctorService.addDoctor(); break;
                case 2: doctorService.viewDoctors(); break;
                case 3: doctorService.updateDoctor(); break;
                case 4: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void appointmentManagementMenu() {
        while (true) {
            ConsolePrinter.printSubHeader("APPOINTMENT MANAGEMENT");
            System.out.println("1. Create Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Back");

            System.out.print("Enter choice: ");
            int choice = InputScanner.readInt();

            switch (choice) {
                case 1: appointmentService.createAppointment(); break;
                case 2: appointmentService.viewAppointments(); break;
                case 3: appointmentService.cancelAppointment(); break;
                case 4: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void prescriptionSystemMenu() {
        while (true) {
            ConsolePrinter.printSubHeader("PRESCRIPTION SYSTEM");
            System.out.println("1. Add Prescription");
            System.out.println("2. View Prescriptions");
            System.out.println("3. Back");

            System.out.print("Enter choice: ");
            int choice = InputScanner.readInt();

            switch (choice) {
                case 1: prescriptionService.addPrescription(); break;
                case 2: prescriptionService.viewPrescriptions(); break;
                case 3: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void medicalTestSystemMenu() {
        while (true) {
            ConsolePrinter.printSubHeader("MEDICAL TEST SYSTEM");
            System.out.println("1. Add Medical Test");
            System.out.println("2. View Tests");
            System.out.println("3. Update Test Result");
            System.out.println("4. Back");

            System.out.print("Enter choice: ");
            int choice = InputScanner.readInt();

            switch (choice) {
                case 1: medicalTestService.addTest(); break;
                case 2: medicalTestService.viewTests(); break;
                case 3: medicalTestService.updateTestResult(); break;
                case 4: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void billingSystemMenu() {
        while (true) {
            ConsolePrinter.printSubHeader("BILLING & PAYMENT");
            System.out.println("1. Create Bill");
            System.out.println("2. View Bills");
            System.out.println("3. Pay Bill");
            System.out.println("4. Back");

            System.out.print("Enter choice: ");
            int choice = InputScanner.readInt();

            switch (choice) {
                case 1: billingService.createBill(); break;
                case 2: billingService.viewBills(); break;
                case 3: billingService.payBill(); break;
                case 4: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void roomBedManagementMenu() {
        while (true) {
            ConsolePrinter.printSubHeader("ROOM / BED MANAGEMENT");
            System.out.println("1. View Rooms");
            System.out.println("2. Assign Bed");
            System.out.println("3. Release Bed");
            System.out.println("4. Back");

            System.out.print("Enter choice: ");
            int choice = InputScanner.readInt();

            switch (choice) {
                case 1: roomService.viewRooms(); break;
                case 2: roomService.assignBed(); break;
                case 3: roomService.releaseBed(); break;
                case 4: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void emergencySystemMenu() {
        while (true) {
            ConsolePrinter.printSubHeader("EMERGENCY PATIENT");
            System.out.println("1. Register Emergency Patient");
            System.out.println("2. View Emergency Patients");
            System.out.println("3. Update Emergency Status");
            System.out.println("4. Back");

            System.out.print("Enter choice: ");
            int choice = InputScanner.readInt();

            switch (choice) {
                case 1: emergencyService.registerEmergency(); break;
                case 2: emergencyService.viewEmergencyPatients(); break;
                case 3: emergencyService.updateEmergencyStatus(); break;
                case 4: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void departmentSystemMenu() {
        while (true) {
            ConsolePrinter.printSubHeader("DEPARTMENT SYSTEM");
            System.out.println("1. Add Department");
            System.out.println("2. View Departments");
            System.out.println("3. Back");

            System.out.print("Enter choice: ");
            int choice = InputScanner.readInt();

            switch (choice) {
                case 1: departmentService.addDepartment(); break;
                case 2: departmentService.viewDepartments(); break;
                case 3: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void medicalHistorySystemMenu() {
        while (true) {
            ConsolePrinter.printSubHeader("MEDICAL HISTORY");
            System.out.println("1. Add Medical History");
            System.out.println("2. View Medical History");
            System.out.println("3. Back");

            System.out.print("Enter choice: ");
            int choice = InputScanner.readInt();

            switch (choice) {
                case 1: medicalHistoryService.addMedicalHistory(); break;
                case 2: medicalHistoryService.viewMedicalHistory(); break;
                case 3: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
