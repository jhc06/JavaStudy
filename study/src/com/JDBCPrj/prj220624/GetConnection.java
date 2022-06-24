package com.JDBCPrj.prj220624;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
    private Connection con;


    public Connection connect(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##TEST","oracle");
        } catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return con;
    }
}
