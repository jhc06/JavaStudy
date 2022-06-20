package com.temp.movieTicket;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class SPersonalInfoManager {
    SPersonalInfo pi = new SPersonalInfo();
    Scanner scan = new Scanner(System.in);

    public void login() {
        while (true) {
            System.out.println("\tuser ID: ");
            pi.setUserID(scan.nextLine());
            if (!pi.getUserID().equals("root")) {
                System.out.println("Invalid user ID");
            } else {
                System.out.println("\tuser PW: ");
                pi.setUserPW(scan.nextLine());
                if (!pi.getUserPW().equals("password")) {
                    System.out.println("Invalid userPW");
                } else {
                    System.out.println("You are logged in.\r\n\n" + "\tWelcome " + pi.getUserID() + "!");
                    break;
                }
            }
        }
    }
    public void setReservationNumber() {
        pi.setReservationNumber((int) (Math.random() * 899999) + 100000);
    }
    public void SPrint(int row, int col) throws IOException {
        System.out.println("예약내용을 출력하시려면 yes를 입력하세요");
        String printCheck = scan.next();
        if (printCheck.equals("yes")) {
            LocalDateTime curDateTime = LocalDateTime.now();
            LocalDate now = LocalDate.now();
            File file = new File("C:/Users/user/Desktop/" + pi.getUserID() + pi.getReservationNumber() + "cinemaPrint.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write("=================================================\r\n");
            fw.write("<Movie Ticket >\r\n");
            fw.write(" Moive : " + "XXX" + "\r\n");
            fw.write(" ID : " + pi.getUserID() + "\r\n");
            fw.write(" PW : " + pi.getUserPW() + "\r\n");
            fw.write(" Reservation Number : " + pi.getReservationNumber() + "\r\n");
            fw.write(" Seat : " + (row) + "row" + (col) + "col" + "\r\n");
            fw.write("=================================================\r\n");
//            fw.write("number"+" "+"this is errorLog"+"  "+curDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"+"\r\n")));
            fw.flush();
            fw.close();
            System.out.println(System.lineSeparator() + "파일이 저장되었습니다@@");
//            fw.write(System.getProperty("line.separator"));
        }
    }
}

