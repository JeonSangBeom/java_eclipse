 package practice;
//��������
class MyPoint {//MyPoint�� ���� ����� �Ͽ��� ������ �������
	private int x,y; // �޼��带 ���ؼ��� ������ ����
	
	public MyPoint(int x,int y) { // ������ �Լ�
		this.x=x;
		this.y=y;
	}

//	public int getX() {
//		return x;
//	}
//
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public void setY(int y) {
//		this.y = y;
//	}

	@Override// ��ü �ּҸ� ������ ���� �ʱ� ���� ���� / �̰� ���� ��� practice.MyPoint@5e91993f �̷��� ������ �ȴ�
	public String toString() {
		return "Point(" + x + "," + y + ")";
	}
	@Override 
	public boolean equals(Object obj) { 
		MyPoint temp = (MyPoint)obj;//�ٿ�ĳ����  
		if(temp.x==x && temp.y==y) return true;
		return false;
	}
}
public class Chap0601 {
	public static void main(String[] args) {
		MyPoint p = new MyPoint(10, 30);
		MyPoint q = new MyPoint(10, 30);
		
		if(p.equals(q)) System.out.println("���� ��"); // override�� ���� ���� ������ �ʴ� �̻� ����� �ȵǾ false�� ���
		else System.out.println("�ٸ� ��");
		System.out.println(p );// tostring�� �ֱ� ������ ���� �� ������ ���� ���� �ٸ� �������̵尡 �ʿ�
		
	}
}
