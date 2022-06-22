package com.JDBCPrj;

import java.util.*;

public class Selection {
    DBManager dbm = new DBManager();
    View view = new View();
    Scanner scan = new Scanner(System.in);
    List<String> comandList = Arrays.asList("ConnectDB", "SelectQuery", "CreateQuery", "DeleteQuery", "Insert Query", "CustomQuery", "CloseDB Manager", "임시Print");

    int selectNum;

    // main에서 실행할 메소드 모음. 가장 처음 실행된다.
    public void start(){
        try {
            System.out.println("---------------------------------");
            System.out.println("|      ORACEL SQL MANAGER        |");
            System.out.println("|                                |");
            System.out.println("---------------------------------");
            controller();
            selectNum();
            select();
        } catch (Exception e) {
            System.out.print("Error : " + e.getMessage());
        }
    }

    // 메뉴 내용을 출력하는 메소드. 메뉴 리스트는 List에서 출력한다.
    public void controller() {
        int i=1;
        for(String menuName : comandList){
            System.out.print(i+"."+menuName+"\t");
            i++;
        }
        System.out.print(System.lineSeparator());
        System.out.println("Input a number of menu->\r\n");
    }

    // 메뉴에서 번호를 선택하는 메소드
    public void selectNum() {
        int size = comandList.size();
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
            if (!(this.selectNum > size) && !(this.selectNum <= 0)) {
                break;

            } else {
                System.out.println("잘못입력하셨습니다. 1번부터 6번까지의 숫자를 입력하세요.");
                controller();
            }
        }
    }

    // 메뉴에서 번호 선택시 이동 경로를 정하는 메소드
    public void select(){
        switch (selectNum) {
            case 1: // db 연결하기
                view.setDBInfo("jdbc:oracle:thin:@localhost:1521:XE", "C##TEST","oracle");
                dbm.getConnection(view);
                controller();
                selectNum();
                select();
                break;
            case 2: // select query
//                view.tempSql();
                view.setSelectSQL();
                dbm.selectQuery(view);
                controller();
                selectNum();
                select();
                break;
            case 3: // create query
                view.setCreateSQL();
                dbm.createQuery(view);
                controller();
                selectNum();
                select();
                break;
            case 4: // drop query
                view.setDropSQL();
                dbm.dropQuery(view);
                controller();
                selectNum();
                select();
                break;
            case 5: // insert query
                view.setInsertSQL();
                dbm.insertQuery(view);
                controller();
                selectNum();
                select();
                break;
            case 6: // custom query
                view.setCustomSql();
                dbm.customQuery(view);
                controller();
                selectNum();
                select();
                break;
            case 7: //close db
                dbm.close();
                break;
            case 8: //임시 print
                dbm.print(3);
                controller();
                selectNum();
                select();
                break;
            default:
        }
    }
}

