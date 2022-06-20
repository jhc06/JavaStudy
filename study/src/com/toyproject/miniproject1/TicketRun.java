package com.toyproject.miniproject1;

import java.io.IOException;

public class TicketRun {
    public static void main(String[] args) throws IOException, InterruptedException {
        Reserveticket rt = new Reserveticket();
        rt.start();
    }
}
