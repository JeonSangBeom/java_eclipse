package lecture;
import java.util.Vector;
//Point라는 클래스 타입을 따로 만들어 사용
class Point {
	private int x,y;
	public Point(int x, int y) {// 생성자 함수
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
		pointVector.add(new Point(3,3));// 바로 생성자 함수로 add 
		pointVector.add(new Point(10,10));
		pointVector.add(new Point(100,100));
		for(int i=0;i<pointVector.size();i++) {
			System.out.println(pointVector.get(i));// 값을 얻어올땐 get 이용
		}
		pointVector.remove(1); // 1번째 것을 지우기
		System.out.println("제거한 후 결과=====");
		for(int i=0;i<pointVector.size();i++) {
			System.out.println(pointVector.get(i));
		}
	}
}
////출력
//Point [x=3, y=3]
//Point [x=10, y=10]
//Point [x=100, y=100]
//제거한 후 결과=====
//Point [x=3, y=3]
//Point [x=100, y=100]





