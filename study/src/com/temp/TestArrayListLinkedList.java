package com.temp;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

// CRUD: Create, Read, Update, Delete!!
public class TestArrayListLinkedList {

    public static void main(String[] args) {

        //*** ArrayList는 검색이 많은 경우에 사용하고 LinkedList는 잦은 삽입/삭제 시 사용합니다.
        // arraylist는 클래시 List는 인터페이스;

        //ArrayList

        //create
        //ArrayList<타입 full spelling>(초기용량 Capacity); -> 타입은 생략가능.
        ArrayList<Integer> integer2 = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<String>();
        ArrayList<Integer> integer3 = new ArrayList<>(integer2);
        colors.add("Black");
        colors.add("red");
        System.out.println(colors+"-> 인자 입력");
        //인덱스 지정시  그 위치에 인자 추가;
        colors.add(0, "Blue");
        System.out.println(colors+"-> 특정 인덱스에 인자 입력");
        // set() 메소드로 인자 대체하기!!
        colors.set(0, "KING");
        System.out.println(colors+"-> 특정 인덱스에 인자 대체");
        //Delete
        // 인자 제거하기
        colors.remove("KING");
        String remove = colors.remove(0);
        //인덱스로 인자 제거시 return 값이 나오니까 다른 용도로 사용 가능;
        System.out.println(remove);
        System.out.println(colors+"-> 인자 삭제");
        //인자 찾기 해당하는 값을 찾아 인덱스를 리턴한다;
        int index = colors.indexOf("red");
        System.out.println(index);
        //전체 삭제
        colors.clear();
        System.out.println(colors);

        //LinkedList

        // create
        LinkedList<Integer> integer1 = new LinkedList<Integer>();
        // Read
        //Update
        //Delete
        //전체 값 확인하기;
        LinkedList<String> colors2 = new LinkedList<>(Arrays.asList("Black", "White", "Green", "Red"));
        // for-each loop
        for (String color : colors2) {
            System.out.print(color + "  ");
        }
        System.out.println();

        // -------------------------->>>>>>>>>> ArrayList랑 같다.

    }
}

