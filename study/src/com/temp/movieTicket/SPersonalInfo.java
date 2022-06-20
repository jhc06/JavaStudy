package com.temp.movieTicket;

public class SPersonalInfo {
    private String userID;
    private String userPW;
    private int reservationNumber;

    public String getUserID(){
        return userID;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    public String getUserPW(){
        return userPW;
    }
    public void setUserPW(String userPW){
        this.userPW = userPW;
    }
    public int getReservationNumber(){
        return reservationNumber;
    }
    public void setReservationNumber(int reservationNumber){
        this.reservationNumber = reservationNumber;
    }
}
