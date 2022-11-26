package app;
//Calculator에 설계한 부분 구현(임폴트)
import lib.Calculator;
public class GoodCalculator extends Calculator {//추상클래스를 상속 받으면 자동으로 import생성 / 오버라이드는 클릭하여 만들어주어야 함
	
	
	@Override  // 덮어쓰기...
	public int add(int a, int b) {
		
		return a+b;
	}
	@Override
	public int substract(int a, int b) {
		return a-b;
	}
	@Override
	public double avg(int[] arr) {
		double sum  = 0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return sum/arr.length;
	}
}




