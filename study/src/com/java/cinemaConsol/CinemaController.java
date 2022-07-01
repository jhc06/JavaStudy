package com.java.cinemaConsol;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CinemaController {
    int selectNum, row, col;
    String[][] seat = new String[5][5];
    Scanner scan = new Scanner(System.in);
    CinemaPersonalInfo cpi = new CinemaPersonalInfo();

    public void start() throws InterruptedException, IOException {
        System.out.println("---------------------------------");
        System.out.println("|     MOVIE RESERVATION SYSTEM   |");
        System.out.println("|                                |");
        System.out.println("---------------------------------");
        cinemaLogin();
        resetSeat();
        controller();
        selectNum();
        select();
    }

    public void controller() {
        System.out.println("\n1.Check seat 2.Reserve seat 3.Cancel seat 4.Sign up, 6.System shut down");
        System.out.print("Input a number of menu->\r\n");
    }

    public void cinemaLogin() {
        while (true) {
            System.out.println("\tuser ID: ");
            cpi.setUserID(scan.nextLine());
            if (!cpi.getUserID().equals("root")) {
                System.out.println("Invalid user ID");
            } else {
                System.out.println("\tuser PW: ");
                cpi.setUserPW(scan.nextLine());
                if (!cpi.getUserPW().equals("password")) {
                    System.out.println("Invalid userPW");
                } else {
                    System.out.println("You are logged in.\r\n\n" + "\tWelcome " + cpi.getUserID() + "!");
                    break;
                }
            }
        }
    }

    public void selectNum() {
        while (true) {
            while (true) {
                try {
                    selectNum = scan.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    e.printStackTrace();
                    scan = new Scanner(System.in);
                    System.out.println("잘못입력하셨습니다. 숫자를 입력하세요");
                    controller();
                }
            }
            if (!(this.selectNum >= 7) && !(this.selectNum <= 0)) {
                break;

            } else {
                System.out.println("잘못입력하셨습니다. 1번부터 6번까지의 숫자를 입력하세요.");
                controller();
            }
        }
    }

    public void select() throws InterruptedException, IOException {
        switch (selectNum) {
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
            case 5:
            case 6:
                cinemaQuit();
                break;
            default:
        }
    }

    //예약번호 생성 메소드. 중복된 번호가 나올가능성이 있음. DB에서 체크후 확인해야 할듯.
    //예약번호 생성 후 로그를 남긴 후 그 값과 대조하여 중복 시 재실행해야함;
    // 예약메소드. 예약시 예약번호 출력 및 프린트 기능 지원.
    public void resetSeat() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                seat[i][j] = "___";
            }
        }
    }

    public void cinemaSeatQuery() throws InterruptedException, IOException {
        char row = 'A';
        for (int i = 0; i < 5; i++) {
            System.out.print(row + " Line: ");
            row++;
            for (int j = 0; j < 5; j++) {
                String seat = (this.seat[i][j].equals("___")) ? "◻" : "◼";
                System.out.print((j + 1) + seat + "  ");
            }
            System.out.print(System.lineSeparator());
        }
        TimeUnit.SECONDS.sleep(2);

    }

    public void reserveTicket() throws InterruptedException, IOException {
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

    public void cinemaCancel() {
        while (true) {
            try {
                System.out.println("Input your reservation number");
                cpi.setReservationNumber(scan.nextInt());
                seat[row - 1][col - 1] = "___";
                System.out.print(System.lineSeparator());
                System.out.println("We canceled your reservation");
            } catch (InputMismatchException e) {
                scan = new Scanner(System.in);
                System.out.println("Invalid reservation Number. Check your reservation number.");
            }
            if (!(cpi.getReservationNumber() < 100000 | cpi.getReservationNumber() >= 1000000)) {
                break;
            } else {
                System.out.println("Invalid reservation Number. Check your reservation number(six digit).");
            }
        }
    }

    public void cinemaPrint() throws IOException{
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
            fw.write(" Seat : " + (row) + "row" + (col) + "col" + "\r\n");
            fw.write("=================================================\r\n");
//            fw.write("number"+" "+"this is errorLog"+"  "+curDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"+"\r\n")));
            fw.flush();
            fw.close();
            System.out.println(System.lineSeparator() + "파일이 저장되었습니다@@");
//            fw.write(System.getProperty("line.separator"));
        }
    }

    public void setReservationNumber() {
        cpi.setReservationNumber((int) (Math.random() * 899999) + 100000);
    }

    public void cinemaQuit() {
        System.out.println("The system has shut down");
    }
}
