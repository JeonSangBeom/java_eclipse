package Exec;

import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		System.out.println("���� �Է��ϼ���(1~12)>>");
		Scanner scanner=new Scanner(System.in);
				int num = scanner.nextInt();
				if(num>=3 && num<=5) {
					System.out.println("��");
				}else if(num>=6 && num<=8) {
					System.out.println("����");
				}else if(num>=9 && num<=11) {
					System.out.println("����");
				}else if(num==12 || num==1 || num==2) {
					System.out.println("�ܿ�");
				}else {
					System.out.println("�߸��� ������ �ƴϰ� �Է�");
				}scanner.close();
					
	}

}
