package com.temp;
import com.temp.movieTicket.SPersonalInfo;

import java.util.Scanner;

public class SLogin {
    SPersonalInfo sf = new SPersonalInfo();
    Scanner scan = new Scanner(System.in);
    public void login() {
        while (true) {
            System.out.println("\tuser ID: ");
            sf.setUserID(scan.nextLine());
            if (!sf.getUserID().equals("root")) {
                System.out.println("Invalid user ID");
            } else {
                System.out.println("\tuser PW: ");
                sf.setUserPW(scan.nextLine());
                if (!sf.getUserPW().equals("password")) {
                    System.out.println("Invalid userPW");
                } else {
                    System.out.println("You are logged in.\r\n\n" + "\tWelcome " + sf.getUserID() + "!");
                    break;
                }
            }
        }
    }
}
