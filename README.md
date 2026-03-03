<div align="center">

<img width="100%" src="https://capsule-render.vercel.app/api?type=soft&color=0:1c0a00,40:3d1a00,100:1c0a00&height=200&section=header&text=Hospital%20Management%20System&fontSize=42&fontColor=f4a94e&fontAlignY=45&desc=JavaFX%20%7C%20OOP%20%7C%20Semester%202%20Project&descAlignY=68&descColor=d4813a&animation=twinkling&fontFamily=Georgia" alt="HMS Banner"/>

<br/>

![Java](https://img.shields.io/badge/Java-17%2B-f4a94e?style=for-the-badge&logo=openjdk&logoColor=black)
![JavaFX](https://img.shields.io/badge/JavaFX-GUI-3d1a00?style=for-the-badge&logo=openjdk&logoColor=f4a94e)
![OOP](https://img.shields.io/badge/OOP-Full%20Stack-d4813a?style=for-the-badge&logo=buffer&logoColor=white)
![Type](https://img.shields.io/badge/Type-Semester%20Project-1c0a00?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Complete-f4a94e?style=for-the-badge&logoColor=black)

<br/><br/>

> *"The art of medicine consists of amusing the patient while nature cures the disease."*
> — **Voltaire**

<br/>

</div>

---

## ◈ What This Is

A fully functional **Hospital Management System** built with **JavaFX** as the capstone project of Semester 2. This is not a toy app — it has real authentication, real CRUD operations across multiple entities, CSV-based persistence, and a layered OOP architecture that puts every concept from the semester to work.

Admin login. Patient records. Doctor records. Appointment scheduling. Billing. All wired together through a clean GUI and a properly designed backend.

---

## ◈ Feature Set

<details>
<summary><b>🔐 Admin Login and Authentication</b></summary>
<br/>
Secure entry point with predefined credentials. The entire system sits behind an admin login — nothing is accessible without authentication first.
</details>

<details>
<summary><b>🧑‍⚕️ Patient Management</b></summary>
<br/>
Full CRUD — add new patients, update existing records, delete entries, and view the complete patient list. Records are stored in ObservableLists for real-time UI updates and persisted to CSV for longevity.
</details>

<details>
<summary><b>👨‍⚕️ Doctor Management</b></summary>
<br/>
The same CRUD pipeline applied to doctor records. Each doctor entry includes detailed information managed through the Doctor and DoctorDetails model classes.
</details>

<details>
<summary><b>📅 Appointment Scheduling</b></summary>
<br/>
Links patients to doctors through appointment records. Appointments can be created, modified, and removed — demonstrating **composition** and **aggregation** between entities in practice.
</details>

<details>
<summary><b>💳 Billing</b></summary>
<br/>
A dedicated billing panel for managing patient invoices. Each Bill object is tied to a patient record, showing real-world **object relationships** in a working context.
</details>

<details>
<summary><b>💾 CSV File Handling and Dynamic Storage</b></summary>
<br/>
Data does not vanish when the program closes. **ObservableLists** keep the JavaFX tables in sync with live data, while **CSV files** act as the persistence layer — data survives between sessions.
</details>

---

## ◈ Architecture

```
src/
│
├── App.java                        ← Entry point, launches the JavaFX GUI
│
├── model/
│   ├── Person.java                 ← Base class (Inheritance root)
│   ├── Patient.java                ← Extends Person
│   ├── PatientDetails.java         ← Composition with Patient
│   ├── Doctor.java                 ← Extends Person
│   ├── DoctorDetails.java          ← Composition with Doctor
│   ├── Appointment.java            ← Aggregates Patient + Doctor
│   └── Bill.java                   ← Associated with Patient
│
├── repository/
│   ├── Repository.java             ← Interface defining CRUD contract
│   ├── PatientRepository.java      ← Implements Repository for Patient
│   ├── DoctorRepository.java       ← Implements Repository for Doctor
│   └── AppointmentRepository.java  ← Implements Repository for Appointment
│
├── service/
│   └── Hospital.java               ← Core logic, implements Repository
│
└── view/
    └── Admin.java                  ← Full GUI, admin-only access
        ├── loginPage()
        │   ├── createPatientTable()
        │   ├── createDoctorTable()
        │   └── createAppointmentTable()
        └── dashBoard()
            ├── patientPanel()
            ├── doctorPanel()
            ├── appointmentPanel()
            └── billingPanel()
```

---

## ◈ OOP Concepts Applied

```java
// Every concept from Semester 2 — used, not just studied.

// Inheritance — Person is the root
class Patient extends Person { ... }
class Doctor  extends Person { ... }

// Composition — Details live inside their owner
class Patient { private PatientDetails details; }

// Aggregation — Appointment holds references, not ownership
class Appointment { private Patient patient; private Doctor doctor; }

// Polymorphism — One interface, many implementations
class PatientRepository     implements Repository<Patient>     { ... }
class DoctorRepository      implements Repository<Doctor>      { ... }
class AppointmentRepository implements Repository<Appointment> { ... }

// Generics — Flexible, type-safe CRUD contract
interface Repository<T> {
    void add(T item);
    void update(T item);
    void delete(T item);
    List<T> getAll();
}
```

---

## ◈ Technologies

<div align="center">

| Technology | Role |
|:---:|:---|
| **Java 17+** | Core language |
| **JavaFX** | GUI framework — login page, dashboard, all panels |
| **ObservableList** | Real-time data binding between backend and UI |
| **CSV File I/O** | Persistent storage across sessions |
| **OOP Principles** | Encapsulation, Inheritance, Polymorphism, Abstraction, Composition, Aggregation |
| **Generics** | Type-safe Repository interface |
| **Interfaces** | Repository contract enforced across all entity types |

</div>

---

## ◈ How to Run

```bash
# Clone the repository
git clone https://github.com/MuhammadAhmadHamim/hospital-management-system.git
cd hospital-management-system
```

> **Recommended:** Open in **IntelliJ IDEA** or **Apache NetBeans**, add the JavaFX SDK under Project Structure as a library, then run `App.java` directly.

---

## ◈ Login Credentials

<div align="center">

```
┌─────────────────────────────┐
│                             │
│   Username  →   admin       │
│   Password  →   1234        │
│                             │
└─────────────────────────────┘
```

</div>

---

## ◈ Dashboard Navigation

**Patient Panel** — Add, view, update, delete patient records<br/>
**Doctor Panel** — Add, view, update, delete doctor records<br/>
**Appointment Panel** — Schedule and manage appointments between patients and doctors<br/>
**Billing Panel** — Generate and manage bills linked to patient records

All panels perform full CRUD and reflect changes in real time via ObservableList bindings.

---

## ◈ Skills This Project Demonstrates

<div align="center">

![](https://img.shields.io/badge/Java-Inheritance%20and%20Polymorphism-3d1a00?style=flat-square&logo=openjdk&logoColor=f4a94e)
![](https://img.shields.io/badge/Java-Composition%20and%20Aggregation-f4a94e?style=flat-square&logo=openjdk&logoColor=black)
![](https://img.shields.io/badge/Java-Generics%20and%20Interfaces-d4813a?style=flat-square&logo=openjdk&logoColor=white)
![](https://img.shields.io/badge/JavaFX-GUI%20Development-1c0a00?style=flat-square&logo=openjdk&logoColor=f4a94e)
![](https://img.shields.io/badge/Design-Layered%20Architecture-3d1a00?style=flat-square&logo=buffer&logoColor=f4a94e)
![](https://img.shields.io/badge/Storage-CSV%20Persistence-d4813a?style=flat-square&logo=files&logoColor=white)

</div>

---

## ◈ A Note on This Project

Every project before this one was an exercise. This was the first time everything came together — a system with moving parts, real relationships between objects, a user interface, and data that persists. It is the project that made OOP stop being theory.

---

<div align="center">

<img width="100%" src="https://capsule-render.vercel.app/api?type=soft&color=0:1c0a00,40:3d1a00,100:1c0a00&height=80&section=footer&text=Built%20with%20Java.%20Designed%20with%20purpose.&fontSize=16&fontColor=d4813a&fontAlignY=55&animation=twinkling" alt="footer"/>

</div>
