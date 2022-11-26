package lecture;

public class CircleTest { //���� Ŭ������ ���� �Լ��� �̷��� ���� ����� ����Ѵ�
	// ���� ��Ű���� ������ ����Ʈ�� �Ͽ� ������ �� �ִ�
	static void increase(Circle circle) { // static�� stack(�⺻�Լ��� ����stack�� ���-increase)�� ���� �޾� �� �� ���� ������ �̸� static�̶�� ���� ���� �� �ξ�� �Ѵ�
		circle.radius++; //circle�� ������ ������ ������ ���� �ʴ´� ���⼭ ���� circle�� �ƹ��ų� �ᵵ �Ȱ��� ����� ���´�
		//Circle�� Ŭ���� Ÿ���� ����� ���� �� �ش� Ŭ���� Ÿ�Կ��� �ִ� �͸� ����ϰ� ���� �� �� �ִٴ� ��
	}
	
	// ��ü�� �Ҵ��ϸ� ���ݷ��� ���� / �⺻Ÿ���� ������ ����ȴ�.
	public static void main(String[] args) {
		Circle pizza = new Circle();  //��ü ����  (memory)  heap - �ٸ� Ŭ������ �ֱ� ������ �̷� ������ �� �ʿ��ϴ�
		pizza.name="��������";
		pizza.radius=20;
		double area = pizza.getArea();
		System.out.println("������ �̸��� "+pizza.name+"�̰� �������� "+pizza.radius+"�̰� ������ "+area+"�̴�");
		
		
		increase(pizza); // static�� stack���� �޾� �ö� ���� ���� static�� �ŷ� �Ͽ��� �ϰ� �׷��� ������ ���ڸ�ü�� ǥ���� �ȴ�
		System.out.println("pizza.radius==="+pizza.radius);
		System.out.println();
				
		
		Circle donut = new Circle();
		donut.name = "��Ų";
		donut.radius = 10;
		double area02 = donut.getArea();
		System.out.println("������ �̸��� "+donut.name+"�̰� �������� "+donut.radius+"�̰� ������ "+area+"�̴�");
		
				
		
		Circle02 circle02 = new Circle02();
		//circle02.radius= 20; / circle Ŭ������ ���� ���� ���ǰ� �Ǿ� ���� ���� ��� ���� ���� ���� �ξ�߸� �۵��Ѵ�(����� Circle02�� ���ǵ� ����)
		double area03 = circle02.getArea();
		System.out.println(area03); // ������ 1�� ������ �� ����(Circle02��) = 3.14���
		
		
		
		Circle02 circle03 = new Circle02(50,"����"); // 50, "����"�߿� Ŭ������ ������ �Ű������� ��ġ�� ���ƾ��Ѵ�
		double area04 = circle03.getArea();
		System.out.println(area04+"==="+circle03.name);//7850.0 ==== ���� ���
		
		
		
		//���� ����
		Circle won ; //��ü(�迭�� ����)�� ���簡 �ƴ� ����(ex)���� ��ũ�� �����´�/�ϳ��� ���Ǹ� �Ǿ� �ִ�)�� �ϱ� ������ �Ʒ� ���� �ϳ��� �ٲٸ� ���� ���� ���� �ٲ�� ���� 
		won = pizza;
		won.name = "���׶��";
		System.out.println(won.name+"===="+pizza.name); // ���׶��===���׶�� ���
		
		int num = 3; //�⺻ Ÿ��(��Ʈ ���� ��Ʈ�� ��)�� ���簡 �Ǿ� ���� �����Ѵ�
		int copyNum = num;
		copyNum=4;
		System.out.println(num+"==="+copyNum); //3===4 ���
		
		Circle circleArray[] = new Circle[5]; //Circle(�Ǵ� int����)Ÿ�����ε� ���� �ִ� ��� �յ� ������� �Ѵ�(��ü�� �迭�� ��� ���� �ִ�) 
		
		for(int i=0;i<5;i++) {
			circleArray[i] =  new Circle(i+1);// Circle(i+1) radious�� 1���� ����
			System.out.println(circleArray[i].getArea());
			// 3.14
			// 12.56
			// 28.26
			// 50.24
			// 78.5 ���
		}
	}
}
