package com.JDBCPrj.prj220624;

public class LoginInfo {
    private String userID, userName, userPW;

    public LoginInfo(String userID, String userName, String userPW){
        this.userID = userID;
        this.userName = userName;
        this.userPW = userPW;
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
}
