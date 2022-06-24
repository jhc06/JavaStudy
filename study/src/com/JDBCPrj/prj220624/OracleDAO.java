package com.JDBCPrj.prj220624;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OracleDAO {
    PreparedStatement ps;
    ResultSet rs;
    private Connection con;


    public Connection connect(){
       try{
           GetConnection gc = new GetConnection();
           this.con = gc.connect();
           return con;
       } catch (Exception e){
           System.out.println("Error : " + e.getMessage());
       }
       return con;
   }

    // Logininfo DB 데이터를 받아와서 객체에 저장 후 객체를 리턴한다.
    public ArrayList<LoginInfo> select() {
        ArrayList<LoginInfo> list = null;
        try {
            ps = con.prepareStatement("SELECT * FROM LOGININFO");
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String userID = rs.getString("userid");
                String userName = rs.getString("userName");
                String userpw = rs.getString("userpw");
                list.add(new LoginInfo(userID, userName, userpw));
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return list;
    }
    public int login(String id, String pw){
        try{
            ps = con.prepareStatement("SELECT userpw FROM logininfo WHERE USERID = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();

            while(rs.next()){
                if(pw.equals(rs.getString("USERPW"))){
                    return 1; // id와 일치하는 pw 발견. 로그인 성공 // 로그인된 main 화면으로 이동한다.
                }
            }
            return 0; // id와 일치하는 pw 없음. 로그인 실패. // 메뉴 초기화면으로 돌아간다;
        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            return -1; //아이디가 없거나 db 에러 // 로그파일로 데이터 전송
        }
    }
    public int loginChangeAccount(String id, String name, String pw, String newPw){ // ID,PW,Name 비교 후 NewPWe로 비밀번호 변경
        ArrayList<LoginInfo> dbData = select();
        try{
            for(LoginInfo info : dbData){
                if((id.equals(info.getUserID()))&&(name.equals(info.getUserName()))&&(pw.equals(info.getUserPW()))){
                    ps = con.prepareStatement("UPDATE LOGININFO SET USERPW = ? WHERE USERID = ?");
                    ps.setString(1, newPw);
                    ps.setString(2, id);
                    ps.executeUpdate();
                    ps = con.prepareStatement("COMMIT");
                    ps.executeUpdate();
                    return 1; // 정보 일치. 비밀번호 변경 성공
                }
            }
            return 0; //정보 불일치. 비밀번호 변경 실패. // 메뉴 초기화면으로 이동한다.
        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            return -1; // db 에러 // 로그파일로 데이터 전송
        }
    }
    public int loginCreateAccount(String id, String name, String pw){
        ArrayList<LoginInfo> dbData = select();
        try{
            for(LoginInfo info : dbData){
                if(id.equals(info.getUserID())){
                    return 0; // 아이디 중복, 가입 실패. // 경고창+재입력
                }
            }
            ps = con.prepareStatement("INSERT INTO LOGININFO (USERID, USERNAME, USERPW) VALUES(?, ?, ?)");
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3,pw);
            ps.executeUpdate();
            ps = con.prepareStatement("COMMIT");
            ps.executeUpdate();
            return 1; // 가입 완료. // 메뉴 초기화면으로 돌아간다;
        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            return -1; // db 에러 // 로그파일로 데이터 전송
        }
    }
    // id,name,pw를 입력받아 db 대조 후 일치 시 DB에서 삭제한다.
    public int loginCloseAccount(String id, String name, String pw){
        ArrayList<LoginInfo> dbData = select();

        try{
            for(LoginInfo info : dbData){
                if((id.equals(info.getUserID()))&&(name.equals(info.getUserName()))&&(pw.equals(info.getUserPW()))){
                    ps = con.prepareStatement("DELETE FROM LOGININFO  WHERE userID=?");
                    ps.setString(1,id);
                    ps.executeUpdate();
                    ps = con.prepareStatement("COMMIT");
                    ps.executeUpdate();
                    return 1; // 정보 일치. 계정 삭제 성공
                }
            }
            return 0; // 정보 불일치. 계정 삭제 실패 // 메뉴 초기화면으로 이동.
        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            return -1; // db 에러 // 로그파일로 데이터 전송
        }
    }
//    public void connectionClose() {
//        try {
//            ps = con.prepareStatement("COMMIT");
//            ps.executeUpdate();
//            System.out.println("3");
//            if(!(rs==null)){
//                rs.close();
//            }
//            ps.close();
//            con.close();
//        } catch (Exception e) {
//            System.out.println("Error : " + e.getMessage());
//        }
//    }
// -------------------------------------------> 종료 메소드는 포기;

}
