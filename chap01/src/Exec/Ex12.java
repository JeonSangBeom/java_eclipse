package Exec;

import java.util.Scanner;

public class Ex12 {
//������ : an operator, ��� : result
	public static void main(String[] args) {
		System.out.println("����>>");
		Scanner scanner=new Scanner(System.in);
		int op1 = scanner.nextInt();
		String op = scanner.next();
		int op2 = scanner.nextInt();
		
		int res=0;
		if(op.equals("+")) {
			res = op1 + op2;
		}else if(op.equals("-")) {
			res = op1 - op2;
		}else if(op.equals("*")) {
			res = op1 * op2;
		}else if(op.equals("/")) {
			if(op2==0) {
				System.out.println("0���� ���� �� �����ϴ�.");
				scanner.close();
				return;
			}else {
				res = op1 / op2;
			}
		}else {
			System.out.println("��Ģ������ �ƴմϴ�.");
			scanner.close();
			return;
		}
		System.out.println(op1+op+op2+"�� �������"+res);
		scanner.close();

	}

}
