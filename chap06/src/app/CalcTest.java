package app;
//GoodCalculator에 구현한 것을 가져와서 실행 하기
import lib.Calculator;
//extends필요 없이 불러 올 수 있기 때문에(같은 폴더 안에 있기 때문에) 선언하여 사용한다

//design  pattern(설계 방식 관련 책)
public class CalcTest {

	public static void main(String[] args) {
		Calculator calc = new GoodCalculator();// 앞에 Calculator를 써도 되고  GoodCalculator을 써도 상관 없다 -upcasting
		//GoodCalculator 가 Calculator을 상속 받았기 때문에 상관없다(부모타입인 Calculator - 부모를 가져오면 자식도 같이 가져올 수 있다)
		System.out.println(calc.add(10, 20));
	}
}
