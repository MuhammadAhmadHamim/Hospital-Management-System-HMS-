/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hms;


public class Admin {
    private  String username;
    private  String password;

    Admin(){}
    Admin(String username,String password){
        this.username=username;
        this.password=password;
    }
    
    public void setUsername(String username){this.username=username;}
    public void setPassword(String password){this.password=password;}
    
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
    
    public void displayInfo(){
    System.out.println("Username:"+this.username);
    System.out.println("Password:"+this.password);
    }
}
