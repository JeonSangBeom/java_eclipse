package lecture;
//override ���� 
class Shape{
	public void draw() {
		System.out.println("shape �׸���");
	}
}
class Line extends Shape{
	public void draw() {
		System.out.println("Line �׸���");
	}
}
class Rect extends Shape{
	public void draw() {
		System.out.println("Rect �׸���");
	}
}
class Circle extends Shape{	
	@Override // �̸� �˷��ִ� �� Annotation �̶�� �Ѵ�(�Ƚᵵ ����� ����)
	//Spring(�������α׷� �ϴ� ��)�Ҷ� ���� ������ �ȴ� - �ڹ��� ��ǥ���� ������ ��ũ
	public void draw() {
		System.out.println("Circle �׸���");
	}
}



class AA{ //����� �ȹ����� ����� �Ұ����ϴ�(��ĳ���ÿ���)
	public void draw() {
		System.out.println("AA �׸���");
	}
}
//����(run time) ���ε�(���� ���) ����ɶ� ���� method override �����϶� ���� �Ǵ� ���� �ƴ϶� ����ɶ� �׶� ���� ex)p.draw()�� �۵��ҋ� �ڽ��� ã�� ��
public class MethodOverrideTest {
	//����ĳ������ �̿��� ���
	public static void paint(Shape p) {
		p.draw(); //�̷��� �� ĳ������ �̿��ϸ� �Ʒ��� ���ʿ��� ��Ȳ���� ������ �� �ִ�(�� ĳ�������� ������ ũ�� �վ� ����ϱ�)
	}
	
	//�ϳ��� �θ��� ���(������ �������� ���Ұ�)
	public static void paintShape(Shape s) {
		s.draw();
	}
	public static void paintLine(Line l) {
		l.draw();
	}
	public static void paintRect(Rect r) {
		r.draw();
	}
	public static void paintCircle(Circle c) {
		c.draw();
	}
	public static void main(String[] args) {
//		paintShape(new Shape());
//		paintLine(new Line());
//		paintRect(new Rect());
//		paintCircle(new Circle());
		//�θ��� draw�� �����ϰ� �ڽ��� draw�� ȣ�� �ǰ� �ִ� = �޼��� �������̵�
		//1.�̸��� ���ƾ� �Ѵ� 2. ����Ÿ�� ���ƾ� �Ѵ� 3. �Ű����� ���ƾ� �Ѵ�  = �θ�� �Ȱ��ƾ� �Ѵ�
//		Line line = new Line();
//		paint(line); -> �� ����� �Ʒ��� ����� ����
		paint(new Shape());
		paint(new Line());
		paint(new Rect());
		paint(new Circle());
	}
}
