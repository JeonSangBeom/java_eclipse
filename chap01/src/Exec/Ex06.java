package Exec;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
//	Scanner scanner = new Scanner(System.in);
//	System.out.println("���� 1~99������ ������ �Է��Ͻÿ�.");
//	int num = scanner.nextInt();
//	int first = num/10; // ù��° ���ϴ� ��
//	int second = num%10;
//	int count = 0; 
//	if(first%3==0 && first!=0) {// �������� 3���� �������ų� 0�� �ƴ϶��
//		count++; // ���� ����
//	}
//	if(second%3==0 && second!=0) {
//		count++;
//	}
//	if(count==2) {
//		System.out.println("�ڼ�¦¦");
//	}else if(count==1) {
//		System.out.println("�ڼ�¦");
//	}else {
//		System.out.println("�ڼ�ġ�� ����...");
//	}
//	scanner.close();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("1~99 ������ ������ �Է��Ͻÿ�>>");
		int num = scanner.nextInt();

		if (num != 0 && num >= 1 && num <= 99) {
			int a, b;
			a = num / 10;
			b = num % 10; // ������ ����

			if ((a == 3 || a == 6 || a == 9) && (b == 3 || b == 6 || b == 9)) {
				System.out.println("�ڼ� ¦¦");
			} else if ((a == 3 || a == 6 || a == 9) || (b == 3 || b == 6 || b == 9)) {
				System.out.println("�ڼ� ¦");
			}
		} else {
			System.out.println("������ ������ ������ϴ�.");
		}
		scanner.close();
	}
}