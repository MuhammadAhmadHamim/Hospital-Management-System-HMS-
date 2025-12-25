/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.hms;

import javafx.collections.ObservableList;


public interface Repository<R>{
    public void add(R r1);
    public void update(R r1);
    public void delete(R r1);
    public ObservableList<R> getAll();
    public R getById(int i);
    void saveToFile();
}
