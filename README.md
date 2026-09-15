# Hospital Management System (Java OOP)

A modular, enterprise-structured Hospital Management System built with Core Java following the 4 Pillars of Object-Oriented Programming (OOP) and Layered Architecture.

---

## 🌟 Key Features
1. **Patient Management** (Add, View, Update, Delete)
2. **Doctor Management & Availability**
3. **Appointment System** (Booking & Cancellations)
4. **Prescription System**
5. **Medical Test System** (Lab Tests & Results)
6. **Billing & Payment System**
7. **Room & Bed Allocation System**
8. **Emergency Patient Queue & Triage**
9. **Department Management**
10. **Medical History System**
11. **Hospital Statistics & Analytics**
12. **Admin Authentication System**

---

## 🏗️ Project Architecture

```
src/
└── com/hospital/
    ├── Main.java                         (Application Entry Point)
    ├── model/                            (Data Models: Person, Patient, Doctor, etc.)
    ├── repository/                       (HospitalDatabase In-Memory Persistence)
    ├── service/                          (Business Logic Layer & HospitalService Interface)
    ├── ui/                               (Console Banners & Interactive Menus)
    └── util/                             (InputScanner & ConsolePrinter Utilities)
```

---

## 💻 How to Build & Run

### Prerequisites
- JDK 11 or higher installed (`java -version`, `javac -version`)

### Execution Commands

```bash
# 1. Compile all Java source files
mkdir -p out/production
javac -d out/production $(find src -name "*.java")

# 2. Run the application
java -cp out/production com.hospital.Main
```

### Default Login Credentials
- **Username**: `admin`
- **Password**: `1234`
