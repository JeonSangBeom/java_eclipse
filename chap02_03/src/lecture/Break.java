package lecture;

import java.util.Scanner;

public class Break {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);//Scanner타입을 new로 선언한 것
//		String txt = scanner.next();//next는 띄어쓰기를 인식 못함 이어진 글자만 인식
//Scanner(타입) scanner(변수) = new Scanner(System.in);
		while(true) {//true 사용시 무한 반복
			System.out.println(">>");
		String txt = scanner.nextLine();//한줄을 입력 받는 것 next는 인식을 못한다(띄어쓰기 등)
		if(txt.equals("exit")) break; //exit 입력시 빠져나가게 된다
		}
		System.out.println("종료합니다");
		scanner.close();
//		int num = 10;
//		String txt = "장성호"; // String는 기본 자료형이 아니기에 여러 메소드가 존재한다
		//기본 자료형은 new를 선언하고 사용하여야 하나 String만큼은 예외가 된다
//		if(txt.equals("장성호"))//equals -문자를 비교할때 사용 
//	}
	}
}
