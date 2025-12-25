/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hms;


public class PatientDetails {
    String disease;
    String phone;
    Bill bill;
    
    PatientDetails(){}
    PatientDetails(String disease,String phone,Bill bill){
    this.disease=disease;
    this.phone=phone;
    this.bill=bill;
    }    
}
