package com.java.mybatis_prj;

public class Reservation implements Service{
    private Long reservationUid;
    private String movieName;
    private int seatNum;
    private String paymentMothod;
    private int price;
    private String userUid;
    private String reservationDate;

    public Reservation(Long reservationUid, String movieName, int seatNum, String paymentMothod, int price, String userUid, String reservationDate) {
        this.reservationUid = reservationUid;
        this.movieName = movieName;
        this.seatNum = seatNum;
        this.paymentMothod = paymentMothod;
        this.price = price;
        this.userUid = userUid;
        this.reservationDate = reservationDate;
    }

    public Long getReservationUid() {
        return reservationUid;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public String getPaymentMothod() {
        return paymentMothod;
    }

    public int getPrice() {
        return price;
    }

    public String getUserUid() {
        return userUid;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationUid(Long reservationUid) {
        this.reservationUid = reservationUid;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public void setPaymentMothod(String paymentMothod) {
        this.paymentMothod = paymentMothod;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }
}
