package Exec;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		System.out.println("��ȭ�� �Է��ϼ���(���� ��)");
//		int score = scanner.nextInt();
//		System.out.println("$" + score / 1100 + ".0");
//		scanner.close();
		System.out.println("��ȭ�� �Է��Ͻÿ�. �޷��� �ٲ� �帳�ϴ�.");
		int won = scanner.nextInt();
		double dollar = won/1100;
		System.out.println(won+"�� �޷��� "+ dollar+"�Դϴ�.");
		scanner.close();
	}

}
