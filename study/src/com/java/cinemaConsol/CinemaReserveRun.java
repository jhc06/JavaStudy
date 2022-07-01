package com.java.cinemaConsol;

import java.io.IOException;

public class CinemaReserveRun {
    public static void main(String args[]) throws InterruptedException, IOException {
//        CinemaReserve.Builder bl = new CinemaReserve().new Builder();
        // static 내부클래스라면 CinemaReserve.Builder bl = new Builder(); 라고 선언;
        createCinemaReserve();
    }
    public static void createCinemaReserve() throws InterruptedException, IOException {
        CinemaReserve cr = new CinemaReserve();
//        CinemaReserve.Builder bl = new CinemaReserve().new Builder();
        // static 내부클래스라면 CinemaReserve.Builder bl = new Builder(); 라고 선언;
        cr.start();
//        System.out.println(cr.userId);
    }
}
