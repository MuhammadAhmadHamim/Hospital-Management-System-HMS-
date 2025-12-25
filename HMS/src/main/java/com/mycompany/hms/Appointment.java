/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hms;


public class Appointment {
    int appointmentID;
    static int counter=0;
    Patient patient;
    Doctor doctor;
    String date;
    
    Appointment(){appointmentID=++counter;}
    Appointment(Patient patient,Doctor doctor,String date){
    this();
    this.patient=patient;
    this.doctor=doctor;
    this.date=date;
    }
    
    public String generateSlipString(){
    String data=appointmentID + "," + patient.getName() + "," + doctor.getName() + "," + date;
    return data;
    }
}
