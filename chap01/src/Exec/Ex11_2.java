package Exec;

import java.util.Scanner;

//switch
public class Ex11_2 {
	public static void main(String[] args) {
		System.out.println("���� �Է��ϼ���(1~12)>>");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		switch(num) {
		case 3: case 4: case 5:
			System.out.println("��");
			break;
		case 6: case 7: case 8:
			System.out.println("����");
			break;
		case 9: case 10: case 11:
			System.out.println("����");
			break;
		case 12: case 1: case 2:
			System.out.println("�ܿ�");
			break;
		default:
			System.out.println("�߸��Է�");
		}
		scanner.close();
	}
}
