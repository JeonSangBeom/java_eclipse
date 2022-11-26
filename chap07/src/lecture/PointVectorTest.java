package lecture;
import java.util.Vector;
//Point��� Ŭ���� Ÿ���� ���� ����� ���
class Point {
	private int x,y;
	public Point(int x, int y) {// ������ �Լ�
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
public class PointVectorTest {
	public static void main(String[] args) {
		Vector <Point> pointVector = new Vector<Point>();
		pointVector.add(new Point(3,3));// �ٷ� ������ �Լ��� add 
		pointVector.add(new Point(10,10));
		pointVector.add(new Point(100,100));
		for(int i=0;i<pointVector.size();i++) {
			System.out.println(pointVector.get(i));// ���� ���ö� get �̿�
		}
		pointVector.remove(1); // 1��° ���� �����
		System.out.println("������ �� ���=====");
		for(int i=0;i<pointVector.size();i++) {
			System.out.println(pointVector.get(i));
		}
	}
}
////���
//Point [x=3, y=3]
//Point [x=10, y=10]
//Point [x=100, y=100]
//������ �� ���=====
//Point [x=3, y=3]
//Point [x=100, y=100]





