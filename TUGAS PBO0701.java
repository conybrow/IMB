/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//open using netbeans
package com.mycompany.pbo07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author evfi2
 */
public class PBO0701 {
    

    public static void main(String[] args) {
        
        PBO0701 run = new PBO0701();
        run.dbconnection();
    }
    
    
    public void dbconnection(){
        Connection connection = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/classicmodels",
                "root", "");
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultset;
            resultset = statement.executeQuery
                ("select * from customers");
            String firstname;
            String lastname;
            while(resultset.next()){
            firstname = resultset.getString("customerName");
            lastname = resultset.getString("addressLine1");
            System.out.println("Name : "+firstname+" "+lastname);
            }
            resultset.close();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
            }
    }   
}
