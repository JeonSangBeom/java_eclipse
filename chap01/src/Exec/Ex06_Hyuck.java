package Exec;

import java.util.Scanner;

public class Ex06_Hyuck {

	public static void main(String[] args) { // main치고 엔터시 자동 생성
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 1~99사이의 정수를 입력하시오.");
		int num = scanner.nextInt();
		int newnum = num / 10;
		if (newnum == 3 || newnum == 6 || newnum == 9) {
			if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
				System.out.println("박수짝짝");
			} else {
				System.out.println("박수짝");
			}
		} else {
			if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
				System.out.println("박수짝");
			}
		}
	}

}
