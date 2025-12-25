/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hms;


public class Doctor extends Person<DoctorDetails>{
    
    Doctor(){this.metaData=new DoctorDetails();}
    Doctor(String name,int age,String gender,String CNIC,String specialization,int salary,Boolean isAvailable){
    super(name,age,gender,CNIC);
    this.metaData=new DoctorDetails(specialization,salary,isAvailable);
    }
    
    @Override
    public String displayInfoString(){
    String data =this.getName() + ","+this.getAge() + "," + this.getGender() + ","+this.getCNIC() + ","+this.metaData.specialization + ","+this.metaData.salary;
    return data;
    }
    @Override
    public String toString(){
    return getName();
    }
    public String getspecialization(){return this.metaData.specialization;}
    public int getsalary(){return this.metaData.salary;}
    public Boolean getisAvailable(){
        return this.metaData.isAvailable;
    }
}
