/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hms;


public abstract class Person<T>{
    private String name;
    private int age;
    private String gender;
    private String CNIC;
    protected T metaData;
    
    Person(){}
    Person(String name,int age,String gender,String CNIC){
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.CNIC=CNIC;
    }
    Person(Person p){
    this.name=p.name;
    this.age=p.age;
    this.gender=p.gender;
    this.CNIC=p.CNIC;
    }
    
    void setName(String name){this.name=name;}
    void setAge(int age){this.age=age;}
    void setGender(String gender){this.gender=gender;}
    void setCNIC(String CNIC){this.CNIC=CNIC;}
    
    public String getName(){return this.name;}
    public int getAge(){return this.age;}
    public String getGender(){return this.gender;}
    public String getCNIC(){return this.CNIC;}
    
    void setMetaData(T metaData){this.metaData=metaData;}
    T getMetaData(){return this.metaData;}
    
    public abstract String displayInfoString();
}
