package Exec;

import java.util.Scanner;

public class Ex08 { // booleanó�� static�� �� �Լ��� static���� ���� ��� ���� �ִ�
	public static boolean inRect(int x, // static�ȿ� ���� ���� ���� �÷��� ���� ����� �Ѵ�
								 int y, // �Ű������� ������ ���� �տ� Ÿ���� ������ �־�� �Ѵ�
								 int rectx1, 
								 int recty1, 
								 int rectx2, 
								 int recty2) {
		if ((x >= rectx1 && x <= rectx2) && (y >= recty1 && y <= recty2)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("��ǥ 4���� x1,y1, x2, y2 ������  �Է��Ͻÿ�.");
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();

		//�ϳ��� ������ ���
		if(inRect(x1,y1,100,100,200,200) || 
		   inRect(x2,y2,100,100,200,200) || 
		   inRect(x1,y2,100,100,200,200) ||
		   inRect(x2,y1,100,100,200,200)
		   ) 
		{
			System.out.println("�浹"); 
		}
		else if(inRect(x1,y1,100,100,200,200) &&  // && �׸���  / else if�� ��� ���ο� ������ �߰��� �� ���
				   inRect(x2,y2,100,100,200,200) && 
				   inRect(x1,y2,100,100,200,200) &&
				   inRect(x2,y1,100,100,200,200)
				   ) 
		{
			System.out.println("�浹");
		}
		else if(inRect(100,100,x1,y1,x2,y2) && 
				   inRect(100,200,x1,y1,x2,y2) && 
				   inRect(200,100,x1,y1,x2,y2) &&
				   inRect(200,200,x1,y1,x2,y2)
				   ) 
		{
			System.out.println("�浹");
		}
		else 
		{System.out.println("���浹");}
		scanner.close();
	}
}
