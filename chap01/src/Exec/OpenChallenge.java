package Exec;

import java.util.Scanner;

public class OpenChallenge {

	public static void main(String[] args) {
		System.out.println("���������� �����Դϴ�. ����, ����, �� �߿��� �Է��ϼ���.");
		Scanner scanner = new Scanner(System.in);
		System.out.println("ö�� >>");
		String boy = scanner.next();
		System.out.println("���� >>");
		String girl = scanner.next();
		
		if(boy.equals("����")) {
			if(girl.equals("����")) {
				System.out.println("�����ϴ�.");
			}else if(girl.equals("����")) {
				System.out.println("ö���� �����ϴ�.");
			}else {
				System.out.println("ö���� �̰���ϴ�.");
			}			
		}
		if(boy.equals("����")) {
			if(girl.equals("����")) {
				System.out.println("ö���� �̰���ϴ�.");
			}else if(girl.equals("����")) {
				System.out.println("�����ϴ�");
			}else {
				System.out.println("ö���� �����ϴ�.");
			}			
		}
		if(boy.equals("��")) {
			if(girl.equals("����")) {
				System.out.println("ö���� �����ϴ�.");
			}else if(girl.equals("����")) {
				System.out.println("ö���� �̰���ϴ�.");
			}else {
				System.out.println("�����ϴ�");
			}			
		}
	}

}
