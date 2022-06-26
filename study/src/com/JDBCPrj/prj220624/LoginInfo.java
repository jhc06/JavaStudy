package com.JDBCPrj.prj220624;

public class LoginInfo {
    private String userID, userName, userPW;
    private String userNewPW;

    public LoginInfo(String userID, String userName, String userPW){ // 로그인 DB 정보 전체 객체 생성용
        this.userID = userID;
        this.userName = userName;
        this.userPW = userPW;
    }

    public LoginInfo(String userID, String userName, String userPW, String userNewPW){ // Client로부터 입력된 정보 객체 생성용.
        this.userID = userID;
        this.userName = userName;
        this.userPW = userPW;
        this.userNewPW = userNewPW;
    }

    public String getUserID(){
        return userID;
    }
    public String getUserName(){
        return userName;
    }
    public String getUserPW(){
        return userPW;
    }
    public String getUserNewPW(){
        return userNewPW;
    }
}
