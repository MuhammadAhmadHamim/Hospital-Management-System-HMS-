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


public class PatientRepository implements Repository<Patient>{
    ObservableList<Patient> o1=FXCollections.observableArrayList();
    
    PatientRepository(){}
    
    @Override
    public void add(Patient p){o1.add(p);}
    
    @Override
    public void update(Patient p){
    for(int i=0;i<o1.size();i++){
    if(o1.get(i).getName().equals(p.getName()))
    {
     o1.set(i, p);
     break;
    }
    else{
     continue;}
    }
    }
    
    @Override
    public void delete(Patient p){
    for(int i=0;i<o1.size();i++){
    if(o1.get(i).getName().equals(p.getName()))
    {
     o1.remove(i);
    }
    else{
     continue;}
    }
    }
    
    @Override
    public ObservableList<Patient> getAll(){
     return o1;
    }
    
    @Override
    public Patient getById(int i){
    return o1.get(i-1);
    }
    
    @Override
public void saveToFile() {
    String filePath = "C:\\Users\\cr7hi\\OneDrive\\Documents\\NetBeansProjects\\HMS\\data\\PatientData.csv";
    try(PrintWriter pw = new PrintWriter(new FileWriter(filePath))){ 

        pw.println("Name,Age,Gender,CNIC,Disease,Phone,BillID,ServiceCharges,MedicineCharges,Total");

        for (Patient p : o1) {
            pw.println(p.getName() + "," +
                       p.getAge() + "," +
                       p.getGender() + "," +
                       p.getCNIC() + "," +
                       p.getdisease() + "," +
                       p.getphone() + "," +
                       p.getbillId() + "," +
                       p.getserviceCharges() + "," +
                       p.getmedicineCharges() + "," +
                       p.gettotal());
        }
        System.out.println("Patient data saved successfully!");
    } catch (IOException e) {
        System.out.println("Save failed!");
        e.printStackTrace();
    }
}
}

