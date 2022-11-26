package Exec;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("금액을 입력하시오>>");
//		
//		int num = scanner.nextInt();
//			System.out.println("50000won"+num/50000+"장");
//			num%=50000;
//			System.out.println("10000won"+num/10000+"장");
//			num%=10000;
//			System.out.println("1000won"+num/1000+"장");
//			num%=1000;
//			System.out.println("100won"+num/100+"장");
//			num%=100;
//			System.out.println("50won"+num/50+"장"); 
//			num%=50;
//			System.out.println("10won"+num/10+"장");
//			num%=10;
//			System.out.println("1won"+num/1+"장");
//			scanner.close();
		int[] coin = { 50000, 10000, 1000, 500, 100, 50, 10, 1 };
		Scanner scanner = new Scanner(System.in);
		System.out.println("금액을 입력하시오>>");
		int num = scanner.nextInt();
		for (int i = 0; i < coin.length; i++) {
			System.out.println(coin[i] + "원:" + num / coin[i]);
			num %= coin[i];
		}
		scanner.close();

	}
}
