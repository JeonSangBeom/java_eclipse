package lecture;

import java.util.Scanner;

public class RectangleTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //자바에서 제공하는 타입 (사용자 정의와는 다르게 따로 정의가 필요 없다)
		Rectangle rect = new Rectangle(); //변수 rect 앞 타입을 써준다(변수 앞에는 의무)  
		rect.width = scanner.nextInt(); //rect. 정의해놓은 값을 불러온다 nexInt(값을 받아온다) 
		rect.height = scanner.nextInt();
		int area = rect.getArea();
		System.out.println(area);
		scanner.close();//의무적으로 달아줘야한다(오류 방지)
	}

}
 