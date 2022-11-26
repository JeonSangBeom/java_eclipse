package lecture;
//메서드 오버로딩 설명
public class MethodOverloading {
	//메서드 오버로딩은 메서드의 이름이 같고 매개변수의 갯수나 타입이 다를때....
	//리턴 타입은 상관없음...
	public int getSum(int a, int b) { //정수를 리턴 / 뭔가를 리턴후 값을 얻어올땐 getSum을 사용한다
		return a + b;
	}
	public int getSum(int a, int b, int c) {
		return a + b + c;
	}
	public double getSum(double a, double b) {
		return a + b;
	}
//	public double getSum(int a,int b) {//매개변수가 같아 오버로딩이 안된다
//		return (double)(a+b); 형변환 사용(int를 double로)
//	}
}
