package Exec;

import java.util.Scanner;

public class Ex02 {
	// ���� ���ڿ� ���� ���ڰ� ������ �����ϱ�

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("2�ڸ��� ������ �Է��Ͻÿ�(10~99)>>");
//		int num = scanner.nextInt(); // ���� �տ� Ÿ���� ����Ѵ� ���� ���� ��� var�̿�
//		if(num/10==num%10) {
//			System.out.println("Yes! 10�� �ڸ��� 1�� �ڸ��� �����ϴ�");
//		}else {
//			System.out.println("No! 10�� �ڸ��� 1�� �ڸ��� �ٸ��ϴ�");
//		}scanner.close();
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("2�ڸ��� ���� �Է�(10");
//		int num = scanner.nextInt();
//		if(num>10 && num<100) {
//			if(num/10==num%10) {
//			System.out.println("Yes! 10�� �ڸ��� 1�� �ڸ��� �����ϴ�");
//			}else {
//				System.out.println("No!10�� �ڸ��� 1�� �ڸ��� �ٸ��ϴ�.");
//			}
//		}else {
//			System.out.println("2�ڸ��� ������ �ƴմϴ�");
//		}scanner.close();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("2�ڸ� ���� �Է� ex) (10~99)");
		int num = scanner.nextInt();
		if(num<10 || num >99) { // num�� 10���� �۰� num 99���� ũ�� 
			System.out.println("���� ���� �� �о�  !!!!");
			scanner.close();
			return;
		} // �ȵǴ� �κ��� �̷��� ������ �ɷ� �ִ¤� �� ����
		int first = num/10; /// ù��° ����
		int second = num%10; // �ι�° ����
		if(first==second) {
			System.out.println("�ΰ��� ���ڰ� �����ϴ�.");
		} else {
			System.out.println("�ΰ��� ���ڰ� �ٸ��ϴ�.");
		}
		scanner.close();
	}

}

