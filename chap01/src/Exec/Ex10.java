package Exec;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		System.out.println("첫 번째 원의 중심과 반지름 입력>>");
		Scanner scanner = new Scanner(System.in);
		int x=scanner.nextInt();
		int x1=scanner.nextInt();
		double r=scanner.nextDouble();
		
		System.out.println("두번째 원의 중심과 반지름 입력>>");
		int y=scanner.nextInt();
		int y1=scanner.nextInt();
		double r1=scanner.nextDouble();
		double distance=0;
		distance = Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
		if(distance<=r+r1) {
			System.out.println("두 원은 서로 겹친다.");
		}else {
			System.out.println("두 원은 서로 안겹친다.");
		}
		scanner.close();
		
	}

}
