package com.JDBCPrj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DBManager {
    Scanner scan = new Scanner(System.in);
    private Connection con;
    private PreparedStatement pstat;
    private ResultSet rs;

    // DB와 연결하는 메소드
    public Connection getConnection(View view) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(view.getUrl(), view.getId(), view.getPW());
            System.out.println("---------------------------");
            System.out.println("연결되었습니다");
            System.out.println("---------------------------");
            System.out.print(System.lineSeparator());
            return con;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return null;
    }

    // select 시퀄문을 실행하는 메소드
    public void selectQuery(View view) {
//        String sql = "select " + view.select + " from " + view.from;
        try {
//            if (!(view.where == null)) {
//                sql += "" + " WHERE " + view.where;
//            } else if (!(view.groupBy == null)) {
//                sql += "" + " GROUP BY " + view.groupBy;
//            } else if (!(view.having == null)) {
//                sql += "" + " HAVING " + view.having;
//            } else if (!(view.orderBy == null)) {
//                sql += "" + " ORDER BY " + view.orderBy;
//            }
//            String num1=scan.nextLine();
//            String num2=scan.nextLine();

//            pstat = con.prepareStatement(sql);
//            pstat.setString(1,num1);
//            pstat.setString(2,num2);
            pstat = con.prepareStatement(view.selectSQL);

            rs = pstat.executeQuery();
            System.out.println("---------------------------");
            System.out.println("테이블을 조회했습니다");
            System.out.println("---------------------------");
        } catch (Exception e) {
            System.out.println("---------------------------");
            System.out.println("SQL문이 틀렸습니다.");
            System.out.println("---------------------------");
            System.out.println("Error : " + e.getMessage());
        }
    }
    public void createQuery(View view){
//        String sql = "CREATE TABLE USERINFO ( NAME VARCHAR2(10), ID VARCHAR2(10) PRIMARY KEY, PW VARCHAR2(10))";
        try {
            pstat = con.prepareStatement(view.createSQL);
            rs = pstat.executeQuery();
            System.out.println("---------------------------");
            System.out.println("테이블이 생성되었습니다.");
            System.out.println("---------------------------");
        } catch (Exception e) {
            System.out.println("---------------------------");
            System.out.println("SQL문이 틀렸습니다.");
            System.out.println("---------------------------");
            System.out.println("Error : " + e.getMessage());
        }
    }

    // 테이블 드랍 시퀄문 메소드.
    public void dropQuery(View view){
//        String sql = "DROP TABLE USERINFO";
        try {
            pstat = con.prepareStatement(view.dropSQL);
            rs = pstat.executeQuery();
            System.out.println("---------------------------");
            System.out.println("테이블이 삭제되었습니다.");
            System.out.println("---------------------------");
        } catch (Exception e) {
            System.out.println("---------------------------");
            System.out.println("SQL문이 틀렸습니다.");
            System.out.println("---------------------------");
            System.out.println("Error : " + e.getMessage());
        }
    }

    // 데이터 값을 입력하는 메소드
    public void insertQuery(View view){
//        String sql = "INSERT INTO USERINFO VALUES ('BOSS', 'boss', 'boss')";
        try {
            pstat = con.prepareStatement(view.insertSQL);
            rs = pstat.executeQuery();
            System.out.println("---------------------------");
            System.out.println("sql문이 실행되었습니다.");
            System.out.println("---------------------------");
        } catch (Exception e) {
            System.out.println("---------------------------");
            System.out.println("SQL문이 틀렸습니다.");
            System.out.println("---------------------------");
            System.out.println("Error : " + e.getMessage());
        }
    }

    // 커스텀 시퀄문을 입력하는 메소드
    public void customQuery(View view){
        try {
            pstat = con.prepareStatement(view.customSQL);
            rs = pstat.executeQuery();
            System.out.println("---------------------------");
            System.out.println("sql문이 실행되었습니다.");
            System.out.println("---------------------------");
        } catch (Exception e) {
            System.out.println("---------------------------");
            System.out.println("SQL문이 틀렸습니다.");
            System.out.println("---------------------------");
            System.out.println("Error : " + e.getMessage());
        }
    }

    // DB연결 끝고 Manager 종료 메소드
    public void close() {
        try {
            rs.close();
            pstat.close();
            con.close();
            System.out.println("정상적으로 종료되었습니다.");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    // select된 결과값을 출력하는 메소드. colNum은 출력할 컬럼 갯수.
    public void print(int colNum) {
        try {
            System.out.println("---------------------------");
            while (rs.next()) {
                for (int i = 0; i < colNum; i++) {
                    System.out.print(rs.getString(i+1) + "\t");
                }
                System.out.print(System.lineSeparator());
            }
            System.out.println("---------------------------");
            System.out.print(System.lineSeparator());
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}