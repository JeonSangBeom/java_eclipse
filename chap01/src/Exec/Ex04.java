package Exec;

import java.util.Scanner;


public class Ex04 {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int a,b,c;
//		System.out.println("���� 3�� �Է�>>");
//		a = scanner.nextInt();
//		b = scanner.nextInt();
//		c = scanner.nextInt();
//		if(a<b && b<c) {System.out.println("�߰� ����"+b+"�Դϴ�.");}
//		if(b<a && a<c) {System.out.println("�߰� ����" +a+ "�Դϴ�.");}
//		else {System.out.println("�߰� ����"+c+"�Դϴ�.");}
//		scanner.close();
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� ������ �Է��Ͻø� �߰��� ã�Ƶ帳�ϴ�.");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		//10 20 30
		int center;
		if( (a >= b &&  a <= c) || ( a >= c && a<=b ) ) {
				// && �׸���  || �Ǵ� 
			center = a;
		} else if ((b >= a &&  b <= c) || ( b >= c && b<= a )) {
			center = b;
		} else {
			center = c;
		}
		System.out.println("�߰��� "+ center +"�Դϴ�.");
		scanner.close();
	}
}
