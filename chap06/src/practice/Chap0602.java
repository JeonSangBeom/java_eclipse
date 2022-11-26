package practice;

import java.util.Objects;

class Circle {
	private int x,y,radius;//매개변수 세개 / 클래스 내부에서만 접근 가능
	
	//Generate Constuctor using Fields
	public Circle(int x, int y, int radius) { // alt+sh+s를 눌러서 한 번에 불러 올 수 있다(생성자)
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	@Override
	public String toString() {
		return "Circle (" + x + "," + y + ") 반지름 = " + radius;
	}
	@Override
	public boolean equals(Object obj) {
		Circle temp = (Circle) obj;
		return temp.x == x && temp.y == y; // x 와 y 둘다 같을 경우 참
	}
	
}
public class Chap0602 {
	public static void main(String[] args) {
		Circle circle01 = new Circle(10,10,50);
		Circle circle02 = new Circle(10,10,30);
		System.out.println(circle01); // toString 출력 
		if(circle01.equals(circle02)) System.out.println("같은 원");
		else System.out.println("다른 원");
	}
}
