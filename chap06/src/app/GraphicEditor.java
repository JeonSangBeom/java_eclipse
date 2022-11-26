package app;
//chap 0604 최종 실행 하는 곳 
import base.Shape;
import derived.Circle;

public class GraphicEditor {
	
	public static void main(String[] args) {
		Shape circle = new Circle();
		circle.draw();
	}
}
