package Exec;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int unit[]= {50000,10000,1000,100,10,1};
		
		System.out.println("�ݾ��� �Է��Ͻÿ�>>");
		int money=scanner.nextInt();
		
		for(int i=0;i<unit.length;i++) {
			System.out.println(unit[i]+"�� ¥�� :"+money/unit[i]+"�� ");
			money-=(money/unit[i])*unit[i]; //���� �� ����
		}
//		for(int i=0;i<unit.length;i++) {
//			int rest = money/unit[i];
//			if(rest>0) {
//				System.out.println(unit[i] +"�� ¥���� "+rest+" ��");
//				money=money%unit[i];
//			}
//		}
		
	}

}
