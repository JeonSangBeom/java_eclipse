package lecture;
//상속 사용법 (Point상속)

public class ColorPoint extends Point { // Point(부모)에게 상속받다
	private String color;
	
	
	public void setColor(String color) {// 쓰기위해 세팅
		this.color = color;
} 
	public void showColorPoint() {
		System.out.print("color : "+color+" ,");
		this.showPoint();//부모에 상속 받아서 사용
	}
	
	//기본생성자를 입력만 해둬도 이 아래 값들이 출력 된다
	public ColorPoint() { //여러번 하는 것이 아니라 생성 할떄 한번만 하는 것이 생성자 함수라고 한다
		set(1,0);
		color = "white";
		showColorPoint(); //color : white ,{1,0} 출력
	}
	public ColorPoint(int x, int y, String color) { //생성을 하고 바로 실행하는 함수를 필요로 할때 위와 다르게 이렇게 만들어 준다
//		this.set(x, y); // private이기 때문에 set으로 불러와야 사용이 가능하다
		super(x,y); // 부모 생성자를 호출 set대신 사용 가능 
		this.color = color;
	}
	
	//상속을 받아도 실행함수에서는 따로 기본 생성자를 생성해야만 실행이 된다
	public static void main(String[] args) {
		Point point = new Point();
		point.showPoint();		
	}
	
}

 