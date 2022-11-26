package Exec;

import java.util.Scanner;

public class Ex03 {
// 1) 별이 정수의 갯수대로 위에서 아래로 내려오는 형식
//	public static void main(String[] args) {
//		System.out.println("정수를 입력하시>>");
//		Scanner scanner=new Scanner(System.in);
//		int n = scanner.nextInt();
//		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n-i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		scanner.close();
//	}
	
	
//	2) 정수의 갯수대로 아래에서 위로 올라가는 형식
//	public static void main(String[] args) {
//		System.out.println("정수를 입력하시>>");
//		Scanner scanner=new Scanner(System.in);
//		int n = scanner.nextInt();
//		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		scanner.close();
//	}
	
	//피라미드 형식
	public static void main(String[] args) {
		System.out.println("정수를 입력하시>>");
		Scanner scanner=new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println();
		
		for(int i=0; i<n; i++) {
			for(int j=1; j<n-i; j++) {
				System.out.print("");
			}
			for(int k=0; k<i*2+1; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		scanner.close();
	}

}
