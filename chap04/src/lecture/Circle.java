package lecture;

public class Circle {
	int radius;  // 속성, properties, field, member field
	String name;
	
	public Circle() {//생성자 함수(ex)탄생/태어난 것과 같다 = 없으면 실행 불가) / 생성자 함수는 클래스와 똑같이 써야한다(규칙)
		System.out.println("원이 생성되었습니다.");
	}
	public Circle(int radius) {
		this.radius = radius;
	}
	public double getArea() { //double = 소수점이 있어 사용 / 반지름 구하는 공식
		return radius*radius*3.14;
	}
	
	
	public static void main(String[] args) {//실행 함수
		Circle pizza = new Circle(); //객체 생성->메모리에 올리겠다는 뜻(heap영역 (메모리의 영역은 세개가 있다 static heap stack 등)
		// 클래스 타입의 Circle로 pizza에 new새롭게 Circle의 객체를 만들어 객체 생성
		//추상적인 존재인 클래스가 new를 통해 객체로 올라가면서 가장 먼저 뜨는 것이 생성자 함수로 지정한 "원이 생성되었습니다."이다 
		pizza.name ="새우피자";
		pizza.radius=20;
		double area = pizza.getArea();
		System.out.println("피자의 이름은 "+pizza.name+"이고 반지름은 "+pizza.radius+"이고 면적은 "+area+"이다");
		
		Circle donut = new Circle();
		donut.name = "던킨";
		donut.radius = 10;
		double area02 = donut.getArea();
		System.out.println("피자의 이름은 "+donut.name+"이고 반지름은 "+donut.radius+"이고 면적은 "+area02+"이다");
		
	}
}






