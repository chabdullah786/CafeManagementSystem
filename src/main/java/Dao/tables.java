/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.PreparedStatement;

/**
 *
 * @author chabd
 */
public class tables {

    public static void main(String[] args) {
        //we can write a query to add tables in db
        String userTable = "create table user(id int NOT NULL AUTO_INCREMENT PRIMARY KEY,name varchar(200),email varchar(200),mobileNumber varchar(200),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE (email))";
        String categoryTable = "create table category (id int AUTO_INCREMENT primary key, name varchar(200) )";
        String productTable = "create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
        String billTable = "create table bill (id int primary key, name varchar(200),mobileNumber varchar(200),email varchar(200),date varchar(50),total varchar(200),createBy varchar(200) )";
        dbOperations.setDataorDelete(userTable, "User Table Created Successfully.");
        dbOperations.setDataorDelete(categoryTable, "Category Table Created Successfully.");
        dbOperations.setDataorDelete(productTable, "Product Table Created Successfully.");
        dbOperations.setDataorDelete(billTable, "Bill Table Created Successfully.");
    }
}
