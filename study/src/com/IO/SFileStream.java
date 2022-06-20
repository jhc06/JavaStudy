package com.IO;

import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public class SFileStream {
    public static void main(String[] args) throws Exception {
        LocalDateTime curDateTime = LocalDateTime.now();
//        LocalDate curDate = LocalDate.now();
//        LocalTime curTime = LocalTime.now();
        File file = new File("C:/Java/log.txt");
        FileWriter fw = new FileWriter(file, true);
        fw.write("----------------------------------------------------------");
        fw.write(System.getProperty("line.separator"));
        fw.write("number"+" "+"this is errorLog"+"  "+curDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"+"\r\n")));
        // 줄바꿈 코드( \r\n win, \r mac, \n unix, System.lineSeparator() All )
        fw.flush();
        fw.close();
        System.out.println(System.lineSeparator()+"파일이 저장되었습니다@@");

    }
}