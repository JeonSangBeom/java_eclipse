package lecture;

class Point { // 따로 만들어 쓰는 것이 기본이나 위에 쓸 수 있다 대신 앞에 퍼블릭같은 접근 제어자는 사용 불가
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override//덮어 씌운다는 개념
	//alt+shift+s -> Generate toString 클릭하여 생성
	public String toString() { //(obj.toString())을 이용할시 자식의 값(point)으로 값을 보여준다 안할시 확인 불가(현재 Point [x=10, y=20] 출력)
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	//개인적으로 입력
	public boolean equals(Object obj) {//boolean - true 와 false의 값을 리턴하여 찾는 것이니 boolean을 써줘야 한다
		Point tempPoint = (Point)obj;//임의의 변수 생성 클래스 포인트에 기존 obj를 다운캐스트를 해준다
		// object안에는 x라는 속성이 없기 때문에 형변환을 하게 된다 - 다운 캐스팅
		if(x==tempPoint.x && y==tempPoint.y) return true; // x와 point안에 있는 매개변수 x의 값이 같을때란 뜻
		return false;
	}
	
}
public class ObjectTest {
	//obj클래스 설명
	public static void print(Object obj) { //Object - 모든 조상(이걸 쓰면 Object부분에 위에 지정한 point도 넣을 수 있다) / static을 불러올려면 static으로 위에 정의해 놓아야 한다
		//obj가 가지고 있는 기본 함수들
		System.out.println(obj.getClass().getName()); //lecture.Point 출력 - lecture객체 안의 Point라는 것이 obj의 이름이란걸 알 수 있다
		System.out.println(obj.hashCode()); // 메모리 주소 값(숫자1586600225 출력) - 값이 같으면 같은 값을 바라 보고 있는 것으로 본다
		System.out.println(obj.toString()); // 문자로 바꾸면 어떻게 되는지(오버라이드를 해줘야 정확히 속성을 볼 수 있다
		System.out.println(obj); //obj자체는 어떻게 되는지 - toString와 같은 값을 내보낸다(두개가 같다 lecture.Point@5e91993f 출력)
	}
	public static void main(String[] args) {
		Point point01 = new Point(10,20);
		Point point02 = new Point(10,20); //point01과 02는 다르다 new는 새롭게 생성을 하는 것이기 떄문에 두개의 정보가 축적된다(heap영역) 값은 같아도 서로 다른 것
		Point point03 = point01; // 참조
		//equals 사용법
		System.out.println(point01==point02);//false 출력
		System.out.println(point01==point03);//true 출력
		System.out.println(point01.equals(point02));//true 출력 - equals를 오바라이드 해줘야만 true의 값이 나온다(hashCode는 다르지만 값을 비교하기 위해)
		
		//obj설명 출력
		print(point01); // 지정한 함수 의 생성자들의 기본 println값을 출력한다
	}
}







