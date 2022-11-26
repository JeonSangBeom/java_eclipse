 package practice;
//연습문제
class MyPoint {//MyPoint를 만들어서 쓰라고 하였기 때문에 만들었다
	private int x,y; // 메서드를 통해서만 접근이 가능
	
	public MyPoint(int x,int y) { // 생성자 함수
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

	@Override// 객체 주소만 나오게 하지 않기 위해 생성 / 이게 없을 경우 practice.MyPoint@5e91993f 이렇게 생성이 된다
	public String toString() {
		return "Point(" + x + "," + y + ")";
	}
	@Override 
	public boolean equals(Object obj) { 
		MyPoint temp = (MyPoint)obj;//다운캐스팅  
		if(temp.x==x && temp.y==y) return true;
		return false;
	}
}
public class Chap0601 {
	public static void main(String[] args) {
		MyPoint p = new MyPoint(10, 30);
		MyPoint q = new MyPoint(10, 30);
		
		if(p.equals(q)) System.out.println("같은 점"); // override로 값을 정의 내리지 않는 이상 출력이 안되어서 false가 뜬다
		else System.out.println("다른 점");
		System.out.println(p );// tostring가 있기 때문에 나온 것 위에는 연관 없이 다르 오버라이드가 필요
		
	}
}
