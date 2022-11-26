package lecture;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 3개를 입력하시오.");
//		int sum = 0;
//		int num = 0;
		int sum=0,num=0; //한줄로 쓸땐 이렇게 사용하여도 된다
		for(int i=0;i<3;i++) {
			System.out.println(i+">>");
			
			try {
				num = scanner.nextInt();
			} catch (InputMismatchException e) {// 정수가 아닐때 사용(예외 처리)
				// TODO: handle exception
				System.out.println("정수가 아닙니다. 다시 입력해 주세요");
				scanner.next(); // 기존 초기화 안해주면 계속 반복하여 위의 말이 나온다
				i--;//하나를 빼줘야 한다 3개를 받는거라
				continue;//해당 사항이 없으면 건너뛰어야 하여 사용
			}
			sum+=num;			
		}
		System.out.println("합은==="+sum);
		scanner.close();
		System.out.println(Integer.parseInt("30"));//자바의 기본 객체(8개)중 Integer -int의 기본 객체를 만들어주는 역할 Integer.parseInt("30") 정수 로 바꿔준다
	}

}
