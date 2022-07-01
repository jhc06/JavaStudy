package com.java.cinemaConsol;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CinemaReserve {

    int row, col, selectNum;
    Scanner scan = new Scanner(System.in);
    String userId;
    String userPw;
    String[][] seat = new String[5][5];
    public CinemaReserve(){
    }
    public void start() throws InterruptedException, IOException {
        System.out.println("---------------------------------");
        System.out.println("|      00영화 예약시스템입니다.     |");
        System.out.println("|                               |");
        System.out.println("---------------------------------");
        cinemaLogin();
        resetSeat();
        System.out.println("\n1.조회 2.예약 3.예약자취소 4.관리자취소, 6.종료(기능)");
        System.out.println("\t원하시는 서비스를 선택해주세요");
        selectNum();
        select();
    }
    public void controller() throws InterruptedException, IOException {
        System.out.println("\n1.조회 2.예약 3.예약자취소 4.관리자취소, 6.종료(기능)");
        System.out.print("원하시는 서비스를 선택해주세요->\r\n");
        selectNum();
        select();

    }
    public void resetSeat(){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                seat[i][j] = "___";
            }
        }
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
                    System.out.println("\n1.조회 2.예약 3.예약자취소 4.관리자취소, 6.종료(기능)");
                    System.out.print("원하시는 서비스를 선택해주세요->\r\n");
                }
            }
            if( !(this.selectNum >= 7) && !(this.selectNum<=0)){
                break;

            } else{
                System.out.println("잘못입력하셨습니다. 1번부터 6번까지의 숫자를 입력하세요.");
                System.out.println("\n1.조회 2.예약 3.예약자취소 4.관리자취소, 6.종료(기능)");
                System.out.print("원하시는 서비스를 선택해주세요->\r\n");
            }
        }
    }
    public void select() throws InterruptedException, IOException {
        switch(selectNum){
            case 1:
                cinemaSeatQuery();
                break;
            case 2:
                reserveTicket();
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                cinemaQuit();
                break;
            default:


        }
    }

    public void cinemaSeatQuery() throws InterruptedException, IOException {
        char row = 'A';
        for(int i=0; i<5; i++){
            System.out.print(row +" Line: ");row++;
            for(int j=0; j<5; j++){
                String seat = (this.seat[i][j].equals("___"))? "◻": "◼";
                System.out.print((j+1)+seat +"  ");
            }
            System.out.print(System.lineSeparator());
        }
        TimeUnit.SECONDS.sleep(5);
        controller();
    }

    public void reserveTicket() throws InterruptedException, IOException {
        while(true) {

                while(true) {
                    try {
                        System.out.println("행을 입력하세요(max:5)");
                        row = scan.nextInt();
                    } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                        scan = new Scanner(System.in);
                        System.out.println("최대 5까지 입력하시길 바랍니다.");
                    }
                    if(!(this.row>5)){
                        break;
                    } else{
                        System.out.println("에러: 행과 열은 최대 5까지입니다.");
                    }
                }

                while(true) {
                    try {
                        System.out.println("열을 입력하세요(max:5)");
                        col = scan.nextInt();
                    } catch (InputMismatchException | ArrayIndexOutOfBoundsException f) {
                        f.printStackTrace();
                        scan = new Scanner(System.in);
                        System.out.println("최대 5까지 입력하시길 바랍니다.");
                    }
                    if (!(col>5)){
                        break;
                    } else {
                        System.out.println("에러: 행과 열은 최대 5까지입니다.");
                    }
                }
            break;
        }
        if(seat[row][col].equals("___")){
            seat[row-1][col-1] = userId;
            System.out.println((row)+"행"+(col)+"열 좌석이 예약되었습니다.");
            cinemaPrint();
            cinemaSeatQuery();
        } else{
            System.out.println("이미 예약된 좌석입니다");
        }

    }
//    public void cinemaCancel(){
//        if()
//    }
    public void cinemaLogin(){
        while(true){
            System.out.println("\tuser ID: ");
            userId = scan.nextLine();
            if(!userId.equals("root")){
                System.out.println("user ID가 존재하지 않습니다.");
            } else{
                System.out.println("\tuser PW: ");
                userPw = scan.nextLine();
                if(!userPw.equals("password")){
                    System.out.println("user password가 일치하지 않습니다.");
                } else{
                    System.out.println("로그인 되었습니다\r\n\n"+"\t환영합니다 "+userId+"님!");
                    break;
                }
            }
        }
    }
    public void cinemaPrint() throws IOException {
        System.out.println("예약내용을 출력하시려면 yes를 입력하세요");
        String printCheck = scan.next();
        if(printCheck.equals("yes")){
            LocalDateTime curDateTime = LocalDateTime.now();
            LocalDate now = LocalDate.now();
            File file = new File("C:/Users/user/Desktop/"+userId+"cinemaPrint.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write("----------------------------------------------------------\r\n");
            fw.write("|                        영화입장권                         |\r\n");
            fw.write("| Moive : "+"XXX영화"+ "                                     |\r\n");
            fw.write("| ID : "+userId+ "                                              |\r\n");
            fw.write("| PW : "+userPw+ "                                          |\r\n");
            fw.write("| Seat : "+(row)+"행"+(col)+"열"+ "                                   |\r\n");
            fw.write("|--------------------------------------------------------|\r\n");
            fw.write("|---------------------------------------------------------\r\n");
            fw.write("number"+" "+"this is errorLog"+"  "+curDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"+"\r\n")));
            fw.flush();
            fw.close();
            System.out.println(System.lineSeparator()+"파일이 저장되었습니다@@");
//            fw.write(System.getProperty("line.separator"));
        }
    }
    public void cinemaQuit(){
        System.out.println("시스템을 종료합니다");
    }

}

    //좌석 기본 셋팅

    //현재 좌석 예약상황 조회


// 예약정보 출력
// 로그인 db 계정 정보 조회
// 빌더 클래스
// 쿼리별 나누기
