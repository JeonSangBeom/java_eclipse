package lecture;

public class Circle {
	int radius;  // �Ӽ�, properties, field, member field
	String name;
	
	public Circle() {//������ �Լ�(ex)ź��/�¾ �Ͱ� ���� = ������ ���� �Ұ�) / ������ �Լ��� Ŭ������ �Ȱ��� ����Ѵ�(��Ģ)
		System.out.println("���� �����Ǿ����ϴ�.");
	}
	public Circle(int radius) {
		this.radius = radius;
	}
	public double getArea() { //double = �Ҽ����� �־� ��� / ������ ���ϴ� ����
		return radius*radius*3.14;
	}
	
	
	public static void main(String[] args) {//���� �Լ�
		Circle pizza = new Circle(); //��ü ����->�޸𸮿� �ø��ڴٴ� ��(heap���� (�޸��� ������ ������ �ִ� static heap stack ��)
		// Ŭ���� Ÿ���� Circle�� pizza�� new���Ӱ� Circle�� ��ü�� ����� ��ü ����
		//�߻����� ������ Ŭ������ new�� ���� ��ü�� �ö󰡸鼭 ���� ���� �ߴ� ���� ������ �Լ��� ������ "���� �����Ǿ����ϴ�."�̴� 
		pizza.name ="��������";
		pizza.radius=20;
		double area = pizza.getArea();
		System.out.println("������ �̸��� "+pizza.name+"�̰� �������� "+pizza.radius+"�̰� ������ "+area+"�̴�");
		
		Circle donut = new Circle();
		donut.name = "��Ų";
		donut.radius = 10;
		double area02 = donut.getArea();
		System.out.println("������ �̸��� "+donut.name+"�̰� �������� "+donut.radius+"�̰� ������ "+area02+"�̴�");
		
	}
}






