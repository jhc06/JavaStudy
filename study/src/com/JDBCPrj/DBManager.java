package com.JDBCPrj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
    private Connection con;
    private PreparedStatement pstat;
    private ResultSet rs;

    public Connection getConnection(String url, String id, String pw) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, id, pw);
//            System.out.println(con.isClosed()? "접속안됨": "접속됨");
//            return이면 메소드가 끝난다.
            return con;
        } catch (Exception e) {
            System.out.print("DBConnection() : " + e.getMessage());
        }
        return null;
    }
    public void query(String sql){
        try{
            pstat = con.prepareStatement(sql);
            rs =pstat.executeQuery();
        }catch (Exception e){
            System.out.println("DB연결 실패하거나, SQL문이 틀렸습니다.");
            System.out.print("Error : " + e.getMessage());
        }
    }

    public void query1(String select, String from, String where, String orderBy){
        try{
            String sql = "SELECT "+ select + " FROM " + from;
            if(!(where==null)){
                sql+=" "+"WHERE "+where;
            } else if (!(orderBy==null)) {
                sql+=" "+"ORDER BY "+orderBy;
            }
            pstat = con.prepareStatement(sql);
            rs =pstat.executeQuery();
        }catch (Exception e){
            System.out.println("DB연결 실패하거나, SQL문이 틀렸습니다.");
            System.out.print("Error : " + e.getMessage());
        }
    }

    public void close(){
        try{
            rs.close();
            pstat.close();
            con.close();
        }catch (Exception e){
            System.out.print("Error : " + e.getMessage());
        }
    }
    public void print(int colNum){
        try{
            while(rs.next()){
                for(int i=0; i<colNum; i++){
                    System.out.print(rs.getString(i+1)+"\t");
                }
                System.out.print(System.lineSeparator());
            }
        }catch (Exception e){
            System.out.print("Error : " + e.getMessage());
        }
    }
}

//update: 조회문(select, show 등)을 제외한 create, drop, insert, delete, update 등등 문을 처리할 때 사용한다.
//Query:  조회문(select, show 등)을 실행할 목적으로 사용한다.

    // prepareStatement sql문 사용 예시
//    public void select(String tableName, String colName, String targetName, String colName2, String targetName2){
//        String sql = "select * from "+tableName+" where "+colName+"= ? and "+ colName2+" = ?";
//        try{
//        pstmt = con.prepareStatement(sql);

    //            //setInt(?순서, 입력 data); setString(?순서, "입력 data");
//            //set타입은 작성한 SQL문에 있는 ? 라는 값을 바꿔주는 역할이다 *중요*
//            //조건을 더해서 쿼리하는 용도
//        pstmt.setString(1, targetName);
//        pstmt.setString(2, targetName2);
//
//        rs =pstmt.executeQuery();
//        System.out.println("테이블을 조회했습니다");
//
//        while(rs.next()){
//            System.out.println(rs.getString(1) + "\t"+rs.getString(2));
//        }
//
//        rs.close();
//        pstmt.close();
//        con.close();
//        } catch(Exception e){
//            System.out.println("DB연결 실패하거나, SQL문이 틀렸습니다.");
//            System.out.print("Error : " + e.getMessage());
//        }
//    }


