package com.toyproject.miniproject1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Reserveticket {
    int row, col, selectNum;
    Scanner scan = new Scanner(System.in);
    String[][] seat = new String[5][5];
    CinemaPersonalInfo cpi = new CinemaPersonalInfo();


    public void start() throws InterruptedException, IOException {
        System.out.println("---------------------------------");
        System.out.println("|     MOVIE RESERVATION SYSTEM   |");
        System.out.println("|                                |");
        System.out.println("---------------------------------");
        resetSeat();
        controller();
        selectNum();
        select();
    }
    public void resetSeat() {
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                seat[i][j] = "___";
            }
        }
    }
    public void controller(){
        System.out.println("\n1.Check seat 2.Reserve seat 3.Cancel seat 4.System shut down");
        System.out.print("Input a number of menu->\r\n");
    }
    public void selectNum(){
        while(true){
            while(true){
                try{
                    selectNum=scan.nextInt();
                    break;
                }
                catch(InputMismatchException e){
                    e.printStackTrace();
                    scan = new Scanner(System.in);
                    System.out.println("잘못입력하셨습니다. 숫자를 입력하세요");
                    controller();
                }
            }
            if( !(this.selectNum >= 5) && !(this.selectNum<=0)){
                break;

            } else{
                System.out.println("잘못입력하셨습니다. 1번부터 4번까지의 숫자를 입력하세요.");
                controller();
            }
        }
    }
    public void select() throws InterruptedException, IOException {
        switch(selectNum){
            case 1:
                cinemaSeatQuery();
                controller();
                selectNum();
                select();
                break;
            case 2:
                reserveTicket();
                controller();
                selectNum();
                select();
                break;
            case 3:
                cinemaCancel();
                controller();
                selectNum();
                select();
                break;
            case 4:
                cinemaQuit();
                break;
            default:
        }
    }

    public void reserveTicket() throws IOException, InterruptedException {
        while(true) {
            while (true) {
                try {
                    System.out.println("행을 입력하세요(max:5)");
                    row = scan.nextInt();
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    scan = new Scanner(System.in);
                    System.out.println("최대 5까지 입력하시길 바랍니다.");
                }
                if ((this.row <= 5 && this.row > 0)) {
                    break;
                } else {
                    System.out.println("에러: 행과 열은 최대 5까지입니다.");
                }
            }
            while (true) {
                try {
                    System.out.println("열을 입력하세요(max:5)");
                    col = scan.nextInt();
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException f) {
                    f.printStackTrace();
                    scan = new Scanner(System.in);
                    System.out.println("최대 5까지 입력하시길 바랍니다.");
                }
                if ((this.col <= 5 && this.col > 0)) {
                    break;
                } else {
                    System.out.println("에러: 행과 열은 최대 5까지입니다.");
                }
            }
            if ((seat[row - 1][col - 1]).equals("___")) {
                //            seat[row-1][col-1] = pi.getUserID();
                seat[row - 1][col - 1] = "reserved";
                setReservationNumber();
                System.out.println("Reservation Number: " + cpi.getReservationNumber() + "\r\n" + (row) + "행" + (col) + "열 좌석이 예약되었습니다.");
                cinemaPrint();
                break;
            } else {
                System.out.println("이미 예약된 좌석입니다");
                cinemaSeatQuery();
            }
        }
    }
    public void cinemaSeatQuery() throws InterruptedException, IOException {
        char row = 'A';
        for(int i=0; i<5; i++){
            System.out.print(row +" Line: ");row++;
            for(int j=0; j<5; j++){
                String seat = (this.seat[i][j].equals("___"))? "X": "O";
                System.out.print((j+1)+seat +"  ");
            }
            System.out.print(System.lineSeparator());
        }
        TimeUnit.SECONDS.sleep(2);
    }
    public void cinemaCancel() {
        while(true){
            try{
                System.out.println("Input your reservation number");
                cpi.setReservationNumber(scan.nextInt());
                seat[row-1][col-1] = "___";
                System.out.print(System.lineSeparator());
                System.out.println("We canceled your reservation");
            } catch (InputMismatchException e){
                scan = new Scanner(System.in);
                System.out.println("Invalid reservation Number. Check your reservation number.");
            }
            if(!(cpi.getReservationNumber()<100000 | cpi.getReservationNumber()>=1000000)){
                break;
            } else{
                System.out.println("Invalid reservation Number. Check your reservation number(six digit).");
            }
        }

    }
    public void cinemaPrint() throws IOException, InterruptedException {
        System.out.println("예약내용을 출력하시려면 yes를 입력하세요");
        String printCheck = scan.next();
        if (printCheck.equals("yes")) {
            LocalDateTime curDateTime = LocalDateTime.now();
            LocalDate now = LocalDate.now();
            File file = new File("C:/Users/user/Desktop/" + cpi.getUserID() + cpi.getReservationNumber() + "cinemaPrint.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write("=================================================\r\n");
            fw.write("<Movie Ticket >\r\n");
            fw.write(" Moive : " + "XXX" + "\r\n");
            fw.write(" ID : " + cpi.getUserID() + "\r\n");
            fw.write(" PW : " + cpi.getUserPW() + "\r\n");
            fw.write(" Reservation Number : " + cpi.getReservationNumber() + "\r\n");
            fw.write(" Seat : " + (row) + "행" + (col) + "열" + "\r\n");
            fw.write("=================================================\r\n");
            fw.flush();
            fw.close();
            System.out.println(System.lineSeparator() + "파일이 저장되었습니다@@");

        }
    }
    public void setReservationNumber() {
        cpi.setReservationNumber((int) (Math.random() * 899999) + 100000);
    }
    public void cinemaQuit() {
        System.out.println("The system has shut down");
    }

//
//    @Override
//    public void Close() {
//        // TODO Auto-generated method stub
//
//    }
//    @Override
//    public void LogIn(String id,int password) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void ReserveTicket()  {
//
//    }
//
//    @Override
//    public void CancleTicket() {
//        // TODO Auto-generated method stub
//
//    }

}
