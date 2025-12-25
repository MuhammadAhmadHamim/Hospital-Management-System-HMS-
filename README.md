# Hospital Management System (HMS)

A **JavaFX-based Hospital Management System** demonstrating **core OOP concepts** such as **inheritance, polymorphism, composition, aggregation, and generics**.
This project allows an admin to manage **patients, doctors, and appointments** efficiently through a **GUI interface**, making it a strong **portfolio-ready project**.

---

## Features

- **Admin Login & Authentication**  
  Secure login with predefined credentials.  

- **Patient Management**  
  Add, update, delete, and view patient records.  

- **Doctor Management**  
  Add, update, delete, and view doctor records.  

- **Appointment Scheduling**  
  Manage appointments between patients and doctors.

- **Billing**  
  Manage billing of diffrent patients.  

- **Dynamic Data Storage**  
  Uses **ObservableLists** to store data for real-time operations.

- **CSV based File Handling**  
  Uses **CSV** files to store data for future use.  

- **Modular OOP Design**  
  Classes are structured with **composition, aggregation, inheritance, and polymorphism** in mind.  

- **Interactive GUI**  
  JavaFX-based interface with login page, dashboard, and panels for different sections.  

---

## Technologies Used

- **Java 17+**  
- **JavaFX** for GUI  
- **ObservableList** for dynamic data management  
- **OOP Concepts**: Encapsulation, Inheritance, Polymorphism, Abstraction, Composition & Aggregation  
- **Generics & Interfaces** for flexible, reusable code  

## Project Structure

# src/
├─ App.java # Main application, launches GUI

# ├─ model/
│ ├─ Person.java
│ ├─ Patient.java
│ ├─ PatientDetails.java
│ ├─ Doctor.java
│ ├─ DoctorDetails.java
│ ├─ Appointment.java
│ ├─ Bill.java

# ├─ repository/
│ └─ Repository.java # Interface for CRUD operations
│ ├─ PatientRepository.java
│ ├─ DoctorRepository.java
│ ├─ AppointmentRepository.java

# ├─ service/
│ └─ Hospital.java # Core system logic, implements Repository

# └─ view/
│ ├─ Admin.java # Can only be accessed by Admin

│ | ├─ loginPage()
| | | ├─ createPatientTable()
| | | ├─ createDoctorTable()
| | | ├─ createAppointmentTable()

│ | ├─ dashBoard()
│ | | ├─ patientPanel()
│ | | ├─ doctorPanel()
│ | | ├─ appointmentPanel()
│ | | ├─ billingPanel()

## Usage

# Login with:

-> Username: admin
-> Password: 1234

# Navigate through Dashboard to manage:

- Patients
- Doctors
- Appointments
- Billing
  
# Perform CRUD operations for each entity.
## Project Structure

