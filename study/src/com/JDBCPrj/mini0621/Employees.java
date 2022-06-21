package com.JDBCPrj.mini0621;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Employees {
    Connection con;
    PreparedStatement pstat;
    ResultSet rs;

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##TEST","oracle");
            System.out.println("연결되었습니다");
            return con;
        } catch (Exception e) {
            System.out.print("DBConnection() : " + e.getMessage());
        }
        return null;
    }
    public void query(String sql) {
        try {
            pstat = con.prepareStatement(sql);
            rs = pstat.executeQuery();
        } catch (Exception e) {
            System.out.println("DB연결 실패하거나, SQL문이 틀렸습니다.");
            System.out.print("Error : " + e.getMessage());
        }
    }
    public void print(List arrayList){
        for (Object obj : arrayList) {
            System.out.println(obj);
        }
    }
    public void close() {
        try {
            rs.close();
            pstat.close();
            con.close();
            System.out.println("정상적으로 종료되었습니다.");
        } catch (Exception e) {
            System.out.print("Error : " + e.getMessage());
        }
    }
}
class run{
    public static void main(String[] args) {
        Employees em = new Employees();
        List<Integer> employeeID = new ArrayList<>();
        List<String> empName = new ArrayList<>();
        List<String> email = new ArrayList<>();


        em.getConnection();

        em.query("select employee_id, EMP_name, email from employees");
        try{
            while (em.rs.next()) {
                employeeID.add(em.rs.getInt(1));
                empName.add(em.rs.getString(2));
                email.add(em.rs.getString(3));
            }
            em.print(employeeID);
            em.print(empName);
            em.print(email);
        } catch (Exception e){
            System.out.print("Error : " + e.getMessage());
        }
        em.close();
    }
}

