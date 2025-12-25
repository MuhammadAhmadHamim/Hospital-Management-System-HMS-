/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hms;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class AppointmentRepository implements Repository<Appointment>{
    ObservableList<Appointment> o3=FXCollections.observableArrayList();
    
    AppointmentRepository(){}
    
    @Override
    public void add(Appointment a){o3.add(a);}
    
    @Override
    public void update(Appointment a){
    for(int i=0;i<o3.size();i++){
    if(o3.get(i).appointmentID==a.appointmentID)
    {
     o3.set(i, a);
    }
    else{
     continue;}
    }
    }
    
    @Override
    public void delete(Appointment a){
    for(int i=0;i<o3.size();i++){
    if(o3.get(i).appointmentID==a.appointmentID)
    {
     o3.remove(i);
    }
    else{
     continue;}
    }
    }
    
    @Override
    public ObservableList<Appointment> getAll(){
    return o3;
    }
    
    @Override
    public Appointment getById(int i){
    return o3.get(i-1);
    }
    
    @Override
public void saveToFile() {
    String filePath = "C:\\Users\\cr7hi\\OneDrive\\Documents\\NetBeansProjects\\HMS\\data\\AppointmentData.csv";
    try(PrintWriter pw = new PrintWriter(new FileWriter(filePath))){
        
        pw.println("AppointmentID,PatientName,DoctorName,Date");

        for (Appointment a : o3) {
            pw.println(a.appointmentID + "," +
                       a.patient.getName() + "," +
                       a.doctor.getName() + "," +
                       a.date);
        }
        System.out.println("Appointment data saved successfully!");
    } catch (IOException e) {
        System.out.println("Save failed!");
        e.printStackTrace();
    }
}
}
