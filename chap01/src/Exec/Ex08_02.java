package Exec;

import java.util.Scanner;

public class Ex08_02 {
//inRect�� ������� �ʰ� Ǫ�� ���
	public static void main(String[] args) {
		System.out.println("�� ��(x1,y1), (x2,y2)�� ��ǥ�� �Է��Ͻÿ� >>");
		Scanner scanner = new Scanner(System.in);
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		if((x1>=100 & x1<=200) && (y1>=100 && y1<=200)) {
			System.out.println("�簢���� ��ħ");
		}else if((x2>=100 & x2<=200) && (y2>=100 && y2<=200)) {
			System.out.println("�簢���� ��ħ");
		}else if((x1<=100 & x2>=200) && (y1<=100 && y2>=200)) {
			System.out.println("�簢���� ��ħ");
		}
		else {
			System.out.println("�簢���� �Ȱ�ħ");
		}scanner.close();
	}

}
