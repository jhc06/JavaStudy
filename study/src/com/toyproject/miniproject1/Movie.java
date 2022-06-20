package com.toyproject.miniproject1;

import java.util.Calendar;

public class Movie {
    public static final String [] movieList = {"ž��-�Ź���", "���˵���2","���Ŀ"};
    public static final String [] today = {"�Ͽ���","������","ȭ����","������","�����","�ݿ���","�����"};
    String time [] = {"10:10" ,"15:20" , "20:40"};

    Calendar now = Calendar.getInstance();
    int month = now.get(Calendar.MONTH)+1;
    int day = now.get(Calendar.DAY_OF_MONTH);
    int week = now.get(Calendar.DAY_OF_WEEK)-1;

    int movieselect ;


    void selectMenu() {
        System.out.println("4.*���� �޴��� ���ư���*");
        System.out.println("------------------");
        System.out.print("��ȣ �Է�>>");

    }

    void selectError() {
        System.out.println("------------------");
        System.out.println("���� ��ȣ�� �Է��ϼ̽��ϴ�.");
        System.out.println("��ȣ�� �ٽ� �Է� �ϼ���.");
    }

    void movieChart() {
        System.out.println("------------------");
        System.out.println("<<������Ʈ>>");
        for(int i=0; i<movieList.length;i++) {
            System.out.println((i+1)+"."+movieList[i]);
        }
    }


    void reservDate() {
        System.out.println("------------------");
        System.out.println("<<���� ���� ��¥>>");
        for(int i=1; i<=3; i++) {
            System.out.println(i+"."+month+"�� "+(day+i)+"�� "+today[week+i]);
        }
    }


    void reservTime(String time[]) {
        System.out.println("------------------");
        System.out.println("<<�󿵽ð�>>");
        for(int i=0; i<3;i++) {
            System.out.println((i+1)+"."+time[i]);
        }
    }

}
