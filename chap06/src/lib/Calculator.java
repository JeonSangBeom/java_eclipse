package lib;
//lib - 명세 - 설계하는 곳
//추상 클래스 - 설계 -> GoodCalculator에 구현
public abstract class Calculator {
	public abstract int add(int a, int b);
	public abstract int substract(int a, int b);
	public abstract double avg(int[] arr);
}
