package Exec;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 3개를 입력>>");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt(); // 순차적으로 입력
		if( (a+b) < c || (a+c) < b || (b+c) < a) { // || = 또는(괄호는 필요가 없다 가장 나중에 연산을 하기 때문에)
			System.out.println("삼각형이 안됩니다.");
		}else {
			System.out.println("삼각형이 됩니다");
		}
		scanner.close();
	}

}
