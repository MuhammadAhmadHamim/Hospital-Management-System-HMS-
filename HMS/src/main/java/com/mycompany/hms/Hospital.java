/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hms;



public class Hospital{
    PatientRepository patientRepo;
    DoctorRepository doctorRepo;
    AppointmentRepository appointmentRepo;
    
    Hospital(){
    this.patientRepo=new PatientRepository();
    this.doctorRepo=new DoctorRepository();
    this.appointmentRepo=new AppointmentRepository();
    }
}
