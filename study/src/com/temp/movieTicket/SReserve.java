package com.temp.movieTicket;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SReserve{
    int row, col;
    Scanner scan = new Scanner(System.in);
    SPersonalInfoManager pim = new SPersonalInfoManager();
    SQuerySeat qs = new SQuerySeat();
    public void reserve(String[][] seat) throws IOException, InterruptedException {
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
                pim.setReservationNumber();
                seat[row - 1][col - 1] = String.valueOf((pim.pi.getReservationNumber()));
                System.out.println("Reservation Number: " + pim.pi.getReservationNumber() + "\r\n" + (row) + "행" + (col) + "열 좌석이 예약되었습니다.");
                pim.SPrint(row, col);
                break;
            } else {
                System.out.println("이미 예약된 좌석입니다");
                qs.seatQuery(seat);
            }
        }
    }
    public void cancel(String[][] seat) {
        Scanner scan = new Scanner(System.in);
        String checkReservationNumber;
        int row = 0;
        int col = 0;
        // row, col은 지역변수. 예약번호를 찾아서 변수로 초기화한다.
        // 지역변수는 미초기화시 에러, 멤버변수는 null값으로 초기화;
        while (true) {
            try {
                System.out.println("Input your reservation number");
                checkReservationNumber = scan.nextLine();
                for(int i=0; i<5; i++){
                    for(int j=0; j<5; j++){
                        if(seat[i][j].equals(checkReservationNumber)){
                            row =i+1;
                            col= j+1;
//                            System.out.println(seat[row - 1][col - 1]);
                            seat[row - 1][col - 1] = "___";
//                            System.out.println(seat[row - 1][col - 1]);
                        }
                    }
                }
            } catch (InputMismatchException e) {
                scan = new Scanner(System.in);
                System.out.println("Invalid reservation Number. Check your reservation number.");
            }
            if ((pim.pi.getReservationNumber() < 100000 | pim.pi.getReservationNumber() >= 1000000)) {
                System.out.println("Invalid reservation Number. Check your reservation number(six digit).");
            }

            if(!(row == 0 || col == 0)){
                System.out.print(System.lineSeparator());
                System.out.println("We canceled your reservation");
                break;
            }else{
                System.out.println("We can't fine your reservation number");
                System.out.print(System.lineSeparator());
            }
        }
    }
}
