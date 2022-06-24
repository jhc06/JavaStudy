package com.JDBCPrj;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private Connection con;
    private PreparedStatement pstat;
    private ResultSet rs;

    // DB와 연결하는 메소드
    public void getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##TEST","oracle");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public int login(String loginID,String loginPW){ // 인자값으로 아이디와 패스워드를 받아서 아이디 값에 해당하는 패스워드를 조회한다..
        try{
            pstat = con.prepareStatement(
                    "SELECT ID, PW FROM USERINFO WHERE ID = ?");
            pstat.setString(1, loginID);
            rs = pstat.executeQuery();
            ArrayList<AppController> IDPassword = new ArrayList<>();
            while(rs.next()){
                String userID = rs.getString("ID");
                String userPW = rs.getString("PW");
                IDPassword.add(new AppController(userID, userPW));
            }
            for(AppController infoObj :IDPassword){ // 컬럼 (id와 password)을 가지는 arraylist
                if(infoObj.getUserPW().equals(loginPW)){
                    System.out.println("일치사항 발견"); // 테스트 후 삭제
                    return 1; // 로그인 성공
                } else {
                    System.out.println("실패"); // 테스트후 삭제
                    return 0; // 로그인 실패
                }
            }
            return -1; // 아이디 없음
        } catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        return -2; // db 오류
    }

    // DB연결 끝고 Manager 종료 메소드
    public void close() {
        try {
            rs.close();
            pstat.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}

//    public void updateQuery(View view){
//        try {
//            pstat = con.prepareStatement(view.updateSQL);
//            pstat.executeUpdate();
//        } catch (Exception e) {
//            System.out.println("Error : " + e.getMessage());
//        }
//    }

//    public ArrayList<View> selectQuery(String sql) {
//        ArrayList<View> list = null;
//        try {
//            pstat = con.prepareStatement(sql);
//            rs = pstat.executeQuery();
//            list = new ArrayList<>();
//            while(rs.next()){
//                String name = rs.getString("NAME");
//                String userID = rs.getString("ID");
//                String userPW = rs.getString("PW");
//                list.add(new View(name, userID, userPW));
//            }
//        } catch (Exception e) {
//            System.out.println("Error : " + e.getMessage());
//        }
//        return list;
//    }