package lecture;

import java.util.Scanner;

public class RectangleTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //�ڹٿ��� �����ϴ� Ÿ�� (����� ���ǿʹ� �ٸ��� ���� ���ǰ� �ʿ� ����)
		Rectangle rect = new Rectangle(); //���� rect �� Ÿ���� ���ش�(���� �տ��� �ǹ�)  
		rect.width = scanner.nextInt(); //rect. �����س��� ���� �ҷ��´� nexInt(���� �޾ƿ´�) 
		rect.height = scanner.nextInt();
		int area = rect.getArea();
		System.out.println(area);
		scanner.close();//�ǹ������� �޾�����Ѵ�(���� ����)
	}

}
 