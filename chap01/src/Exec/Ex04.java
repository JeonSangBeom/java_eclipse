package Exec;

import java.util.Scanner;


public class Ex04 {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int a,b,c;
//		System.out.println("정수 3개 입력>>");
//		a = scanner.nextInt();
//		b = scanner.nextInt();
//		c = scanner.nextInt();
//		if(a<b && b<c) {System.out.println("중간 값은"+b+"입니다.");}
//		if(b<a && a<c) {System.out.println("중간 값은" +a+ "입니다.");}
//		else {System.out.println("중간 값은"+c+"입니다.");}
//		scanner.close();
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 세개를 입력하시면 중간꺼 찾아드립니다.");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		//10 20 30
		int center;
		if( (a >= b &&  a <= c) || ( a >= c && a<=b ) ) {
				// && 그리고  || 또는 
			center = a;
		} else if ((b >= a &&  b <= c) || ( b >= c && b<= a )) {
			center = b;
		} else {
			center = c;
		}
		System.out.println("중간은 "+ center +"입니다.");
		scanner.close();
	}
}
