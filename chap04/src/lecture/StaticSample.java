package lecture;

public class StaticSample {
	public static int m;
	public int n;
	public void g() {
		m=20;
	}
	public void h() {
		m=30;
	}
	public static void f() {
		m = 5;
	}
	//static 메서드에는 this 사용안됨.
	//static은 클래스 변수 메서드이다.
}
