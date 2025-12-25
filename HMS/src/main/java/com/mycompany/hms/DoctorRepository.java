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


public class DoctorRepository implements Repository<Doctor>{
    ObservableList<Doctor> o2=FXCollections.observableArrayList();
    
    DoctorRepository(){}
    
    @Override
    public void add(Doctor d){o2.add(d);}
    
    @Override
    public void update(Doctor d){
    for(int i=0;i<o2.size();i++){
    if(o2.get(i).getName().equals(d.getName()))
    {
     o2.set(i, d);
    }
    else{
     continue;}
    }
    }
    
    @Override
    public void delete(Doctor d){
    for(int i=0;i<o2.size();i++){
    if(o2.get(i).getName().equals(d.getName()))
    {
     o2.remove(i);
    }
    else{
     continue;}
    }
    }
    
    @Override
    public ObservableList<Doctor> getAll(){
    return o2;
    }
    
    @Override
    public Doctor getById(int i){
    return o2.get(i-1);
    }
    
    @Override
public void saveToFile() {
    String filePath = "C:\\Users\\cr7hi\\OneDrive\\Documents\\NetBeansProjects\\HMS\\data\\DoctorData.csv";
    try(PrintWriter pw = new PrintWriter(new FileWriter(filePath))){
        
        pw.println("Name,Age,Gender,CNIC,Specialization,Salary,Availability");

        for (Doctor d : o2) {
            pw.println(d.getName() + "," +
                       d.getAge() + "," +
                       d.getGender() + "," +
                       d.getCNIC() + "," +
                       d.getspecialization() + "," +
                       d.getsalary() + "," +
                       d.getisAvailable());
        }
        System.out.println("Doctor data saved successfully!");
    } catch (IOException e) {
        System.out.println("Save failed!");
        e.printStackTrace();
    }
}
}
