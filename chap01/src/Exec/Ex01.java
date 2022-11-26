package Exec;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		System.out.println("원화를 입력하세요(단위 원)");
//		int score = scanner.nextInt();
//		System.out.println("$" + score / 1100 + ".0");
//		scanner.close();
		System.out.println("원화를 입력하시오. 달러로 바꿔 드립니다.");
		int won = scanner.nextInt();
		double dollar = won/1100;
		System.out.println(won+"은 달러로 "+ dollar+"입니다.");
		scanner.close();
	}

}
