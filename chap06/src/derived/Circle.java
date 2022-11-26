package derived;
//chap 0604
import base.Shape;

public class Circle extends Shape {
	
	//덮어 씌우기 (부모가 정의한 함수를 자식이 재정의한 것)
	@Override
	public void draw() {
		System.out.println("Circle");
	}
}
