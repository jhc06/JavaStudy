package com.JDBCPrj;

public class Example {
    public static void main(String[] args) {
        DBManager dbm = new DBManager();
        View view = new View();

        view.setDBInfo("jdbc:oracle:thin:@localhost:1521:XE", "C##TEST","oracle");
//        view.selectSqlInput();
        view.tempSql();

        dbm.getConnection(view);
        dbm.selectQuery(view);
        dbm.print(1);

        //rs 이용 메소드 위치장소

        dbm.close();
    }
}