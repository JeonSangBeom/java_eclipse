package Exec;

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		System.out.println("���� �߽ɰ� ������ �Է�>>");
		Scanner scanner = new Scanner(System.in);
		double p1=scanner.nextDouble();
		double p2=scanner.nextDouble();
		double r=scanner.nextDouble();
		
		System.out.println("�� �Է�>>");
		double x=scanner.nextDouble();
		double y=scanner.nextDouble();
		
		double distance=Math.sqrt((x-p1)*(x-p1)+(y-p2)*(y-p2));
		if(distance<r) {
			System.out.println("��"+x+","+y+"��"+"�� �ȿ� �ֽ��ϴ�");
		}else {
			System.out.println("��"+x+","+y+"��"+"�� �ۿ� �ֽ��ϴ�");
		}scanner.close();
			
	}

}
