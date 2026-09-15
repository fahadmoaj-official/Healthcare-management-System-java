package com.hospital.service;

import com.hospital.model.Department;
import com.hospital.repository.HospitalDatabase;
import com.hospital.util.ConsolePrinter;
import com.hospital.util.InputScanner;

import java.util.List;

public class DepartmentService {

    private final HospitalDatabase db = HospitalDatabase.getInstance();

    public void addDepartment() {
        System.out.print("Department name: ");
        String name = InputScanner.readString();

        System.out.print("Head Doctor: ");
        String head = InputScanner.readString();

        int newId = db.generateDepartmentId();
        Department d = new Department(newId, name, head);
        db.getDepartments().add(d);

        System.out.println("Department added successfully!");
    }

    public void viewDepartments() {
        List<Department> departments = db.getDepartments();

        if (departments.isEmpty()) {
            System.out.println("No departments found.");
            return;
        }

        for (Department d : departments) {
            ConsolePrinter.printDivider();
            System.out.println("Department ID : " + d.getId());
            System.out.println("Name          : " + d.getName());
            System.out.println("Head Doctor   : " + d.getHeadDoctor());
        }
    }
}
