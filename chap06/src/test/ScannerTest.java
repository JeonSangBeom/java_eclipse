package test;
//��Ű�� ���� ����(import)
import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		char ch = 'a';
		int num = 10;
		//String str = "aaa";// String�� new��� �����ڸ� ���� ��ü�� �����Ͽ� �����ؾ������� ���� ����Ͽ� string�� ��ŵ ����
		Scanner scanner = new Scanner(System.in);
		//java.util.Scanner scanner = new Scanner(System.in); import�� ���� ��� �̷��� ���		
		Scanner scanner02 = new Scanner(System.in);
		Scanner scanner03 = scanner;
		//�ֿ� �⺻ �޼��� (Object Ŭ������ ���ԵȰ�) 
		System.out.println(scanner.hashCode()); // hashCode - �޸� �ּ� ��
		System.out.println(scanner03.hashCode());
		System.out.println(scanner.equals(scanner03));//equals - �� �ϴ� ��(Ŭ���� �񱳽� ���)
	}
}
