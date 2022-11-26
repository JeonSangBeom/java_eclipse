package Exec;

import java.util.Scanner;

public class Ex12 {
//연산자 : an operator, 결과 : result
	public static void main(String[] args) {
		System.out.println("연산>>");
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
				System.out.println("0으로 나눌 수 없습니다.");
				scanner.close();
				return;
			}else {
				res = op1 / op2;
			}
		}else {
			System.out.println("사칙연산이 아닙니다.");
			scanner.close();
			return;
		}
		System.out.println(op1+op+op2+"의 계산결과는"+res);
		scanner.close();

	}

}
