/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hms;


public class Bill {
    static int counter=0;
    int billId;
    int serviceCharges;
    int medicineCharges;
    int total;
    
    Bill(){billId=++counter;}
    Bill(int serviceCharges,int medicineCharges){
    this();
    this.serviceCharges=serviceCharges;
    this.medicineCharges=medicineCharges;
}
    void calculateTotal(){
        this.total=this.serviceCharges+this.medicineCharges;
    }
    public String displayBillString(){
        String data=this.billId + ","+this.serviceCharges + ","+this.medicineCharges + ","+this.total;
        return data;
    }
}
