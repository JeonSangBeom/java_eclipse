package Exec;

import java.util.Scanner;

public class Ex12_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("����>>");
		int op1 = scanner.nextInt();
		String op = scanner.next();
		int op2 = scanner.nextInt();
		int res = 0;
		switch(op) {
		case "+":
			res = op1 + op2;
			break;
		case "-":
			res = op1 - op2;
			break;
		case "*":
			res = op1 * op2;
			break;
		case "/":
			if(op2==0) {
				System.out.println("0���� ������ ����");
				scanner.close();
			}
			res = op1 / op2;
			break;
			default:
				System.out.println("��Ģ������ �ƴմϴ�.");
				scanner.close();
				break;
		}
		System.out.println(op1+op+op2+"�� �������"+res);
		scanner.close();
	}

}
