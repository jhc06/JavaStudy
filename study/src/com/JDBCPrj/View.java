package com.JDBCPrj;

import java.util.Scanner;

public class View {
    Scanner scan = new Scanner(System.in);
    private String url, id, pw;
    String select;
    String from;
    String where;
    String groupBy;
    String having;
    String orderBy;
    String customSQL;
    String selectSQL;
    String createSQL;
    String dropSQL;
    String insertSQL;


    //DB 접속 정보 주소, 아이디, 비밀번호를 입력하는 메소드.
    public void setDBInfo(String url,String id, String pw){
        this.url = url;
        this.id = id;
        this.pw = pw;
    }
    // 스캐너로 입력된 값을 시퀄문으로 설정하는 메소드
    public void setSelectSQL(){
        System.out.println("SelectSQL: ");
        selectSQL = scan.nextLine();
    }
    public void setCreateSQL(){
        System.out.println("CreateSQL: ");
        createSQL = scan.nextLine();
    }
    public void setDropSQL(){
        System.out.println("DropSQL: ");
        dropSQL = scan.nextLine();
    }
    public void setInsertSQL(){
        System.out.println("InsertSQL: ");
        insertSQL = scan.nextLine();
    }
    public void setCustomSql(){
        System.out.println("CustomSQL: ");
        customSQL = scan.nextLine();
    }


//    public void tempSql(){
//        select = "*";
//        from = "EMPLOYEES";
//        where = "hire_date BETWEEN TO_DATE(?, 'YYMMDD') AND TO_DATE(?, 'YYMMDD')";
//        groupBy = null;
//        orderBy = null;
//    }
//    public void selectSqlInput() {
//        try {
//            System.out.println("SELECT: ");
//            select = scan.nextLine();
//            System.out.println("FROM: ");
//            from = scan.nextLine();
//            System.out.println("WHERE: ");
//            where = scan.nextLine();
//            System.out.println("GROUP BY: ");
//            groupBy = scan.nextLine();
//            System.out.println("HAVING: ");
//            having = scan.nextLine();
//            System.out.println("ORDER BY: ");
//            orderBy = scan.nextLine();
//        } catch (Exception e) {
//            System.out.print("Error : " + e.getMessage());
//        }
//    }


    public String getUrl(){
        return url;
    }
    public String getId(){
        return id;
    }
    public String getPW(){
        return pw;
    }
}
