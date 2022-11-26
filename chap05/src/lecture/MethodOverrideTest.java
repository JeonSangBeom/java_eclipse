package lecture;
//override 사용법 
class Shape{
	public void draw() {
		System.out.println("shape 그리기");
	}
}
class Line extends Shape{
	public void draw() {
		System.out.println("Line 그리기");
	}
}
class Rect extends Shape{
	public void draw() {
		System.out.println("Rect 그리기");
	}
}
class Circle extends Shape{	
	@Override // 미리 알려주는 것 Annotation 이라고 한다(안써도 상관은 없다)
	//Spring(서버프로그램 하는 것)할때 자주 만나게 된다 - 자바의 대표적인 프레임 워크
	public void draw() {
		System.out.println("Circle 그리기");
	}
}



class AA{ //상속을 안받으면 사용이 불가능하다(업캐스팅에서)
	public void draw() {
		System.out.println("AA 그리기");
	}
}
//동적(run time) 바인딩(묶어 사용) 실행될때 결정 method override 컴파일때 결정 되는 것이 아니라 실행될때 그때 결정 ex)p.draw()가 작동할떄 자식을 찾는 것
public class MethodOverrideTest {
	//업스캐스팅을 이용한 방법
	public static void paint(Shape p) {
		p.draw(); //이러한 업 캐스팅을 이용하면 아래의 불필요한 상황들을 정리할 수 있다(업 캐스팅으로 구멍을 크게 뚫어 사용하기)
	}
	
	//하나씩 부르는 방법(갯수가 많아지면 사용불가)
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
		//부모의 draw를 무시하고 자식의 draw가 호출 되고 있다 = 메서드 오버라이드
		//1.이름이 같아야 한다 2. 리턴타입 같아야 한다 3. 매개변수 같아야 한다  = 부모와 똑같아야 한다
//		Line line = new Line();
//		paint(line); -> 이 방법과 아래의 방법이 동일
		paint(new Shape());
		paint(new Line());
		paint(new Rect());
		paint(new Circle());
	}
}
