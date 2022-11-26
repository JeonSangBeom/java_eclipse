package lecture;
//입력 받아서 갑을 출력할 것 만들기
public class Rectangle { //static
	int width;
	int height;
	
	public Rectangle() {//생성자 함수를 만든다(클래스 네임과 동일) / heap
		System.out.println("사각형이 만들어 졌습니다.");
	}
	
	public int getArea() { //stack
		return width*height;
	}
}
