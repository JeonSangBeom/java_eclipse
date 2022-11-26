package lecture;
// 예외 처리 
import java.util.Scanner;

public class DivideZero {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num ;
		int dividor;
		System.out.println("숫자를 입력하세요.");
		num = scanner.nextInt();
		System.out.println("어떤 수로 나누어 볼까요");
		dividor = scanner.nextInt();
//		try {
//		System.out.println(num+"를"+dividor+"로 나누면"+num/dividor+"입니다.");
//		} catch (ArithmeticException e) { //ArithmeticException - 정수를 0으로 나눌때 발생
//			System.out.println("0으로 나눌 수는 없어요.");
//		} 예외 처리시 사용
		try {
			System.out.println(num+"를"+dividor+"로 나누면"+num/dividor+"입니다.");
			} catch (Exception e) {
				e.printStackTrace(); // 오류 발생시 예외처리 방법을 알려준다(뭐가 에러인지 모를때 그리고 대표적으로 사용)
			}
		scanner.close();
	}

}
