package Exec;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
//	Scanner scanner = new Scanner(System.in);
//	System.out.println("정수 1~99사이의 정수를 입력하시오.");
//	int num = scanner.nextInt();
//	int first = num/10; // 첫번째 구하는 식
//	int second = num%10;
//	int count = 0; 
//	if(first%3==0 && first!=0) {// 나머지가 3으로 떨어지거나 0이 아니라면
//		count++; // 숫자 증가
//	}
//	if(second%3==0 && second!=0) {
//		count++;
//	}
//	if(count==2) {
//		System.out.println("박수짝짝");
//	}else if(count==1) {
//		System.out.println("박수짝");
//	}else {
//		System.out.println("박수치면 죽음...");
//	}
//	scanner.close();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("1~99 사이의 정수를 입력하시오>>");
		int num = scanner.nextInt();

		if (num != 0 && num >= 1 && num <= 99) {
			int a, b;
			a = num / 10;
			b = num % 10; // 나머지 연산

			if ((a == 3 || a == 6 || a == 9) && (b == 3 || b == 6 || b == 9)) {
				System.out.println("박수 짝짝");
			} else if ((a == 3 || a == 6 || a == 9) || (b == 3 || b == 6 || b == 9)) {
				System.out.println("박수 짝");
			}
		} else {
			System.out.println("숫자의 범위를 벗어났습니다.");
		}
		scanner.close();
	}
}