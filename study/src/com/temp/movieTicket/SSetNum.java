package com.temp.movieTicket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SSetNum {
    int selectNum;
    Scanner scan = new Scanner(System.in);
    public void controller() {
        System.out.println("\n1.Check seat 2.Reserve seat 3.Cancel seat 4.Movie info 5.sadfafas 6.System shut down");
        System.out.print("Input a number of menu->\r\n");
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
}
