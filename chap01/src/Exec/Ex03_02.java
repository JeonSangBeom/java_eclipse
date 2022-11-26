package Exec;

import java.util.Scanner;

public class Ex03_02 {

	public static void main(String[] args) {
		//54300
//				int money;
//				int rest; 
//				Scanner scanner = new Scanner(System.in);
//				System.out.println("돈을 입력하면 몇장인지 세어 드립니다.");
//				money = scanner.nextInt();
//				rest = money/50000;
//				money = money%50000;
//				if(rest > 0) {
//					System.out.println("오만원권 "+ rest +"장");
//				}
//				rest = money/10000;
//				money = money%10000;
//				if(rest > 0) {
//					System.out.println("만원권 "+ rest +"장");
//				}
//				rest = money/5000;
//				money = money%5000;
//				if(rest > 0) {
//					System.out.println("오천원 "+ rest +"장");
//				}
//				rest = money/1000;
//				money = money%1000;
//				if(rest > 0) {
//					System.out.println("천원 "+ rest +"장");
//				}
//				rest = money/500;
//				money = money%500;
//				if(rest > 0) {
//					System.out.println("오백원 "+ rest +"개");
//				}
//				rest = money/100;
//				money = money%100;
//				if(rest > 0) {
//					System.out.println("백원 "+ rest +"개");
//				}
//				rest = money/50;
//				money = money%50;
//				if(rest > 0) {
//					System.out.println("오십원 "+ rest +"개");
//				}
//				rest = money/10;
//				money = money%10;
//				if(rest > 0) {
//					System.out.println("십원 "+ rest +"개");
//				}
//				scanner.close();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("금액을 입력하시오>>");
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
				System.out.println(wonArray[idx] + "원권 " + k + "매");
			}
			idx++;
		}
		scan.close();
	}

}
