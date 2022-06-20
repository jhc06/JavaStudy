package com.temp;

public class Score {
    public static void main(String[] args) {
//		Library st01 = new Library("you", 80, 55, 10);
//
//		System.out.println(st01.sum);
//		System.out.println(st01.avg);
//
//		if (st01.avg > 60) {
//			System.out.println(st01.name+"���� "+"�հ��Դϴ�.");
//		} else if(st01.avg <= 40) {
//			System.out.println(st01.name+"���� "+"���հ��Դϴ�.");
//
//		}
//		System.out.println(st01.st01Arr[1]);
//
//		int sum = 0;
//		for ( int i=0; i<3; i++) {
//			sum += st01.st01Arr[i];
//		System.out.println(st01.sKor);
//		}
        StudentsScore[] stArr = new StudentsScore[2];

        stArr[0] = new StudentsScore("you", 80, 55, 10);
        stArr[1] = new StudentsScore("me", 75, 90, 20);

        for(int i = 0; i <stArr.length; i++) {
            System.out.println(stArr[i].getName()+"\n"+stArr[i].getsKor()+"\n"+stArr[i].getsMath()+"\n"+stArr[i].getsEng());
        }
        //-------------------------�׽�Ʈ�� �հ� ���հ�
//	for(int i = 1; i <stArr.length; i++) {
//		int sum = 0;
//		sum += stArr[i];
//	}
//		if (stArr[i]>60) {
//			System.out.println("�հ��Դϴ�");
//		} else if (stArr[i]<40) {
//			System.out.println("���հ��Դϴ�");
//		}
//	System.out.println(stArr[0].getsKor());
        //------------------------------�׽�Ʈ��
    }
}
class StudentsScore{
    private String name;
    private int sKor;
    private int sMath;
    private int sEng;
    private int sum;

    public StudentsScore() {}
    public StudentsScore(String name, int sKor, int sMath, int sEng) {
        this.setName(name);
//			this.name = name;
        this.setsKor(sKor);
        this.setsMath(sMath);
        this.setsEng(sEng);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setsKor(int sKor) {
        this.sKor = sKor;
    }
    public void setsMath(int sMath) {
        this.sMath = sMath;
    }
    public void setsEng(int sEng) {
        this.sEng = sEng;
    }
    public String getName() {
        return name;
    }
    public int getsKor() {
        return sKor;
    }
    public int getsMath() {
        return sMath;
    }
    public int getsEng() {
        return sEng;
    }
    public int sum() {
        sum = sKor+sMath+sEng;
        return sum;
    }
}

// 1. ������ ����ϴ� �޼ҵ�, 2. ����� ����ϴ� �޼ҵ�, �հݿ��θ� ��Ÿ���� �޼ҵ��߰��ؼ� �հ� ���� ȭ�� ���(���60,����40), ���� �Ǵ� ��� �̴��� ������ ȭ�鿡 ����ϼ���.
// ���� �����ؼ� ����غ��s�;
