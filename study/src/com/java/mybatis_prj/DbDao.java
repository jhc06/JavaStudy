package com.java.mybatis_prj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbDao {
    public static final Map<Long, Service> db = new HashMap();
    private static final long Uid = 0L;

    public String reserve(Reservation reservation){
        List<Reservation> purchase = reservation.reserve();
        return "reserve OK";
    }
    public String cancel(Reservation reservation){

    }
    public String seatQuery(Seat seat){

    }
    public String findAnalysis(Analysis analysis){

    }

}
