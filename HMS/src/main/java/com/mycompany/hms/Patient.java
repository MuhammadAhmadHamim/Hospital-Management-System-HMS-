/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hms;


public class Patient extends Person<PatientDetails>{
    
    Patient(){this.metaData=new PatientDetails();}
    Patient(String name,int age,String gender,String CNIC,String disease,String phone,Bill bill){
    super(name,age,gender,CNIC);
    this.metaData=new PatientDetails(disease,phone,bill);
    }
    
    @Override
    public String displayInfoString(){
    String data=this.getName() + ","+this.getAge() + ","+this.getGender() + ","+this.getCNIC() + ","+this.metaData.disease + ","+this.metaData.phone + ","+this.metaData.bill.displayBillString();
    return data;}
    @Override
    public String toString(){return this.getName();}
    public String getdisease(){return this.metaData.disease;}
    public String getphone(){return this.metaData.phone;}
    public int getbillId(){return this.metaData.bill.billId;}
    public int getmedicineCharges(){return this.metaData.bill.medicineCharges;}
    public int getserviceCharges(){return this.metaData.bill.serviceCharges;}
    public int gettotal(){return this.metaData.bill.total;}
}
