package lecture;
//��� ���� (Point���)

public class ColorPoint extends Point { // Point(�θ�)���� ��ӹ޴�
	private String color;
	
	
	public void setColor(String color) {// �������� ����
		this.color = color;
} 
	public void showColorPoint() {
		System.out.print("color : "+color+" ,");
		this.showPoint();//�θ� ��� �޾Ƽ� ���
	}
	
	//�⺻�����ڸ� �Է¸� �صֵ� �� �Ʒ� ������ ��� �ȴ�
	public ColorPoint() { //������ �ϴ� ���� �ƴ϶� ���� �ҋ� �ѹ��� �ϴ� ���� ������ �Լ���� �Ѵ�
		set(1,0);
		color = "white";
		showColorPoint(); //color : white ,{1,0} ���
	}
	public ColorPoint(int x, int y, String color) { //������ �ϰ� �ٷ� �����ϴ� �Լ��� �ʿ�� �Ҷ� ���� �ٸ��� �̷��� ����� �ش�
//		this.set(x, y); // private�̱� ������ set���� �ҷ��;� ����� �����ϴ�
		super(x,y); // �θ� �����ڸ� ȣ�� set��� ��� ���� 
		this.color = color;
	}
	
	//����� �޾Ƶ� �����Լ������� ���� �⺻ �����ڸ� �����ؾ߸� ������ �ȴ�
	public static void main(String[] args) {
		Point point = new Point();
		point.showPoint();		
	}
	
}

 