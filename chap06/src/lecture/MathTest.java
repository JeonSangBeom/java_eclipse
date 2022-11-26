package lecture;
//math 설명 - 기본적으로 알아두어야 할 것
import java.util.Random;

public class MathTest {
	public static void main(String[] args) {
		System.out.println(Math.abs(10-21)); // abs - 절대값 // 출력 11
		//이렇게 앞에 바로 Math를 쓰는 것은 static로 분류 되어 있는 것이기 때문이다
		System.out.println(Math.cos(1));//출력 0.5403023058681398
		System.out.println(Math.ceil(0.1));// 1.0 출력
		System.out.println(Math.round(0.5)); // 1 출력
		System.out.println(Math.floor(0.5)); //0.0 출력
		System.out.println("Math.random "+Math.random()*2);// 1.4219018932792993 출력 / 값이 계속 바뀐다
		System.out.println(Math.sqrt(2)); // 루트 // 1.4142135623730951 출력 
		System.out.println(Math.exp(2)); // 7.38905609893065 출력
		Random random = new Random(); // java안에는 util이라는 곳에 Random이라는 함수가 존재한다
		//System.out.println(random.nextInt()); // 자바 안에는 랜덤이라는 함수가(util.Random) 존재해서 이 값이 나온다
		//System.out.println(random.nextInt(45)); - 45중에 하나를 골라 출력 할때
		
	}
}
