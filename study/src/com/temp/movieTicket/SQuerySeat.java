package com.temp.movieTicket;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SQuerySeat {
    public void resetSeat(String[][] seat) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                seat[i][j] = "___";
            }
        }
    }

    public void seatQuery(String[][] seat) throws InterruptedException, IOException {
        char row = 'A';
        for (int i = 0; i < 5; i++) {
            System.out.print(row + " Line: ");
            row++;
            for (int j = 0; j < 5; j++) {
                String seat1 = (seat[i][j].equals("___")) ? "◻" : "◼";
                System.out.print((j + 1) + seat1 + "  ");
            }
            System.out.print(System.lineSeparator());
        }
        TimeUnit.SECONDS.sleep(2);

    }
}
