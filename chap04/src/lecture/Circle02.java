package lecture;
//생성자를 두개 만들기
public class Circle02 {
	int radius;
	String name;
	//constructor === 생성자
	//생성자는 리턴 타입이 없음 - 자기 자신이 리턴이다
	//생성자함수 (메서드고 클래스와 이름이 같아야 한다.)
	//여러개 작성이 가능하다. (오버로딩)
	//new 를 통해 객체가 생성될때 한번 호출 가능(초기화)
	//만약 아래처럼 내용을 적지 않으면 컴파일러가 자동으로 하나 만들어서 집어 넣는다. (그것을 default 생성자라한다 - int의 경우 default의 값이 0이다)
	
	public Circle02() { //생성자는 클래스 네임과 같아야한다
		radius = 1;
	}

	public Circle02(int r, String n) {
		radius= r;
		name = n;
	}
	public double getArea() {
		return radius*radius*3.14;
	}
}
