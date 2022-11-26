package Exec;

import java.util.Scanner;

public class Ex02 {
	// 앞의 숫자와 뒤의 숫자가 같은지 구분하기

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("2자리의 정수를 입력하시오(10~99)>>");
//		int num = scanner.nextInt(); // 변수 앞엔 타입을 써야한다 쓰기 싫을 경우 var이용
//		if(num/10==num%10) {
//			System.out.println("Yes! 10의 자리와 1의 자리가 같습니다");
//		}else {
//			System.out.println("No! 10의 자리와 1의 자리가 다릅니다");
//		}scanner.close();
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("2자리의 정수 입력(10");
//		int num = scanner.nextInt();
//		if(num>10 && num<100) {
//			if(num/10==num%10) {
//			System.out.println("Yes! 10의 자리와 1의 자리가 같습니다");
//			}else {
//				System.out.println("No!10의 자리와 1의 자리가 다릅니다.");
//			}
//		}else {
//			System.out.println("2자리의 정수가 아닙니다");
//		}scanner.close();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("2자리 정수 입력 ex) (10~99)");
		int num = scanner.nextInt();
		if(num<10 || num >99) { // num이 10보다 작고 num 99보다 크면 
			System.out.println("제발 지문 좀 읽어  !!!!");
			scanner.close();
			return;
		} // 안되는 부분은 이렇게 위에서 걸러 주는ㄴ 겟 좋다
		int first = num/10; /// 첫번째 숫자
		int second = num%10; // 두번째 숫자
		if(first==second) {
			System.out.println("두개의 숫자가 같습니다.");
		} else {
			System.out.println("두개의 숫자가 다릅니다.");
		}
		scanner.close();
	}

}

