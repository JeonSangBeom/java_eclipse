package Exec;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		System.out.println("ù ��° ���� �߽ɰ� ������ �Է�>>");
		Scanner scanner = new Scanner(System.in);
		int x=scanner.nextInt();
		int x1=scanner.nextInt();
		double r=scanner.nextDouble();
		
		System.out.println("�ι�° ���� �߽ɰ� ������ �Է�>>");
		int y=scanner.nextInt();
		int y1=scanner.nextInt();
		double r1=scanner.nextDouble();
		double distance=0;
		distance = Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
		if(distance<=r+r1) {
			System.out.println("�� ���� ���� ��ģ��.");
		}else {
			System.out.println("�� ���� ���� �Ȱ�ģ��.");
		}
		scanner.close();
		
	}

}
