package com.JDBCPrj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
    private Connection con;
    private PreparedStatement pstat;
    private ResultSet rs;

    public Connection getConnection(View view) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(view.getUrl(), view.getId(), view.getPW());
            System.out.println("연결되었습니다");
            return con;
        } catch (Exception e) {
            System.out.print("DBConnection() : " + e.getMessage());
        }
        return null;
    }
    //update: 조회문(select, show 등)을 제외한 create, drop, insert, delete, update 등등 문을 처리할 때 사용한다.
//Query:  조회문(select, show 등)을 실행할 목적으로 사용한다.
    public void selectQuery(View view) {
        String sql = "select " + view.select + " from " + view.from;
        try {
            pstat = con.prepareStatement(sql);
            if (!(view.where == null)) {
                sql += "" + " WHERE " + view.where;
            } else if (!(view.groupBy == null)) {
                sql += "" + " GROUP BY " + view.groupBy;
            } else if (!(view.having == null)) {
                sql += "" + " HAVING " + view.having;
            } else if (!(view.orderBy == null)) {
                sql += "" + " ORDER BY " + view.orderBy;
            }
            pstat = con.prepareStatement(sql);
            rs = pstat.executeQuery();
            System.out.println("테이블을 조회했습니다");
        } catch (Exception e) {
            System.out.println("DB연결 실패하거나, SQL문이 틀렸습니다.");
            System.out.print("Error : " + e.getMessage());
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

    public void print(int colNum) {
        try {
            while (rs.next()) {
                for (int i = 0; i < colNum; i++) {
                    System.out.print(rs.getString(i + 1) + "\t");
                }
                System.out.print(System.lineSeparator());
            }
        } catch (Exception e) {
            System.out.print("Error : " + e.getMessage());
        }
    }

//    public void sales(int soldIndex, int amountIndex) {
//        try {
//            int sold = rs.getInt(soldIndex);
//            int amount = rs.getInt(amountIndex);
//            int totalSales = sold * amount;
//        } catch (Exception e) {
//            System.out.print("Error : " + e.getMessage());
//        }
//    }
//
//    public void insert(String insertInto, String select, String from, String where, String orderBy) {
//        try {
//            String sql = "INSERT INTO " + insertInto + " SELECT " + select + " FROM " + from;
//            if (!(where == null)) {
//                sql += " " + "WHERE " + where;
//            } else if (!(orderBy == null)) {
//                sql += " " + "ORDER BY " + orderBy;
//            }
//            pstat = con.prepareStatement(sql);
//            rs = pstat.executeQuery();
//        } catch (Exception e) {
//            System.out.println("DB연결 실패하거나, SQL문이 틀렸습니다.");
//            System.out.print("Error : " + e.getMessage());
//        }
//    }
}