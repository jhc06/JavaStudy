package com.toyproject.miniproject1;

public class CinemaPersonalInfo {
    //    private int PN;
    public String userID;
    //    private String name;
    private String userPW;
    //    private String sex;
//    private int age;
//    private int telNumber;
//    private int phoneNumber;
    private int reservationNumber;


    //    public int getPn(){
//        return PN;
//    }
//    public void setPN(int pn){
//        this.PN = pn;
//    }
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
    public void showPersonalInfo(){
        System.out.println("ID: " + this.userID);
        System.out.println("PW: "+ this.userPW);
        System.out.println("Reservation Number: "+ this.reservationNumber);
    }
}


