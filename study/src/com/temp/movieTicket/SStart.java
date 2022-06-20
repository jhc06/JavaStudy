package com.temp.movieTicket;

import java.io.IOException;

public class SStart {
    String[][] seat = new String[5][5];
    SQuerySeat sq = new SQuerySeat();
    SReserve sr = new SReserve();
    SSetNum sm = new SSetNum();
    SQuit squ = new SQuit();
    public void start() throws InterruptedException, IOException {
        System.out.println("---------------------------------");
        System.out.println("|     MOVIE RESERVATION SYSTEM   |");
        System.out.println("|                                |");
        System.out.println("---------------------------------");
        sr.pim.login();
        sq.resetSeat(seat);
        sm.controller();
        sm.selectNum();
        select();
    }
    public void select() throws InterruptedException, IOException {

        switch (sm.selectNum) {
            case 1:
                sq.seatQuery(seat);
                sm.controller();
                sm.selectNum();
                select();
                break;
            case 2:
                sr.reserve(seat);
                sm.controller();
                sm.selectNum();
                select();
                break;
            case 3:
                sr.cancel(seat);
                sm.controller();
                sm.selectNum();
                select();
                break;
            case 4:

                break;
            case 5:
//                System.out.println((sr.pim.pi.getReservationNumber()));
//                System.out.println(sr.pim.pi.getReservationNumber());
//                System.out.println(Arrays.asList(seat).indexOf(sr.pim.pi.getReservationNumber()));
            case 6:
                squ.quit();
                break;
            default:
        }
    }
}
