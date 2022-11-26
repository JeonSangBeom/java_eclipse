package lecture;
//추상 클래스 설명 - 추상 클래스는 설계의 개념이다
//				객체 생성 불가
//class만들때 abstract를 클릭하는 부분이 따로 있다
public abstract class Calculator {
	public abstract int add(int a, int b); // abstract 은 몸통({})을 만들어서는 안된다
	public abstract int subtract(int a, int b);
	public abstract double avg(int arr[]);
}
