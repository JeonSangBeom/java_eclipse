package Exec;

import java.util.Scanner;

public class Ex03_02 {

	public static void main(String[] args) {
		//54300
//				int money;
//				int rest; 
//				Scanner scanner = new Scanner(System.in);
//				System.out.println("���� �Է��ϸ� �������� ���� �帳�ϴ�.");
//				money = scanner.nextInt();
//				rest = money/50000;
//				money = money%50000;
//				if(rest > 0) {
//					System.out.println("�������� "+ rest +"��");
//				}
//				rest = money/10000;
//				money = money%10000;
//				if(rest > 0) {
//					System.out.println("������ "+ rest +"��");
//				}
//				rest = money/5000;
//				money = money%5000;
//				if(rest > 0) {
//					System.out.println("��õ�� "+ rest +"��");
//				}
//				rest = money/1000;
//				money = money%1000;
//				if(rest > 0) {
//					System.out.println("õ�� "+ rest +"��");
//				}
//				rest = money/500;
//				money = money%500;
//				if(rest > 0) {
//					System.out.println("����� "+ rest +"��");
//				}
//				rest = money/100;
//				money = money%100;
//				if(rest > 0) {
//					System.out.println("��� "+ rest +"��");
//				}
//				rest = money/50;
//				money = money%50;
//				if(rest > 0) {
//					System.out.println("���ʿ� "+ rest +"��");
//				}
//				rest = money/10;
//				money = money%10;
//				if(rest > 0) {
//					System.out.println("�ʿ� "+ rest +"��");
//				}
//				scanner.close();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("�ݾ��� �Է��Ͻÿ�>>");
		int amount = scan.nextInt();
		int wonArray[] = { 50000, 10000, 1000, 500, 100, 50, 10, 1 };
		int jangArray[] = new int[8];
		for (int i = 0; i < 8; i++) {
			jangArray[i] = amount / wonArray[i];
			amount = amount % wonArray[i];
		}
		int idx = 0;
		for (int k : jangArray) {
			if (k != 0) {
				System.out.println(wonArray[idx] + "���� " + k + "��");
			}
			idx++;
		}
		scan.close();
	}

}
