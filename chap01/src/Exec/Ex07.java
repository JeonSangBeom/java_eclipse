package Exec;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		System.out.println("��(x,y)�� ��ǥ�� �Է��Ͻÿ�>>");
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		if((100<=x && x<=200)&&(100<=y && y<=200))
			System.out.println("�簢�� �ȿ� ���� �ֽ��ϴ�.");
		else System.out.println("�簢�� �ȿ� ���� �����ϴ�");
		scanner.close();			
	}

}
