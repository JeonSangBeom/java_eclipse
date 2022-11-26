package lecture;
 //사각형 두개가 같은지(면적) 테스트 - equals 설명

class Rect {
	private int width; // 속성을 만들땐 되도록 private를 사용
	private int height;
	
	//생성자함수
	public Rect(int width, int height) { // 생성자는 public 그리고 class네임과 같은 Rect사용
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "Rect [width=" + width + ", height=" + height + "]";
	}

	@Override
	public boolean equals(Object obj) {//equals를 출력하는데 Object로 받겠단 뜻(Object에 있는 메서드이기 때문에)
		Rect tempRect = (Rect)obj;//형 변환 필요 Object는 최상위 객체이기 때문에 아무나 들어 올 수 있기 때문 - 다운 캐스팅
		//tempRect는 변수일 뿐이기 때문에 아래 width앞에 tempRect를 굳이 안붙여도 된다
		//같은 변수로 변할수 있는 값일뿐 서로 같은 width와 height를 바라보기 때문
		if(width*height == tempRect.width*tempRect.height) return true; 
		return false;
	}
}

//테스트 시작
public class RectTest { // 이곳 클래스 네임과 클래스 파일 자체 이름은 같아야 한다
	public static void main(String[] args) {//static는 클래스 변수
		Rect rect01 = new Rect(10,10);
		Rect rect02 = new Rect(5,20);
		System.out.println(rect01==rect02); // false 출력
		System.out.println(rect01.equals(rect02));
		System.out.println(rect01);
	}
}
