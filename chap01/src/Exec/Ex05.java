package Exec;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� 3���� �Է�>>");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt(); // ���������� �Է�
		if( (a+b) < c || (a+c) < b || (b+c) < a) { // || = �Ǵ�(��ȣ�� �ʿ䰡 ���� ���� ���߿� ������ �ϱ� ������)
			System.out.println("�ﰢ���� �ȵ˴ϴ�.");
		}else {
			System.out.println("�ﰢ���� �˴ϴ�");
		}
		scanner.close();
	}

}
