package Exec;

import java.util.Scanner;

public class Ex03 {
// 1) ���� ������ ������� ������ �Ʒ��� �������� ����
//	public static void main(String[] args) {
//		System.out.println("������ �Է��Ͻ�>>");
//		Scanner scanner=new Scanner(System.in);
//		int n = scanner.nextInt();
//		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n-i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		scanner.close();
//	}
	
	
//	2) ������ ������� �Ʒ����� ���� �ö󰡴� ����
//	public static void main(String[] args) {
//		System.out.println("������ �Է��Ͻ�>>");
//		Scanner scanner=new Scanner(System.in);
//		int n = scanner.nextInt();
//		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		scanner.close();
//	}
	
	//�Ƕ�̵� ����
	public static void main(String[] args) {
		System.out.println("������ �Է��Ͻ�>>");
		Scanner scanner=new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println();
		
		for(int i=0; i<n; i++) {
			for(int j=1; j<n-i; j++) {
				System.out.print("");
			}
			for(int k=0; k<i*2+1; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		scanner.close();
	}

}
