package Exec;

import java.util.Scanner;

public class Ex08_02 {
//inRect를 사용하지 않고 푸는 방법
	public static void main(String[] args) {
		System.out.println("두 점(x1,y1), (x2,y2)의 좌표를 입력하시오 >>");
		Scanner scanner = new Scanner(System.in);
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		if((x1>=100 & x1<=200) && (y1>=100 && y1<=200)) {
			System.out.println("사각형이 겹침");
		}else if((x2>=100 & x2<=200) && (y2>=100 && y2<=200)) {
			System.out.println("사각형이 겹침");
		}else if((x1<=100 & x2>=200) && (y1<=100 && y2>=200)) {
			System.out.println("사각형이 겹침");
		}
		else {
			System.out.println("사각형이 안겹침");
		}scanner.close();
	}

}
