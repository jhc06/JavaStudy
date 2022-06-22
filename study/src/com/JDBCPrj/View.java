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

    public void setDBInfo(String url,String id, String pw){
        this.url = url;
        this.id = id;
        this.pw = pw;
    }
    public void tempSql(){
        select = "prod_subcategory 상품종류";
        from = "products";
        where = "prod_subcategory = 'Recordable CDs'";
        groupBy = null;
        orderBy = null;
    }
    public void selectSqlInput() {
        try {
            System.out.println("SELECT: ");
            select = scan.nextLine();
            System.out.println("FROM: ");
            from = scan.nextLine();
            System.out.println("WHERE: ");
            where = scan.nextLine();
            System.out.println("GROUP BY: ");
            groupBy = scan.nextLine();
            System.out.println("HAVING: ");
            having = scan.nextLine();
            System.out.println("ORDER BY: ");
            orderBy = scan.nextLine();
        } catch (Exception e) {
            System.out.print("Error : " + e.getMessage());
        }
    }
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
